package com.farmingweb.farmingwebsite.entities;

import com.farmingweb.farmingwebsite.enums.NotificationStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotificationID")
    private Integer notificationID;

    @Column(name = "Content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", nullable = false)
    private NotificationStatus status;

    @Column(name = "TimeStamp", nullable = false)
    private LocalDateTime  timeStamp;

    // @Column(name = "FarmerID", nullable = false, length = 8)
    // private String farmerID;

    @ManyToOne
    @JoinColumn(name = "FarmerID")
    @JsonIgnore
    private Farmer farmer;

    @OneToOne
    @JoinColumn(name = "AdID", referencedColumnName = "AdID")
    @JsonIgnore
    private Advertisement advertisement;
}
