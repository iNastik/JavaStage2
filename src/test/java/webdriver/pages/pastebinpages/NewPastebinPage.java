package webdriver.pages.pastebinpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.pages.AbstractPage;
import webdriver.utilities.CustomConditions;

public class NewPastebinPage extends AbstractPage {

    @FindBy(xpath = "//h1")
    private WebElement pasteName;

    @FindBy(xpath = "//textarea")
    private WebElement pasteTextArea;

    @FindBy(xpath = "//div[@class='highlighted-code']")
    private WebElement highlightedCode;

    @FindBy(xpath = "//div[@class='expire' and contains (text(),'10 min')]")
    private WebElement autoDeleteTime;

    @FindBy(xpath = "//a[text() = 'Bash']")
    private WebElement bashButton;

    public NewPastebinPage(WebDriver driver) {
        super(driver);
    }

    public String getPasteName() {
        CustomConditions.waitForElementVisibility(pasteName, driver);
        return pasteName.getText();
    }

    public String getHighlightedText() {
        CustomConditions.waitForElementVisibility(highlightedCode, driver);
        return highlightedCode.getText();
    }

    public boolean hasBashButton() {
        CustomConditions.waitForElementVisibility(bashButton, driver);
        return bashButton.isDisplayed();
    }
}

