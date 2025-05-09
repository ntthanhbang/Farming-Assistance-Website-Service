package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.dtos.LoginRequest;
import com.farmingweb.farmingwebsite.entities.Administrator;
import com.farmingweb.farmingwebsite.services.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Administrator create(@RequestBody Administrator obj) {
        return administratorService.create(obj);
    }

    //Login Function
    @PostMapping("/login")
    public Administrator login(@RequestBody LoginRequest request) {
        return administratorService.login(request.getEmail(), request.getPassword());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        administratorService.delete(id);
    }
}
