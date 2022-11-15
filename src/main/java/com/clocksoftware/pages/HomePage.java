package com.clocksoftware.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private final String pageUrl = "https://www.clock-software.com/demo-clockpms/index.html";

    private final By dateStartInputLocator = By.id("date-start");
    private final By toPlaceInputLocator = By.id("to-place");
    private final By bookNowButton = By.xpath("//input[@name='commit' and @value='Book now !']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        openUrl(pageUrl);
    }

    public void enterArrival(String date) {
        type(date, dateStartInputLocator);
    }

    public void enterNights(int nights) {
        typeAndReplace(String.valueOf(nights), toPlaceInputLocator);
    }

    public SelectRoomPage clickBookNow() {
        click(bookNowButton);
        return new SelectRoomPage(driver);
    }
}
