package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Farmer;
import com.farmingweb.farmingwebsite.entities.Supplier;
import com.farmingweb.farmingwebsite.entities.Transaction;
import com.farmingweb.farmingwebsite.entities.TransactionItem;
import com.farmingweb.farmingwebsite.repositories.SupplierRepository;
import com.farmingweb.farmingwebsite.repositories.TransactionRepository;
import com.farmingweb.farmingwebsite.repositories.FarmerRepository;
import com.farmingweb.farmingwebsite.repositories.TransactionItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    private SupplierRepository supplierRepository;
    private FarmerRepository farmerRepository;
    private TransactionItemRepository transactionItemRepository;

    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsBySupplier(String supplierID) {
        Supplier supplier = supplierRepository.findById(supplierID)
            .orElseThrow(() -> new RuntimeException("Supplier not found"));
        return transactionRepository.findBySupplier(supplier);
    }

    public Transaction createTransaction(Transaction transaction) {
        Farmer farmer = farmerRepository.findById(transaction.getFarmer().getFarmerID())
            .orElseThrow(() -> new RuntimeException("Farmer not found"));
        Supplier supplier = supplierRepository.findById(transaction.getSupplier().getSupplierID())
            .orElseThrow(() -> new RuntimeException("Supplier not found"));

        transaction.setFarmer(farmer);
        transaction.setSupplier(supplier);
        transaction.setTimestamp(LocalDateTime.now());

        //Save transaction to generate ID
        Transaction savedTransaction = transactionRepository.save(transaction);

        //Link and save transaction item
        for (TransactionItem item : transaction.getTransactionItems()) {
            item.setTransaction(savedTransaction);
            transactionItemRepository.save(item);
        }

        return savedTransaction;
    }

    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }
}
