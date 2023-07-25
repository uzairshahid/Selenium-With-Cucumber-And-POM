package utilities.Drivers;

import com.testvagrant.commons.entities.DeviceDetails;
import com.testvagrant.mdb.android.Android;
import core.utils.ConfigUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<>();
    public static Properties environmentConfig = ConfigUtil.getConfig("environment");
    private static List<DeviceDetails> androidDevices;

    public static void setAppiumDriver(AppiumDriver driver) {
        DriverManager.appiumDriver.set(driver);
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void setAndroidPhysicalDevices() {
        androidDevices = new Android().getDevices();
    }

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static List<DeviceDetails> getAndroidPhysicalDevices() {
        return androidDevices;
    }

    public static void initializeDriver(String browser, String appName) throws Exception {
        WebDriver driver;
        AppiumDriver appiumDriver;
        DesiredCapabilities caps = new DesiredCapabilities();
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                setDriver(driver);
                getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
                getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
                getDriver().get(appName);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                setDriver(driver);
                getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
                getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
                getDriver().get(appName);

                break;
            case "android":
                setAndroidPhysicalDevices();
                caps.setCapability(
                        MobileCapabilityType.PLATFORM_NAME,
                        getAndroidPhysicalDevices().get(0).getPlatform().toString()
                );
                caps.setCapability(MobileCapabilityType.UDID, getAndroidPhysicalDevices().get(0).getUdid());
                caps.setCapability(
                        MobileCapabilityType.PLATFORM_VERSION,
                        getAndroidPhysicalDevices().get(0).getPlatform().toString()
                );
                caps.setCapability(
                        MobileCapabilityType.DEVICE_NAME,
                        getAndroidPhysicalDevices().get(0).getDeviceName()
                );
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability("appium:enforceAppInstall", true);
                caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 0);
                caps.setCapability(MobileCapabilityType.NO_RESET, false);

                switch (appName) {
                    case "seller":
                        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "");
                        caps.setCapability(MobileCapabilityType.APP, environmentConfig.getProperty("androidApp"));
                        System.out.println(
                                "App path from Environment Config: " + environmentConfig.getProperty("androidApp")
                        );
                        break;
                    default:
                        throw new IllegalArgumentException("INVALID APPLICATION TYPE HAS BEEN GIVEN");
                }
                caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
                appiumDriver = new AndroidDriver(url, caps);
                setAppiumDriver(appiumDriver);
                getAppiumDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                break;
            default:
                throw new IllegalStateException("invalid browser provided" + browser);
        }
    }
}
