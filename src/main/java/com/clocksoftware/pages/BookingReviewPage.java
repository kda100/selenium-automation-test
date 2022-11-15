package com.clocksoftware.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingReviewPage extends Iframe{

    private final By arrivalDateLocator = By.xpath("//*[text() = 'Arrival']/ancestor::div[1]/following-sibling::div");
    private final By stayLocator = By.xpath("//*[text() = 'Stay']/ancestor::div[1]/following-sibling::div");
    private final By roomTypeLocator = By.xpath("//*[text() = 'Room Type']/ancestor::div[1]/following-sibling::div");
    private final By rateLocator = By.xpath("//*[text() = 'Rate']/ancestor::div[1]/following-sibling::div");
    private final By roomsPriceLocator = By.xpath("//*[text() = 'Rooms']/ancestor::div[1]/following-sibling::div");
    private final By cityTaxPriceLocator = By.xpath("//*[text() = 'City Tax']/ancestor::div[1]/following-sibling::div");
    private final By extraServicesLocator = By.xpath("//*[text() = 'Extra Services']/ancestor::div[1]/following-sibling::div");
    private final By emailInputLocator = By.id("booking_guest_attributes_e_mail");
    private final By lastNameLocator = By.id("booking_guest_attributes_last_name");
    private final By firstNameLocator = By.id("booking_guest_attributes_first_name");
    private final By phoneNumberLocator = By.id("booking_guest_attributes_phone_number");
    private final By creditCardSelectLocator = By.id("booking_payment_service_credit_card_collect");
    private final By bookingAgreedLocator = By.id("booking_agreed");
    private final By createBookingButton = By.xpath("//input[@value='Create Booking']");

    public BookingReviewPage(WebDriver driver) {
        super(driver);
    }

    public PurchasePage fillDetails() {
        type("joedoe@hotmail.co.uk", emailInputLocator);
        type("Doe", lastNameLocator);
        type("John", firstNameLocator);
        type("07787116549", phoneNumberLocator);
        click(creditCardSelectLocator);
        click(bookingAgreedLocator);
        submit(createBookingButton);
        return new PurchasePage(driver);
    }

    public String getArrivalDate() {
        return find(arrivalDateLocator).getText();
    }
    public int getStay() {
        return Integer.parseInt(find(stayLocator).getText());
    }
    public String getRoomType() {
        return find(roomTypeLocator).getText();
    }
    public String getRate() {
        return find(rateLocator).getText();
    }
    public double getRoomPrice() {
        return parsePrice(find(roomsPriceLocator).getText());
    }

    public double getCityTaxPrice() {
        return parsePrice(find(cityTaxPriceLocator).getText());
    }

    public double getExtraServicesPrice() {
        return parsePrice(find(extraServicesLocator).getText());
    }
}
