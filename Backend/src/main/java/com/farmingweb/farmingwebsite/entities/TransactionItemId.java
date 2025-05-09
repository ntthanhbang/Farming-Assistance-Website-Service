package com.farmingweb.farmingwebsite.entities;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class TransactionItemId implements Serializable {
    private int transItemID;
    private int itemID;

    public TransactionItemId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionItemId)) return false;
        TransactionItemId that = (TransactionItemId) o;
        return transItemID == that.transItemID && itemID == that.itemID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transItemID, itemID);
    }
}
