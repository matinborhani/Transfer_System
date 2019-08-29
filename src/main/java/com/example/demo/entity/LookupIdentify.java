package com.example.demo.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class LookupIdentify implements Serializable {


    private String valueLookUP;

    private String nameLookup;

    // Constructor

    public LookupIdentify() {
    }

    // Getter & Setter


    public String getValueLookUP() {
        return valueLookUP;
    }

    public void setValueLookUP(String valueLookUP) {
        this.valueLookUP = valueLookUP;
    }

    public String getNameLookup() {
        return nameLookup;
    }

    public void setNameLookup(String nameLookup) {
        this.nameLookup = nameLookup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        else return false;
//        LookupIdentify that = (LookupIdentify) o;
//
//        if (!employeeId.equals(that.employeeId)) return false;
//        return companyId.equals(that.companyId);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
