package webdriver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.pages.googlecloudpages.EmailForm;
import webdriver.pages.googlecloudpages.GoogleCloudHomePage;
import webdriver.pages.googlecloudpages.TenMinuteMailPage;

import java.util.concurrent.TimeUnit;

public class HardcoreTest {
    private WebDriver driver;

    private final String EXPECTED_ESTIMATED_COST = "USD 1,082.77";

    @BeforeTest
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void checkIfTheCurrentEstimatedCostMatchesTheCostFromEmail() {
        EmailForm emailForm = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForGoogleCloudPlatformPricingCalculator()
                .switchToCalculator()
                .setParameters()
                .addToEstimate()
                .clickEmailEstimateButton()
                .sendEmail();

        String totalCostFromReceivedEmail = new TenMinuteMailPage(driver)
                .getTotalEstimatedMonthlyCostFromReceivedEmail();
        Assert.assertEquals(EXPECTED_ESTIMATED_COST, totalCostFromReceivedEmail);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
