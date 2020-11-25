package com.tutors;

import com.tutors.handler.MappingConverter;
import com.tutors.model.Student;

public class App {
    public static void main(String[] args) {
        Student student = new Student("1", "Bảo Quang Tử", "Mê Linh - Hà Nội", 24);
        MappingConverter<Student> mapping = new MappingConverter<Student>(student);
        System.out.println(mapping.getByFieldName("name"));
        System.out.println(mapping.getByFieldName("address"));
    }
}