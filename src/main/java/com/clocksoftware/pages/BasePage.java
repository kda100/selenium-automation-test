package com.clocksoftware.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected void type(String text, By locator) {
        find(locator).sendKeys(text);
    }

    protected void typeAndReplace(String text, By locator) {
        String n = Keys.chord(Keys.CONTROL, "A");
        find(locator).sendKeys(n, text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void submit(By locator) {
        find(locator).submit();
    }

    protected void switchToFrame(By frameLocator) {
        driver.switchTo().frame(find(frameLocator));
    }

    protected double parsePrice(String price) {
        return Double.parseDouble(price.split("\\s+")[0].replace(",", ""));
    }

    protected void selectFromDropDown(String value, By locator) {
        Select select = new Select(find(locator));
        select.selectByValue(value);
    }
}
