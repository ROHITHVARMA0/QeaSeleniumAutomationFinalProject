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
	
	public CarWashingServicesWebPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
		System.out.println(driver.getTitle());
		
	}
	
	ReadFromExcelFile readData = new ReadFromExcelFile();
	
	
	
	//PageFactory WebElements

	@FindBy(xpath="//span[text()='Sort by']/parent::button")
	public WebElement sortingList;

	@FindBy(xpath="//span[text()='Rating']")
	public WebElement ratingElement;


	@FindBy(xpath="//span[text()='Ratings']/parent::button")
	public WebElement ratingGreaterThan4;


	@FindBy(xpath="//span[text()='4.0+']")
	public WebElement ratingElement1;
	
	//List of Web Elements
	
	@FindBy(xpath="//div/ul/li/div/div/span[starts-with(text(),'0')]/ancestor::div/div/h2/a/h3")
	public List<WebElement> storeNameElements;
	
	@FindBy(xpath="//div/ul/li/div/div/span[starts-with(text(),'0')]")
	public List<WebElement> phoneNumberElements;
	
	
	@FindBy(xpath = "//h1")
	public WebElement assertText;
	
	
	//WebElement clicking methods
	
	public void sortingListClick() {
		sortingList.click();
	}
	
	public void ratingElementClick() {
		ratingElement.click();
	}
	
	public void ratingGreaterThan4Click() {
		ratingGreaterThan4.click();
	}
	
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
	
	public String getAssertionText() {
		return assertText.getText();
	}
	
	public boolean assertSortByDisplayed() {
		return sortingList.isDisplayed();
	}
	
	public boolean assertRatingSelectionDisplayed() {
		return ratingGreaterThan4.isDisplayed();
	}
	
	
}