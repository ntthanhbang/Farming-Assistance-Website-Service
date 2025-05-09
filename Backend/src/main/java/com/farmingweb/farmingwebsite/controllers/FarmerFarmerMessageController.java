package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.FarmerFarmerMessage;
import com.farmingweb.farmingwebsite.entities.FarmerFarmerMessageId;
import com.farmingweb.farmingwebsite.services.FarmerFarmerMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/api/farmerfarmermessages")
public class FarmerFarmerMessageController {
    @Autowired
    private FarmerFarmerMessageService farmerfarmermessageService;

    @GetMapping
    public List<FarmerFarmerMessage> getAll() {
        return farmerfarmermessageService.getAll();
    }

    @PostMapping
    public FarmerFarmerMessage create(@RequestBody FarmerFarmerMessage ffm) {
        return farmerfarmermessageService.create(ffm);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable FarmerFarmerMessageId id) {
        farmerfarmermessageService.delete(id);
    }
}
