package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day_01_b_BaseURIDemo {

    @BeforeClass
    public static void setUpClass() {
        // baseURI --> used to save the base url for all resources
        RestAssured.baseURI = "https://api.got.show/api";
    }

    @Test
    public void culturesTest() {
        Response response = RestAssured.get("/book/cultures/"); //endpoint
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("Ironborn"));
    }

    @Test
    public void citiesTest() {
        Response response = RestAssured.get("/book/cities/"); //endpoint
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("White Harbor"));
    }
}