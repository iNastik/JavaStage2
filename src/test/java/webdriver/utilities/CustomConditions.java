package webdriver.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomConditions {
    public static void switchToInnerFrame(WebElement firstFrame, WebElement secondFrame, WebDriver driver) {
        switchToAvailableFrame(firstFrame, driver);
        switchToAvailableFrame(secondFrame, driver);
    }

    private static void switchToAvailableFrame(WebElement frame, WebDriver driver) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

    public static void waitForElementVisibility(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));
    }
}
