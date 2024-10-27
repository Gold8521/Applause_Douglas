package com.utills;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class BaseClass {
    /*    protected HomePage homePage;
        @Parameters
        @BeforeSuite
        public void setup(String browser) {
            WebDriverManager.setDriver(browser);
            homePage= new HomePage(WebDriverManager.getDriver());
        }*/
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) {
        WebDriverManager.setDriver(browser);
        this.driver = WebDriverManager.getDriver();
    }

    @AfterClass
    public void tearDown() {
        WebDriverManager.quitDriver();
    }

    public void handleCookies() {
        driver.findElement(By.id("cookie-consent-accept-button")).click();
    }

    public void readFromExcel(String filePath) {
    }

    public void writeToExcel(String filePath) {
    }

    public void waitTill(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
