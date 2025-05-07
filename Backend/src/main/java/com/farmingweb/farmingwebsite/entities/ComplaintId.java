package com.farmingweb.farmingwebsite.entities;

import java.io.Serializable;
import java.util.Objects;

public class ComplaintId implements Serializable {

    private Integer complaintID;
    private String farmer;

    public ComplaintId() {}

    public ComplaintId(Integer complaintID, String farmer) {
        this.complaintID = complaintID;
        this.farmer = farmer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplaintId)) return false;
        ComplaintId that = (ComplaintId) o;
        return Objects.equals(complaintID, that.complaintID) &&
               Objects.equals(farmer, that.farmer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(complaintID, farmer);
    }
}