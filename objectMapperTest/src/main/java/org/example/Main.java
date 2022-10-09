package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
        System.out.println("Hello world!");

        String jsonString = "{\"name\":\"Hyl\", \"age\":20}";

        ObjectMapper mapper=new ObjectMapper();

        Student student=mapper.readValue(jsonString, Student.class);

        System.out.println(student);



    }

    static class Student {
        String name;
        String age;


        public String toString() {
            return "name: "+name+","+"age: "+age;
        }
    }
}