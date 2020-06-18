package com.app.tests;

import com.app.pojos.pojosrandomusers.RandomUser;
import com.app.pojos.pojosrandomusers.Results;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class Day_06_b_ResponseToPojoExample {

    @Test
    public void extractPath_Tests(){
        String gender = given().get("https://randomuser.me/api/").then().extract().path("results[0].gender");
        System.out.println(gender);

        HashMap<String, Object> infoObject = given().get("https://randomuser.me/api/").then().extract().path("info");
        System.out.println(infoObject.size());

        String seed = given().get("https://randomuser.me/api/").then().extract().path("info.seed");
        System.out.println(seed);

        Response response = given().get("https://randomuser.me/api/");
        System.out.println(response.path("info.version").toString());
    }
    @Test
    public void gender_Test(){
        given().queryParam("gender", "female")
                .get("https://randomuser.me/api/").prettyPrint();
    }

    @Test
    public void responseToPojo_Test(){

        Response response =
                given().queryParam("gender", "male").get("https://randomuser.me/api/");

        //TODO response to pojo (In pojo classes, int must be converted to String)
        RandomUser randomUser = response.as(RandomUser.class);

        List<Results> listOfResult = randomUser.getResults();
        Assert.assertTrue(listOfResult.get(0).getGender().equalsIgnoreCase("male"));
    }

    @Test
    public void responseToPojoNestedOjbectInArray_Test(){
        Response response =
                given().queryParam("gender", "male").get("https://randomuser.me/api/");
        //TODO response to pojo
        RandomUser randomUser = response.as(RandomUser.class);
        List<Results> results = randomUser.getResults();
        Assert.assertFalse(results.get(0).getName().getFirst().equalsIgnoreCase("Rodrigo"));
    }
}
