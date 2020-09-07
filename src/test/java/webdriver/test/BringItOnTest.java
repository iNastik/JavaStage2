package webdriver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.pages.pastebinpages.NewPastebinPage;
import webdriver.pages.pastebinpages.PastebinHomePage;

public class BringItOnTest {
    private WebDriver driver;
    private NewPastebinPage newPage;
    private final String pasteName = "how to gain dominance among developers";
    private final String code = "git config --global user.name  \"New Sheriff in Town\"\n"
            + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
            + "git push origin master --force";

    @BeforeTest
    public void setupBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        newPage = new PastebinHomePage(driver)
                .openPage()
                .addCode(code)
                .selectSyntaxHighlightingAsBash()
                .selectPasteExpirationAsTenMinutes()
                .addPasteNameOrTitle(pasteName)
                .createNewPaste();
        Thread.sleep(5000);
    }

    @Test
    public void checkIfReceivedTitleMatchesPasteName() {
        Assert.assertEquals(newPage.getPasteName(), pasteName);
    }

    @Test
    public void checkIfSyntaxIsHighlighted() {
        Assert.assertTrue(newPage.hasBashButton());
    }

    @Test
    public void checkIfReceivedTextMatchesCode() {
        Assert.assertTrue(newPage.getHighlightedText().contains(code));
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
