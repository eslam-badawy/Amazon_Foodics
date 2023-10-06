package com.amazon.pages;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonPage extends WebPage {
    public AmazonPage() throws IOException{}

    private static By cartContainer = By.id("nav-cart-count-container");

    private static By allMenu = By.id("nav-hamburger-menu");
    private static By videoGames = By.xpath("//div[text()='Video Games']");
    private static By allVideoGames = By.xpath("//a[text()='All Video Games']");
    private static By freeShippingFilter = By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-mini']/span[contains(text(), 'FREE Shipping')]");
    private static By newConditionFilter = By.xpath("//a[contains(@class, 's-navigation-item') and .//span[contains(text(), 'New')]]");
    private static By sortBy = By.xpath("//span[contains(text(), 'Sort by:')]");
    private static By priceHighToLow = By.xpath("//a[contains(text(), 'Price: High to Low')]");
    private static By productPrice = By.xpath("//a/span/span/span[@class='a-price-whole']");
    private static By addToCart = By.id("add-to-cart-button");
    private static By nextButton = By.xpath("//a[contains(@class, 's-pagination-next')]");
    private static By seeAll = By.xpath("//a[@class='hmenu-item hmenu-compressed-btn' and contains(., 'see all')]");


   

   

    public static void clickOnAllMenu() {
    	clickOnElement(allMenu);
    }

    public static void clickOnSeeAll() {
    	clickOnElement(seeAll);
    }

    public static void clickOnVideoGames() {
    	clickOnElement(videoGames);
    }

     public static void clickOnAllVideoGames() {
    	clickOnElement(allVideoGames);
    }

    public static void clickOnFreeShippingFilter() {
    	clickOnElement(freeShippingFilter);
    }

    public static void clickOnNewConditionFilter() {
    	clickOnElement(newConditionFilter);
    }

     public static void clickOnSortByPriceHighToLow() throws InterruptedException {
        clickOnElement(sortBy);
    	clickOnElement(priceHighToLow);
        Thread.sleep(3000);
    }

    private static void clickOnNextButton(){
        clickOnElement(nextButton);
    }

    private static void clickOnAddToCart(){
        clickOnElement(addToCart);
    }
    
    public static void addProductsBelowSpecificAmount(double amount) {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
        List<WebElement> productElements;  
        do {
            productElements = driver.findElements(productPrice);
            boolean productsAdded = false;
            for (int i = 0; i <= productElements.size(); i++) {
                productElements = driver.findElements(productPrice); // Re-locate elements
                WebElement product = productElements.get(i);
                double price = extractPriceFromElement(product);       
                if (price < amount) {
                    wait.until(ExpectedConditions.elementToBeClickable(product)).click();
                    clickOnAddToCart();
                    productsAdded = true;
                    driver.navigate().back();  driver.navigate().back();
                }
            }           
            if (!productsAdded) {
                clickOnNextButton();
            }
        } while (areMorePagesAvailable());        
    }
       
    public static boolean areMorePagesAvailable() {
        try {
            WebElement nextButton = driver.findElement(By.cssSelector(".s-pagination-next"));
            return nextButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void clickOnCartContainer(){
        clickOnElement(cartContainer);
    }    
    
}
