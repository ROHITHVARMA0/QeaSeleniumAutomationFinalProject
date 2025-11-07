package com.cognizant.QEA25QE028.Selenium.TestNG.ProjectNew;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cognizant.QEA25QE028.PomClasses.GymsWebPage;
import com.cognizant.QEA25QE028.PomClasses.JustDialHomePage;


public class Gyms extends DriverSetUp{
	
//	@FindBy(xpath="//a[contains(@title,'Gym in ')]")
//	WebElement gymIcon;
	
	public GymsWebPage gymWebPage;
	
	public JustDialHomePage jdHP;
	
//	@Test
	//It will not execute because there is not @Test annotation
	public void navigateToHomePage() {
		
		gymWebPage = PageFactory.initElements(driver, GymsWebPage.class);
		
		//Going back to the home page of Just Dial Web site
//		driver.navigate().back();
		gymWebPage.navigateBackWebPageGym();

		// delete the cookies in this web site
//		driver.manage().deleteAllCookies();
		gymWebPage.deleteCookies();

		// Refreshing the web page so that the web structure doesn't change
//		driver.navigate().refresh();
		gymWebPage.refreshWebPage();
		
		
	}
	
	@BeforeClass
	public void verifyGymsTitleClass() {
		
		
		
		gymWebPage = PageFactory.initElements(driver, GymsWebPage.class);
		jdHP = PageFactory.initElements(driver, JustDialHomePage.class);
		
		

		// delete the cookies in this web site
//		driver.manage().deleteAllCookies();
		gymWebPage.deleteCookies();

		// Refreshing the web page so that the web structure doesn't change
//		driver.navigate().refresh();
		gymWebPage.refreshWebPage();
		
		
		jdHP.verifyGymsTitle();
		
	}
	
/*	
//	@Test(dependsOnMethods = "navigateToHomePage")
//	public void clickOnGymIcon() {
//		
//		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//		// Clicking on the Gym Icon
////		WebElement gymIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'Gym in ')]")));
//		wait.until(ExpectedConditions.elementToBeClickable(gymWebPage.gymIcon));
//		gymWebPage.gymIconClick();
//		
//		// delete the cookies in this web site
////		driver.manage().deleteAllCookies();
//		gymWebPage.deleteCookies();
//
//		// Refreshing the web page so that the web structure doesn't change
////		driver.navigate().refresh();
//		gymWebPage.refreshWebPage();
//		
//	}*/
	
//	@Test(dependsOnMethods = "verifyGymsTitle")
	@Test
	public void scrollToViewAndLoadElements() throws InterruptedException {
		
		
//		// delete the cookies in this web site
//		driver.manage().deleteAllCookies();
//
//		// Refreshing the web page so that the web structure doesn't change
//		driver.navigate().refresh();
		
		gymWebPage.deleteCookies();
		
		gymWebPage.refreshWebPage();
		
		String actualText = gymWebPage.gymSearchText();
		System.out.println(actualText);
		String expectedText = "Popular Gyms in";
		
		Assert.assertTrue(actualText.contains(expectedText));
		
		gymWebPage.deleteCookies();
		
		gymWebPage.refreshWebPage();
		
//		gymWebPage.deleteCookies();
//		
//		gymWebPage.refreshWebPage();
//		
//		gymWebPage.deleteCookies();
//		
//		gymWebPage.refreshWebPage();
		
		gymWebPage.scrolling();
		
		String gymPageTitle = gymWebPage.getGymWebPageTitle();
		System.out.println(gymPageTitle);
		String expectedPageTitle = "Best Gym in";
		
		Assert.assertTrue(gymPageTitle.contains(expectedPageTitle));
		
	}
	
	
	@Test(dependsOnMethods = "scrollToViewAndLoadElements")
	public void savingDataInCollections() throws IOException {
		
		gymWebPage.printingDataIntoExcel();
		
		//Going back to the home page of Just Dial Web site
//		driver.navigate().back();
		gymWebPage.navigateBackWebPageGym();

		// delete the cookies in this web site
//		driver.manage().deleteAllCookies();
		gymWebPage.deleteCookies();

		// Refreshing the web page so that the web structure doesn't change
//		driver.navigate().refresh();
		gymWebPage.refreshWebPage();
		
		
//		driver.manage().deleteAllCookies();
		gymWebPage.deleteCookies();
		
		
	}
	
	
	
}