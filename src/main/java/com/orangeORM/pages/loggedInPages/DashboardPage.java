package com.orangeORM.pages.loggedInPages;

import com.orangeORM.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends BasePage {
    private static final String PAGE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
    private static final String HELP_PAGE_URL = "https://starterhelp.orangehrm.com/hc/en-us";

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement header;

    @FindBy(css = "aside[class='oxd-sidepanel']")
    private WebElement openSidebar;

    @FindBy(xpath = "//button[contains(@class, 'oxd-main-menu-button')]")
    private WebElement sidebarToggle;

    @FindBy(css = "aside[class*='toggled']")
    private WebElement closedSidebar;

    @FindBy(css = "button[title='Help']")
    private WebElement helpIcon;

    @FindBy(css = "li[class='oxd-userdropdown']")
    private WebElement userDropdown;

    @FindBy(css = "li[class='--active oxd-userdropdown']")
    private WebElement openUserDropdown;

    @FindBy(xpath = "//div[contains(@class, 'orangehrm-dashboard-grid')]/div[contains(@class, 'oxd-grid-item')]")
    private List<WebElement> widgets;

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminLink;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnPage() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

    public boolean headerDisplays() {
        return header.isDisplayed();
    }

    public boolean widgetsDisplay() {
        return widgets.size() == 7;
    }

    public boolean sidebarIsOpen() {
        return openSidebar.isDisplayed();
    }

    public void toggleSidebar() {
        sidebarToggle.click();
    }

    public boolean sidebarIsClosed() {
        return closedSidebar.isDisplayed();
    }

    public boolean userDropdownIsClosed() {
        return userDropdown.isDisplayed();
    }

    public void toggleUserDropdown() {
        userDropdown.click();
    }

    public boolean userDropdownIsOpen() {
        return openUserDropdown.isDisplayed();
    }

    public boolean helpIconDisplays() {
        return helpIcon.isDisplayed();
    }

    private void clickHelpIcon() {
        helpIcon.click();

        List<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(1));
    }

    public boolean helpPageOpened() {
        clickHelpIcon();
        return driver.getCurrentUrl().equals(HELP_PAGE_URL);
    }

    public void clickSideLink(String elementToClick) {
        switch(elementToClick) {
            case "Admin":
                adminLink.click();
                break;
        }
    }
}
