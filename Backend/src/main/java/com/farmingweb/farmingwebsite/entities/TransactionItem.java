package com.farmingweb.farmingwebsite.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToOne
    @JoinColumn(name = "TransactionID", nullable = false)
    @JsonIgnore
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "ItemID", insertable = false, updatable = false)
    @JsonIgnore
    private InventoryItem item;
}
