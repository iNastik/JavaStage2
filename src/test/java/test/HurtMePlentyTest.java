package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import training.webdriver.pages.googlecloudpages.EstimatedPage;
import training.webdriver.pages.googlecloudpages.GoogleCloudHomePage;

import java.util.concurrent.TimeUnit;

public class HurtMePlentyTest {
    private WebDriver driver;
    private EstimatedPage estimatedPage;

    private final String EXPECTED_VIRTUAL_MACHINE_CLASS = "Regular";
    private final String EXPECTED_INSTANCE_TYPE = "n1-standard-8";
    private final String EXPECTED_REGION = "Frankfurt";
    private final String EXPECTED_LOCAL_SSD = "2x375";
    private final String EXPECTED_COMMITMENT_TERM = "1 Year";
    private final String EXPECTED_ESTIMATED_COST = "USD 1,082.77";

    @BeforeSuite
    public void setupBrowser () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeTest
    public void createGoogleCloudCalculatorPage() throws InterruptedException {
        estimatedPage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForGoogleCloudPlatformPricingCalculator()
                .switchToCalculator()
                .setParameters()
                .addToEstimate();
    }

    @Test
    public void checkIfTheCurrentVirtualMachineClassMatchesTheExpectedResult() {
        Assert.assertTrue(estimatedPage.getEstimatedVirtualMachineClass().contains(EXPECTED_VIRTUAL_MACHINE_CLASS.toLowerCase()));
    }

    @Test
    public void checkIfTheCurrentInstanceTypeMatchesTheExpectedResult() {
        Assert.assertTrue(estimatedPage.getEstimatedInstanceType().contains(EXPECTED_INSTANCE_TYPE.toLowerCase()));
    }

    @Test
    public void checkIfTheCurrentRegionMatchesTheExpectedResult() {
        Assert.assertTrue(estimatedPage.getEstimatedRegion().contains(EXPECTED_REGION.toLowerCase()));
    }

    @Test
    public void checkIfTheCurrentLocalSsdMatchesTheExpectedResult() {
        Assert.assertTrue(estimatedPage.getEstimatedLocalSsd().contains(EXPECTED_LOCAL_SSD.toLowerCase()));
    }

    @Test
    public void checkIfTheCurrentCommitmentTermMatchesTheExpectedResult() {
        Assert.assertTrue(estimatedPage.getEstimatedCommitmentTerm().contains(EXPECTED_COMMITMENT_TERM.toLowerCase()));
    }

    @Test
    public void checkIfTheCurrentEstimatedCostMatchesTheExpectedResult() {
        Assert.assertTrue(estimatedPage.getTotalEstimatedCost().contains(EXPECTED_ESTIMATED_COST.toLowerCase()));
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(200);
        driver.close();
        driver.quit();
        driver = null;
    }
}
