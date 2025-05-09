package com.farmingweb.farmingwebsite.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @OneToMany(mappedBy = "farmer")
    @JsonIgnore
    private List<Complaint> complaints;

    @OneToMany(mappedBy = "farmer")
    @JsonIgnore
    private List<Notification> notifications;

    @OneToMany(mappedBy = "send")
    @JsonIgnore
    private List<FarmerFarmerMessage> sentMessages;

    @OneToMany(mappedBy = "recieve")
    @JsonIgnore
    private List<FarmerFarmerMessage> recieveMessages;

    @OneToMany(mappedBy = "farmer")
    @JsonIgnore
    private List<SupplierFarmerMessage> supplierMessages;
}
