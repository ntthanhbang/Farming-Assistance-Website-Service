package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
