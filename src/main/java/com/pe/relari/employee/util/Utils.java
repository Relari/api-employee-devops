package com.pe.relari.employee.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
    }

    public static <T> T readDataFromFileJson(
            String fileName, Class<T> className) {
        try {
            return mapper.readValue(
                    Utils.class.getClassLoader().getResourceAsStream(fileName), className
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T readData(
            String json, Class<T> className) {
        try {
            return mapper.readValue(json, className);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertJsonToString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
