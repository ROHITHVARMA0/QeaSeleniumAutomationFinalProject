package com.cognizant.QEA25QE028.Selenium.TestNG.Project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite; // Use @AfterSuite for final cleanup
import org.testng.annotations.BeforeSuite; // Use @BeforeSuite for initial setup
import org.testng.annotations.Test;


public class IdentifyCarWashServices {
	
	// Class fields will now use the static driver from DriverSetUp
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeSuite
	public void setupDriver() {
		// Initialize the driver using the centralized setup class
		driver = DriverSetUp.getDriver();
		
		// Initial setup steps
		driver.get("https://www.justdial.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// Initialize the wait object once the driver is ready
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	@Test(priority=1)
	public void testWebPageOpenAndCarWashSearch() throws InterruptedException {
		
		// Driver setup and options are now handled by @BeforeSuite and DriverSetUp.getDriver()
		
		// The driver and wait variables are now local to the class and initialized in @BeforeSuite
		
		// Closing the Login Page without Logging into the Web Page
		WebElement loginMayBeLater = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Maybe Later']")));
		loginMayBeLater.click();
		
		// Closing the popUp Message
		WebElement popUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='Close Banner']")));
		popUp.click();
		
		// Finding the Search Bar and Entering the Car Washing Services Near me as Input
		WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main-auto")));
		searchBar.sendKeys("Car Washing Services Near me"+Keys.ENTER);
		
		// To select the Sort By Rating Filter
		WebElement filterTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='All Filters']/parent::button")));
		filterTab.click();
		
		// Clicking on the Rating button in Sort by Category
		WebElement sortByRatingElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Rating']")));
		sortByRatingElement.click();
		
		// Selecting the Apply Button to click so that we can apply the selected filters
		WebElement applyFiltersElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Apply Filters']")));
		applyFiltersElement.click();
		
		
		// Rating more than 4
		WebElement ratingGreaterThan4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Ratings']/parent::button")));
		ratingGreaterThan4.click();
		
		WebElement ratingE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='4.0+']")));
		ratingE.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down to load more results
		int scrollDistance = 3000;
		for ( int i = 0 ; i <= 35 ; i++ ) {
			
			js.executeScript("window.scrollBy(0,"+scrollDistance+")");
			System.out.println("Scroll count: " + i);
			Thread.sleep(4000); // Wait for content to load
			scrollDistance = 1000; // Reduce scroll distance after the first large scroll
			
		}
		
		// WebElements to store the Car Store Names containing phone numbers
		List<WebElement> storeNameElements = driver.findElements(By.xpath("//div/ul/li/div/div/span[contains(text(),'0')]/ancestor::div/div/h2/a/h3"));
		
		// Storing the names of Car Stores containing phone numbers
		List<String> storeNamesText = new ArrayList<String>();
		for ( WebElement ele : storeNameElements ) {
			storeNamesText.add(ele.getText());
		}
		
		// WebElements to store the phone numbers
		List<WebElement> phoneNumberElements = driver.findElements(By.xpath("//div/ul/li/div/div/span[contains(text(),'0')]"));
		
		// Storing the names of Car Stores Phone Numbers containing phone numbers
		List<String> phoneNumbersText = new ArrayList<String>();
		for (WebElement ele : phoneNumberElements) {
			phoneNumbersText.add(ele.getText());
		}
		
		// Printing the store Names and its respective phone numbers
		System.out.println("\n--- Top 5 Car Wash Services ---");
		for ( int i = 0 ; i < 5 && i < storeNamesText.size() ; i++ ) {
			System.out.print(storeNamesText.get(i)+"\t\t"+phoneNumbersText.get(i));
			System.out.println();
		}
		System.out.println("Total Stores Found: " + storeNamesText.size()+"\tTotal Phone Numbers Found: "+phoneNumberElements.size());
		
		// Going back to the home page of Just Dial Web site
		driver.navigate().back();

		// delete the cookies in this web site
		driver.manage().deleteAllCookies();

		// Refreshing the web page so that the web structure doesn't change
		driver.navigate().refresh();
		
		// Going to the free listing in web site
		WebElement freeListingElement = driver.findElement(By.xpath("//div/a[text()='Free Listing']"));
		freeListingElement.click();
		
		// delete the cookies in this web site
		driver.manage().deleteAllCookies();

		// Refreshing the web page so that the web structure doesn't change
		driver.navigate().refresh();
		
		// Input details for Free Listing
		WebElement phoneNumberElement = driver.findElement(By.id("1"));
		phoneNumberElement.sendKeys("1234567890");
		
		// Clicking on StartNow Button
		WebElement startNow = driver.findElement(By.xpath("//*[@id=\"listyourbusiness\"]/div[1]/form/button"));
		startNow.click();
		
		// Finding and printing the Error Message
		WebElement errorMessage = driver.findElement(By.xpath("//span[@class='undefined entermobilenumber_error__text__uPM09']"));
		System.out.println("The Error Message while giving Invalid Input for Free Listing is : "+errorMessage.getText());
		
		// delete the cookies in this web site
		driver.manage().deleteAllCookies();
		
	}
	
	@Test(priority=2)
	public void testGyms() throws InterruptedException {
		
		// Going back to the home page of Just Dial Web site
		driver.navigate().back();

		// delete the cookies in this web site
		driver.manage().deleteAllCookies();
		
		// Refreshing the web page so that the web structure doesn't change
		driver.navigate().refresh();

		// Wait object is already initialized in @BeforeSuite
		
		// Clicking on the Gym Icon
		WebElement gymIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'Gym in ')]")));
		gymIcon.click();
		
		// delete the cookies in this web site
		driver.manage().deleteAllCookies();

		// Refreshing the web page so that the web structure doesn't change
		driver.navigate().refresh();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		int scrollDistance = 3000;
		for ( int i = 0 ; i <= 30 ; i++ ) {
			
			js.executeScript("window.scrollBy(0,"+scrollDistance+")");
			System.out.println("Scroll count: " + i);
			Thread.sleep(4000); // Wait for content to load
			scrollDistance = 1000;
			
		}
		
		// Finding gym names and phone numbers logic remains the same (using existing driver)
		
		// ... (Gym extraction and printing logic from your original code) ...
		
		//WebElements to store the Gym Names that does not have phone numbers
		List<WebElement> gymNameElementsWithoutPhNo = driver.findElements(By.xpath("//h3"));

		// Storing the names of Gym that does not have phone numbers
		List<String> gymNamesTextWithoutPhno = new ArrayList<String>();
		for (WebElement ele : gymNameElementsWithoutPhNo) {
			gymNamesTextWithoutPhno.add(ele.getText());
		}
		
		//WebElements to Gym the phone numbers that does not contain phone numbers
		List<WebElement> gymPhoneNumberElementsWithoutPhNo = driver.findElements(By.xpath("//span[contains(@class,'jsx-5dc0aa11bf0ffdf3 callcontent')]"));

		// Storing the names of Gym Phone Numbers that does not contain phone numbers
		List<String> gymPhoneNumbersTextWithoutPhNo = new ArrayList<String>();
		for (WebElement ele : gymPhoneNumberElementsWithoutPhNo) {
			gymPhoneNumbersTextWithoutPhNo.add(ele.getText());
		}
		
		System.out.println("Gyms (without phone filter) Name Count: " + gymNameElementsWithoutPhNo.size()+"\t\tPhone Number Count: "+gymPhoneNumbersTextWithoutPhNo.size());
		
		
		//WebElements to store the Gym Names containing phone numbers
		List<WebElement> gymNameElements = driver.findElements(By.xpath("//div/ul/li/div/div/span/ancestor::div/div/h2/a/h3"));
				
		//Storing the names of Gym containing phone numbers
		List<String> gymNamesText = new ArrayList<String>();
		for ( WebElement ele : gymNameElements ) {
			gymNamesText.add(ele.getText());
		}
				
		//WebElements to Gym the phone numbers
		List<WebElement> gymPhoneNumberElements = driver.findElements(By.xpath("//div/ul/li/div/div/span[contains(text(),'0')]"));
		
		//Storing the names of Gym Phone Numbers containing phone numbers
		List<String> gymPhoneNumbersText = new ArrayList<String>();
		for (WebElement ele : gymPhoneNumberElements) {
			gymPhoneNumbersText.add(ele.getText());
		}
				
		//Printing the Gym and its respective phone numbers
		System.out.println("\n--- Gyms with Phone Numbers ---");
		for ( int i = 0 ; i < gymNameElements.size() && i < gymPhoneNumbersText.size() ; i++ ) {
			System.out.print(gymNamesText.get(i)+"\t\t"+gymPhoneNumbersText.get(i));
			System.out.println();
		}
		System.out.println("Gyms (with phone filter) Name Count: " + gymNamesText.size()+"\tPhone Number Count: "+gymPhoneNumbersText.size());
		
		// Going back to the home page of Just Dial Web site
		driver.navigate().back();

		// delete the cookies in this web site
		driver.manage().deleteAllCookies();

		// Refreshing the web page so that the web structure doesn't change
		driver.navigate().refresh();
		
		driver.manage().deleteAllCookies();

	}
	
	@AfterSuite
	public void tearDown() {
		// Close the driver using the centralized setup class
		DriverSetUp.closeDriver();
	}
	
}