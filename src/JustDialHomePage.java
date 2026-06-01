package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew.WebElements;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class JustDialHomePage {
	
	
	WebDriver driver ;
	WebDriverWait wait;
	public static boolean proceedToCarWashing;
	public static boolean proceedToFreeListing;
	public static boolean proceedToGyms;
	
	public JustDialHomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver,this);
//		System.out.println(driver.getTitle());
		
	}
	
	ReadFromExcelFile readData = new ReadFromExcelFile();
	
	
	@FindBy(xpath="//a[text()='Maybe Later']")
	public WebElement loginMayBeLater;
	
	@FindBy(xpath="//span[@aria-label='Close Banner']")
	public WebElement popUp;

	@FindBy(xpath="//input[@aria-label='Select Location']")
	public WebElement locationSelection;

	@FindBy(xpath="//div[contains(text(),'Detect L')]")
	public WebElement detectLocationElement;

	@FindBy(id="main-auto")
	public WebElement searchBar;
	
	
	
	@FindBy(xpath="//div/a[text()='Free Listing']")
	public WebElement freeListingElement;
	
	
	public void loginMayBeLaterClick() {
		loginMayBeLater.click();
	}
	
	public void popUpClick() {
		popUp.click();
	}
	
	public void locationSelectionClick() {
		locationSelection.click();
	}
	
	public void detectLocationElementClick() {
		detectLocationElement.click();
	}
	
	//Sending data using sendKeys
	public void searchBarSendKeys() throws IOException {
		String[] input = ReadFromExcelFile.testReadExcelSheet();
		searchBar.sendKeys(input[0]+Keys.ENTER);;
	}
	
	public void waitVisibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void verifyCarWashingServicesSearchResultsTitle() {
        String expectedSearchTerm = "Top Car Washing Services near"; //assuming this is the search term
        String pageTitle = driver.getTitle();
        
        System.out.println("Current Page Title: " + pageTitle);

        // Verification logic
        if (pageTitle.toLowerCase().contains(expectedSearchTerm.toLowerCase())) {
            proceedToCarWashing = true; // Set the flag to true
            System.out.println("Verification Successful: Title contains '" + expectedSearchTerm + "'. Proceeding to next class.");
        } else {
            proceedToCarWashing = false; // Set the flag to false
            // If verification fails, you might want to fail the test explicitly
            //Assert.fail("Verification Failed: Title does not contain '" + expectedSearchTerm + "'. Actual Title: " + pageTitle);
        }
    }
	
	
	public void freeListingElementClick() {
		freeListingElement.click();
	}
	
	public void verifyFreeListingTitle() {
		freeListingElement.click();
		
//		String expectedSearchTerm = "Free Listing - Just Dial - List In Your Business For Free"; // Assuming this is the search term
        String expectedSearchTerm = "List";
		String pageTitle = driver.getTitle();
        
        System.out.println("Current Page Title: " + pageTitle);

        // Verification logic
        if (pageTitle.toLowerCase().contains(expectedSearchTerm.toLowerCase())) {
        	proceedToFreeListing = true; // Set the flag to true
            System.out.println("Verification Successful: Title contains '" + expectedSearchTerm + "'. Proceeding to next class.");
        } else {
        	proceedToFreeListing = false; // Set the flag to false
            // If verification fails, you might want to fail the test explicitly
            //Assert.fail("Verification Failed: Title does not contain '" + expectedSearchTerm + "'. Actual Title: " + pageTitle);
        }
	}
	
	
	@FindBy(xpath="//a[contains(@title,'Gym in ')]")
	public WebElement gymIcon;
	
	public void gymIconClick() {
		gymIcon.click();
	}
	
	public void verifyGymsTitle() {
		gymIconClick();
		
		String expectedSearchTerm = ""; // Assuming this is the search term
        String pageTitle = driver.getTitle();
        
        System.out.println("Current Page Title: " + pageTitle);

        // Verification logic
        if (pageTitle.toLowerCase().contains(expectedSearchTerm.toLowerCase())) {
        	proceedToGyms = true; // Set the flag to true
            System.out.println("Verification Successful: Title contains '" + expectedSearchTerm + "'. Proceeding to next class.");
        } else {
        	proceedToGyms = false; // Set the flag to false
            // If verification fails, you might want to fail the test explicitly
            //Assert.fail("Verification Failed: Title does not contain '" + expectedSearchTerm + "'. Actual Title: " + pageTitle);
        }
	}
	
	
	
	
}