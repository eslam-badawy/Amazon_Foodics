package com.amazon.pages;

import java.io.IOException;

import org.openqa.selenium.By;

public class ShippingPage extends WebPage {

    public ShippingPage() throws IOException {}

    private static By fullName = By.id("address-ui-widgets-enterAddressFullName");
    private static By mobileNumber = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private static By streetName = By.id("address-ui-widgets-enterAddressLine1");
    private static By buildingName = By.id("address-ui-widgets-enter-building-name-or-number");
    private static By city = By.id("address-ui-widgets-enterAddressCity");
    private static By nearestLandMark = By.id("address-ui-widgets-landmark"); 
    private static By district = By.id("address-ui-widgets-enterAddressDistrictOrCounty");
    private static By firstDistrict = By.xpath("(//div[@id='address-ui-widgets-enterAddressDistrictOrCounty-dynamic-validation-alerts'])[1]");
    
}
