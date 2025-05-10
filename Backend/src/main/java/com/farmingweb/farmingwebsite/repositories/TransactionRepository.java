package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Supplier;
import com.farmingweb.farmingwebsite.entities.Transaction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findBySupplier(Supplier supplier);
}
