package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findBySupplier_SupplierID(String supplierID);

    List<Transaction> findByFarmer_FarmerID(String farmerID);
}
