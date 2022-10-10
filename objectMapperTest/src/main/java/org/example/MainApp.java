package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainApp {
    public Student2 student2=new Student2();

    public static void main(String[] args) throws JsonMappingException, JsonProcessingException  {
        MainApp mainApp=new MainApp();
        mainApp.student2.setName("aaaaa"); 
        mainApp.student2.setAge(50);

        System.out.println(mainApp.student2.getName()+","+mainApp.student2.getAge());

    }

    public class Student2 {
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