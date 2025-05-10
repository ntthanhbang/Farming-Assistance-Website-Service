package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.Advertisement;
import com.farmingweb.farmingwebsite.entities.AdvertisementId;
import com.farmingweb.farmingwebsite.services.AdvertisementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping
    public List<Advertisement> getAll() {
        return advertisementService.getAll();
    }

    @PostMapping("/supplier/{supplierID}")
    public Advertisement addAdvertisement(@PathVariable String supplierID, @RequestBody Advertisement ad) {
        return advertisementService.createAd(supplierID, ad);
    }

    @GetMapping("/supplier/{supplierID}")
    public List<Advertisement> getAdvertisements(@PathVariable String supplierID) {
        return advertisementService.getAdsBySupplier(supplierID);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable AdvertisementId id) {
        advertisementService.delete(id);
    }
}
