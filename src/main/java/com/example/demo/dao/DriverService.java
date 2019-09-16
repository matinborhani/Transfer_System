package com.example.demo.dao;

import com.example.demo.entity.Driver;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService  {

    @Autowired
    DriverRepository driverRepository;

    public List<Driver> getAllDriver(){
        ArrayList<Driver> drivers = Lists.newArrayList(driverRepository.findAll());
        return drivers;
    }

    public Driver getDriver(Driver driver){
        List<Driver> drivers;
        if (driver.getCodNtnDrv() != null) {
            drivers = driverRepository.findByNTNCode(driver.getCodNtnDrv());
        }
        else {
            drivers = driverRepository.findByName(driver.getNamDrv());
        }
        if (drivers.isEmpty())
            return null;
        else {
            return drivers.get(0);
        }

    }

    public boolean updateDriver(Driver driver){
        Driver driverResult = driverRepository.save(driver);
        if (driverResult != null)
            return true;
        else
            return false;
    }
}
