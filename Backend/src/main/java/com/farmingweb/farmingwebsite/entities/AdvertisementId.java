package com.farmingweb.farmingwebsite.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class AdvertisementId implements Serializable {
    private int adID;
    private String supplier;
}
