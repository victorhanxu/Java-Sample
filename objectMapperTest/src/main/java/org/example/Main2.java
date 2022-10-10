package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main2 {

    public static void main(String[] args) throws JsonMappingException, JsonProcessingException  {
        Main2 mainApp=new Main2();
        mainApp.test1();
    }

    void test1() throws JsonMappingException, JsonProcessingException {
        Student2 student2=new Student2();
        System.out.println("Hello world!");
        String jsonString = "{\"name\":\"Hyl\", \"age\":20}";
        ObjectMapper mapper=new ObjectMapper();
        student2=mapper.readValue(jsonString, Student2.class);
        System.out.println(student2.getName()+","+student2.getAge());
    }

    public static class Student2 {
        String name;
        int age;

        public Student2() {
            super();
        }

        public Student2(String name, int age) {
            Student2 s=new Student2();
            s.setName(name);
            s.setAge(age);
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
    
    }

}