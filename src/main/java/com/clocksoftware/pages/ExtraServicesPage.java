package com.clocksoftware.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExtraServicesPage extends Iframe{

    private final By airportTransferInputLocator = By.xpath("//div[contains(text(), 'Airport Transfer')]/parent::div/following-sibling::div/following-sibling::div/input");
    private final By airportTransferPriceLocator = By.xpath("//div[contains(text(), 'Airport Transfer')]/parent::div/following-sibling::div/div[contains(text(), 'EUR')]");
    private final By dryCleaningInputLocator = By.xpath("//div[contains(text(), 'Dry Cleaning')]/parent::div/following-sibling::div/following-sibling::div/input");
    private final By dryCleaningPriceLocator = By.xpath("//div[contains(text(), 'Dry Cleaning')]/parent::div/following-sibling::div/div[contains(text(), 'EUR')]");

    private final By addSelectedServicesButton = By.xpath("(//input[@value='Add the selected services >>'])[1]");
    public ExtraServicesPage(WebDriver driver) {
        super(driver);
    }

    public BookingReviewPage addAirportTransferAndDryCleaningServices() {
        type(String.valueOf(1), airportTransferInputLocator);
        type(String.valueOf(1), dryCleaningInputLocator);
        submit(addSelectedServicesButton);
        return new BookingReviewPage(driver);
    }

    public double getAirportTransferPrice() {
        return parsePrice(find(airportTransferPriceLocator).getText());
    }

    public double getDryCleaningPrice() {
        return parsePrice(find(dryCleaningPriceLocator).getText());
    }
}
