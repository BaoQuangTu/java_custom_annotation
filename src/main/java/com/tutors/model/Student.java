package com.tutors.model;

import com.tutors.annotation.MappingField;

public class Student extends People {
    private String id;
    @MappingField(prefix="Tên tôi là ")
    private String name;
    @MappingField(suffix=" là địa chỉ của tôi")
    private String address;
    @MappingField
    private int age;


    public Student(String id, String name, String address, int age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}