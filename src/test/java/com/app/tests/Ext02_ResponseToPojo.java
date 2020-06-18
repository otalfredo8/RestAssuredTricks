package com.app.tests;

import com.app.pojos.pojosreqres.ReqRes;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Ext02_ResponseToPojo {

    @Test
    public void gsonArrayList_Test(){

        Response response = given().get("https://reqres.in/api/users?page=2");
        response.prettyPrint();
        ReqRes reqRes = response.as(ReqRes.class);
        System.out.println(reqRes.getAd().getUrl());
    }

    @Test
    public void emailsFromDiffJsonObjects_Test(){
        Response response = given().get("https://reqres.in/api/users?page=2");
        ReqRes reqRes = response.as(ReqRes.class);

        //TODO testing all emails using extract().path()
        System.out.println((String) given().get("https://reqres.in/api/users?page=2").then().extract().path("data[0].email"));



        //TODO testing all emails using pojos
        List<String> emails = new ArrayList<>();
        for (int i = 0; i<=reqRes.getData().size()-1; i++){
            emails.add(reqRes.getData().get(i).getEmail());
            System.out.println(reqRes.getData().get(i).getEmail());
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");

        Collections.sort(emails);
        for (int i = 0; i<=emails.size()-1; i++){
            System.out.println(emails.get(i));
        }
    }
}
