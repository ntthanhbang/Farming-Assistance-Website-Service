package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.InventoryItem;
import com.farmingweb.farmingwebsite.services.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventoryitems")
public class InventoryItemController {
    @Autowired
    private InventoryItemService inventoryitemService;

    @GetMapping
    public List<InventoryItem> getAll() {
        return inventoryitemService.getAll();
    }

    @PostMapping
    public InventoryItem create(@RequestBody InventoryItem obj) {
        return inventoryitemService.create(obj);
    }
    // public InventoryItem save(@RequestBody InventoryItem item) {
    //     return inventoryitemService.save(item);
    // }

    @DeleteMapping
    public void delete(@PathVariable Integer id) {
        inventoryitemService.delete(id);
    }
}
