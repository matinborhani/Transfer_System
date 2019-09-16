package com.example.demo.dao;

import com.example.demo.entity.Driver;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends CrudRepository<Driver,Long> {
    @Override
    Iterable<Driver> findAll();

    @Override
    Optional<Driver> findById(Long aLong);

    @Query(
            value = "SELECT * FROM DRIVER u WHERE u.COD_NTN_DRV = ?1",
            nativeQuery = true
    )
    public List<Driver> findByNTNCode(String ntn_code);

    @Query(
            value = "SELECT * FROM DRIVER u WHERE u.NAM_DRV = ?1",
            nativeQuery = true
    )
    public List<Driver> findByName(String name);
    @Override
    <S extends Driver> S save(S s);
}
