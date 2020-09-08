package webdriver.pages.googlecloudpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.pages.AbstractPage;
import webdriver.utilities.Helpers;

public class GoogleCloudSearchPage extends AbstractPage {

    @FindBy(xpath = "//b[contains(text(),'Google Cloud Platform Pricing Calculator')]")
    private WebElement searchResult;

    public GoogleCloudSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage switchToCalculator() {
        Helpers.clickOnTheClickableElement(searchResult, driver);
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
