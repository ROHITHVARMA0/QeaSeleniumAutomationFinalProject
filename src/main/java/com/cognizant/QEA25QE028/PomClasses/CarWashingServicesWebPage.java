package com.cognizant.QEA25QE028.PomClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cognizant.QEA0250QE28.Utilities.ReadFromExcelFile;
import com.cognizant.QEA0250QE28.Utilities.WriteIntoExcelFile;


public class CarWashingServicesWebPage {
	
	WebDriver driver ;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	//CarWashingServicesWebPage constructor when gets invoked the WebDriver gets initialized
	public CarWashingServicesWebPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
		System.out.println(driver.getTitle());
		
	}
	
	ReadFromExcelFile readData = new ReadFromExcelFile();
	
	
	
	//PageFactory WebElements 
	
	//Web Element of "Sort By" filter
	@FindBy(xpath="//span[text()='Sort by']/parent::button")
	public WebElement sortingList;
	
	//Web Element of Rating in "Sort By" filter 
	@FindBy(xpath="//span[text()='Rating']")
	public WebElement ratingElement;
	
	//Web Element of Sort By "Rating" filter
	@FindBy(xpath="//span[text()='Ratings']/parent::button")
	public WebElement ratingGreaterThan4;
	
	//Web Element of rating Greater than "4.0+"
	@FindBy(xpath="//span[text()='4.0+']")
	public WebElement ratingElement1;
	
	//List of Web Elements
	
	//List of the store names
	@FindBy(xpath="//div/ul/li/div/div/span[starts-with(text(),'0')]/ancestor::div/div/h2/a/h3")
	public List<WebElement> storeNameElements;
	
	//List of store names
	@FindBy(xpath="//div/ul/li/div/div/span[starts-with(text(),'0')]")
	public List<WebElement> phoneNumberElements;
	
	//Web element of assert element 
	@FindBy(xpath = "//h1")
	public WebElement assertText;
	
	
	//WebElement clicking methods
	
	//Clicking on sorting element
	public void sortingListClick() {
		sortingList.click();
	}
	
	//Clicking on the sort by rating element 
	public void ratingElementClick() {
		ratingElement.click();
	}
	
	//Clicking on the sort by specific rating element
	public void ratingGreaterThan4Click() {
		ratingGreaterThan4.click();
	}
	
	//Clicking on the sort by specific rating element like greater than "4.0+"
	public void ratingElement1Click() {
		ratingElement1.click();
	}
	
	//Saving data into ExcelFile
	public void savingDataInCollections() throws IOException {
		
		// Storing the names of Car Stores containing phone numbers
		List<String> storeNamesText = new ArrayList<String>();
		for (WebElement ele : storeNameElements) {
			storeNamesText.add(ele.getText());
		}

		// Storing the names of Car Stores Phone Numbers containing phone numbers
		List<String> phoneNumbersText = new ArrayList<String>();
		for (WebElement ele : phoneNumberElements) {
			phoneNumbersText.add(ele.getText());
		}

		// Printing the store Names and its respective phone numbers
		for (int i = 0; i < 5; i++) {
			System.out.print(storeNamesText.get(i) + "\t\t" + phoneNumbersText.get(i));
			System.out.println();
		}
		System.out.println(storeNamesText.size()+"\t"+phoneNumberElements.size());
		
		//Sending data to WriteIntoExcelFile class to print data into ExcelFile
		WriteIntoExcelFile.carWashingDataIntoExcel( storeNamesText , phoneNumbersText);
		
	}
	
	//scrolling the web page to load more car washing services stores
	public void scrolling() throws InterruptedException {
		
		js = (JavascriptExecutor) driver;

		// Scroll down by 1000 pixels
		int length = 3000;
		for ( int i = 0 ; i <= 2 ; i++ ) {
			
			js.executeScript("window.scrollBy(0," + length + ")");
			System.out.println(i);
			Thread.sleep(4000);
			length = 1000;
		}
			
	
		
	}
	
	//WebDriverWait for the element for the element's visibility for 10 seconds
	public void waitVisibilityOfElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	//Going back to the home page of Just Dial Web site
	public void navigateBackWebPage() {
		driver.navigate().back();
	}
	
	// Refreshing the web page so that the web structure doesn't change
	public void refreshWebPage() {
		driver.navigate().refresh();
	}

	// delete the cookies in this web site
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	// To convert the assertion web element into text to verify it
	public String getAssertionText() {
		return assertText.getText();
	}
	
	// To verify the sort by element is displayed or not
	public boolean assertSortByDisplayed() {
		return sortingList.isDisplayed();
	}
	
	// To verify the rating specific is greater than "4.0+" is displayed or not
	public boolean assertRatingSelectionDisplayed() {
		return ratingGreaterThan4.isDisplayed();
	}
	
	
}