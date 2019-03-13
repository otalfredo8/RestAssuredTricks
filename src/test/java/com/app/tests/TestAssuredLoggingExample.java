package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestAssuredLoggingExample {

    @Test
    public void loggingTest(){
        // LOGGING REQUEST
        // log --> provides logging options for request
        //
       given().log().all().
       when().get("https://uinames.com/api/");

        System.out.println("**********************************\n");

       // LOG RESPONSE
        Response response = RestAssured.get("https://uinames.com/api/");

        response.then().log().all();
    }
}
