package com.farmingweb.farmingwebsite.entities;

import com.farmingweb.farmingwebsite.enums.ComplaintStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "Complaints")
@IdClass(ComplaintId.class)
public class Complaint {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ComplaintID", nullable = false)
    private Integer complaintID;

    @Id
    @ManyToOne
    @JoinColumn(name = "FarmerID")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Farmer farmer;

    @Column(name = "Subject", nullable = false, length = 200)
    private String subject;

    @Column(name = "Content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private ComplaintStatus status;

    @Column(name = "Timestamp")
    private LocalDateTime timestamp;

    @OneToMany(mappedBy = "complaint")
    @JsonIgnore
    private List<Review> reviews;
}
