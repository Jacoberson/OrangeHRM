package com.orangeORM.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;
    private static final Duration WAIT = Duration.ofSeconds(10);


    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(WAIT);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
