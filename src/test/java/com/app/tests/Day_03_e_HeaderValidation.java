package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class Day_03_e_HeaderValidation {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://randomuser.me/api/";
    }


   @Test
    public void headerTest(){
    given().
            when().get().
    then().log().headers().
            header("Content-Type", "application/json; charset=utf-8");
    // headerName, headerValue  (no explicit assertion is required)
   }
}
