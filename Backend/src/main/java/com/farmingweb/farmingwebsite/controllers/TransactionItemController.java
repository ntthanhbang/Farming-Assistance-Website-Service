package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.TransactionItem;
import com.farmingweb.farmingwebsite.entities.TransactionItemId;
import com.farmingweb.farmingwebsite.services.TransactionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactionitems")
public class TransactionItemController {
    @Autowired
    private TransactionItemService transactionitemService;

    @GetMapping
    public List<TransactionItem> getAll() {
        return transactionitemService.getAll();
    }

    @PostMapping
    public TransactionItem create(@RequestBody TransactionItem obj) {
        return transactionitemService.create(obj);
    }

    @DeleteMapping
    public void delete(@PathVariable TransactionItemId id) {
        transactionitemService.delete(id);
    }
}
