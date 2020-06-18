package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Day_03_d_TestAssuredLoggingExample {

    @Test
    public void logRequestTest(){
        // log() --> provides logging options
       given().log().cookies().
       when().get("https://randomuser.me/api/");
    }

    @Test
    public void logResponseTest(){
        // log() --> provides logging options
        Response response = RestAssured.get("https://randomuser.me/api/");
        response.then().log().cookies();
    }
    /* Request Logging - requestspecifications
        gieven().log().all(). .. // Log all request specification details including parameters, headers and body
        gieven().log().params(). .. // Log only the parameters of the request
        gieven().log().body(). .. // Log only the request body
        gieven().log().headers(). .. // Log only the request headers
        gieven().log().cookies(). .. // Log only the request cookies
        gieven().log().method(). .. // Log only the request method (GET, POST, PUT...)
        gieven().log().uri(). .. // Log only the request uri
    *___________________________________________________________________________
    * Response Logging - validatableresponse
        then().log().body()
        then().log().ifError()
        then().log().all()
        then().log().statusLine()
        then().log().headers()
        then().log().cookies()
        then().log().ifStatusCodeIsEqualTo()
    */
}
