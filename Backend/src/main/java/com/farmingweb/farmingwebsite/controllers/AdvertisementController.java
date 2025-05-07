package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.Advertisement;
import com.farmingweb.farmingwebsite.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public List<Advertisement> getAll() {
        return advertisementService.getAll();
    }

    @PostMapping
    public Advertisement create(@RequestBody Advertisement obj) {
        return advertisementService.create(obj);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        advertisementService.delete(id);
    }
}
