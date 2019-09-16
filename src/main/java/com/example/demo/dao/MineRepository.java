package com.example.demo.dao;

import com.example.demo.entity.Mine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MineRepository extends CrudRepository<Mine,Long> {

    @Override
    Iterable<Mine> findAll();

    @Query(
            value = "SELECT * FROM MINE u WHERE u.COD_NTN_MINE = ?1",
            nativeQuery = true
    )
    public List<Mine> findByNTN(String nationalCode);

    @Query(
            value = "SELECT * FROM MINE u WHERE u.NAM_MINE = ?1",
            nativeQuery = true
    )
    public List<Mine> findByName(String name);

    @Override
    <S extends Mine> S save(S s);
}
