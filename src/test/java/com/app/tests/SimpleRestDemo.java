package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class SimpleRestDemo {

    @Test
    public void test1() {
        // this is class from rest assured library, it contains methods and objects used for
        // creating and sending requests
        // get --> method for making a get request, accepts the resource uri as parameter
        // response --> represents the response that came back from server based on out request
        Response response = RestAssured.get("https://uinames.com/api/");
        // prints the response
        response.prettyPrint();
        // asString --> converts the response to string
        String resString = response.asString();
        Assert.assertTrue(resString.contains("name"));
       // statusCode returns the response code
        int code = response.statusCode();
        Assert.assertEquals(200, code);

    }


    @Test
    public void headersTest(){
        Response response = RestAssured.get("https://uinames.com/api/");
        // returns the headers of the response
        System.out.println(response.headers());
        // header --> returns the value of a header
        String contentType = response.header("Content-Type");
        System.out.println(contentType);
        Assert.assertEquals("application/json; charset=utf-8", contentType);

    }


    @Test
    public void statusLineTest(){
        Response response = RestAssured.get("https://uinames.com/api/");
        // statusLine  --> returns all the information in the status line of the response
        String statusLine = response.statusLine();
        System.out.println(statusLine);
        Assert.assertTrue(statusLine.contains("200"));

    }
}
