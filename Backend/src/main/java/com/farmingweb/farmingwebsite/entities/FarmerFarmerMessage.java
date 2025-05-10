package com.farmingweb.farmingwebsite.entities;

import com.farmingweb.farmingwebsite.enums.MessageStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @Column(name = "Farmer1ID", length = 8)
    private String farmer1ID;

    @Id
    @Column(name = "Farmer2ID", length = 8)
    private String farmer2ID;

    @Column(name = "Content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private MessageStatus status;

    @Column(name = "Timestamp")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "Farmer1ID", insertable = false, updatable = false)
    @JsonIgnore
    private Farmer send;

    @ManyToOne 
    @JoinColumn(name = "Farmer2ID", insertable = false, updatable = false)
    @JsonIgnore
    private Farmer recieve;
}
