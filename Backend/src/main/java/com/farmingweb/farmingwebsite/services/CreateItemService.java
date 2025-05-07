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

    public CreateItem create(CreateItem obj) {
        return createitemRepository.save(obj);
    }

    public void delete(CreateItemId id) {
        createitemRepository.deleteById(id);
    }
}
