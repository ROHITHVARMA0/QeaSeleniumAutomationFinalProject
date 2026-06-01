package com.cognizant.QEA25QE028.PomClasses;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

import com.cognizant.QEA0250QE28.Utilities.ConfigLoader;
import com.cognizant.QEA0250QE28.Utilities.ReadFromExcelFile;

public class JustDialFreeListingErrorMessageWebPage {
	
	WebDriver driver;
	
	ConfigLoader cfl;
	
	//JustDialFreeListingErrorMessageWebPage constructor when gets invoked the WebDriver gets initialized
	public JustDialFreeListingErrorMessageWebPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		System.out.println(driver.getTitle());
	}
	
	//Reading excel file and getting data from the excel file
	ReadFromExcelFile readData = new ReadFromExcelFile();
		
	
//	@FindBy(xpath="//div/a[text()='Free Listing']")
//	public WebElement freeListingElement;
	
	//The web element of phone number input field
	@FindBy(id="1")
	public WebElement phoneNumberElement;
	
	//THe start now button
	@FindBy(xpath = "(//button[text()='Start Now '])[1]")
	public WebElement startNow;
	
	//The error message that gets displayed after giving an invalid input
	@FindBy(xpath = "//span[@class='undefined entermobilenumber_error__text__uPM09']")
	public WebElement errorMessage;
	
	
//	public void freeListingElementClick() {
//		freeListingElement.click();
//	}
	
	//Sending an invalid input into phone number input web element that we got after reading excel file
	public void phoneNumberElementSendKeys() throws IOException {
		String[] input = ReadFromExcelFile.testReadExcelSheet();
		phoneNumberElement.sendKeys(input[1]);
	}
	
	//Clicking on the start now button
	public void startNowClick() {
		startNow.click();
	}
	
	//Printing the error message we got after giving an invalid input in phone number input field
	public void printErrorMessage() {
		System.out.println("The Error Message while giving Invalid Input for Free Listing is : "+errorMessage.getText());
	}
	
	// Refreshing the web page so that the web structure doesn't change
	public void refreshWebPage() {
		driver.navigate().refresh();
	}
	
	
	// delete the cookies in this web site
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	//Going back to the home page of Just Dial Web site
	public void navigateBackWebPage() {
		driver.navigate().back();
	}
	
	//Taking screenshot of the web page when the error message gets displayed in the web page
	public void takeScreenShot() {
		
		try {
		    // Check if the driver supports screenshots
		    if (!(driver instanceof TakesScreenshot)) {
		        System.err.println("Driver does not support screenshots.");
		        return;
		    }
		    
		    TakesScreenshot screenShot = (TakesScreenshot) driver;
		    
		    // 1. Get the temporary screenshot file (src)
		    File src = screenShot.getScreenshotAs(OutputType.FILE);

		    // 2. Generate a unique file name using a timestamp
		    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		    String fileName = "screenshot_" + timeStamp + ".png"; // e.g., screenshot_20251105_093519.png

		    // 3. Define the target file path
		    String targetDirPath = ConfigLoader.getScreenShotFilePath(); // The directory path
		    File targetFile = new File(targetDirPath, fileName); // The complete file path and name

		    // 4. Copy the temporary file to the new target file with the unique name
		    FileUtils.copyFile(src, targetFile);
		    
		    System.out.println("Screenshot saved successfully to: " + targetFile.getAbsolutePath());
		    
		} catch (Exception e) {
		    System.err.println("Error taking screenshot: " + e.getMessage());
		    // In a real framework, you might want to log the stack trace: e.printStackTrace();
		}
		
	}
	
	//Checking whether we got redirected from home page to free listing page of just dial
	public void testFreeListingTitle() {
		if (!JustDialHomePage.proceedToFreeListing) {
            throw new SkipException("Skipping FreeListing class because title verification failed in JustDialHome.");
       }
	}
	
	//Checking whether the phone number field is enabled
	public boolean assertPhoneNumberEnabled() {
		return phoneNumberElement.isEnabled();
	}
	
	//Checking whether the start now button is enabled
	public boolean assertStartNowButtonEnabled() {
		return startNow.isEnabled();
	}
	
	//Checking whether the error message gets displayed after providing an invalid number
	public boolean assertErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}
	
}