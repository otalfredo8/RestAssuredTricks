package com.app.tests;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Day_03_a_HomeWork___pathParam {
    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = "https://api.github.com";
    }

    @Test
    public void getByUserTest(){
        given().pathParam("username", "marufjont").
        when().get("/users/{username}").
        prettyPrint();
    }
}
