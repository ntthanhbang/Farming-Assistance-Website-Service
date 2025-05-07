package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.Complaint;
import com.farmingweb.farmingwebsite.entities.ComplaintId;
import com.farmingweb.farmingwebsite.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Complaint create(@RequestBody Complaint obj) {
        return complaintService.create(obj);
    }

    @DeleteMapping
    public void delete(@PathVariable ComplaintId id) {
        complaintService.delete(id);
    }
}
