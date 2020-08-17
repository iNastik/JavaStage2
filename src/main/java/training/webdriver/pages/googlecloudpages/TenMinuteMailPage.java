package training.webdriver.pages.googlecloudpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import training.webdriver.pages.AbstractPage;
import training.webdriver.utilities.CustomConditions;
import training.webdriver.utilities.Helpers;

import java.util.ArrayList;

public class TenMinuteMailPage extends AbstractPage {
    private static final String TEN_MINUTE_MAIL_PAGE_URL = "https://10minutemail.com";

    @FindBy(xpath = "//*[@id='mail_address']")
    private WebElement emailAddress;

    @FindBy(xpath = "//*[@id='mail_messages_content']" + "//*[contains(text(), 'Google Cloud Platform Price Estimate')]")
    private WebElement emailMessage;

//    @FindBy(xpath = "//*[@id='mobilepadding']//td[2]/h3")
    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    private WebElement totalCost;

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public TenMinuteMailPage openPage() {
        driver.get(TEN_MINUTE_MAIL_PAGE_URL);
        CustomConditions.waitForElementVisibility(emailAddress, driver);
        return this;
    }

    public TenMinuteMailPage copyEmail() {
        emailAddress.sendKeys(Keys.chord(Keys.CONTROL, "c"));
        return this;
    }

    public String getTotalEstimatedMonthlyCostFromReceivedEmail() {
        ArrayList<String> newWindowsSet = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newWindowsSet.get(1));

        Helpers.clickOnTheClickableElement(emailMessage, driver);
        CustomConditions.waitForElementVisibility(totalCost, driver);
        return totalCost.getText();
    }
}
