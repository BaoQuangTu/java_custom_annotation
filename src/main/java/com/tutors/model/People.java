package com.tutors.model;

import com.tutors.annotation.MappingField;

public class People {
    @MappingField
    private int gender;

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

}