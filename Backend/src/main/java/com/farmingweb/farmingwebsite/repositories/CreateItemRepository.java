package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.CreateItem;
import com.farmingweb.farmingwebsite.entities.CreateItemId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreateItemRepository extends JpaRepository<CreateItem,CreateItemId> {
    List<CreateItem> findByFarmer_FarmerID(String farmerID);
    
    List<CreateItem> findByFarmer_FarmerIDAndItem_NameContainingIgnoreCase(String farmerID, String name);
}
