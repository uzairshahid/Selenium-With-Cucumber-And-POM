package VerticalCommons;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Drivers.DriverManager;

import java.io.File;
import java.io.IOException;

public class WebHooks {
    @After
    public void afterScenario(Scenario scenarioUnderTest) throws IOException {
        if (DriverManager.getAppiumDriver() != null) {
            if (scenarioUnderTest.isFailed()) {
                System.out.println("In @After Appium Android screenshot ... ");
                File failureScreenShot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
                Allure.addAttachment("Failure Screen", FileUtils.openInputStream(failureScreenShot));
            }
            DriverManager.getAppiumDriver().quit();
        } else if (DriverManager.getDriver() != null) {
            if (scenarioUnderTest.isFailed()) {
                System.out.println("In @After Selenium screenshot ... ");
                File failureScreenShot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
                Allure.addAttachment("Failure Screen", FileUtils.openInputStream(failureScreenShot));
            }
            DriverManager.getDriver().quit();
        }
    }
}
