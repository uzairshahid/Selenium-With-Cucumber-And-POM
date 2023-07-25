package VerticalCommons;

import core.utils.SeleniumHook.SeleniumRunner;
import io.cucumber.java.en.Given;
import utilities.JSONReader;

import java.io.IOException;

public class CommonSteps {
    private static final String testEnvironmentFilePath = "src/test/resources/TestData/Environment.json";

    @Given("Setting Web Selenium connection for {string}")
    public static void settingWebSeleniumConnectionFor(String envURL) throws IOException {
        SeleniumRunner.startSeleniumServer(JSONReader.jsonEnvNodeReader(testEnvironmentFilePath, System.getProperty("env"), envURL));
    }
}
