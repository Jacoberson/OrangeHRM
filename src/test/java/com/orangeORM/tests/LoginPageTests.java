package com.orangeORM.tests;

import com.orangeORM.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTests {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");

        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @Test
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin1234");

        Assert.assertTrue(loginPage.isAlertDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
