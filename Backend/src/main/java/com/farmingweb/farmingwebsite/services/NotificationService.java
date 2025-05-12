package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Notification;
import com.farmingweb.farmingwebsite.enums.NotificationStatus;
import com.farmingweb.farmingwebsite.repositories.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAll() {
        return notificationRepository.findAll();
    }

    public List<Notification> getByFarmer(String farmerID) {
        return notificationRepository.findByFarmer_FarmerID(farmerID);
    }
    
    public Notification create(Notification notif) {
        return notificationRepository.save(notif);
    }

    public void delete(Integer id) {
        notificationRepository.deleteById(id);
    }

    public Notification markAsRead(Integer id) {
        Notification notif = notificationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Notification not found"));
        notif.setStatus(NotificationStatus.read);
        return notificationRepository.save(notif);
    }
}
