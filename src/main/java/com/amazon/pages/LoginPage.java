package com.amazon.pages;

import java.io.IOException;

import org.openqa.selenium.By;

public class LoginPage extends WebPage {

    public LoginPage() throws IOException {}

    private static By signInMenuButton = By.xpath("//a[contains(@class, 'hmenu-item') and text()='Sign in']");
    private static By emailTextField = By.xpath("//input[@type='email']");   
    private static By continueButton = By.id("continue");
    private static By passwordTextField = By.xpath("//input[@type='password']");
    private static By signInButton = By.id("signInSubmit");

    public void login() {
    	AmazonPage.clickOnAllMenu();
        clickOnElement(signInMenuButton);
        EnterTextInField(emailTextField, prop.getProperty("email"));
        clickOnElement(continueButton);
        EnterTextInField(passwordTextField, prop.getProperty("password"));
        clickOnElement(signInButton);
    }
    
}
