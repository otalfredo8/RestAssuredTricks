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
                get("/sign");
        response.then().log().all().
                assertThat().statusCode(200);
        // used to parse through json response easily

        String accessToken = response.jsonPath().get("accessToken");

        System.out.println(accessToken);

        // trying to get the my campus
        // we are passing our token as a part of the request header
        RestAssured.given().header("Authorization", accessToken).
                get("/api/campuses").then().log().all().
                assertThat().statusCode(200);

    }
}

















