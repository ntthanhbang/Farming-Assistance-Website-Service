package com.farmingweb.farmingwebsite.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Farmers")
public class Farmer {
    @Id
    @Column(name = "FarmerID", nullable = false, length = 8)
    private String farmerID;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Address")
    private String address;

    @Column(name = "FarmLocation")
    private String farmLocation;

}
