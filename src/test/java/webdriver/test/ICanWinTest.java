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
    private final String PASTE_NAME = "helloweb";
    private final String CODE = "Hello from WebDriver";

    @BeforeTest
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createNewPasteHelloweb() {
        NewPastebinPage newPage = new PastebinHomePage(driver)
                .openPage()
                .addCode(CODE)
                .selectPasteExpirationAsTenMinutes()
                .addPasteNameOrTitle(PASTE_NAME)
                .createNewPaste();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}

