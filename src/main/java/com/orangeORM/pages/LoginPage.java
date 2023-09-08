package com.orangeORM.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private static String PAGE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(@class, 'alert-content-text')]")
    private WebElement alert;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    private void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    private void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    private void clickLogin() {
        loginButton.click();
    }

    public void doLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public boolean isLoggedIn() {
        return driver.getCurrentUrl() != PAGE_URL;
    }

    public boolean isAlertDisplayed() {
        return alert.isDisplayed();
    }

}
