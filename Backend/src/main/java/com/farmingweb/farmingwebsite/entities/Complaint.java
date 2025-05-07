package com.farmingweb.farmingwebsite.entities;

import com.farmingweb.farmingwebsite.enums.ComplaintStatus;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "Complaints")
@IdClass(ComplaintId.class)
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ComplaintID", nullable = false)
    private Integer complaintID;

    @Id
    @ManyToOne
    @JoinColumn(name = "FarmerID", referencedColumnName = "FarmerID")
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
}
