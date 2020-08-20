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
    private EmailForm emailForm;

    private final String EXPECTED_ESTIMATED_COST = "USD 1,082.77";

    @BeforeTest
    public void setupBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        emailForm = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForGoogleCloudPlatformPricingCalculator()
                .switchToCalculator()
                .setParameters()
                .addToEstimate()
                .clickEmailEstimateButton()
                .sendEmail();
        Thread.sleep(5000);
    }

    @Test
    public void checkIfTheCurrentEstimatedCostMatchesTheCostFromEmail() throws InterruptedException {
        String totalCostFromReceivedEmail = new TenMinuteMailPage(driver)
                .getTotalEstimatedMonthlyCostFromReceivedEmail();
        Assert.assertEquals(EXPECTED_ESTIMATED_COST, totalCostFromReceivedEmail);
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
