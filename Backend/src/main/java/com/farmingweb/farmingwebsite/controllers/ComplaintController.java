package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.Complaint;
import com.farmingweb.farmingwebsite.entities.ComplaintId;
import com.farmingweb.farmingwebsite.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;

    @GetMapping
    public List<Complaint> getAll() {
        return complaintService.getAll();
    }

    @PostMapping
    public Complaint create(@RequestBody Complaint complaint) {
        return complaintService.create(complaint);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ComplaintId id) {
        complaintService.delete(id);
    }
}
