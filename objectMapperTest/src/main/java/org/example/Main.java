package org.example;

import java.io.File;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    @Test
    public void test1() throws Exception  {
        Student student2=new Student();
        System.out.println("Hello world!");
        String jsonString = "{\"name\":\"Jessica\", \"age\":20}";
        ObjectMapper mapper=new ObjectMapper();
        student2=mapper.readValue(jsonString, Student.class);
        System.out.println(student2);
        System.out.println("------------------------------");

        Student s1=new Student("Hayley", 31);
        String str1=mapper.writeValueAsString(s1);
        System.out.println(str1);

        mapper.writeValue(new File("student.json"), s1);
        
    }

}