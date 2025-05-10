package com.farmingweb.farmingwebsite.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@Table(name = "Advertisements")
@IdClass(AdvertisementId.class)
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdID")
    private Integer adID;

    @Id
    @ManyToOne
    @JoinColumn(name = "SupplierID")
    @JsonIgnore
    private Supplier supplier;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Content", nullable = false)
    private String content;

    @Column(name = "Timestamp")
    private LocalDateTime timestamp;

    @OneToOne(mappedBy = "advertisement")
    @JsonIgnore
    private Notification notification;
}
