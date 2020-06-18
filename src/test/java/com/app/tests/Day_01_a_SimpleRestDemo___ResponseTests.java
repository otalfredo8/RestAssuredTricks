package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Day_01_a_SimpleRestDemo___ResponseTests {

    @Test
    public void responseAsStringContainsTest() {

        Response response = RestAssured.get("https://randomuser.me/api/?format=json");
        response.prettyPrint();

        String resString = response.asString();
        Assert.assertTrue(resString.contains("name"));
    }

    @Test
    public void statusCodeTest(){
        Response response = RestAssured.get("https://randomuser.me/api/?format=json");
        int code = response.statusCode();
        Assert.assertEquals(200, code);
    }

    @Test
    public void headersAsListTest() {
        Response response = RestAssured.get("https://randomuser.me/api/?format=json");
        List<Header> randomUserHeadersList = response.headers().asList();

        List<String> headersValues = new ArrayList<>();
        for (Header header : randomUserHeadersList) {
            headersValues.add(header.getValue());
        }
        Assert.assertEquals(true, headersValues.contains("gzip"));
    }

    @Test
    public void headerTest(){
        Response response = RestAssured.get("https://randomuser.me/api/");
        // returns the headers of the response
        System.out.println(response.headers());
        // header --> returns the value of a header
        String contentType = response.header("Content-Type");
        System.out.println(contentType);
        Assert.assertEquals("application/json; charset=utf-8", contentType);

    }


    @Test
    public void statusLineTest(){
        Response response = RestAssured.get("https://randomuser.me/api/");
        // statusLine  --> returns all the information in the status line of the response
        String statusLine = response.statusLine();
        System.out.println(statusLine);
        Assert.assertTrue(statusLine.contains("200"));

    }
}
