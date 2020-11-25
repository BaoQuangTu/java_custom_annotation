package com.tutors.handler;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.tutors.annotation.MappingField;

public class MappingConverter<T> {
    T tObject;
    Map<String, String> mapField = new HashMap<String, String>();

    public MappingConverter(T tObject) {
        this.tObject = tObject;
        try {
            this.buildFieldMappingExcel(tObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getByFieldName(String fieldName) {
        return mapField.get(fieldName);
    }

    private void buildFieldMappingExcel(Object object) throws IllegalArgumentException, IllegalAccessException {	
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(MappingField.class)) {
                mapField.put(field.getName(), getPrefix(field) + field.get(object) + "" + getSuffix(field));
            }
        }		
    }

    private String getPrefix(Field field) {
        return field.getAnnotation(MappingField.class).prefix();
    }

    private String getSuffix(Field field) {
        return field.getAnnotation(MappingField.class).suffix();
    }
}