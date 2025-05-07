package com.farmingweb.farmingwebsite.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CreateItem")
@IdClass(CreateItemId.class)
public class CreateItem {
    @Id
    @ManyToOne
    @JoinColumn(name = "ItemID", referencedColumnName = "ItemID")
    private InventoryItem item;

    @Id
    @ManyToOne
    @JoinColumn(name = "FarmerID", referencedColumnName = "FarmerID")
    private Farmer farmer;
}
