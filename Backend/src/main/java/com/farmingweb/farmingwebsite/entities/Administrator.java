package com.farmingweb.farmingwebsite.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Administrators")
public class Administrator {
    @Id
    @Column(name = "AdminID",nullable = false, length = 8)
    private String adminID;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Phone", nullable = false)
    private String phone;

    @Column(name = "Email", nullable = false)
    private String email;
}
