package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew.WebElements.JustDialFreeListingErrorMessageWebPage;
import com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew.WebElements.JustDialHomePage;
public class JustDialFreeListingErrorMessage extends DriverSetUp {
	
	
	public JustDialFreeListingErrorMessageWebPage freeListingWebElements;
	
	public JustDialHomePage jdHP;
	
	
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	
//	@Test
	public void navigatingToHomePage() {
		//freeListingWebElements = PageFactory.initElements(driver, JustDialFreeListingErrorMessageWebPage.class);
		
//		freeListingWebElements = new JustDialFreeListingErrorMessageWebPage(driver);
		
		//Going back to the home page of Just Dial Web site
//		driver.navigate().back();
		freeListingWebElements.navigateBackWebPage();

		// delete the cookies in this web site
//		driver.manage().deleteAllCookies();
		freeListingWebElements.deleteCookies();

		// Refreshing the web page so that the web structure doesn't change
//		driver.navigate().refresh();
		freeListingWebElements.refreshWebPage();
				
		
	}
	
//	@Test(dependsOnMethods = "navigatingToHomePage")
	@BeforeClass
	public void homePageClickingFreeListingIcon() {
		
		//freeListingWebElements = new JustDialFreeListingErrorMessageWebPage(driver);
		freeListingWebElements = new JustDialFreeListingErrorMessageWebPage(driver);
		jdHP = new JustDialHomePage(driver);
		jdHP.verifyFreeListingTitle();
		
		//Going to the free listing in web site
		freeListingWebElements.testFreeListingTitle();
		
		System.out.println("FreeListing Page Object initialized.");
		
		
	}
	
//	@Test(dependsOnMethods = "homePageClickingFreeListingIcon")
	@Test
	public void cookieAndRefersh() {
		
		// delete the cookies in this web site
//		driver.manage().deleteAllCookies();
		freeListingWebElements.deleteCookies();

		// Refreshing the web page so that the web structure doesn't change
//		driver.navigate().refresh();
		freeListingWebElements.refreshWebPage();
		
	}
	
	@Test(dependsOnMethods = "cookieAndRefersh")
	public void sendData() throws IOException {
		
		Assert.assertTrue(freeListingWebElements.assertPhoneNumberEnabled());
		System.out.println("PhoneNumber Element is Enabled");
		System.out.println("------------------------");
		
		freeListingWebElements.phoneNumberElementSendKeys();
		
		Assert.assertTrue(freeListingWebElements.assertStartNowButtonEnabled());
		System.out.println("StartNow Button Element is Enabled");
		System.out.println("------------------------");

		// Clicking on StartNow Button
		freeListingWebElements.startNowClick();
		
	}
	
	@Test(dependsOnMethods = "sendData")
	public void takeScreenShot() {
		
		freeListingWebElements.takeScreenShot();
		
	}
	
	@Test(dependsOnMethods = "takeScreenShot")
	public void printErrorMessage() {
		
		Assert.assertTrue(freeListingWebElements.assertErrorMessageDisplayed());
		System.out.println("Error Message Element is Displayed");
		System.out.println("------------------------");
		
		//Finding and printing the Error Message		
		freeListingWebElements.printErrorMessage();
		
		freeListingWebElements.deleteCookies();
	}
	
	@Test(dependsOnMethods = "printErrorMessage")
	public void navigateToHomePage() {
		freeListingWebElements.deleteCookies();
		
		freeListingWebElements.refreshWebPage();
		
		//freeListingWebElements.navigateBackWebPage();
		
		freeListingWebElements.navigateBackWebPage();
		
		freeListingWebElements.deleteCookies();
		
		freeListingWebElements.refreshWebPage();
	}
	
	
}