package com.clocksoftware.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Iframe extends BasePage{
    private final By frameLocator = By.id("clock_pms_iframe_1");

    public Iframe(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame() {
        switchToFrame(frameLocator);
    }
}
