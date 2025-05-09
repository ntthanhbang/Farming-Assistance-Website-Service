package com.farmingweb.farmingwebsite.entities;

import java.io.Serializable;
import java.util.Objects;

public class ReviewId implements Serializable {
    private int complaintID;
    private String farmerID;
    private String adminID;

    public ReviewId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewId)) return false;
        ReviewId that = (ReviewId) o;
        return  complaintID == that.complaintID &&
                Objects.equals(farmerID, that.farmerID) &&
                Objects.equals(adminID, that.adminID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(complaintID, farmerID, adminID);
    }
}
