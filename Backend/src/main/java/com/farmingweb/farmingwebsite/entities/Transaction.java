package com.farmingweb.farmingwebsite.entities;

import java.util.List;
import java.time.LocalDateTime;

import com.farmingweb.farmingwebsite.enums.PaymentMethod;
import com.farmingweb.farmingwebsite.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
// @IdClass(TransactionId.class)
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID", nullable = false)
    private int transactionID;


    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentMethod", nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentStatus", nullable = false)
    private PaymentStatus paymentStatus;

    @Column(name = "Timestamp")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "FarmerID")
    @JsonIgnore
    private Farmer farmer;

    @ManyToOne
    @JoinColumn(name = "SupplierID")
    @JsonIgnore
    private Supplier supplier;

    @OneToMany(mappedBy = "transaction")
    @JsonIgnore
    private List<TransactionItem> transactionItems;
}
