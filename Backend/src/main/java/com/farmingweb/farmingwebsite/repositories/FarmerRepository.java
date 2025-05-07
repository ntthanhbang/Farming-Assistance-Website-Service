package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, String> {
}
