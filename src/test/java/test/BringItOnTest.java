package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import training.webdriver.pages.pastebinpages.NewPastebinPage;
import training.webdriver.pages.pastebinpages.PastebinHomePage;

import java.util.concurrent.TimeUnit;

public class BringItOnTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteWithSyntaxHighlighting() {
        String name = "how to gain dominance among developers";
        String text = "git config --global user.name  \"New Sheriff in Town\"\n"
                + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
                + "git push origin master --force";
        NewPastebinPage newPage = new PastebinHomePage(driver)
                .openPage()
                .addCode(text)
                .selectSyntaxHighlightingAsBash()
                .selectPasteExpirationAsTenMinutes()
                .addPasteNameOrTitle(name)
                .createNewPaste();
        Assert.assertEquals(newPage.getPasteName(), name);
        Assert.assertTrue(newPage.hasBashButton());
        Assert.assertTrue(newPage.getHighlightedText().contains(text));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
