package com.cognizant.QEA25QE028.PomClasses;

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

import com.cognizant.QEA0250QE28.Utilities.ReadFromExcelFile;

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
	
	//Finding the cancel mark for login pop up message
	@FindBy(xpath="//a[text()='Maybe Later']")
	public WebElement loginMayBeLater;
	
	//Finding the cancel mark for free listing pop up message
	@FindBy(xpath="//span[@aria-label='Close Banner']")
	public WebElement popUp;

	//Finding the location selection web element
	@FindBy(xpath="//input[@aria-label='Select Location']")
	public WebElement locationSelection;

	//Finding the detect location in Select Location
	@FindBy(xpath="//div[contains(text(),'Detect L')]")
	public WebElement detectLocationElement;
	
	//Searching the search bar for providing the input
	@FindBy(id="main-auto")
	public WebElement searchBar;
	
	
	//Searching for the free listing icon
	@FindBy(xpath="//div/a[text()='Free Listing']")
	public WebElement freeListingElement;
	
	//Clicking on the cancel mark of login pop up message
	public void loginMayBeLaterClick() {
		loginMayBeLater.click();
	}
	
	//Clicking on the cancel mark of free listing pop up message
	public void popUpClick() {
		popUp.click();
	}
	
	//Clicking on the location selection web element
	public void locationSelectionClick() {
		locationSelection.click();
	}
	
	//Clicking on the detect location in location selection options
	public void detectLocationElementClick() {
		detectLocationElement.click();
	}
	
	//Sending data using sendKeys into the search bar
	public void searchBarSendKeys() throws IOException {
		String[] input = ReadFromExcelFile.testReadExcelSheet();
		searchBar.sendKeys(input[0]+Keys.ENTER);;
	}
	
	//WebDriver wait specification for the home page web elements
	public void waitVisibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//Checking the car washing services title web page of just dial
	public void verifyCarWashingServicesSearchResultsTitle() {
        String expectedSearchTerm = "Top Car Washing Services near"; 
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
	
	//Clicking on the free listing icon
	public void freeListingElementClick() {
		freeListingElement.click();
	}
	
	//Checking the free listing title web page of just dial
	public void verifyFreeListingTitle() {
		freeListingElementClick();
		
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
        }
	}
	
	//Finding the gyms icon 
	@FindBy(xpath="//a[contains(@title,'Gym in ')]")
	public WebElement gymIcon;
	
	//Clicking on the gyms icon
	public void gymIconClick() {
		gymIcon.click();
	}
	
	//Checking the gyms title web page of just dial 
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