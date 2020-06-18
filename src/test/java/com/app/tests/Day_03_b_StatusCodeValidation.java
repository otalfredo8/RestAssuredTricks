package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Day_03_b_StatusCodeValidation {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://randomuser.me/api/";
    }

    @Test
    public void test200(){
        given().
        when().get().
        then().statusCode(200);
    }

    @Test
    public void test404(){
        given().
        when().get("sdfgsfgds").
        then().statusCode(404);
    }
}