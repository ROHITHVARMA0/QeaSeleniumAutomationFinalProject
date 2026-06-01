package projectCombinedStepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static projectCombinedStepDefinitions.CommonStepsDriverOrHook.*;

public class JustDialSteps {

    // --- Common Navigation Steps (Conditional Pop-up Handling) ---

    @And("I handle the login prompt and notification pop-ups")
    public void iHandleTheLoginPromptAndNotificationPopUps() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); 
        
        // 1. Handle "Maybe Later" Login Pop-up
        try {
            System.out.println("Attempting to dismiss 'Maybe Later' pop-up...");
            // Uses dynamic locator access
            WebElement loginMaybeLater = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Maybe Later']"))
            );
            loginMaybeLater.click();
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("'Maybe Later' pop-up was not present. Continuing.");
        }
        
        // 2. Handle the "Close Banner/Pop-up"
        try {
            System.out.println("Attempting to dismiss general pop-up...");
            WebElement generalPopup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='Close Banner']")
            ));
            generalPopup.click();
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("General pop-up was not present. Continuing.");
        }

        driver.manage().deleteAllCookies(); 
    }

    // --- Car Washing Services Steps ---

    @When("I search for {string}")
    public void iSearchFor(String searchItem) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(justDialPage.locationSelection)).click();
        justDialPage.detectLocationElement.click();
        Thread.sleep(5000); 
        wait.until(ExpectedConditions.visibilityOf(justDialPage.searchBar)).sendKeys(searchItem + Keys.ENTER);
        driver.manage().deleteAllCookies();
    	driver.navigate().refresh();
    }

    @And("I apply the filter for {string} greater than {string}")
    public void iApplyTheFilterForGreaterThan(String filterType, String rating) {
    	driver.manage().deleteAllCookies();
    	driver.navigate().refresh();
    	
        wait.until(ExpectedConditions.elementToBeClickable(justDialPage.sortingList)).click();
        wait.until(ExpectedConditions.elementToBeClickable(justDialPage.ratingElement)).click();
        
        // Keeping navigation logic here, though it might be excessive
        //driver.navigate().back();
        driver.manage().deleteAllCookies(); 
        driver.navigate().refresh();
        
        wait.until(ExpectedConditions.elementToBeClickable(justDialPage.ratingGreaterThan4)).click();
        wait.until(ExpectedConditions.elementToBeClickable(justDialPage.ratingElement1)).click();
        driver.manage().deleteAllCookies();
    	driver.navigate().refresh();
    }

    @And("I scroll the page to load more results")
    public void iScrollThePageToLoadMoreResults() throws InterruptedException {
//		driver.manage().deleteAllCookies();
//		driver.navigate().refresh();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int scrollLength = 3000;
        for (int i = 0; i < 3; i++) {
            js.executeScript("window.scrollBy(0," + scrollLength + ")");
            Thread.sleep(4000);
            scrollLength = 1000;
        }
    }

    @Then("I should extract and display the top 5 car washing service names and phone numbers")
    public void iShouldExtractAndDisplayTheTopCarWashingServiceNamesAndPhoneNumbers() {
        List<WebElement> storeNameElements = driver.findElements(By.xpath("//div/ul/li/div/div/span[starts-with(text(),'0')]/ancestor::div/div/h2/a/h3"));
        List<WebElement> phoneNumberElements = driver.findElements(By.xpath("//div/ul/li/div/div/span[starts-with(text(),'0')]"));

        List<String> storeNamesText = new ArrayList<>();
        List<String> phoneNumbersText = new ArrayList<>();

        for (WebElement ele : storeNameElements) {
            storeNamesText.add(ele.getText());
        }
        for (WebElement ele : phoneNumberElements) {
            phoneNumbersText.add(ele.getText());
        }
            
        System.out.println("\n--- Top 5 Car Washing Services (Rating 4.0+) ---");
        System.out.printf("%-4s %-40s %s\n", "No.", "Service Name", "Phone Number");
        System.out.println("-----------------------------------------------------------------");

        int count = Math.min(5, storeNamesText.size());
        for (int i = 0; i < count; i++) {
            System.out.printf("%-4d %-40s %s\n", (i + 1), storeNamesText.get(i), phoneNumbersText.get(i));
        }
        System.out.println("-----------------------------------------------------------------");
    }

    // --- Free Listing Error Message Steps ---

    @And("I click on the {string} link")
    public void iClickOnTheLink(String link) {
            wait.until(ExpectedConditions.elementToBeClickable(justDialPage.freeListingElement)).click();
            driver.manage().deleteAllCookies(); 
            driver.navigate().refresh();
        
    }

    @When("I enter an invalid phone number {string} and click Start Now")
    public void iEnterAnInvalidPhoneNumberAndClickStartNow(String invalidNumber) {
        wait.until(ExpectedConditions.visibilityOf(justDialPage.phoneNumberInput)).sendKeys(invalidNumber);
        justDialPage.startNowButton.click();
    }

    @Then("I should capture and print the validation error message")
    public void iShouldCaptureAndPrintTheValidationErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(justDialPage.errorMessage));
        String errorMessage = justDialPage.errorMessage.getText();
        System.out.println("\n--- Free Listing Error Message ---");
        System.out.println("The Error Message while giving Invalid Input for Free Listing is: " + errorMessage);
        System.out.println("------------------------------------");
        driver.manage().deleteAllCookies();
    }
        
    @And("I take a screenshot of the error message")
    public void iTakeAScreenshotOfTheErrorMessage() {
        TakesScreenshot screenShot = (TakesScreenshot) driver;
        File screenShotFile = screenShot.getScreenshotAs(OutputType.FILE);
        File targetFile = new File(System.getProperty("user.dir") + "/projectCombinedOutputs/screenshot_Error.png");
        screenShotFile.renameTo(targetFile);
        System.out.println("Screenshot saved to: " + targetFile.getAbsolutePath());
    }

    // --- Gym Sub-Menu/Listing Extraction Steps ---

    @When("I click on the {string} icon")
    public void iClickOnTheIcon(String iconName) {
    	
    	driver.manage().deleteAllCookies();
    	driver.navigate().refresh();
            
    	wait.until(ExpectedConditions.elementToBeClickable(justDialPage.gymIcon)).click();
        driver.manage().deleteAllCookies(); 
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @And("I scroll the page to load all gym listings")
    public void iScrollThePageToLoadAllGymListings() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int scrollLength = 3000;
        for (int i = 0; i < 6; i++) {
            js.executeScript("window.scrollBy(0," + scrollLength + ")");
            Thread.sleep(4000);
            scrollLength = 1000;
        }
    }

    @Then("I should extract and display all visible gym names and phone numbers")
    public void iShouldExtractAndDisplayAllVisibleGymNamesAndPhoneNumbers() {
        List<WebElement> gymNameElements = driver.findElements(By.xpath("//div/ul/li/div/div/span[contains(text(),'0')]/ancestor::div/div/h2/a/h3"));
        List<WebElement> gymPhoneNumberElements = driver.findElements(By.xpath("//div/ul/li/div/div/span[contains(text(),'0')]"));

        List<String> gymNamesText = new ArrayList<>();
        List<String> gymPhoneNumbersText = new ArrayList<>();

        for (WebElement ele : gymNameElements) {
            gymNamesText.add(ele.getText());
        }
        for (WebElement ele : gymPhoneNumberElements) {
            gymPhoneNumbersText.add(ele.getText());
        }

        System.out.println("\n--- Extracted Gym Listings ---");
        System.out.printf("%-4s %-40s %s\n", "No.", "Gym Name", "Phone Number");
        System.out.println("-----------------------------------------------------------------");

        for (int i = 0; i < gymNamesText.size(); i++) {
            System.out.printf("%-4d %-40s %s\n", (i + 1), gymNamesText.get(i), gymPhoneNumbersText.get(i));
        }
        System.out.println("Total Gyms Found (with Phone #): " + gymNamesText.size());
        System.out.println("-----------------------------------------------------------------");
    }
        
    /**
     * FIX: Use driver.get(baseURL) instead of driver.navigate().back()
     */
    @And("I should navigate back to the homepage")
    public void iShouldNavigateBackToTheHomepage() {
        // Navigates directly to the base URL for a clean state
        driver.get(baseURL); 
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}