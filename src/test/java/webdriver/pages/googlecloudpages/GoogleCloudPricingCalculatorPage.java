package webdriver.pages.googlecloudpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.pages.AbstractPage;
import webdriver.utilities.CustomConditions;
import webdriver.utilities.Helpers;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private final String NUMBER_OF_INSTANCES = "4";

    @FindBy(xpath = "//*[@id='cloud-site']//iframe")
    private WebElement firstFrame;

    @FindBy(xpath = "//*[@id='myFrame']")
    private WebElement secondFrame;

    @FindBy(xpath = "//md-tab-item//div[text()='Compute Engine']")
    private WebElement computeEngineIcon;

    @FindBy(id = "input_60")
    private WebElement numberOfInstancesInput;

    @FindBy(id = "input_61")
    private WebElement instanceAssignmentField;

    @FindBy(id = "select_value_label_53")
    private WebElement operatingSystemField;

    @FindBy(id = "select_option_62")
    private WebElement freeOperatingSystemOrSoftwareOption;

    @FindBy(id = "select_value_label_54")
    private WebElement machineClassField;

    @FindBy(id = "select_option_75")
    private WebElement machineClassRegularOption;

    @FindBy(id = "select_value_label_57")
    private WebElement machineTypeField;

    @FindBy(id = "select_option_236")
    private WebElement machineTypeOption;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGpusCheckbox;

    @FindBy(id = "select_value_label_370")
    private WebElement numberOfGpusField;

    @FindBy(id = "select_option_377")
    private WebElement numberOfGpusSingleGpuOption;

    @FindBy(id = "select_value_label_371")
    private WebElement gpuTypeField;

    @FindBy(id = "select_option_384")
    private WebElement requiredGpuType;

    @FindBy(id = "select_value_label_192")
    private WebElement localSsdField;

    @FindBy(id = "select_option_257")
    private WebElement requiredLocalSsd;

    @FindBy(id = "select_value_label_58")
    private WebElement datacenterLocationField;

    @FindBy(id = "select_option_204")
    private WebElement requiredDatacenterLocation;

    @FindBy(id = "select_value_label_59")
    private WebElement committedUsageField;

    @FindBy(id = "select_option_93")
    private WebElement committedUsageOneYearOption;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage setParameters() {
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
        instanceAssignmentField.clear();
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

    public GoogleCloudPricingCalculatorPage addGpus() {
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
        Helpers.clickOnTheClickableElement(addToEstimateButton, driver);
        return new EstimatedPage(driver);
    }
}
