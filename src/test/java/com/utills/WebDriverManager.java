package com.utills;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Getter
@Setter
public class WebDriverManager {
    /*    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
        public static void setDriver(String browser) {
            if (browser == null || browser.isEmpty()) {
                browser = "chrome";
                switch (browser.toUpperCase()) {
                    case "CHROME":
                        driver.set(new ChromeDriver());
                        break;
                    case "EDGE":
                        driver.set(new EdgeDriver());
                    case "FIREFOX":
                        driver.set(new FirefoxDriver());
                    default:
                        throw new WebDriverException(STR."Browser Not Supported: \{browser}");

                }
            }
        }
        public static void tearDown(){
            if(driver.get()!=null){
                driver.get().quit();
                driver.get().close();
            }
        }
        public static WebDriver getDriver() {
            return driver.get();
        }*/
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver.set(new ChromeDriver());
                break;
            case "edge":
                driver.set(new EdgeDriver());
                break;
            default:
                System.out.println("Invalid browser specified. Defaulting to Chrome.");
                driver.set(new ChromeDriver());
                break;
        }
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}