package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.InventoryItem;
import com.farmingweb.farmingwebsite.repositories.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemService {
    @Autowired
    private InventoryItemRepository inventoryitemRepository;

    public List<InventoryItem> getAll() {
        return inventoryitemRepository.findAll();
    }

    public InventoryItem create(InventoryItem invitem) {
        return inventoryitemRepository.save(invitem);
    }

    public InventoryItem save(InventoryItem item) {
        return inventoryitemRepository.save(item);
    }

    //Display and search
    public List<InventoryItem> searchByName(String name) {
        return inventoryitemRepository.findByNameContainingIgnoreCase(name);
    }

    public void delete(Integer id) {
        inventoryitemRepository.deleteById(id);
    }
}
