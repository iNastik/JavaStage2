package training.webdriver.pages.googlecloudpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import training.webdriver.pages.AbstractPage;
import training.webdriver.utilities.CustomConditions;

public class EstimatedPage extends AbstractPage {
    @FindBy(xpath = "//div[contains(text(),'VM class:')]")
    private WebElement virtualMachineClass;

    @FindBy(xpath = "//div[contains(text(),'Instance type:')]")
    private WebElement instanceType;

    @FindBy(xpath = "//div[contains(text(),'Region')]")
    private WebElement region;

    @FindBy(xpath = "//div[contains(text(),'local SSD')]")
    private WebElement localSsd;

    @FindBy(xpath = "//div[contains(text(),'Commitment term')]")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost')]")
    private WebElement totalEstimatedCost;

    //    @FindBy(xpath = "//button[contains(text(),'Email Estimate')]")
    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailEstimateButton;

    public EstimatedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getEstimatedVirtualMachineClass() {
        CustomConditions.waitForElementVisibility(virtualMachineClass, driver);
        return virtualMachineClass.getText().toLowerCase();
    }

    public String getEstimatedInstanceType() {
        CustomConditions.waitForElementVisibility(instanceType, driver);
        return instanceType.getText().toLowerCase();
    }

    public String getEstimatedRegion() {
        CustomConditions.waitForElementVisibility(region, driver);
        return region.getText().toLowerCase();
    }

    public String getEstimatedLocalSsd() {
        CustomConditions.waitForElementVisibility(localSsd, driver);
        return localSsd.getText().toLowerCase();
    }

    public String getEstimatedCommitmentTerm() {
        CustomConditions.waitForElementVisibility(commitmentTerm, driver);
        return commitmentTerm.getText().toLowerCase();
    }

    public String getTotalEstimatedCost() {
        CustomConditions.waitForElementVisibility(totalEstimatedCost, driver);
        return totalEstimatedCost.getText().toLowerCase();
    }

    public EmailForm clickEmailEstimateButton() {
        CustomConditions.waitForElementVisibility(emailEstimateButton, driver);
        emailEstimateButton.click();
        return new EmailForm(driver);
    }
}
