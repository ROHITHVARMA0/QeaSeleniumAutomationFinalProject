package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cognizant.QEA25QE028.PomClasses.JustDialHomePage;

public class JustDialHome extends DriverSetUp {
	
	JustDialHomePage jdHP;
	public static boolean proceedToCarWashing;
	
	@BeforeClass
	public void testLoginCancelOperationAndClosePopUpMessage() {
		

		jdHP = new JustDialHomePage(driver);

		// Closing the Login Page without Logging into the Web Page

		jdHP.waitVisibilityOfElement(jdHP.loginMayBeLater);
		jdHP.loginMayBeLaterClick();

		// Closing the popUp Message

		jdHP.waitVisibilityOfElement(jdHP.popUp);
		jdHP.popUpClick();
	}
	
	
	@Test
	public void testSearchBarInput() throws InterruptedException, IOException {
		//deleteCookies();
		

		jdHP.waitVisibilityOfElement(jdHP.locationSelection);
		jdHP.locationSelectionClick();
		
//		WebElement detectLocationElement = driver.findElement(By.xpath("//div[contains(text(),'Detect L')]"));
		jdHP.detectLocationElementClick();
		
		Thread.sleep(5000);
		
		//String[] inputData = ReadFromExcelFile.testReadExcelSheet();

		// Finding the Search Bar and Entering the Car Washing Services Near me as Input

		jdHP.waitVisibilityOfElement(jdHP.searchBar);
		jdHP.searchBarSendKeys();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods = "testSearchBarInput")
	public void verifyCarWashingServices() {

		jdHP.verifyCarWashingServicesSearchResultsTitle();
		
    }
	
	
//	@Test
	public void verifyFreeListing() {
		jdHP.verifyFreeListingTitle();
	}
	
	
	
	
	
}