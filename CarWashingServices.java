package com.cognizant.QEA25QE028.Selenium.TestNG.Project;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
// Note: Ensure DriverSetUp is in the same package or imported correctly

public class CarWashingServices {
	
	String baseURL = "https://www.justdial.com/";
	// Make the driver static so it can be managed throughout the suite
	public static WebDriver driver; 
	
	/**
	 * Initializes the WebDriver using the configured DriverSetUp class
	 * and opens the starting URL before the test suite runs.
	 */
	@BeforeSuite
	public void openWebPage() {
		
		// 1. Call the static method to create and configure the driver.
		// This ensures ChromeOptions (notifications, cookies) are applied.
		driver = DriverSetUp.getDriver(); 
		
		// 2. Open the URL
		driver.get(baseURL);
		
		// 3. Add common setup steps
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
	}
	
	// Optional: Add an AfterSuite method to clean up the driver
	@AfterSuite
	public void tearDown() {
		DriverSetUp.closeDriver();
	}
	
	
}