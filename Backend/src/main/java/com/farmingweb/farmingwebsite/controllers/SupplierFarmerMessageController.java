package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.SupplierFarmerMessage;
import com.farmingweb.farmingwebsite.entities.SupplierFarmerMessageId;
import com.farmingweb.farmingwebsite.services.SupplierFarmerMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/supplierfarmermessages")
public class SupplierFarmerMessageController {
    @Autowired
    private SupplierFarmerMessageService supplierfarmermessageService;

    @GetMapping
    public List<SupplierFarmerMessage> getAll() {
        return supplierfarmermessageService.getAll();
    }

    @PostMapping
    public SupplierFarmerMessage create(@RequestBody SupplierFarmerMessage sfm) {
        return supplierfarmermessageService.create(sfm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable SupplierFarmerMessageId id) {
        supplierfarmermessageService.delete(id);
    }

    //Get messages
    @GetMapping("/{supplierID}/{farmerID}")
    public List<SupplierFarmerMessage> getMessagesBetween(
            @PathVariable String supplierID,
            @PathVariable String farmerID) {
        return supplierfarmermessageService.getMessagesBetween(supplierID, farmerID);
    }

    //Get chats
    @GetMapping("/farmers/{supplierID}")
    public List<String> getConnectedFarmers(@PathVariable String supplierID) {
        return supplierfarmermessageService.getConnectedFarmerIDs(supplierID);
    }
}
