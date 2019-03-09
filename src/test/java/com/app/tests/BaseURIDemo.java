package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseURIDemo {

    @BeforeClass
    public static void setUpClass() {
        // baseURI --> used to save the base url for all resources
        // when we actually make requests, we only provide the path to
        // specific resource

        RestAssured.baseURI = "https://api.got.show/api";

    }

    @Test
    public void culturesTest() {

        Response response = RestAssured.get("/cultures/");
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("Ironborn"));

    }

    @Test
    public void citiesTest() {
        Response response = RestAssured.get("/cities/");
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("White Harbor"));

    }
}
