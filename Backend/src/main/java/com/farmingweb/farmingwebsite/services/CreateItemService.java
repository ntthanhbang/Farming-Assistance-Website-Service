package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.CreateItem;
import com.farmingweb.farmingwebsite.entities.CreateItemId;
import com.farmingweb.farmingwebsite.repositories.CreateItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateItemService {
    @Autowired
    private CreateItemRepository createitemRepository;

    public List<CreateItem> getAll() {
        return createitemRepository.findAll();
    }

    //Add & save items
    public CreateItem create(CreateItem createitem) {
        return createitemRepository.save(createitem);
    }

    public void delete(CreateItemId id) {
        createitemRepository.deleteById(id);
    }

    //Display farmer's items
    public List<CreateItem> getItemsByFarmer(String farmerID) {
        return createitemRepository.findByFarmer_FarmerID(farmerID);
    }

    //Search items by name
    public List<CreateItem> searchItemsByName(String farmerID, String name) {
        return createitemRepository.findByFarmer_FarmerIDAndItem_NameContainingIgnoreCase(farmerID, name);
    }
}
