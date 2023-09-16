package com.orangeORM.tests;

import com.orangeORM.pages.ForgotPasswordPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ForgotPasswordPageTests {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void clickCancel() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickCancel();

        Assert.assertFalse(forgotPasswordPage.isOnPage());
    }

    @Test
    public void resetWithoutUsername() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickResetPassword();

        Assert.assertTrue(forgotPasswordPage.validationIsVisible());
    }

    @Test
    public void resetWithUsername() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.enterUsername("Admin");
        forgotPasswordPage.clickResetPassword();

        Assert.assertFalse(forgotPasswordPage.isOnPage());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}