package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Transaction;
import com.farmingweb.farmingwebsite.entities.TransactionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, TransactionId> {
}
