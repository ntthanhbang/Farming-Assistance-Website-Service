package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.SupplierFarmerMessage;
import com.farmingweb.farmingwebsite.entities.SupplierFarmerMessageId;
import com.farmingweb.farmingwebsite.services.SupplierFarmerMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public SupplierFarmerMessage create(@RequestBody SupplierFarmerMessage obj) {
        return supplierfarmermessageService.create(obj);
    }

    @DeleteMapping
    public void delete(@PathVariable SupplierFarmerMessageId id) {
        supplierfarmermessageService.delete(id);
    }
}
