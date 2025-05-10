package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Advertisement;
import com.farmingweb.farmingwebsite.entities.AdvertisementId;
import com.farmingweb.farmingwebsite.repositories.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    public List<Advertisement> getAll() {
        return advertisementRepository.findAll();
    }

    public Advertisement create(Advertisement obj) {
        return advertisementRepository.save(obj);
    }

    public void delete(AdvertisementId id) {
        advertisementRepository.deleteById(id);
    }
}
