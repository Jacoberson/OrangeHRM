package com.orangeORM.tests;

import com.orangeORM.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.doLogin("Admin", "admin123");

        Assert.assertTrue(loginPage.isLoggedIn());
    }

    @Test
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.doLogin("Admin", "admin1234");

        Assert.assertTrue(loginPage.isAlertDisplayed());
    }

    @Test(dataProvider = "SocialMediaDataProvider")
    public void clickSocialMediaIcon(String socialMediaSite) {
        LoginPage loginPage = new LoginPage(getDriver());

        Assert.assertTrue(loginPage.isSocialMediaOpened(socialMediaSite));
    }

    @DataProvider(name = "SocialMediaDataProvider")
    private Object[][] getData() {
        Object[][] data = {{"LinkedIn"}, {"Facebook"}, {"Twitter"}, {"YouTube"}};
        return data;
    }

}
