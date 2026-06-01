package com.cognizant.QEA25QE028.Selenium.TestNG.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetUp {
	
	// MAKE THE DRIVER STATIC so all test methods use the same instance
	public static WebDriver driver;
	
	/**
	 * Creates and configures the ChromeDriver instance with desired options.
	 * @return The configured WebDriver instance.
	 */
	public static WebDriver getDriver() {
		
		// 1. Create ChromeOptions object
		ChromeOptions options = new ChromeOptions();
		
		// 2. Add Arguments (moved from IdentifyCarWashServices)
		//options.addArguments("--disable-notifications");
		options.addArguments("--disable-cookies");
		
		// 3. Initialize the static driver and return it
		driver = new ChromeDriver(options);
		return driver;
	}
	
	/**
	 * Simple static method to access the already created driver.
	 * @return The current WebDriver instance.
	 */
	public static WebDriver getCurrentDriver() {
		return driver;
	}
	
	
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}