package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "LOOKUP")
public class ValueLookup {
    //    @Id
//    @Column(name = "LKP_NAM_LKPVL")
//    String categoryName;
//    @Id
//    @Column(name = "VAL_LOOKUP_LKPVL")
//    String value;
    @EmbeddedId
    LookupIdentify lookupIdentify;
    @Column(name = "DES_FARSI_LKPVL")
    String desFarsi;
    @Column(name = "DES_LATIN_LKPVL")
    String desLatin;


    // Construtor

    public ValueLookup() {
    }

    public ValueLookup(LookupIdentify lookupIdentify, String desFarsi, String desLatin) {
        this.lookupIdentify = lookupIdentify;
        this.desFarsi = desFarsi;
        this.desLatin = desLatin;
    }

// GETTER & SETTER


//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }


    public LookupIdentify getLookupIdentify() {
        return lookupIdentify;
    }

    public void setLookupIdentify(LookupIdentify lookupIdentify) {
        this.lookupIdentify = lookupIdentify;
    }

    public String getDesFarsi() {
        return desFarsi;
    }

    public void setDesFarsi(String desFarsi) {
        this.desFarsi = desFarsi;
    }

    public String getDesLatin() {
        return desLatin;
    }

    public void setDesLatin(String desLatin) {
        this.desLatin = desLatin;
    }
}
