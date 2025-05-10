package com.farmingweb.farmingwebsite.entities;

import com.farmingweb.farmingwebsite.enums.MessageStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "SupplierFarmerMessages")
@IdClass(SupplierFarmerMessageId.class)
public class SupplierFarmerMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SFMessageID", nullable = false)
    private int sfMessageID;

    @Id
    @Column(name = "FarmerID", length = 8)
    private String farmerID;

    @Id
    @Column(name = "SupplierID", length = 8)
    private String supplierID;

    @Column(name = "Content", columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private MessageStatus status;

    @Column(name = "Timestamp")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "FarmerID", referencedColumnName = "FarmerID", insertable = false, updatable = false)
    @JsonIgnore
    private Farmer farmer;

    @ManyToOne
    @JoinColumn(name = "SupplierID", referencedColumnName = "SupplierID", insertable = false, updatable = false)
    @JsonIgnore
    private Supplier supplier;
}
