package com.app.tests;

import com.app.pojos.pojoscyber.Person;
import com.app.pojos.pojoscyber.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.junit.Test;

import java.io.IOException;

public class Day_06_a_PojoExamples {

    @SerializedName("user")
    private User user;

    @Test
    public void gson_Test() {

        //TODO declare Person values
        Person person = new Person();
        person.setName("Daniel");
        person.setSurname("Jackson");
        person.setGender("male");
        person.setRegion("Earth");
        System.out.println("printing the person object: " + person);

        // TODO serialization example
        // gson is a class used to convert objects to json
        Gson gson = new Gson();
        // toJson --> method which converts its parameter to json
        String jsonString = gson.toJson(person);

        System.out.println("printing the json: " + jsonString);


        // TODO deserialization

        // fromJson()  --> converts the input to given type
        Person myPerson = gson.fromJson(jsonString, Person.class);
        System.out.println("Printing the new person object:" + myPerson);

        // TODO. If no jsonString exist, create it

        String myJsonString = "{\"name\":\"Jack\"," +
                "\"surname\":\"ONeil\"," +
                "\"gender\":\"male\"," +
                "\"region\":\"Earth\"}";
    }

    @Test
    public void objectMapper_Test() throws IOException {

        //TODO declare pojo values
        Person person = new Person();
        person.setName("Daniel");
        person.setSurname("Jackson");
        person.setGender("male");
        person.setRegion("Earth");
        System.out.println("printing the person object: " + person);

        // TODO serialization example
        // ObjectMapper --> class which converts from and to pojos
        ObjectMapper objectMapper = new ObjectMapper();
        // writeValueAsString()  --> takes the input and converts to json
        // writeValueAsString()  --> throws JsonProcessingException
        String jsonStr = objectMapper.writeValueAsString(person);
        System.out.println("printing the json string: " + jsonStr);


        // TODO deserialization example
        // readValue() --> converts the input to given type
        Person myPerson = objectMapper.readValue(jsonStr, Person.class);
        System.out.println("Printing the new object: " + myPerson);

        // TODO. If no jsonStr exists, create it
        String myJsonString = "{\"name\":\"Jack\"," +
                "\"surname\":\"ONeil\"," +
                "\"gender\":\"male\"," +
                "\"region\":\"Earth\"}";

    }


    @Test
    public void objectMapperVSgson() throws JsonProcessingException {

        // TODO serialization example
        Person person = new Person();

        person.setName("Daniel");
        person.setSurname("Jackson");

        Gson gson = new Gson();
        String j1 = gson.toJson(person);

        ObjectMapper objectMapper = new ObjectMapper();
        String j2 = objectMapper.writeValueAsString(person);

        //Difference
        System.out.println(j1);
//        {"name":"Daniel","surname":"Jackson"}
        System.out.println(j2);
//        {"name":"Daniel","surname":"Jackson","gender":null,"region":null}


    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
