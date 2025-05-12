package com.farmingweb.farmingwebsite.controllers;

import com.farmingweb.farmingwebsite.entities.Complaint;
import com.farmingweb.farmingwebsite.entities.ComplaintId;
import com.farmingweb.farmingwebsite.services.ComplaintService;
import com.farmingweb.farmingwebsite.enums.ComplaintStatus;

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

    @GetMapping("/new")
    public List<Complaint> getNewComplaints() {
        return complaintService.getNewComplaints();
    }

    @GetMapping("/status/{status}")
    public List<Complaint> getByStatus(@PathVariable ComplaintStatus status) {
        return complaintService.getByStatus(status);
    }

    @PostMapping
    public Complaint create(@RequestBody Complaint complaint) {
        return complaintService.create(complaint);
    }

    @PostMapping("/review/{complaintID}/{farmerID}")
    public Complaint reviewComplaint(
        @PathVariable Integer complaintID,
        @PathVariable String farmerID,
        @RequestParam ComplaintStatus status,
        @RequestParam String adminID
    ) {
        return complaintService.reviewComplaintWithAdmin(
            new ComplaintId(complaintID, farmerID),
            status,
            adminID
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ComplaintId id) {
        complaintService.delete(id);
    }

    @DeleteMapping("/{complaintID}/{farmerID}")
    public void delete(@PathVariable Integer complaintID, @PathVariable String farmerID) {
        complaintService.delete(new ComplaintId(complaintID, farmerID));
    }
}
