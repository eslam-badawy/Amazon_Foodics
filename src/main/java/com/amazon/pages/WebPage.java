package com.amazon.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.base.Base;

public class WebPage extends Base{

     private static final int ExplicitTimeoutInSeconds = 15;

    public WebPage() throws IOException {
        super();
    }

    public static void clickOnElement(By locator) {
        WebElement element = driver.findElement(locator);
        WebDriverWait wait = new WebDriverWait(driver, ExplicitTimeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform(); 
       }
    
    public static String getElementText(By locator) {
    	WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    	return element.getText();
    }

    public int getElementsSize(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return elements.size(); 
    }

    public static boolean isElementDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }
    
    public static double extractPriceFromElement(WebElement priceLocator) {
        String priceText = priceLocator.getText().replace(",", "").trim();
        try {
            return Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            // Handle the exception, e.g., return a default value or throw an error
            return 0.0;
        }
    }

    public static void EnterTextInField(By elementLocator, String text)
    {
        WebElement element = driver.findElement(elementLocator);
        element.clear();
        element.sendKeys(text);
    }
    
}
