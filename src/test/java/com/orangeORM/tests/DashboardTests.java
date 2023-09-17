package com.orangeORM.tests;

import com.orangeORM.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends BaseLoggedInTest {
    @Test
    public void pageDisplays() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.isOnPage());
        Assert.assertTrue(dashboardPage.headerDisplays());
    }

    @Test
    public void allWidgetsDisplay() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.widgetsDisplay());
    }

    @Test
    public void sidebarCanBeToggled() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.sidebarIsOpen());

        dashboardPage.toggleSidebar();

        Assert.assertTrue(dashboardPage.sidebarIsClosed());
    }

    @Test
    public void userDropdownCanBeToggled() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.userDropdownIsClosed());

        dashboardPage.toggleUserDropdown();

        Assert.assertTrue(dashboardPage.userDropdownIsOpen());
    }

    @Test
    public void helpIconDisplays() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        Assert.assertTrue(dashboardPage.helpIconDisplays());
    }

    @Test
    public void helpIconWorks() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.helpPageOpened());
    }
}
