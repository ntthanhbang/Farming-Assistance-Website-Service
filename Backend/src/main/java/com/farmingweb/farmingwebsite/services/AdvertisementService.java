package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Advertisement;
import com.farmingweb.farmingwebsite.entities.AdvertisementId;
import com.farmingweb.farmingwebsite.entities.Supplier;
import com.farmingweb.farmingwebsite.repositories.AdvertisementRepository;
import com.farmingweb.farmingwebsite.repositories.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;
    private SupplierRepository supplierRepository;

    public Advertisement createAd(String supplierID, Advertisement ad) {
        Supplier supplier = supplierRepository.findById(supplierID)
            .orElseThrow(() -> new RuntimeException("Supplier not found!"));
        ad.setSupplier(supplier);
        return advertisementRepository.save(ad);    
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
