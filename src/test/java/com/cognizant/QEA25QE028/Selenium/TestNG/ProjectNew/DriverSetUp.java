package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.cognizant.QEA0250QE28.Utilities.ConfigLoader;

public class DriverSetUp {
	
	public static WebDriver driver;
    public static WebDriverWait wait;
    public final String baseURL = ConfigLoader.getBaseURL();
    
    //Returning web driver when ever invoked the method from this class
    public static WebDriver getDriver() {
		return driver; 
	}
	
    //Disabling notifications for the web page
	public ChromeOptions blockNotifications(ChromeOptions options) {
		return options.addArguments("--disable-notifications");
	}
	
	
    @BeforeSuite
    public void suiteSetup() {
    	
    	System.out.println("--- Starting Test Suite Setup ---");
    	
    	ChromeOptions options = new ChromeOptions();

    	options = blockNotifications(options);
    	
    	driver = new ChromeDriver(options); 
    	
        driver.get(baseURL);
        deleteCookies();
        driver.manage().window().maximize();
    	
        // Initialize the wait object once
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    // Utility method to be used by all test classes
    public void deleteCookies() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }
	
	@AfterSuite
	public void closeDriver() {
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.quit();
		}
	}
}


