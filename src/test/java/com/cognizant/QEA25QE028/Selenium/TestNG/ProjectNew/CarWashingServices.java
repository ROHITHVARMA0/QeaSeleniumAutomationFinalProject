package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cognizant.QEA25QE028.PomClasses.CarWashingServicesWebPage;
import com.cognizant.QEA25QE028.PomClasses.JustDialHomePage;



public class CarWashingServices extends DriverSetUp{
		
	CarWashingServicesWebPage carWebPage;
	
	

	@BeforeClass
    public void setupCarWashingPage() {
        // CHECK 1: If the flag is false, skip the entire class setup
        if (!JustDialHomePage.proceedToCarWashing) {
             throw new SkipException("Skipping CarWashingServices class because title verification failed in JustDialHome.");
        }
		carWebPage = new CarWashingServicesWebPage(driver);
		System.out.println("CarWashingServices Page Object initialized.");
		
		String actualOutputText = carWebPage.getAssertionText();
		String expectedOutputText = "Popular Car Washing Services in";
		
		Assert.assertTrue(actualOutputText.contains(expectedOutputText),expectedOutputText);
		
	}
	
	
	@Test(dependsOnMethods = "testSearchBarInput")
	public void testSortByRatingWithSpecificRating() throws InterruptedException {
		
		Assert.assertTrue(carWebPage.assertSortByDisplayed());
		System.out.println("Sort By Element is Displayed.");
		System.out.println("---------------------------");
				
		
//		Thread.sleep(3000);
		//carWebPage = new CarWashingServicesWebPage(driver);
		
		
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));		
		
		// Rating more than 4
//		WebElement sortingList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sort by']/parent::button")));
//		wait.until(ExpectedConditions.visibilityOf(carWebPage.sortingList));
		carWebPage.waitVisibilityOfElement(carWebPage.sortingList);
		carWebPage.sortingListClick();

//		WebElement ratingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Rating']")));
//		wait.until(ExpectedConditions.visibilityOf(carWebPage.ratingElement));
		carWebPage.waitVisibilityOfElement(carWebPage.ratingElement);
		carWebPage.ratingElementClick();
		

		// Rating more than 4
//		WebElement ratingGreaterThan4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Ratings']/parent::button")));
//		wait.until(ExpectedConditions.visibilityOf(carWebPage.ratingGreaterThan4));
		carWebPage.waitVisibilityOfElement(carWebPage.ratingGreaterThan4);
		carWebPage.ratingGreaterThan4Click();
		
		Assert.assertTrue(carWebPage.assertRatingSelectionDisplayed());
		System.out.println("Rating Selection Button is Displayed.");
		System.out.println("---------------------------");

//		WebElement ratingElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='4.0+']")));
//		wait.until(ExpectedConditions.visibilityOf(carWebPage.ratingElement1));
		carWebPage.waitVisibilityOfElement(carWebPage.ratingElement1);
		carWebPage.ratingElement1Click();
	}
	
	
	@Test(dependsOnMethods = "testSortByRatingWithSpecificRating")
	public void scrolling() throws InterruptedException {
		
		carWebPage.deleteCookies();
		
		carWebPage.refreshWebPage();
		
//		carWebPage.deleteCookies();
//		
//		carWebPage.refreshWebPage();
//		
//		carWebPage.deleteCookies();
//		
//		carWebPage.refreshWebPage();
		
		carWebPage.scrolling();
		
	}
	
	@Test(dependsOnMethods = "scrolling")
	public void savingDataInCollections() throws IOException {
		
		
		carWebPage.savingDataInCollections();
		
		
	}
	
	
	@Test(dependsOnMethods = "savingDataInCollections")
    public void navigateBackToHomepage() {
        System.out.println("Navigating back to JustDial Homepage...");
        
        carWebPage.refreshWebPage();
        
        carWebPage.deleteCookies();
        
        carWebPage.navigateBackWebPage();
        
        carWebPage.deleteCookies();
        
        carWebPage.refreshWebPage();
        
        // Call the inherited utility method
//        carWebPage.navigateBackWebPage();
        
        // OPTIONAL: Simple verification that we are no longer on a detailed search page
        String currentTitle = driver.getTitle();
        System.out.println("Title after navigating back: " + currentTitle);
        // Assert.assertFalse(currentTitle.contains("Car Washing Services"), "Failed to navigate back.");
    }

	
	
}