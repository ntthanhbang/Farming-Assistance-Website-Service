package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, String> {
    
}
