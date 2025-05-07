package com.farmingweb.farmingwebsite.entities;

import java.io.Serializable;
import java.util.Objects;

public class ReviewId implements Serializable {
    private Complaint complaint;
    private Administrator administrator;

    public ReviewId() {}

    public ReviewId(Complaint complaint,Farmer farmer, Administrator administrator) {
        this.complaint = complaint;
        this.administrator = administrator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReviewId)) return false;
        ReviewId that = (ReviewId) o;
        return  Objects.equals(complaint, that.complaint) &&
                Objects.equals(administrator, that.administrator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(complaint, administrator);
    }
}
