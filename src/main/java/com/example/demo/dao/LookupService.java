package com.example.demo.dao;

import com.example.demo.entity.ValueLookup;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LookupService {

    @Autowired
    LookupRepository lookupRepository;


    public List<ValueLookup> getAllLookup() {
        List<ValueLookup> valueLookups = Lists.newArrayList(lookupRepository.findAll());
        return valueLookups;
    }

    public List<ValueLookup> getGoodsLookup() {
        List<ValueLookup> goodsLookup = lookupRepository.findByValueLookup();
        return goodsLookup;
    }


    public List<ValueLookup> getStatusLookup() {
        ArrayList<ValueLookup> statusLookups = Lists.newArrayList(lookupRepository.findAllStatusByValueLookup());
        return statusLookups;
    }

    public List<ValueLookup> getCarsLookup() {
        ArrayList<ValueLookup> carsLookups = Lists.newArrayList(lookupRepository.findAllCarByValueLookup());
        return carsLookups;
    }


}
