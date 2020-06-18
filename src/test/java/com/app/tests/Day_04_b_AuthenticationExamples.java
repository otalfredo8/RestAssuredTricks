package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

public class Day_04_b_AuthenticationExamples {

    @Test
    public void apiKey_Test(){
        RestAssured.given().log().all().
                queryParam("t", "Kung Fury").
                queryParam("apikey", "a9faab96").
                when().get("http://www.omdbapi.com/").
                then().log().all().assertThat().statusCode(200);
    }

    @Test
    public void notAuthorized401_Test(){
        // 401 - Endpoint without without authorization
        RestAssured.get("https://the-internet.herokuapp.com/basic_auth").
                then().assertThat().statusCode(401);
    }

    @Test
    public void basicAuth_Test(){
        // auth().basic(user, pass).
        RestAssured.given().
                auth().basic("admin", "admin").
                when().get("https://the-internet.herokuapp.com/basic_auth").
                then().assertThat().statusCode(200);
    }

    @Test
    public void basicPreemptiveAuth_Test(){
        // auth.preemptive().basic("admin", "admin").
        // preemptive --> server sends the basic auth response before and unauthorized response
        Response response = RestAssured.given().
                auth().preemptive().basic("admin", "admin").
                when().get("https://the-internet.herokuapp.com/basic_auth");
        response.then().log().all().and().assertThat().statusCode(200);
    }

    @Test
    public void xmlResponseSample_Test(){
        // Response: xml body
        RestAssured.get("http://parabank.parasoft.com/parabank/services/bank/customers/12212/").
                then().log().all().assertThat().statusCode(200);
    }
}