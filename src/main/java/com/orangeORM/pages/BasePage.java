package com.orangeORM.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected static String PAGE_URL;

    protected abstract void setPageUrl(String url);
    protected abstract String getPageUrl();
}
