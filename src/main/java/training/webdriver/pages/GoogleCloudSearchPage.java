package training.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import training.webdriver.pages.AbstractPage;
import training.webdriver.pages.GoogleCloudPricingCalculatorPage;

public class GoogleCloudSearchPage extends AbstractPage {

    @FindBy(xpath = "//b[contains(text(),'Google Cloud Platform Pricing Calculator')]")
    private WebElement searchResult;

    public GoogleCloudSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudPricingCalculatorPage switchToCalculator() {
        searchResult.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
