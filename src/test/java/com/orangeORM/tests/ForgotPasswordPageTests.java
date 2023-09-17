package com.orangeORM.tests;

import com.orangeORM.pages.ForgotPasswordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordPageTests extends BaseTest {

    @Test
    public void clickCancel() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
        forgotPasswordPage.clickCancel();

        Assert.assertFalse(forgotPasswordPage.isOnPage());
    }

    @Test
    public void resetWithoutUsername() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
        forgotPasswordPage.clickResetPassword();

        Assert.assertTrue(forgotPasswordPage.validationIsVisible());
    }

    @Test
    public void resetWithUsername() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(getDriver());
        forgotPasswordPage.enterUsername("Admin");
        forgotPasswordPage.clickResetPassword();

        Assert.assertFalse(forgotPasswordPage.isOnPage());
    }
}