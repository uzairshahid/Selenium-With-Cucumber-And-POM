package core.utils.SeleniumHook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import com.paulhammant.ngwebdriver.ByAngular;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Drivers.DriverManager;

public class SeleniumUtil {
    private static FluentWait<WebDriver> fluentWaitForNoSuchElementException;
    private static WebDriverWait wait5Sec = null;

    private static void waitForCondition(ExpectedCondition condition, int timeOut) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeOut));
        wait.until(condition);
    }

    public static WebElement waitForElementTobeClickable(WebElement element) {
        waitForCondition(ExpectedConditions.elementToBeClickable(element), 5);
        return element;
    }

    public static void waitForTextToBeNotPresent(WebElement element, String text) {
        waitForCondition(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)), 5);
    }

    public static WebElement waitForTextToBePresent(WebElement element, String text) {
        waitForCondition(ExpectedConditions.textToBePresentInElement(element, text), 5);
        return element;
    }

    public static void clickElementIfVisible(String element) {
        try {
            SeleniumUtil
                    .waitForElement5Secs()
                    .until(ExpectedConditions.presenceOfElementLocated(ByAngular.BaseBy.cssSelector(element)))
                    .click();
        } catch (Exception ex) {
            System.out.println("Element " + element + " NOT displayed!\nException Caught: " + ex);
        }
    }

    public static WebElement waitForElementToBeVisibleByID(String elementID) {
        waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.id(elementID)), 5);
        return DriverManager.getDriver().findElement(By.id(elementID));
    }

    public static WebDriverWait waitForElement5Secs() {
        if (wait5Sec == null) {
            return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        } else {
            return wait5Sec;
        }
    }
}
