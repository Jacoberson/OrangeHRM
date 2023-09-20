package com.orangeORM.tests.loggedInTests;

import com.orangeORM.pages.loggedInPages.AdminPage;
import com.orangeORM.pages.loggedInPages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminPageTests extends BaseLoggedInTest {
    @BeforeMethod
    public void navigateToAdminPage() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.clickSideLink("Admin");
    }
    @Test
    public void pageDisplays() {
        AdminPage adminPage = new AdminPage(getDriver());
        Assert.assertTrue(adminPage.isOnPage());
        Assert.assertTrue(adminPage.headerDisplays());
    }
}
