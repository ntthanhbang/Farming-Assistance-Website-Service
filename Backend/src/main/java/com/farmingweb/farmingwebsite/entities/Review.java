package com.farmingweb.farmingwebsite.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@IdClass(ReviewId.class)
@Table(name = "Review")
public class Review {
    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ComplaintID", referencedColumnName = "ComplaintID"),
        @JoinColumn(name = "FarmerID", referencedColumnName = "FarmerID")
    })
    private Complaint complaint;

    @Id
    @ManyToOne
    @JoinColumn(name = "AdminID", referencedColumnName = "AdminID")
    private Administrator administrator;
}
