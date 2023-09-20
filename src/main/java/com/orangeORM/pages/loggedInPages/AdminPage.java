package com.orangeORM.pages.loggedInPages;

import com.orangeORM.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminPage extends BasePage {
    private static final String PAGE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";

    @FindBy(tagName = "h6")
    private List<WebElement> header;

    @FindBy(css = "div[data-v-957b4417] > input[data-v-1f99f73c]")
    private WebElement usernameSearchField;

    @FindBy(xpath = "//form/descendant::div[contains(@class, 'oxd-select-text--active')][1]")
    private WebElement userRoleSearchField;

    @FindBy(css = "input[placeholder='Type for hints...']")
    private WebElement employeeNameSearchField;

    @FindBy(xpath = "//form/descendant::div[contains(@class, 'oxd-select-text--active')][2]")
    private WebElement statusSearchField;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        usernameSearchField.sendKeys(username);
    }

    public void enterEmployeeName(String employeeName) {
        employeeNameSearchField.sendKeys(employeeName);
    }

    public boolean isOnPage() {
        return driver.getCurrentUrl().equals(PAGE_URL);
    }

    public boolean headerDisplays() {
        return (header.get(0).getText().equals("Admin") &&
                header.get(1).getText().equals("User Management"));
    }
}
