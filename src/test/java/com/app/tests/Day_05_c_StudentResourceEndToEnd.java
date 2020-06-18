package com.app.tests;

import com.app.utlities.Day_04_dd_DatabaseUtility;
import com.app.utlities.Day_04_e_BookITRestUtility;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class Day_05_c_StudentResourceEndToEnd {

    Logger log = Logger.getLogger(Day_05_c_StudentResourceEndToEnd.class);

    @Test
    public void postStudent() throws InterruptedException {
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

        String token = Day_04_e_BookITRestUtility.getTeacherToken();

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

        // VERIFY USING UI

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password + Keys.ENTER);
        Thread.sleep(5000);
        assertThat(driver.getCurrentUrl(), endsWith("map"));


    }


    public static Map<String, Object> getDBUser(String email){
        Day_04_dd_DatabaseUtility.createConnection();
        String sql = "select firstname, lastname, role, id, email from users where email = '"+email+"';";
        Map<String, Object> rowMap = Day_04_dd_DatabaseUtility.getRowMap(sql);
        Day_04_dd_DatabaseUtility.closeConnection();
        return rowMap;
    }
}
