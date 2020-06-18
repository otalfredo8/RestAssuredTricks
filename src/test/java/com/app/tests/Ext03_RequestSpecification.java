package com.app.tests;

import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Ext03_RequestSpecification {

    //for standard spects for my requests
    private static RequestSpecification requestSpec;
    private static Response response;
    AuthenticationScheme basicAuthScheme = new BasicAuthScheme();


    @BeforeClass
    public void requestSpecs_test(){
            requestSpec = new RequestSpecBuilder().setBaseUri("anyURIpath")
                                                .setContentType("anyContentType")
                                                .addCookie("anyCookie")
                                                .addHeader("anyHeader", "value")
                                                .addPathParam("anyPathParam", "value")
                                                .addFormParam("andy")
                                                .addQueryParam("anyQueryParam")
                                                .setAuth(basicAuthScheme)
                                                .setBody("body")
                                                .build();

            response = given().spec(requestSpec).get("anyURIapi");
    }

    @Test
    public void validatableRes_test(){
        ValidatableResponse valres = response.then();

        valres.extract().path("anyPath");
        assertThat("anyExpected", equalToIgnoringCase(valres.extract().path("anyPath")));

//        valres.body("services[0].id", equalTo(pojoA.getId()));
//        valres.body("services[0].name", equalTo(pojoA.getName()));
//        valres.body("services[0].description", equalTo(pojoA.getDescription()));

        valres.extract().headers().asList();    //returns a list
        valres.extract().cookies();             //returns a map

        List<Map<String, String>> headersMap = new LinkedList<>();
        valres.header("anyHeader", isIn(headersMap));

        valres.assertThat().statusCode(200);
    }


}
