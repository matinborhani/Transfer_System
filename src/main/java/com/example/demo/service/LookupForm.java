package com.example.demo.service;

import java.util.List;

public class LookupForm {
    List lkpStatus;
    List<String> lkpGoods;
    List<String> lkpTypeCars;


    // GETTER & SETTER

    public List getLkpStatus() {
        return lkpStatus;
    }

    public void setLkpStatus(List lkpStatus) {
        this.lkpStatus = lkpStatus;
    }

    public List<String> getLkpGoods() {
        return lkpGoods;
    }

    public void setLkpGoods(List<String> lkpGoods) {
        this.lkpGoods = lkpGoods;
    }

    public List<String> getLkpTypeCars() {
        return lkpTypeCars;
    }

    public void setLkpTypeCars(List<String> lkpTypeCars) {
        this.lkpTypeCars = lkpTypeCars;
    }


}
