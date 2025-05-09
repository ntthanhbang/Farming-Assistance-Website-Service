package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, String> {
    Optional<Supplier> findByEmailAndPassword(String email, String password);
}
