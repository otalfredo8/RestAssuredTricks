package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WarmUpEx {


    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://api.got.show/api";
    }

    @Test
    public void continentsTest(){
        Response response = RestAssured.get("/continents");
        Assert.assertEquals(200, response.statusCode());
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("Westeros"));

    }

    @Test
    public void episodeTest(){
        Response response = RestAssured.get("episodes");
        Assert.assertEquals(200, response.statusCode());
        Assert.assertTrue(response.asString().contains("Rains of Castamere"));
    }

    public static void main(String[] args) {

    }

}
