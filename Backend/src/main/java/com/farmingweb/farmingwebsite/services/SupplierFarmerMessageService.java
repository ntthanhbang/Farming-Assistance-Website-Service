package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.SupplierFarmerMessage;
import com.farmingweb.farmingwebsite.entities.SupplierFarmerMessageId;
import com.farmingweb.farmingwebsite.repositories.SupplierFarmerMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierFarmerMessageService {
    @Autowired
    private SupplierFarmerMessageRepository supplierfarmermessageRepository;

    public List<SupplierFarmerMessage> getAll() {
        return supplierfarmermessageRepository.findAll();
    }

    public SupplierFarmerMessage create(SupplierFarmerMessage obj) {
        return supplierfarmermessageRepository.save(obj);
    }

    public void delete(SupplierFarmerMessageId id) {
        supplierfarmermessageRepository.deleteById(id);
    }
}
