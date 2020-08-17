package training.webdriver.pages.googlecloudpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import training.webdriver.pages.AbstractPage;
import training.webdriver.utilities.CustomConditions;
import training.webdriver.utilities.Helpers;

import java.util.ArrayList;

public class EmailForm extends AbstractPage {
    @FindBy(xpath = "//*[@id='input_419']")
    private WebElement emailInput;

//    @FindBy(xpath = "//*[@id='dialogContent_425']")
    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement firstFrame;

    @FindBy(xpath = "//*[@id='myFrame']")
    private WebElement secondFrame;

    public EmailForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public EmailForm sendEmail() {
        copyGeneratedEmailFromTenMinuteMailPage();
        CustomConditions.waitForElementVisibility(emailInput, driver);
        emailInput.sendKeys(Keys.chord(Keys.CONTROL, "v") + Keys.ENTER);
        Helpers.clickOnTheVisibleElement(sendEmailButton, driver);
        return this;
    }

    private void copyGeneratedEmailFromTenMinuteMailPage() {
        ((JavascriptExecutor) driver).executeScript("window.open()");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        new TenMinuteMailPage(driver).openPage().copyEmail();

        driver.switchTo().window(tabs.get(0));
        CustomConditions.switchToInnerFrame(firstFrame, secondFrame, driver);
    }
}
