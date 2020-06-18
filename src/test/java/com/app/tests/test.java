package com.app.tests;

public class test {
    import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

    public class DataProviderTest {

&nbsp;&nbsp; &nbsp;private static WebDriver driver;

&nbsp; @DataProvider(name = "Authentication")

&nbsp; public static Object[][] credentials() {

            // The number of times data is repeated, test will be executed the same no. of times

            // Here it will execute two times

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};

&nbsp; }

&nbsp; // Here we are calling the Data Provider object with its Name

&nbsp; @Test(dataProvider = "Authentication")

&nbsp; public void test(String sUsername, String sPassword) {

&nbsp;&nbsp; &nbsp;&nbsp; driver = new FirefoxDriver();

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; driver.get("http://www.store.demoqa.com");

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; driver.findElement(By.xpath(".//*[@id='account']/a")).click();

            // Argument passed will be used here as String Variable

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; driver.findElement(By.id("log")).sendKeys(sUsername);

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; driver.findElement(By.id("pwd")).sendKeys(sPassword);

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; driver.findElement(By.id("login")).click();

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; driver.quit();

&nbsp; }

    }
