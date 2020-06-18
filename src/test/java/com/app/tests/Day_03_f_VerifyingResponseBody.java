package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public abstract class Day_03_f_VerifyingResponseBody {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://randomuser.me/api/";
    }

    @Test
    public void bodyNotNull_Test() {
        given().when().get().
                then().assertThat().body("info", notNullValue());

        given().when().get().
                then().assertThat().body("results", notNullValue());
    }

    //!!!
    //How to find an specific key?(JSON parser)
    @Test
    public void natUS_Test() {
        Response response = given().
                queryParam("nat", "us").
                when().get();
        System.out.println(response.jsonPath().getString("results[0].nat"));
//        then().log().body().
//            assertThat().body("nat", is("US"));
    }

    @Test
    public void resultsSize_Test() {
        Response response = given().
                queryParam("results", 4).
                when().get();
//                then().
//                assertThat().body("results", hasSize(4));
        // in this example we are verify number of objects in a json response
        System.out.println(response.prettyPrint());
    }
}