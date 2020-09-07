package webdriver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.pages.googlecloudpages.EstimatedPage;
import webdriver.pages.googlecloudpages.GoogleCloudHomePage;

public class HurtMePlentyTest {
    private WebDriver driver;
    private EstimatedPage estimatedPage;

    private final String EXPECTED_VIRTUAL_MACHINE_CLASS = "Regular";
    private final String EXPECTED_INSTANCE_TYPE = "n1-standard-8";
    private final String EXPECTED_REGION = "Frankfurt";
    private final String EXPECTED_LOCAL_SSD = "2x375";
    private final String EXPECTED_COMMITMENT_TERM = "1 Year";
    private final String EXPECTED_ESTIMATED_COST = "USD 1,082.77";

    @BeforeTest
    public void setupBrowser () throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        estimatedPage = new GoogleCloudHomePage(driver)
                .openPage()
                .searchForGoogleCloudPlatformPricingCalculator()
                .switchToCalculator()
                .setParameters()
                .addToEstimate();
        Thread.sleep(5000);
    }

    @Test
    public void checkIfCurrentVirtualMachineClassMatchesExpectedResult() {
        Assert.assertTrue(estimatedPage.getEstimatedVirtualMachineClass().contains(EXPECTED_VIRTUAL_MACHINE_CLASS.toLowerCase()));
    }

    @Test
    public void checkIfCurrentInstanceTypeMatchesExpectedResult() {
        Assert.assertTrue(estimatedPage.getEstimatedInstanceType().contains(EXPECTED_INSTANCE_TYPE.toLowerCase()));
    }

    @Test
    public void checkIfCurrentRegionMatchesExpectedResult() {
        Assert.assertTrue(estimatedPage.getEstimatedRegion().contains(EXPECTED_REGION.toLowerCase()));
    }

    @Test
    public void checkIfCurrentLocalSsdMatchesExpectedResult() {
        Assert.assertTrue(estimatedPage.getEstimatedLocalSsd().contains(EXPECTED_LOCAL_SSD.toLowerCase()));
    }

    @Test
    public void checkIfCurrentCommitmentTermMatchesExpectedResult() {
        Assert.assertTrue(estimatedPage.getEstimatedCommitmentTerm().contains(EXPECTED_COMMITMENT_TERM.toLowerCase()));
    }

    @Test
    public void checkIfCurrentEstimatedCostMatchesExpectedResult() {
        Assert.assertTrue(estimatedPage.getTotalEstimatedCost().contains(EXPECTED_ESTIMATED_COST.toLowerCase()));
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
