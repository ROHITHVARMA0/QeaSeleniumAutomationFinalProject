package com.cognizant.QEA25QE028.PomClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

import com.cognizant.QEA0250QE28.Utilities.WriteIntoExcelFile;

//import com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew.WebElements.WriteIntoExcelFile;


public class GymsWebPage {
	
	WebDriver driver;
	JavascriptExecutor js;
	
	public GymsWebPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println(driver.getTitle());
	}
	
//	@FindBy(xpath="//a[contains(@title,'Gym in ')]")
//	public WebElement gymIcon;
	
	@FindBy(xpath = "//h3[@class='jsx-5dc0aa11bf0ffdf3 resultbox_title_anchor font22 fw500 color111 line_clamp_1 ']")
	public List<WebElement> gymNameElementsWithoutPhNo;
	
	@FindBy(xpath="//span[contains(@class,'jsx-5dc0aa11bf0ffdf3 callcontent')]")
	public List<WebElement> gymPhoneNumberElementsWithoutPhNo;
	
	@FindBy(xpath="//div/ul/li/div/div/span[contains(text(),'0')]/ancestor::div/div/h2/a/h3")
	public List<WebElement> gymNameElements;
	
	@FindBy(xpath="//div/ul/li/div/div/span[contains(text(),'0')]")
	public List<WebElement> gymPhoneNumberElements;
	
	@FindBy(xpath = "//h1")
	public WebElement gymSearchTextElement;
	
//	public void gymIconClick() {
//		gymIcon.click();
//	}
	
	
	
	public void printingDataIntoExcel() throws IOException {
	
			// Storing the names of Gym that does not have phone numbers
			List<String> gymNamesTextWithoutPhno = new ArrayList<String>();
			for (WebElement ele : gymNameElementsWithoutPhNo) {
				gymNamesTextWithoutPhno.add(ele.getText());
			}
			
			// Storing the names of Gym Phone Numbers that does not contain phone numbers
			List<String> gymPhoneNumbersTextWithoutPhNo = new ArrayList<String>();
			for (WebElement ele : gymPhoneNumberElementsWithoutPhNo) {
				gymPhoneNumbersTextWithoutPhNo.add(ele.getText());
			}
			
			System.out.println(gymNameElementsWithoutPhNo.size()+"\t\t"+gymPhoneNumbersTextWithoutPhNo.size());
			
			//Storing the names of Gym containing phone numbers
			List<String> gymNamesText = new ArrayList<String>();
			for ( WebElement ele : gymNameElements ) {
				gymNamesText.add(ele.getText());
			}
			
			//Storing the names of Gym Phone Numbers containing phone numbers
			List<String> gymPhoneNumbersText = new ArrayList<String>();
			for (WebElement ele : gymPhoneNumberElements) {
				gymPhoneNumbersText.add(ele.getText());
			}
			
			//Sending data to WriteIntoExcelFile class to print data into ExcelFile that contains phoneNumbers
			WriteIntoExcelFile.gymsDataIntoExcel(gymNamesText, gymPhoneNumbersText);
			
			//Sending data to WriteIntoExcelFile class to print data into ExcelFile that contains phoneNumbers
			WriteIntoExcelFile.gymsDataWithOutPhNumIntoExcel(gymNamesTextWithoutPhno, gymPhoneNumbersTextWithoutPhNo);
			
			//Printing the Gym and its respective phone numbers
			for ( int i = 0 ; i < gymNameElements.size() ; i++ ) {
				System.out.print(gymNamesText.get(i)+"\t\t"+gymPhoneNumbersText.get(i));
				System.out.println();
			}
			System.out.println(gymNamesText.size()+"\t"+gymPhoneNumbersText.size());
			
			
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
		public void navigateBackWebPageGym() {
			driver.navigate().back();
		}
		
		public void scrolling() throws InterruptedException {
			
			js = (JavascriptExecutor) driver;
			
			int length = 3000;
			for ( int i = 0 ; i <= 10 ; i++ ) {
				
				js.executeScript("window.scrollBy(0,"+length+")");
				System.out.println(i);
				Thread.sleep(4000);
				length = 1000;
				
			}
		}	
		
		
		public void testGymsTitle() {
			if (!JustDialHomePage.proceedToGyms) {
	            throw new SkipException("Skipping FreeListing class because title verification failed in JustDialHome.");
	       }
		}
		
		public String gymSearchText() {
			return gymSearchTextElement.getText();
		}
		
		public String getGymWebPageTitle() {
			return driver.getTitle();
		}
	
	
}