package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByFarmer_FarmerID(String farmerID);
}
