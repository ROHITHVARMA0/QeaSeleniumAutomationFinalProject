package projectCombinedStepDefinitions;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JustDialWebPageWebElements {
    public JustDialWebPageWebElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Common Elements
    @FindBy(xpath = "//a[text()='Maybe Later']")
    public WebElement loginMayBeLater;

    @FindBy(xpath = "//span[@aria-label='Close Banner']")
    public WebElement popUp;

    @FindBy(xpath = "//input[@aria-label='Select Location']")
    public WebElement locationSelection;

    @FindBy(xpath = "//div[contains(text(),'Detect L')]")
    public WebElement detectLocationElement;

    @FindBy(id = "main-auto")
    public WebElement searchBar;

    @FindBy(xpath = "//div/a[text()='Free Listing']")
    public WebElement freeListingElement;

    @FindBy(xpath = "//a[contains(@title,'Gym in ')]")
    public WebElement gymIcon;
    
    // Car Wash Specific Elements
    @FindBy(xpath = "//span[text()='Sort by']/parent::button")
    public WebElement sortingList;

    @FindBy(xpath = "//span[text()='Rating']")
    public WebElement ratingElement;

    @FindBy(xpath = "//span[text()='Ratings']/parent::button")
    public WebElement ratingGreaterThan4;

    @FindBy(xpath = "//span[text()='4.0+']")
    public WebElement ratingElement1;

    // Free Listing Specific Elements
    @FindBy(id = "1")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//*[@id=\"listyourbusiness\"]/div[1]/form/button")
    public WebElement startNowButton;

    @FindBy(xpath = "//span[@class='undefined entermobilenumber_error__text__uPM09']")
    public WebElement errorMessage;
}