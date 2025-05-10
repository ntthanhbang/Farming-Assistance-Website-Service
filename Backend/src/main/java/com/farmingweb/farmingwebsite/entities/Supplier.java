package com.farmingweb.farmingwebsite.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Suppliers")
public class Supplier {
    @Id
    @Column(name = "SupplierID", nullable = false, length = 8)
    private String supplierID;

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

    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<SupplierFarmerMessage> supplierMessages;

    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<Advertisement> advertisement;
}
