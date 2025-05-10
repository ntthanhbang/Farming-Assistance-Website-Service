package com.farmingweb.farmingwebsite.entities;

import java.io.Serializable;
import java.util.Objects;

public class SupplierFarmerMessageId implements Serializable {
    private int sfMessageID;
    private String farmerID;
    private String supplierID;

    public SupplierFarmerMessageId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierFarmerMessageId)) return false;
        SupplierFarmerMessageId that = (SupplierFarmerMessageId) o;
        return sfMessageID == that.sfMessageID &&
                Objects.equals(farmerID, that.farmerID) &&
                Objects.equals(supplierID, that.supplierID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sfMessageID, farmerID, supplierID);
    }
}
