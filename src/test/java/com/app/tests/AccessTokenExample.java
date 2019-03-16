package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AccessTokenExample {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com/";
    }

    @Test
    public void getTokenTest() {
        Response response = given().log().all().
                param("email", "teacherva5@gmail.com").
                param("password", "maxpayne").
                get("sign");
        response.then().log().all().
                assertThat().statusCode(200);
    }
}

















