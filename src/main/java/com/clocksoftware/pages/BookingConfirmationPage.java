package com.clocksoftware.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingConfirmationPage extends Iframe{
    By successMessageLocator = By.xpath("//div[@id='common_alert']//following-sibling::h1");

    public BookingConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessage() {
        return find(successMessageLocator).getText();
    }
}
