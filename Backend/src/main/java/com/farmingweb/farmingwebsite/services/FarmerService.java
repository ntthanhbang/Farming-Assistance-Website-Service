package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Farmer;
import com.farmingweb.farmingwebsite.repositories.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {
    @Autowired
    private FarmerRepository farmerRepository;

    public List<Farmer> getAll() {
        return farmerRepository.findAll();
    }

    public Farmer create(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public void delete(String id) {
        farmerRepository.deleteById(id);
    }

    //Login Function
    public Farmer login(String email, String password) {
        return farmerRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
                // .orElse(null);
    }
}
