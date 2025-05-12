package com.farmingweb.farmingwebsite.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@IdClass(ReviewId.class)
@Table(name = "Review")
public class Review {
    @Id
    @Column(name = "ComplaintID")
    private int complaintID;

    @Id
    @Column(name = "FarmerID", length = 8)
    private String farmerID;

    @Id
    @Column(name = "AdminID", length = 8)
    private String adminID;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ComplaintID", referencedColumnName = "ComplaintID", insertable = false, updatable = false),
        @JoinColumn(name = "FarmerID", referencedColumnName = "FarmerID", insertable = false, updatable = false)
    })
    private Complaint complaint;

    @ManyToOne
    @JoinColumn(name = "AdminID", referencedColumnName = "AdminID", insertable = false, updatable = false)
    private Administrator admin;
}
