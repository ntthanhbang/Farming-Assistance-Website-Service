package com.farmingweb.farmingwebsite.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "InventoryItem")
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID", nullable = false)
    private Integer itemID;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "QuantityAvailable", nullable = false)
    private Float quantityAvailable;

    @Column(name = "Price", nullable = false)
    private Double price;

}
