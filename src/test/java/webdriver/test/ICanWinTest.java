package webdriver.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webdriver.pages.pastebinpages.NewPastebinPage;
import webdriver.pages.pastebinpages.PastebinHomePage;

public class ICanWinTest {
    private WebDriver driver;
    private final String pasteName = "helloweb";
    private final String code = "Hello from WebDriver";

    @BeforeTest
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteHelloweb() throws InterruptedException {
        NewPastebinPage newPage = new PastebinHomePage(driver)
                .openPage()
                .addCode(code)
                .selectPasteExpirationAsTenMinutes()
                .addPasteNameOrTitle(pasteName)
                .createNewPaste();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}

