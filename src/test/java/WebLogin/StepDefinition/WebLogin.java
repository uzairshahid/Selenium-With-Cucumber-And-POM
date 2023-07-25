package WebLogin.StepDefinition;

import io.cucumber.java.en.And;
import pages.Page;

import java.util.concurrent.TimeUnit;

public class WebLogin extends Page {

    @And("^\\[Admin Portal] User enters Email \"([^\"]*)\"$")
    public void enterEmailAddress(String emailAddress) {
        getPageLogin().getEmailAddress().sendKeys(emailAddress);
    }

    @And("^\\[Admin Portal] User enters Password \"([^\"]*)\"$")
    public void enterPassword(String password) {
        getPageLogin().getPassword().sendKeys(password);
    }

    @And("^\\[Admin Portal] Click on login button")
    public void loginButton() {
        getPageLogin().loginClick().click();
    }
    @And("^\\[Admin Portal] Go to side menu")
    public void goToSideMenu() throws InterruptedException {
        getPageLogin().sideMenuClick().click();
        TimeUnit.SECONDS.sleep(3);

    }
    @And("^\\[Admin Portal] Click on logout button")
    public void logoutButton() {
        getPageLogin().logoutClick().click();
    }



}