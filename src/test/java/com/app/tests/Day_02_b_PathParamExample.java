package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Day_02_b_PathParamExample {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI = "https://api.got.show/api";
    }

    @Test
    public void getCityByNameTest() {
        given().pathParam("name", "Braavos").
                when().get("/map/cities/{name}").
                prettyPrint();
    }

    @Test
    public void getCharacterByNameTest() {
        given().pathParam("name", "Pypar").
                when().get("/map/characters/{name}").
                prettyPrint();
    }

    @Test
    public void getCharacterById() {
        given().pathParam("id", "5cc0743604e71a0010b854cd").
                when().get("/map/characters/byId/{id}").
                prettyPrint();
    }
}