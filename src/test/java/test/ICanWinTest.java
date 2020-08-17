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

public class ICanWinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteHelloweb() {
        String name = "helloweb";
        String text = "Hello from WebDriver";
        NewPastebinPage newPage = new PastebinHomePage(driver)
                .openPage()
                .addCode(text)
                .selectPasteExpirationAsTenMinutes()
                .addPasteNameOrTitle(name)
                .createNewPaste();
        Assert.assertEquals(newPage.getPasteName(), name);
        Assert.assertEquals(newPage.getPasteText(), text);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}

