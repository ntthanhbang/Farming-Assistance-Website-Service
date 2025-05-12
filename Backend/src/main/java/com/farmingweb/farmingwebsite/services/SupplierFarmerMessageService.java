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

    public SupplierFarmerMessage create(SupplierFarmerMessage sfm) {
        return supplierfarmermessageRepository.save(sfm);
    }

    public void delete(SupplierFarmerMessageId id) {
        supplierfarmermessageRepository.deleteById(id);
    }

    public List<SupplierFarmerMessage> getMessagesBetween(String supplierID, String farmerID) {
        return supplierfarmermessageRepository.findBySupplierIDAndFarmerID(supplierID, farmerID);
    }

    public List<String> getConnectedFarmerIDs(String supplierID) {
        return supplierfarmermessageRepository.findDistinctFarmerIDsBySupplierID(supplierID);
    }
}
