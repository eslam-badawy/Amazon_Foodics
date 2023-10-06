package com.amazon.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.pages.AmazonPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {
	
    public static WebDriver driver;
    public static Properties prop = new Properties();
    
    
   public Base() throws IOException {
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\amazon\\properties\\config.properties");
    prop.load(fis);
}

    public static void initializeBrowser() {
        if (prop.getProperty("browser").contentEquals("chrome"))  //It will get the property from properties file
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").contentEquals("firefox"))   //It will get the property from properties file
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (prop.getProperty("browser").contentEquals("edge"))   //It will get the property from properties file
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else {
            throw new Error("You picked a wrong browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
        driver.get(prop.getProperty("url"));
    }
   
}