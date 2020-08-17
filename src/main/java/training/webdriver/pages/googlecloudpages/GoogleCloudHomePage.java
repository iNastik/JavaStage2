package training.webdriver.pages.googlecloudpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import training.webdriver.pages.AbstractPage;
import training.webdriver.utilities.CustomConditions;

public class GoogleCloudHomePage extends AbstractPage {
    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com/";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchInput;

    @FindBy(xpath = "//b[contains(text(),'Google Cloud Platform Pricing Calculator')]")
    private WebElement searchResult;

    @FindBy(xpath = "//*[@id='input_60']")
    private WebElement numberOfInstancesField;


    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(GOOGLE_CLOUD_URL);
        CustomConditions.waitForElementVisibility(searchInput, driver);
        return this;
    }

    public GoogleCloudSearchPage searchForGoogleCloudPlatformPricingCalculator() {
        searchInput.click();
        searchInput.sendKeys(SEARCH_QUERY + Keys.ENTER);
        return new GoogleCloudSearchPage(driver);
    }
}
