package com.orangeORM.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends BaseLoggedInTest {
    @Test
    public void isOnDashboard() {
        Assert.assertTrue(getDriver().getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
    }
}
