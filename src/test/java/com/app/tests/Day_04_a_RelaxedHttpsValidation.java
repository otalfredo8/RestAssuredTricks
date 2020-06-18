package com.app.tests;

import io.restassured.RestAssured;
import org.junit.Test;

public class Day_04_a_RelaxedHttpsValidation {

    @Test
    public void relaxedHTTPSValidation_Test(){

        //Trusting Connections With Bad Certificates, three options:
        // A. manually: change network sharing and time settings.

        // B. In Rest Assure useRelaxedHTTPSValidation()
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.get("https://untrusted-root.badssl.com/").
                then().log().all().statusCode(200);

        // C. RestAssured.config = RestAssured.newConfig().sslConfig(new SSLConfig("/truststore_javanet.jks", "test1234");
    }
}
