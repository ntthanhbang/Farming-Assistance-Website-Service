package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Transaction;
import com.farmingweb.farmingwebsite.entities.TransactionId;
import com.farmingweb.farmingwebsite.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public Transaction create(Transaction obj) {
        return transactionRepository.save(obj);
    }

    public void delete(TransactionId id) {
        transactionRepository.deleteById(id);
    }
}
