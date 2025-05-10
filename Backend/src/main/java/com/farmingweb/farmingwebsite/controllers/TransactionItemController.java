package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.TransactionItem;
import com.farmingweb.farmingwebsite.entities.TransactionItemId;
import com.farmingweb.farmingwebsite.services.TransactionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
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
    public TransactionItem create(@RequestBody TransactionItem transitem) {
        return transactionitemService.create(transitem);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable TransactionItemId id) {
        transactionitemService.delete(id);
    }
}
