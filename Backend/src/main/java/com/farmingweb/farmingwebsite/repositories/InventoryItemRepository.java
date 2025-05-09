package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.InventoryItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer> {
    //Display and search items
    List<InventoryItem> findByNameContainingIgnoreCase(String name);
}
