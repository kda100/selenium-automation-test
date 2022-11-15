package com.clocksoftware;

import com.clocksoftware.base.TestUtilities;
import com.clocksoftware.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;

public class BookRoomTest extends TestUtilities {

    @Test
    public void bookRoomTest() throws Exception {
        Date arrivalDate = getTomorrowsDate();
        int numOfNights = 4;

        //Home Page
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        homePage.enterArrival(convertDateToFormat(arrivalDate, "dd-MM-yyyy"));
        homePage.enterNights(numOfNights);

        //Select Room Page
        SelectRoomPage selectRoomPage = homePage.clickBookNow();
        selectRoomPage.switchToFrame();
        String roomType = selectRoomPage.getRoomType();
        double roomPrice = selectRoomPage.getPriceOfExpensiveRoom();
        String roomRate = selectRoomPage.getRoomRate();

        //ExtraServicesPage
        ExtraServicesPage extraServicesPage = selectRoomPage.selectExpensiveRoom();
        double airportTransferServicePrice = extraServicesPage.getAirportTransferPrice();
        double dryCleaningPrice = extraServicesPage.getDryCleaningPrice();

        //BookingReviewPage
        BookingReviewPage bookingReviewPage = extraServicesPage.addAirportTransferAndDryCleaningServices();

        //BookingReviewPage - Validations
        Assert.assertEquals(bookingReviewPage.getArrivalDate(), convertDateToFormat(arrivalDate, "dd MMM yyyy")); //Date
        Assert.assertEquals(bookingReviewPage.getStay(), numOfNights); //Num of nights
        Assert.assertEquals(roomPrice,bookingReviewPage.getRoomPrice() + bookingReviewPage.getCityTaxPrice()); //total
        Assert.assertEquals(roomType, bookingReviewPage.getRoomType()); //Room type
        Assert.assertEquals(airportTransferServicePrice + dryCleaningPrice, bookingReviewPage.getExtraServicesPrice()); //Add ons
        Assert.assertTrue(bookingReviewPage.getRate().contains(roomRate)); //rate

        //PurchasePage
        PurchasePage purchasePage = bookingReviewPage.fillDetails();

        //BookingConfirmationPage
        BookingConfirmationPage bookingConfirmationPage = purchasePage.enterCardDetails(getThisMonth(), getNextYear());
        Assert.assertEquals(bookingConfirmationPage.getSuccessMessage(), "Thank you for your booking!");


    }
}
