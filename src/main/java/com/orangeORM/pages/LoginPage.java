package com.orangeORM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {
    private static final String PAGE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    @FindBy(xpath = "//p[contains(@class, 'alert-content-text')]")
    private WebElement alert;

    @FindBy(css = "a[href*='linkedin']")
    private WebElement linkedInIcon;

    @FindBy(css = "a[href*='facebook']")
    private WebElement facebookIcon;

    @FindBy(css = "a[href*='twitter']")
    private WebElement twitterIcon;

    @FindBy(css = "a[href*='youtube']")
    private WebElement youTubeIcon;

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(PAGE_URL);
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

    private void clickSocialMediaIcon(String socialMediaSite) {
        switch(socialMediaSite) {
            case "LinkedIn":
                linkedInIcon.click();
                break;
            case "Facebook":
                facebookIcon.click();
                break;
            case "Twitter":
                twitterIcon.click();
                break;
            case "YouTube":
                youTubeIcon.click();
                break;
        }

        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
    }

    public boolean isSocialMediaOpened(String socialMediaSite) {
        clickSocialMediaIcon(socialMediaSite);

        String lowercaseSite = socialMediaSite.toLowerCase();
        return driver.getCurrentUrl().contains(lowercaseSite);
    }
}
