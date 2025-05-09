package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.dtos.LoginRequest;
import com.farmingweb.farmingwebsite.entities.Farmer;
import com.farmingweb.farmingwebsite.services.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {
    @Autowired
    private FarmerService farmerService;

    @GetMapping
    public List<Farmer> getAll() {
        return farmerService.getAll();
    }

    @PostMapping
    public Farmer create(@RequestBody Farmer obj) {
        return farmerService.create(obj);
    }

    //Login function
    @PostMapping("/login")
    public Farmer login(@RequestBody LoginRequest request) {
        return farmerService.login(request.getEmail(), request.getPassword());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        farmerService.delete(id);
    }
}
