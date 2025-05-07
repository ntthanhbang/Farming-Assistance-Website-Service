package com.farmingweb.farmingwebsite.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TransactionItem")
@IdClass(TransactionItemId.class)
public class TransactionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransItemID", nullable = false)
    private int transItemID;

    @Id
    @Column(name = "ItemID")
    private int itemID;

    @Column(name = "Quantity", nullable = false)
    private float quantity;

    @Column(name = "TransactionID")
    private int transactionID;
}
