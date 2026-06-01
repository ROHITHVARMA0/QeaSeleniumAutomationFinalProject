package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew.WebElements;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

public class JustDialFreeListingErrorMessageWebPage {
	
	WebDriver driver;
	
	public JustDialFreeListingErrorMessageWebPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		System.out.println(driver.getTitle());
	}
	
	
	ReadFromExcelFile readData = new ReadFromExcelFile();
		
	
//	@FindBy(xpath="//div/a[text()='Free Listing']")
//	public WebElement freeListingElement;
	
	@FindBy(id="1")
	public WebElement phoneNumberElement;
	
	@FindBy(xpath = "(//button[text()='Start Now '])[1]")
	public WebElement startNow;
	
	@FindBy(xpath = "//span[@class='undefined entermobilenumber_error__text__uPM09']")
	public WebElement errorMessage;
	
	
//	public void freeListingElementClick() {
//		freeListingElement.click();
//	}
	
	public void phoneNumberElementSendKeys() throws IOException {
		String[] input = ReadFromExcelFile.testReadExcelSheet();
		phoneNumberElement.sendKeys(input[1]);
	}
	
	public void startNowClick() {
		startNow.click();
	}
	
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
	
	public void takeScreenShot() {
		
//		TakesScreenshot screenShot = (TakesScreenshot) driver;
//		File screenShotFile = screenShot.getScreenshotAs(OutputType.FILE);
//		File targetFile = new File(System.getProperty("user.dir")+"\\projectResourcesOutputs\\screenshot.png");
//		screenShotFile.renameTo(targetFile);
		
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE); // Temporary file from Selenium

		// Define the final destination file
		File targetFile = new File(System.getProperty("user.dir") + "\\projectResourcesOutputs\\screenshot.png");

		try {
		    // 1. Ensure the destination directory exists
		    targetFile.getParentFile().mkdirs(); 

		    // 2. Use Files.copy() with REPLACE_EXISTING to reliably overwrite the old file
		    // This is much more reliable than renameTo()
		    Files.copy(srcFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		    
		    // Optional: Delete the temporary file created by Selenium after copying
		    srcFile.delete();
		    
		    System.out.println("Screenshot successfully saved and updated at: " + targetFile.getAbsolutePath());
		    
		} catch (IOException e) {
		    // Handle potential exceptions like permission issues or path errors
		    System.err.println("Failed to save or overwrite screenshot: " + e.getMessage());
		    e.printStackTrace();
		}
		
	}
	
	public void testFreeListingTitle() {
		if (!JustDialHomePage.proceedToFreeListing) {
            throw new SkipException("Skipping FreeListing class because title verification failed in JustDialHome.");
       }
	}
	
	public boolean assertPhoneNumberEnabled() {
		return phoneNumberElement.isEnabled();
	}
	
	public boolean assertStartNowButtonEnabled() {
		return startNow.isEnabled();
	}
	
	public boolean assertErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}
	
}