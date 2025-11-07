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
	
	// Retain static fields for shared use
	public static WebDriver driver;
    public static WebDriverWait wait;
    public final String baseURL = ConfigLoader.getBaseURL();
    
    // 1. ADD THIS STATIC GETTER METHOD
    /**
     * Provides access to the WebDriver instance initialized in @BeforeSuite.
     * This is what your ProjectEventListeners or Test classes should call.
     * @return The currently active WebDriver instance.
     */
    public static WebDriver getDriver() {
		return driver; 
	}
	
	public ChromeOptions blockNotifications(ChromeOptions options) {
		return options.addArguments("--disable-notifications");
	}
	
	public ChromeOptions disableCookies(ChromeOptions options) {
		return options.addArguments("--disable-cookies");
	}
	
	
    @BeforeSuite
    public void suiteSetup() {
    	
    	System.out.println("--- Starting Test Suite Setup ---");
    	
    	// Initialize options
    	ChromeOptions options = new ChromeOptions();

    	// Configure options by invoking methods
    	options = blockNotifications(options);
    	options = disableCookies(options);
    	
    	// Create the WebDriver instance and assign it to the static 'driver' field
    	driver = new ChromeDriver(options); 
    	
        driver.get(baseURL);
        driver.manage().deleteAllCookies();
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

























//package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew.WebElements.ConfigLoader;
//
//public class DriverSetUp {
//	
//	ChromeOptions options = new ChromeOptions();
//	
//	public WebDriver getDriver(ChromeOptions options) {
//		return driver = new ChromeDriver(options);
//	}
//	
//	ConfigLoader cFL = new ConfigLoader();
//	
//	
//	public static WebDriver driver;
//  public static WebDriverWait wait;
//  public final String baseURL = ConfigLoader.getBaseURL();
//  
//  
//  
//  // Note: DriverSetUp is still needed for the actual creation logic.
//  
//  @BeforeSuite
//  public void suiteSetup() {
//  	
//  	ChromeOptions options = new ChromeOptions();
//  	options.addArguments("--disable-notifications");
//  	options.addArguments("--disable-cookies");
//  	
//      System.out.println("--- Starting Test Suite Setup ---");
//      
//      
//      WebDriver driver = new ChromeDriver(options);
////      DriverSetUp dst = new DriverSetUp();
////      driver = dst.getDriverAfterBlockingNotifications();
////      driver = dst.getDriverAfterDisablingCookies();
//      
//      driver.get(baseURL);
//      driver.manage().deleteAllCookies();
//      driver.manage().window().maximize();
//      
//      // Initialize the wait object once
//      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//  }
//  
//  
//  // Utility method to be used by all test classes
//  public void deleteCookies() {
//      if (driver != null) {
//          driver.manage().deleteAllCookies();
//      }
//  }
//	
//	
//	public ChromeOptions BlockNotifications() {
//		return options.addArguments("--disable-notifications");
//	}
//	
//	public WebDriver getDriverAfterBlockingNotifications() {
//		return driver = new ChromeDriver(BlockNotifications());
//	}
//	
//	public ChromeOptions DisablingCookies() {
//		return options.addArguments("--disable-cookies");
//	}
//	
//	
//	public WebDriver getDriverAfterDisablingCookies() {
//		return driver = new ChromeDriver(DisablingCookies());
//	}
//	
//	@AfterSuite
//	public void closeDriver() {
//		driver.manage().deleteAllCookies();
//		driver.quit();
//	}
//	
//	
//}