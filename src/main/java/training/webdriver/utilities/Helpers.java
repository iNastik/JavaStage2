package training.webdriver.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helpers {
    public static void clickOnTheVisibleElement(WebElement element, WebDriver driver) {
        CustomConditions.waitForElementVisibility(element, driver);
        element.click();
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void clickOnTheClickableElement(WebElement element, WebDriver driver) {
        CustomConditions.waitForElementToBeClickable(element, driver);
        element.click();
    }

    public static void selectFromTheDropdownList(WebElement dropdownList, WebElement requiredOption, WebDriver driver) {
//        dropdownList.click();
        clickOnTheVisibleElement(dropdownList, driver);
        clickOnTheClickableElement(requiredOption, driver);
    }
}
