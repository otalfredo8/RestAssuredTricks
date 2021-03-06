package com.app.utlities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Day_04_e_BookITRestUtility {

    public static void main(String[] args) {
        System.out.println(getTeacherToken());
    }

    public static String getTeacherToken() {
        RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com";

        Response response = given().log().all().
                param("email", "teacherva5@gmail.com").
                param("password", "maxpayne").
                get("/sign");
        response.then().log().all().
                assertThat().statusCode(200);
        return response.jsonPath().get("accessToken");

    }
}
