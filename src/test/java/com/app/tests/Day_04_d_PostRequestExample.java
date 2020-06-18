package com.app.tests;

import com.app.utlities.Day_04_dd_DatabaseUtility;
import com.app.utlities.Day_04_e_BookITRestUtility;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class Day_04_d_PostRequestExample {

    Logger log = Logger.getLogger(Day_04_d_PostRequestExample.class);

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://cybertek-reservation-api-qa.herokuapp.com/";
    }

    @Test
    public void postTeam_Test() {

        String token = Day_04_e_BookITRestUtility.getTeacherToken();

        String team =new Faker().team().name();
        String batch = "8";
        RestAssured.given().header("Authorization", token).
                            param("campus-location", "VA").
                            param("batch-number", batch).
                            param("team-name", team).
                    when().post("/api/teams/team").
                    then().log().all().
                    statusCode(201).
                    body(is("team "+team+" has been added to the batch "+batch+"."));
                    // body(containsString("created")); //alternative test
        verifyTeamExists_DB_Test(team);
    }

    public static void verifyTeamExists_DB_Test(String team) {
        Day_04_dd_DatabaseUtility.createConnection();
        String sql = "select * from team where name = '" + team + "';";
        System.out.println(sql);
        Map<String, Object> result = Day_04_dd_DatabaseUtility.getRowMap(sql);
        Assert.assertNotNull(result);
    }
}
