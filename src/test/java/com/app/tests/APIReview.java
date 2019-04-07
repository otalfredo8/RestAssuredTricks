package com.app.tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class APIReview {

    String instructorALLURL = "http://cybertekchicago.com/instructor/all";

     @Test
    public void instructorALLTest() {
        when().get(instructorALLURL)
                .then().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().body(containsString("instructors"));
    }

    @Test
    public void instructorALLTest2() {
       Response response = when().get(instructorALLURL);
       assertEquals(200, response.getStatusCode());
       assertTrue(response.getContentType().contains("application/json"));
       response.body().prettyPrint();
    }

    @Test
    public void instructorALLTest3() {
        Response response = when().get(instructorALLURL);
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getContentType().contains("application/json"));
        JsonPath json = response.jsonPath();

        assertEquals(129, json.getInt("instructors[0].id"));
        assertEquals("Reda", json.getString("instructors[0].firstName"));
        assertEquals("Larson", json.getString("instructors[0].lastName"));

        List<Integer> ids = json.getList("instructors.id");
        List<Integer> expectedIDs = Arrays.asList(129, 61, 62, 81, 82, 101, 102, 103, 104, 121, 122, 123, 124, 125, 126, 127, 128, 141, 142, 161);
        System.out.println(ids);
        assertTrue(ids.containsAll(expectedIDs));

    }
    String instructorByIdURL = "http://cybertekchicago.com/instructor/";

    @Test
    public void instructorALLTest4() {
        Response response = when().get(instructorByIdURL+61);
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getContentType().contains("application/json"));
        //List< Map<Object, Object >> responseList = response.jsonPath().getList("instructors", List.class);
        Map<String, String > responseMap = response.body().as(Map.class);

        System.out.println(responseMap);
       // System.out.println(responseList.get("id"));
        assertEquals(61, responseMap.get("id"));
        assertEquals("John", responseMap.get("firstName"));
        assertEquals("Smith", responseMap.get("lastName"));
        assertEquals(11, responseMap.get("batch"));
        assertEquals("Intro to Java programming", responseMap.get("subject"));
    }





}
