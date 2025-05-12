package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.Transaction;
import com.farmingweb.farmingwebsite.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAll() {
        return transactionService.getAll();
    }

    //Display transactions (suppliers)
    @GetMapping("/supplier/{supplierID}")
    public List<Transaction> getBySupplier(@PathVariable String supplierID) {
        return transactionService.getTransactionsBySupplier(supplierID);
    }
    
    //Display transactions (farmers)
    @GetMapping("/farmer/{farmerID}")
    public List<Transaction> getByFarmerID(@PathVariable String farmerID) {
        return transactionService.getByFarmerID(farmerID);
    }
    
    @PostMapping("/create")
    public Transaction create(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        transactionService.delete(id);
    }
}
