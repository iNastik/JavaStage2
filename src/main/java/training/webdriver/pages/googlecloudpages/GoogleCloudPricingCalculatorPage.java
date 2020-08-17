package training.webdriver.pages.googlecloudpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import training.webdriver.pages.AbstractPage;
import training.webdriver.utilities.CustomConditions;
import training.webdriver.utilities.Helpers;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private final String NUMBER_OF_INSTANCES = "4";

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement firstFrame;

    @FindBy(xpath = "//*[@id='myFrame']")
    private WebElement secondFrame;

    @FindBy(xpath = "//md-tab-item//div[text()='Compute Engine']")
    private WebElement computeEngineIcon;

    @FindBy(id = "input_61")
    private WebElement numberOfInstancesInput;

    @FindBy(id = "input_62")
    private WebElement whatAreTheseInstancesForField;

    @FindBy(id = "select_value_label_54")
    private WebElement operatingSystemField;

    @FindBy(id = "select_option_63")
    private WebElement freeOperatingSystemOrSoftwareOption;

    @FindBy(id = "select_value_label_55")
    private WebElement machineClassField;

    @FindBy(id = "select_option_75")
    private WebElement machineClassRegularOption;

    @FindBy(id = "select_value_label_58")
    private WebElement machineTypeField;

    @FindBy(id = "select_option_228")
    private WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGpusCheckbox;

    @FindBy(xpath = "//*[@id='select_value_label_350']")
    private WebElement numberOfGpusField;

    @FindBy(xpath = "//*[@id='select_option_357']")
    private WebElement numberOfGpusSingleGpuOption;

    @FindBy(xpath = "//*[@id='select_354']")
    private WebElement gpuTypeField;

    @FindBy(xpath = "//*[@id='select_option_364']")
    private WebElement requiredGpuType;

    @FindBy(id = "select_value_label_184")
    private WebElement localSsdField;

    @FindBy(id = "select_option_249")
    private WebElement requiredLocalSsd;

    @FindBy(id = "select_value_label_59")
    private WebElement datacenterLocationField;

    @FindBy(xpath = "//*[@id='select_option_196']")
    private WebElement requiredDatacenterLocation;

    @FindBy(id = "select_value_label_60")
    private WebElement committedUsageField;

    @FindBy(xpath = "//*[@id='select_option_93']/div[1]")
    private WebElement committedUsageOneYearOption;

    @FindBy(xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[15]/button")
    private WebElement addToEstimateButton;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudPricingCalculatorPage setParameters() throws InterruptedException {
        CustomConditions.switchToInnerFrame(firstFrame, secondFrame, driver);
        activateTheComputeEngineSection();
        addNumberOfInstances(NUMBER_OF_INSTANCES);
        setInstancesAssignment();
        selectFreeOperatingSystem();
        selectRegularVmClass();
        selectMachineType();
        clickToAddGpusCheckbox();
        addGpus();
        selectLocalSsd();
        selectDatacenterLocation();
        selectCommittedUsage();
        return this;
    }

    public GoogleCloudPricingCalculatorPage activateTheComputeEngineSection() {
        Helpers.clickOnTheVisibleElement(computeEngineIcon, driver);
        return this;
    }

    public GoogleCloudPricingCalculatorPage addNumberOfInstances(String numberOfInstances) {
        numberOfInstancesInput.click();
        numberOfInstancesInput.sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudPricingCalculatorPage setInstancesAssignment() {
        whatAreTheseInstancesForField.clear();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectFreeOperatingSystem() {
        Helpers.selectFromTheDropdownList(operatingSystemField, freeOperatingSystemOrSoftwareOption, driver);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectRegularVmClass() {
        Helpers.selectFromTheDropdownList(machineClassField, machineClassRegularOption, driver);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineType() {
        Helpers.selectFromTheDropdownList(machineTypeField, machineTypeOption, driver);
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickToAddGpusCheckbox() {
        Helpers.clickOnTheVisibleElement(addGpusCheckbox, driver);
        return this;
    }

    public GoogleCloudPricingCalculatorPage addGpus() throws InterruptedException {
        Helpers.selectFromTheDropdownList(numberOfGpusField, numberOfGpusSingleGpuOption, driver);
        Helpers.selectFromTheDropdownList(gpuTypeField, requiredGpuType, driver);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSsd() {
        Helpers.selectFromTheDropdownList(localSsdField, requiredLocalSsd, driver);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDatacenterLocation() {
        Helpers.selectFromTheDropdownList(datacenterLocationField, requiredDatacenterLocation, driver);
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommittedUsage() {
        Helpers.selectFromTheDropdownList(committedUsageField, committedUsageOneYearOption, driver);
        return this;
    }

    public EstimatedPage addToEstimate() {
        addToEstimateButton.click();
        return new EstimatedPage(driver);
    }
}
