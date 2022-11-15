package com.clocksoftware.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectRoomPage extends Iframe {
    private final By deluxeRoomPricesLocator = By.xpath("//h2[contains(text(), 'Superior')]/ancestor::div[2]/following-sibling::div[1]/div[2]/table/tbody/tr/td/h4[contains(text(), 'EUR')]");
    private final By selectDeluxeRoomButtonLocator = By.xpath("//h2[contains(text(), 'Superior')]/ancestor::div[2]/following-sibling::div[1]/div[2]/table/tbody/tr/td[3]//a");

    private final By deluxeRoomType = By.xpath("//h2[contains(text(), 'Superior')]");
    private final By deluxeRoomTypeLocator = By.xpath("//h2[contains(text(), 'Superior')]/ancestor::div[2]/following-sibling::div[1]/div[2]/table/tbody/tr//h4[contains(text(), 'Rate')]");

    public SelectRoomPage(WebDriver driver) {
        super(driver);
    }

    double maxPrice = Double.MIN_VALUE;
    int maxPriceIndex = -1;

    public String getRoomType() {
        return find(deluxeRoomType).getText();
    }

    public double getPriceOfExpensiveRoom() {
        List<WebElement> roomPriceElements = findAll(deluxeRoomPricesLocator);

        System.out.println();
        for(int i = 0; i< roomPriceElements.size(); i++) {
            double roomPrice = parsePrice(roomPriceElements.get(i).getText());
            if(roomPrice > maxPrice) {
                maxPrice = roomPrice;
                maxPriceIndex = i;
            }
        }
        return maxPrice;
    }

    public String getRoomRate() throws Exception {
        if(maxPriceIndex != -1) {
            List<WebElement> getRoomType = findAll(deluxeRoomTypeLocator);
            return getRoomType.get(maxPriceIndex).getText().split("\\n")[0];
        } else {
            throw new Exception("No max price selected");
        }
    }

    public ExtraServicesPage selectExpensiveRoom() throws Exception {
        if(maxPriceIndex != -1) {
            List<WebElement> selectRoomButtons = findAll(selectDeluxeRoomButtonLocator);
            selectRoomButtons.get(maxPriceIndex).click();
            return new ExtraServicesPage(driver);
        } else {
            throw new Exception("No max price selected");
        }
    }
}
