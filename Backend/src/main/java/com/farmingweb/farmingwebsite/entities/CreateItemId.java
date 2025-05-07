package com.farmingweb.farmingwebsite.entities;

import java.io.Serializable;
import java.util.Objects;

public class CreateItemId implements Serializable {
    private Integer item;
    private String farmer;

    public CreateItemId() {}

    public CreateItemId(Integer item, String farmer) {
        this.item = item;
        this.farmer = farmer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateItemId)) return false;
        CreateItemId that = (CreateItemId) o;
        return  Objects.equals(item, that.item) && 
                Objects.equals(farmer, that.farmer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, farmer);
    }
}
