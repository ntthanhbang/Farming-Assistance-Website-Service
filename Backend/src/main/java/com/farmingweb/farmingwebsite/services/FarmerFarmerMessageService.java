package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.FarmerFarmerMessage;
import com.farmingweb.farmingwebsite.entities.FarmerFarmerMessageId;
import com.farmingweb.farmingwebsite.repositories.FarmerFarmerMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerFarmerMessageService {
    @Autowired
    private FarmerFarmerMessageRepository farmerfarmermessageRepository;

    public List<FarmerFarmerMessage> getAll() {
        return farmerfarmermessageRepository.findAll();
    }

    public FarmerFarmerMessage create(FarmerFarmerMessage ffm) {
        return farmerfarmermessageRepository.save(ffm);
    }

    public void delete(FarmerFarmerMessageId id) {
        farmerfarmermessageRepository.deleteById(id);
    }
}
