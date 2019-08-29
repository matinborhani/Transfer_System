package com.example.demo.entity;

public class Student {
    private String family;
    private String name;
    private Integer id;

    /* ********
     Constructor
     ********/
    public Student(Integer id, String name, String family) {
        this.family = family;
        this.name = name;
        this.id = id;
    }

    public Student(String family, String name) {
        this.family = family;
        this.name = name;
    }

    public Student() {
    }

    // GETTER & SETTER **************

    public void setFamily(String family) {

        this.family = family;
    }

    public String getFamily() {
        return family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
