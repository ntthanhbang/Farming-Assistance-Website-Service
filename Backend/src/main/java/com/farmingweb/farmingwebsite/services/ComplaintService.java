package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Complaint;
import com.farmingweb.farmingwebsite.entities.ComplaintId;
import com.farmingweb.farmingwebsite.repositories.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;

    public List<Complaint> getAll() {
        return complaintRepository.findAll();
    }

    public Complaint create(Complaint obj) {
        return complaintRepository.save(obj);
    }

    public void delete(ComplaintId id) {
        complaintRepository.deleteById(id);
    }
}
