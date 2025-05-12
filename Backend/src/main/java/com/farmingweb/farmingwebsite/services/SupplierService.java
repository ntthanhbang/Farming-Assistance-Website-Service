package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Supplier;
import com.farmingweb.farmingwebsite.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public Supplier create(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public void delete(String id) {
        supplierRepository.deleteById(id);
    }

    //Login Function
    public Supplier login(String email, String password) {
        return supplierRepository.findByEmailAndPassword(email, password)
                // .orElseThrow(() -> new RuntimeException("Invalid credentials"));
                .orElse(null);
    }
}
