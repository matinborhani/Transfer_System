package com.example.demo.dao;

import com.example.demo.entity.WayBil;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//@Component
//@Repository
//@ComponentScan({"com.example.demo.entity"})
//@EntityScan(basePackages = "com.example.demo.entity.WayBil")

public interface WayBilRepository extends CrudRepository<WayBil, Long> {
    @Override
    Iterable<WayBil> findAll();

    @Override
    <S extends WayBil> S save(S s);

    @Override
    Optional<WayBil> findById(Long aLong);

    @Override
    void delete(WayBil wayBil);

    @Override
    void deleteById(Long aLong);
}
