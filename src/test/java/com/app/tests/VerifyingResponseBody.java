package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class VerifyingResponseBody {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://uinames.com/api";
    }

    @Test
    public void testBody(){
        given().when().get().

        // body("name"  --> first param is locator, gets the value from the response. it will be actual value
        // second argument will be the matcher
        then().assertThat().body("name", notNullValue());
        // in the example above we are verifying that key name has value

//        {
//               "name": "Adin",
//                "surname": "Nadarević",
//                "gender": "male",
//                "region": "Bosnia and Herzegovina"
//        }

    }

    @Test
    public void verifyRegion(){
        String region = "Mexico";
        // where only want to get people name from Mexico
        given().
                queryParam("region", region).
                when().get().
        then().log().body().
            assertThat().body("region", is(region));
    }


    @Test
    public void verifyNumberOfResults(){
        given().
                queryParam("amount", 2).
                when().get().
                then().
                assertThat().body("$", hasSize(2));
        // in this example we are verify number of objects in a json response
    }

}
