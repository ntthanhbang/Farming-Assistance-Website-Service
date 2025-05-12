package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.Notification;
import com.farmingweb.farmingwebsite.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Notification> getAll() {
        return notificationService.getAll();
    }
    
    @GetMapping("/farmer/{farmerID}")
    public List<Notification> getByFarmer(@PathVariable String farmerID) {
        return notificationService.getByFarmer(farmerID);
    }
    
    @PostMapping
    public Notification create(@RequestBody Notification notif) {
        return notificationService.create(notif);
    }

    @PutMapping("/mark-as-read/{id}")
    public Notification markAsRead(@PathVariable Integer id) {
        return notificationService.markAsRead(id);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        notificationService.delete(id);
    }
}
