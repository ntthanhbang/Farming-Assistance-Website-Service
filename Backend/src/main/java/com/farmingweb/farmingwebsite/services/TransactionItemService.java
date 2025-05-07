package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.TransactionItem;
import com.farmingweb.farmingwebsite.entities.TransactionItemId;
import com.farmingweb.farmingwebsite.repositories.TransactionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionItemService {
    @Autowired
    private TransactionItemRepository transactionitemRepository;

    public List<TransactionItem> getAll() {
        return transactionitemRepository.findAll();
    }

    public TransactionItem create(TransactionItem obj) {
        return transactionitemRepository.save(obj);
    }

    public void delete(TransactionItemId id) {
        transactionitemRepository.deleteById(id);
    }
}
