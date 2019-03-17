package com.app.tests;

import com.github.javafaker.Faker;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class StudentResourceEndToEnd {

    Logger log = Logger.getLogger(StudentResourceEndToEnd.class);

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
                body( is(expectedMessage));

        // GET THE NEW USER FROM DB USING JDBC
        Map<String, Object> dbUser = getDBUser(email);
        log.info(dbUser);
        // VERIFY THE DB DATA HAS THE CORRECT INFO
        assertThat(dbUser.get("firstname"), is(firstName));
        assertThat(dbUser.get("lastname"), is(lastName));
        assertThat(dbUser.get("email"), is(email));
        // verify that id is not empty
        assertThat(dbUser.get("id"), is(notNullValue()));

        // GET THE USER INFO FROM DB USING API

        String id = dbUser.get("id").toString();

        given().
                log().all().
                header("Authorization", token).
                pathParam("id", id).
        when().
                get("/api/students/{id}").
        then().
                log().all().
                assertThat().statusCode(200).
                body("firstName", is(firstName)).
                body("lastName", is(lastName)).
                body("role", is(role));

    }


    public static Map<String, Object> getDBUser(String email){
        DatabaseUtility.createConnection();
        String sql = "select firstname, lastname, role, id, email from users where email = '"+email+"';";
        Map<String, Object> rowMap = DatabaseUtility.getRowMap(sql);
        DatabaseUtility.closeConnection();
        return rowMap;
    }
}
