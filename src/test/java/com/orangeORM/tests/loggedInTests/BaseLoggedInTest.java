package com.orangeORM.tests.loggedInTests;

import com.orangeORM.pages.loggedOutPages.LoginPage;
import com.orangeORM.tests.BaseTest;
import org.testng.annotations.BeforeMethod;

public class BaseLoggedInTest extends BaseTest {
    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.doLogin("Admin", "admin123");
    }
}
