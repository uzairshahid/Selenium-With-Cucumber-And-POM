package pages.BaseScreen;

import core.utils.SeleniumHook.SeleniumRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageLogin {
    private String EMAIL_ADDRESS_TEXTBOX_ID = "user-name";
    private String PASSWORD_TEXTBOX_ID = "password";
    private String LOGIN_BUTTON_ID = "login-button";
    private String SIDE_MENU_BUTTON_ID = "react-burger-menu-btn";
    private String LOGOUT_BUTTON_XPATH = "xpath=//a[3]";


    public WebElement getEmailAddress() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(EMAIL_ADDRESS_TEXTBOX_ID)); }
    public WebElement getPassword() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(PASSWORD_TEXTBOX_ID)); }
    public WebElement loginClick() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(LOGIN_BUTTON_ID)); }
    public WebElement sideMenuClick() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(SIDE_MENU_BUTTON_ID)); }
    public WebElement logoutClick() { return SeleniumRunner.getSeleniumDriver().findElement(By.cssSelector(LOGOUT_BUTTON_XPATH)); }
}
