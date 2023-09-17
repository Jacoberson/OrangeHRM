package com.orangeORM.tests;

import com.orangeORM.pages.LoginPage;
import org.testng.annotations.BeforeMethod;

public class BaseLoggedInTest extends BaseTest {
    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.doLogin("Admin", "admin123");
    }
}
