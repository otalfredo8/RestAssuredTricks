package com.app.tests;

import com.github.javafaker.Faker;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class StudentResourceEndToEnd {
    @Test
    public void postStudent(){
        // Create test data
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase()+lastName.toLowerCase()+"@"+faker.internet().domainName();
        String password = firstName.toLowerCase()+lastName.toLowerCase();
        String role = "student-team-member";
        String campusLocation = "VA";
        String batchNumber = "8";
        String teamName = "CodeHunters";

        String expectedMessage = "user "+firstName+" "+lastName+" has been added to database.";

        String token = BookITRestUtility.getTeacherToken();

        given().
                log().all().
                header("Authorization", token).
                queryParam("first-name", firstName).
                queryParam("last-name", lastName).
                queryParam("password", password).
                queryParam("email", email).
                queryParam("role", role).
                queryParam("campus-location", campusLocation).
                queryParam("batch-number", batchNumber).
                queryParam("team-name", teamName).
        when().
                post("api/students/student").
        then().
                log().all().
                assertThat().statusCode(201).
                body(is(expectedMessage));


    }
}
