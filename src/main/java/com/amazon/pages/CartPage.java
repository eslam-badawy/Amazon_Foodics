package com.amazon.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends WebPage{
    public CartPage() throws IOException{}

    private static By deleteProduct = By.xpath("//input[@value='Delete']");
    private static By cartContainer = By.id("nav-cart-count-container");
    private static By subTotalPrice = By.id("sc-subtotal-amount-buybox");
    private static By proceedToBuy = By.id("sc-buy-box-ptc-button");
    private static By finalPrice = By.xpath("tr[data-testid='order-summary-unidenfitied-style'] td.a-text-right:contains('EGP')");

    public void deleteAllProductsInCart() {
    // Click the cart icon to navigate to the cart page
    clickOnElement(cartContainer);
    // Declare WebDriverWait
    WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
    while (true) {
        try {
            // Find all delete buttons
            List<WebElement> deleteButtons = driver.findElements(deleteProduct);
            // Loop through the delete buttons and click them to remove the products
            for (WebElement deleteButton : deleteButtons) {
                wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
            }
        } catch (StaleElementReferenceException e) {
            // If a stale element exception occurs, re-try the operation
            continue;
        }       
        // If there are no more delete buttons, exit the loop
        break;
    }
   }

   public static double getSubTotalPrice(){
   return extractPriceFromElement(driver.findElement(subTotalPrice));
   }

   public static void clickOnProceedToBuyButton(){
   clickOnElement(proceedToBuy);
   }
   
    public static double getFinalPrice(){
   return extractPriceFromElement(driver.findElement(finalPrice));
   }
}
