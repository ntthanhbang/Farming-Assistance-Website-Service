package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.dtos.LoginRequest;
import com.farmingweb.farmingwebsite.entities.Farmer;
import com.farmingweb.farmingwebsite.services.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
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
    public Farmer create(@RequestBody Farmer farmer) {
        return farmerService.create(farmer);
    }

    //Login function
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Farmer farmer = farmerService.login(request.getEmail(), request.getPassword());

        if (farmer != null) {
            return ResponseEntity.ok(farmer);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        farmerService.delete(id);
    }
}
