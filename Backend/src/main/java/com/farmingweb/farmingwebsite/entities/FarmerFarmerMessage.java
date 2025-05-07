package com.farmingweb.farmingwebsite.entities;

import com.farmingweb.farmingwebsite.enums.MessageStatus;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "FarmerFarmerMessages")
@IdClass(FarmerFarmerMessageId.class)
public class FarmerFarmerMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FFMessageID", nullable = false)
    private int ffMessageID;

    @Id
    @ManyToOne
    @JoinColumn(name = "Farmer1ID", referencedColumnName = "FarmerID")
    private Farmer farmer1;

    @Id
    @ManyToOne 
    @JoinColumn(name = "Farmer2ID", referencedColumnName = "FarmerID")
    private Farmer farmer2;

    @Column(name = "Content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private MessageStatus status;

    @Column(name = "Timestamp")
    private LocalDateTime timestamp;
}
