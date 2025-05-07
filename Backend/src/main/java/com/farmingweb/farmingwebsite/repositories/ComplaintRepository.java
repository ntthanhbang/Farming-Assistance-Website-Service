package com.farmingweb.farmingwebsite.repositories;

import com.farmingweb.farmingwebsite.entities.Complaint;
import com.farmingweb.farmingwebsite.entities.ComplaintId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, ComplaintId> {
}
