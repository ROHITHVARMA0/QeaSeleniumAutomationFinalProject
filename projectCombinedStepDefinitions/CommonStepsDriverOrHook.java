package projectCombinedStepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CommonStepsDriverOrHook {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JustDialWebPageWebElements justDialPage;
    public final static String baseURL = "https://www.justdial.com/";
    
    public static ChromeOptions blockNotifications() {
        ChromeOptions options = new ChromeOptions();
        return options.addArguments("--disable-notifications");
    }

    @BeforeAll
    public static void setup() {
        System.out.println("--- Starting Cucumber Test Run Setup ---");
        driver = new ChromeDriver(blockNotifications());
        
        driver.get(baseURL); 
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        justDialPage = new JustDialWebPageWebElements(driver); 
    }

    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
        System.out.println("--- Ending Cucumber Test Run Teardown ---");
    }

    // --------------------------------------------------------------------------------------------------
    // NAVIGATION STEPS
    // --------------------------------------------------------------------------------------------------

    @Given("I navigate to the JustDial homepage")
    public void iNavigateToTheJustDialHomepage() {
        driver.get(baseURL);
    }
    
    /**
     * FIX: Use driver.get(baseURL) instead of driver.navigate().back()
     */
    @Given("I navigate back to the JustDial homepage")
    public void iNavigateBackToTheJustDialHomepage() throws InterruptedException {
        // Navigates directly to the base URL for a clean state
        driver.get(baseURL); 
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        Thread.sleep(2000); 
    }
}