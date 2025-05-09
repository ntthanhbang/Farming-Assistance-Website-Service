package com.farmingweb.farmingwebsite.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private InventoryItem item;

    @Id
    @ManyToOne
    @JoinColumn(name = "FarmerID", referencedColumnName = "FarmerID")
    @JsonIgnore
    private Farmer farmer;
}
