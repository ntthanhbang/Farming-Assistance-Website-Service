package com.farmingweb.farmingwebsite.entities;

import java.io.Serializable;
import java.util.Objects;

public class FarmerFarmerMessageId implements Serializable {
    private Integer ffMessageID;
    private String farmer1;
    private String farmer2;

    public FarmerFarmerMessageId() {}

    public FarmerFarmerMessageId(Integer ffMessageID, String farmer1, String farmer2) {
        this.ffMessageID = ffMessageID;
        this.farmer1 = farmer1;
        this.farmer2 = farmer2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FarmerFarmerMessageId)) return false;
        FarmerFarmerMessageId that = (FarmerFarmerMessageId) o;
        return Objects.equals(ffMessageID, that.ffMessageID) &&
               Objects.equals(farmer1, that.farmer1) &&
               Objects.equals(farmer2, that.farmer2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ffMessageID, farmer1, farmer2);
    }
}
