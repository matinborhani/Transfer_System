package com.example.demo.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.demo.controller"})
@ComponentScan({"com.example.demo.dao"})
@ComponentScan({"com.example.demo.entity"})
@ComponentScan({"com.example.demo.exception"})
@EntityScan(basePackages = {"com.example.demo.entity"})
@EnableJpaRepositories("com.example.demo.dao")
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

}
