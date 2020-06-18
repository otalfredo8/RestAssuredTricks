package com.app.tests;

import io.restassured.RestAssured;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Day_05_a_LoggingExample_log4j {

Logger log = Logger.getLogger(Day_05_a_LoggingExample_log4j.class);

    @Before
    public void before(){
        log.info("this is the before method");
    }

    @Test
    public void test(){
        log.trace("this is the test method: TRACE");
        log.info("this is the test method: INFO");
        log.warn("this is the test method: WARN");
        RestAssured.get("https://randomuser.me/api/");
    }

    @After
    public void after(){
        log.info("this is the after method");
    }

}
