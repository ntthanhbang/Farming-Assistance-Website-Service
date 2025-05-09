package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, String> {
    Optional<Farmer> findByEmailAndPassword(String email, String password);
}
