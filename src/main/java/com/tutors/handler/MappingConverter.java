package com.tutors.handler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tutors.annotation.MappingField;

public class MappingConverter<T> {
    List<String> fieldsName = new ArrayList<String>();

    public MappingConverter(Class<T> clazz) {
        try {
            this.getFieldsNestedSuperClass(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getFieldValueByObject(T tObject) throws IllegalAccessException {
        Map<String, String> mapFieldValue = new HashMap<String, String>();

        for (String fieldName: fieldsName) {
            Field field = getFieldByName(tObject.getClass(), fieldName);
            
            if (field == null) {
                continue;
            } 

            field.setAccessible(true);

            mapFieldValue.put(fieldName, getPrefix(field) + field.get(tObject) + "" + getSuffix(field));
        }

        return mapFieldValue;
    }

    private void getFieldsNestedSuperClass(Class<?> clazz) {
        for (Field field: clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(MappingField.class)) {
                fieldsName.add(field.getName());
            }
        }

        if (clazz.getSuperclass().getDeclaredFields().length > 0) {
            getFieldsNestedSuperClass(clazz.getSuperclass());
        }
    }

    private Field getFieldByName(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            return field;
        } catch (NoSuchFieldException e) {
            // return field from super class
            if (clazz.getSuperclass().getDeclaredFields().length > 0) {
                return getFieldByName(clazz.getSuperclass(), fieldName);
            }
        }

        return null;
    }

    private String getPrefix(Field field) {
        return field.getAnnotation(MappingField.class).prefix();
    }

    private String getSuffix(Field field) {
        return field.getAnnotation(MappingField.class).suffix();
    }
}