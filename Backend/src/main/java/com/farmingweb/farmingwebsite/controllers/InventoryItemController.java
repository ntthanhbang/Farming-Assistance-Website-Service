package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.InventoryItem;
import com.farmingweb.farmingwebsite.services.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/inventoryitems")
public class InventoryItemController {
    @Autowired
    private InventoryItemService inventoryitemService;

    @GetMapping
    public List<InventoryItem> getAll() {
        return inventoryitemService.getAll();
    }

    //Display and search
    @GetMapping("/inventoryitems/search")
    public List<InventoryItem> searchItems(@RequestParam String invitem) {
        return inventoryitemService.searchByName(invitem);
    }

    @PostMapping
    public InventoryItem create(@RequestBody InventoryItem obj) {
        return inventoryitemService.create(obj);
    }
    // public InventoryItem save(@RequestBody InventoryItem item) {
    //     return inventoryitemService.save(item);
    // }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        inventoryitemService.delete(id);
    }
}
