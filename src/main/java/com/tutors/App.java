package com.tutors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import com.tutors.handler.MappingConverter;
import com.tutors.model.Student;

public class App {
    public static void main(String[] args)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        Student student = new Student("1", "Bảo Quang Tử", "Mê Linh - Hà Nội", 24);
        MappingConverter<Student> mapping = new MappingConverter<Student>(Student.class);
        Map<String, String> mapFieldValue = mapping.getFieldValueByObject(student);
        System.out.println(mapFieldValue);
        System.out.println(mapFieldValue.get("name"));
        System.out.println(mapFieldValue.get("address"));
    }
}