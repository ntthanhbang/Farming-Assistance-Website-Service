package com.farmingweb.farmingwebsite.services;

import com.farmingweb.farmingwebsite.entities.Complaint;
import com.farmingweb.farmingwebsite.entities.ComplaintId;
import com.farmingweb.farmingwebsite.entities.Review;
import com.farmingweb.farmingwebsite.repositories.ComplaintRepository;
import com.farmingweb.farmingwebsite.enums.ComplaintStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComplaintService {
    @Autowired
    private ComplaintRepository complaintRepository;
    private ReviewService reviewService;

    public List<Complaint> getAll() {
        return complaintRepository.findAll();
    }

    public List<Complaint> getByStatus(ComplaintStatus status) {
        return complaintRepository.findByStatus(status);
    }
    
    public Complaint create(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    public void delete(ComplaintId id) {
        complaintRepository.deleteById(id);
    }

    //Get new complaints
    public List<Complaint> getNewComplaints() {
        return complaintRepository.findByStatus(ComplaintStatus.unreviewed);
    }

    //Change status of complaints
    public Complaint updateStatus(ComplaintId id, ComplaintStatus status) {
        Optional<Complaint> optionalComplaint = complaintRepository.findById(id);
        if (optionalComplaint.isPresent()) {
            Complaint complaint = optionalComplaint.get();
            complaint.setStatus(status);
            return complaintRepository.save(complaint);
        } else {
            throw new RuntimeException("Complaint not found!");
        }
    }

    //Review complaint
    public Complaint reviewComplaintWithAdmin(ComplaintId id, ComplaintStatus status, String adminID) {
        Complaint complaint = updateStatus(id, status);

        Review review = new Review();
        review.setComplaintID(id.getComplaintID());
        review.setFarmerID(id.getFarmer());
        review.setAdminID(adminID);

        reviewService.saveReview(review);
        return complaint;
    }
}
