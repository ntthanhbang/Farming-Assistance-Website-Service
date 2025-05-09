package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.dtos.LoginRequest;
import com.farmingweb.farmingwebsite.entities.Supplier;
import com.farmingweb.farmingwebsite.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5500")
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAll() {
        return supplierService.getAll();
    }
    
    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return supplierService.create(supplier);
    }

    //Login Function
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Supplier supplier = supplierService.login(request.getEmail(), request.getPassword());

        if (supplier != null) {
            return ResponseEntity.ok(supplier);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
    // public Supplier login(@RequestBody LoginRequest request) {
    //     return supplierService.login(request.getEmail(), request.getPassword());
    // }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        supplierService.delete(id);
    }
}
