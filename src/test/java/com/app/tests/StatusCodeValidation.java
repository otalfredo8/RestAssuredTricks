package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StatusCodeValidation {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://uinames.com/api";
    }

    @Test
    public void testOK(){
        // given --> prep request
        given().
        // the submit request
        when().get().
        // then verify response
        // statusCode --> verify the status code
        then().statusCode(200);
    }

    @Test
    public void notFoundTest(){
        given().
        // we are passing wrong value on purpose
        // so that it goes to wrong url
        when().get("sdfgsfgds").
        then().statusCode(404);
    }



}
