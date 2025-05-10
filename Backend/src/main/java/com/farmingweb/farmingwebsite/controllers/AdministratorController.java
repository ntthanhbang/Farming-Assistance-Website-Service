package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.dtos.LoginRequest;
import com.farmingweb.farmingwebsite.entities.Administrator;
import com.farmingweb.farmingwebsite.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/administrators")
public class AdministratorController {
    @Autowired
    private AdministratorService administratorService;

    @GetMapping
    public List<Administrator> getAll() {
        return administratorService.getAll();
    }

    @PostMapping
    public Administrator create(@RequestBody Administrator admin) {
        return administratorService.create(admin);
    }

    //Login Function
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Administrator administrator = administratorService.login(request.getEmail(), request.getPassword());

        if (administrator != null) {
            return ResponseEntity.ok(administrator);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
    // public Administrator login(@RequestBody LoginRequest request) {
    //     return administratorService.login(request.getEmail(), request.getPassword());
    // }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        administratorService.delete(id);
    }
}
