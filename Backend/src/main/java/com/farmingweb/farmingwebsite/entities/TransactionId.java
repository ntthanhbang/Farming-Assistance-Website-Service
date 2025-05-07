package com.farmingweb.farmingwebsite.entities;

import java.io.Serializable;
import java.util.Objects;

public class TransactionId implements Serializable {
    private int transactionID;
    private String farmerID;
    private String supplierID;

    public TransactionId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionId)) return false;
        TransactionId that = (TransactionId) o;
        return  Objects.equals(transactionID, that.transactionID) &&
                Objects.equals(farmerID, that.farmerID) &&
                Objects.equals(supplierID, that.supplierID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, farmerID, supplierID);
    }
}
