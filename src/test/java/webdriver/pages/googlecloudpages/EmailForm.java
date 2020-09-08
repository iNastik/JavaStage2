package webdriver.pages.googlecloudpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.pages.AbstractPage;
import webdriver.utilities.CustomConditions;
import webdriver.utilities.Helpers;

import java.util.ArrayList;

public class EmailForm extends AbstractPage {
    @FindBy(id = "input_439")
    private WebElement emailInput;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    @FindBy(xpath = "//*[@id='cloud-site']//iframe")
    private WebElement firstFrame;

    @FindBy(xpath = "//*[@id='myFrame']")
    private WebElement secondFrame;

    public EmailForm(WebDriver driver) {
        super(driver);
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
