package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.Supplier;
import com.farmingweb.farmingwebsite.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Supplier create(@RequestBody Supplier obj) {
        return supplierService.create(obj);
    }

    @DeleteMapping
    public void delete(@PathVariable String id) {
        supplierService.delete(id);
    }
}
