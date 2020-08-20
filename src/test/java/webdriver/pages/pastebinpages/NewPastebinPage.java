package webdriver.pages.pastebinpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.pages.AbstractPage;

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
        PageFactory.initElements(this.driver, this);
    }

    public String getPasteName() {
        return pasteName.getText();
    }

    public String getPasteText() {
        return pasteTextArea.getText();
    }

    public String getHighlightedText() {
        return highlightedCode.getText();
    }

    public boolean hasBashButton() {
        return bashButton.isDisplayed();
    }
}

