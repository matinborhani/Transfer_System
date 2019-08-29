package com.example.demo.dao;

import com.example.demo.entity.LookupIdentify;
import com.example.demo.entity.ValueLookup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LookupRepository extends CrudRepository<ValueLookup, LookupIdentify> {

    @Override
    Iterable<ValueLookup> findAll();

    @Query(
            value = "SELECT * FROM Lookup u WHERE u.NAME_LOOKUP = 'LKP_COD_GOODS'",
            nativeQuery = true)
    public List<ValueLookup> findByValueLookup();

    @Query(
            value = "SELECT * FROM LOOKUP u WHERE u.NAME_LOOKUP = 'LKP_COD_STA'",
            nativeQuery = true
    )
    public List<ValueLookup> findAllStatusByValueLookup();

    @Query(
            value = "SELECT * FROM LOOKUP u WHERE u.NAME_LOOKUP = 'LKP_COD_CAR'",
            nativeQuery = true
    )
    public List<ValueLookup> findAllCarByValueLookup();
}
