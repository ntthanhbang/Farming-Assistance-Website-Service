package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, String> {
    Optional<Administrator> findByEmailAndPassword(String email, String password);
}
