package com.farmingweb.farmingwebsite.entities;

import java.io.Serializable;
import java.util.Objects;

public class FarmerFarmerMessageId implements Serializable {
    private Integer ffMessageID;
    private String farmer1ID;
    private String farmer2ID;

    public FarmerFarmerMessageId() {}

    // public FarmerFarmerMessageId(Integer ffMessageID, String farmer1, String farmer2) {
    //     this.ffMessageID = ffMessageID;
    //     this.farmer1ID = farmer1ID;
    //     this.farmer2ID = farmer2ID;
    // }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FarmerFarmerMessageId)) return false;
        FarmerFarmerMessageId that = (FarmerFarmerMessageId) o;
        return Objects.equals(ffMessageID, that.ffMessageID) &&
               Objects.equals(farmer1ID, that.farmer1ID) &&
               Objects.equals(farmer2ID, that.farmer2ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ffMessageID, farmer1ID, farmer2ID);
    }
}
