package org.example;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest1 {
    ObjectMapper mapper;
    @Before
    public void setUp() {
        mapper=new ObjectMapper();

    }
   
    @Test
    public void test1() throws Exception  {
        Student student2=new Student();
        System.out.println("Hello world!");
        String jsonString = "{\"name\":\"Jessica\", \"age\":20}";
        student2=mapper.readValue(jsonString, Student.class);
        System.out.println(student2);
        System.out.println("------------------------------");

        Student s1=new Student("Hayley", 31);
        String str1=mapper.writeValueAsString(s1);
        System.out.println(str1);

        mapper.writeValue(new File("student.json"), s1);
        
    } 

    @Test//Read JSON into POJO calss
    public void test2() throws Exception {
        MyValue value = mapper.readValue(new File("data.json"), MyValue.class);
        System.out.println("read value from json file"+value);
        // or:
        //value = mapper.readValue(new URL("http://some.com/api/entry.json"), MyValue.class);
        // or:
        value = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", MyValue.class);
        System.out.println("read value from json string"+value);
    }

    @Test//Write JAva POJO into JSON string etc...
    public void test3() throws Exception{
        //And if we want to write JSON, we do the reverse:
        MyValue myResultObject=new MyValue();
        myResultObject.name="Jessica";
        myResultObject.age=31;


        mapper.writeValue(new File("result.json"), myResultObject);
        // or:
        byte[] jsonBytes = mapper.writeValueAsBytes(myResultObject);
        System.out.println("Write value into byte array--->");
        for(int i=0;i<jsonBytes.length;i++){
            System.out.println(jsonBytes[i]);
        }

        // or:
        String jsonString = mapper.writeValueAsString(myResultObject);
        System.out.println("Write value into JSON String"+jsonString);
    }


    // Note: can use getters/setters as well; here we just use public fields directly:
    public static class MyValue {
        public String name;
        public int age;
        // NOTE: if using getters/setters, can keep fields `protected` or `private`
        public String toString(){
            return "MyValue [ name: "+name+", age: "+ age+ " ]";
         }

    }
}
