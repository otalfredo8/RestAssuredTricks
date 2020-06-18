package com.app.tests;


import io.restassured.response.ValidatableResponse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Ext04_HeaderValidation_DataProvider {

    @Test(dataProvider = "headers")
    public void headersTest2(String actualHeader, String actualValue){
        ValidatableResponse valres = given().when().get().then();
        valres.log().headers().header(actualHeader, actualValue);
    }

    @DataProvider(name = "headers")
    public Object[][] headerProvider(){
        return new Object[][]{{"header1", "value1"},
                                {"header2", "value2"},
                                {"header3", "value3"},
                                {"header4", "value4"}};
    }

    @DataProvider(name = "excelHeaders")
    public Object[][] excelHeadersProvider(){
    return null;
    }
}
