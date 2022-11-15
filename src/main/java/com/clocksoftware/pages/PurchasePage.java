package com.clocksoftware.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage extends Iframe {
    private final By cardNumberInputLocator = By.id("cardNumber");
    private final By cardBrandSelectLocator = By.id("credit_card_collect_purchase_brand");
    private final By cardHolderInputLocator = By.id("ccName");
    private final By cardExpirationMonthSelectLocator = By.id("cardExpirationMonth");
    private final By cardExpirationYearSelectLocator = By.id("cardExpirationYear");
    private final By billingAddressInputLocator = By.id("credit_card_collect_purchase_address");
    private final By zipCodeInputLocator = By.id("credit_card_collect_purchase_zip");
    private final By cityInputLocator = By.id("credit_card_collect_purchase_city");
    private final By stateInputLocator = By.id("credit_card_collect_purchase_state");
    private final By countrySelectLocator = By.id("credit_card_collect_purchase_country");
    private final By payButtonLocator = By.xpath("//button[@type='submit']");
    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    public BookingConfirmationPage enterCardDetails(String expirationMonth, String expirationYear) {
        type("5400708549589144", cardNumberInputLocator);
        selectFromDropDown("master", cardBrandSelectLocator);
        typeAndReplace("John Doe", cardHolderInputLocator);
        selectFromDropDown(expirationMonth, cardExpirationMonthSelectLocator);
        selectFromDropDown(expirationYear, cardExpirationYearSelectLocator);
        type("123 Good Street", billingAddressInputLocator);
        type("30083", zipCodeInputLocator);
        type("New York", cityInputLocator);
        type("New York", stateInputLocator);
        selectFromDropDown("US", countrySelectLocator);
        click(payButtonLocator);
        return new BookingConfirmationPage(driver);
    }
}
