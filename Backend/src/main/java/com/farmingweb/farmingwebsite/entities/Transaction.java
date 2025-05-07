package com.farmingweb.farmingwebsite.entities;

import com.farmingweb.farmingwebsite.enums.PaymentMethod;
import com.farmingweb.farmingwebsite.enums.PaymentStatus;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@IdClass(TransactionId.class)
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID", nullable = false)
    private int transactionID;

    @Id
    @Column(name = "FarmerID", length = 8)
    private String farmerID;

    @Id
    @Column(name = "SupplierID", length = 8)
    private String supplierID;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentMethod", nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentStatus", nullable = false)
    private PaymentStatus paymentStatus;

    @Column(name = "Timestamp")
    private LocalDateTime Timestamp;
}
