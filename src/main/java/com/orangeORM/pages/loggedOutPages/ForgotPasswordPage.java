package com.orangeORM.pages.loggedOutPages;

import com.orangeORM.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage {
    private static final String PAGE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(xpath = "//button[text()[contains(., 'Cancel')]]")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[text()[contains(., 'Reset Password')]]")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//*[text()[contains(., 'Required')]]")
    private WebElement requiredValidation;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public void clickResetPassword() {
        resetPasswordButton.click();
    }

    public boolean isOnPage() {
        return driver.getCurrentUrl() == PAGE_URL;
    }

    public boolean validationIsVisible() {
        return requiredValidation.isDisplayed();
    }
}
