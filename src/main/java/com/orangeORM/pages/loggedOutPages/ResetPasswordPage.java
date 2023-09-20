package com.orangeORM.pages.loggedOutPages;

import com.orangeORM.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BasePage {
    private static final String PAGE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/sendPasswordReset";

    @FindBy(xpath = "//*[text()[contains(., 'Reset Password link sent successfully')]]")
    private WebElement resetPasswordMessage;

    public ResetPasswordPage(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
    }

    public boolean isOnPage() {
        return driver.getCurrentUrl() == PAGE_URL;
    }

    public boolean messageIsDisplayed() {
        return resetPasswordMessage.isDisplayed();
    }
}
