package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Day_02_a_QueryParamsExample {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://randomuser.me/api/";
    }

    @Test
    public void restultsQueryTest(){
        given().
                queryParam("results", "3").
        when().get().
        prettyPrint();
    }

    @Test
    public void passwordsQueryTest(){
        given().
                queryParam("passwords", "upper,lower,1-16").
                when().get().
                prettyPrint();
    }

    @Test
    public void genderResultsNatQueriesTest(){
        given().
                queryParam("results", "2").
                queryParam("gender", "female").
                queryParam("nat", "us").
        when().get().
        prettyPrint();
    }
}