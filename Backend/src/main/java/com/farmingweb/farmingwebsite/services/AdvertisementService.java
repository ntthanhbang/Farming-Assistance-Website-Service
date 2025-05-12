package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Advertisement;
import com.farmingweb.farmingwebsite.entities.AdvertisementId;
import com.farmingweb.farmingwebsite.entities.Farmer;
import com.farmingweb.farmingwebsite.entities.Notification;
import com.farmingweb.farmingwebsite.entities.Supplier;
import com.farmingweb.farmingwebsite.enums.NotificationStatus;
import com.farmingweb.farmingwebsite.repositories.AdvertisementRepository;
import com.farmingweb.farmingwebsite.repositories.FarmerRepository;
import com.farmingweb.farmingwebsite.repositories.NotificationRepository;
import com.farmingweb.farmingwebsite.repositories.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private FarmerRepository farmerRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    public Advertisement createAd(String supplierID, Advertisement ad) {
        Supplier supplier = supplierRepository.findById(supplierID)
            .orElseThrow(() -> new RuntimeException("Supplier not found!"));

        ad.setSupplier(supplier);
        Advertisement savedAd = advertisementRepository.save(ad);

        // Notify all farmers about the new advertisement
        List<Farmer> farmers = farmerRepository.findAll();
        for (Farmer farmer : farmers) {
            Notification notif = new Notification();
            notif.setFarmer(farmer);
            notif.setAdvertisement(savedAd);
            notif.setContent("New advertisement from " + supplier.getName() + ": " + ad.getTitle());
            notif.setStatus(NotificationStatus.unread);
            notif.setTimeStamp(LocalDateTime.now());

            notificationRepository.save(notif);
        }

        return savedAd;   
    }

    public List<Advertisement> getAll() {
        return advertisementRepository.findAll();
    }

    public List<Advertisement> getAdsBySupplier(String supplierID) {
        return advertisementRepository.findBySupplier_SupplierID(supplierID);
    }

    public void delete(AdvertisementId id) {
        advertisementRepository.deleteById(id);
    }
}
