package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Administrator;
import com.farmingweb.farmingwebsite.repositories.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;

    public List<Administrator> getAll() {
        return administratorRepository.findAll();
    }

    public Administrator create(Administrator admin) {
        return administratorRepository.save(admin);
    }

    public void delete(String id) {
        administratorRepository.deleteById(id);
    }

    //Login Function
    public Administrator login(String email, String password) {
        return administratorRepository.findByEmailAndPassword(email, password)
                // .orElseThrow(() -> new RuntimeException("Invalid credentials"));
                .orElse(null);
    }
}
