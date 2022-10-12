package org.example;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
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

    @Test
    public void test4() throws IOException {
        //Test Collections
        Map<String, Integer> map=new HashMap<String, Integer>();
        map.put("A1", 1);
        map.put("A2", 2);
        map.put("A3", 3);
        map.put("A4", 4);
        String mapString=mapper.writeValueAsString(map);
        System.out.println("map string:" + mapString);

        List<String> list=new ArrayList<String>();
        list.add("E1");
        list.add("E2");
        list.add("E3");
        list.add("E4");
        String listString=mapper.writeValueAsString(list);
        System.out.println("listString:" + listString);

        mapString="{\"A1\":1,\"A2\":2,\"A3\":3,\"A4\":4}";
        listString="[\"E1\",\"E2\",\"E3\",\"E4\"]";
        Map<String, Integer> newMap=mapper.readValue(mapString, Map.class);
        for (String key: newMap.keySet()) {
            System.out.println("key: "+key+","+"value: "+newMap.get(key));
        }
        System.out.println("mapper write newMap"+mapper.writeValueAsString(newMap));

        List<String> newList=mapper.readValue(listString, List.class);
        for(String e: newList){
            System.out.println("list e: " + e);
        }
        System.out.println("mapper write list: "+mapper.writeValueAsString(newList));
        // and can obviously write out as well
        mapper.writeValue(new File("testList.json"), newList);
    }

    @Test
    public void test5(){
        Map<String, MyValue> map=new HashMap<String,MyValue>();
        MyValue myValue1=new MyValue(); myValue1.name="A1"; myValue1.age=21;
        MyValue myValue2=new MyValue(); myValue2.name="A1"; myValue2.age=21;
        
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
