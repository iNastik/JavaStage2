package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import training.webdriver.pages.googlecloudpages.EmailForm;
import training.webdriver.pages.googlecloudpages.GoogleCloudHomePage;
import training.webdriver.pages.googlecloudpages.TenMinuteMailPage;

import java.util.concurrent.TimeUnit;

public class HardcoreTest {
    private WebDriver driver;
    private EmailForm emailForm;

    private final String EXPECTED_ESTIMATED_COST = "USD 1,082.77";

    @BeforeSuite
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void checkTotalCostAndData() throws InterruptedException {
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
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(200);
        driver.close();
        driver.quit();
        driver = null;
    }
}
