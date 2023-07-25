package WebLogin.StepDefinition;

import io.cucumber.java.en.And;
import pages.Page;

import java.util.concurrent.TimeUnit;

public class WebLogin extends Page {

    @And("^\\[Admin Portal] User enters Email \"([^\"]*)\"$")
    public void enterEmailAddress(String emailAddress) throws InterruptedException {
        getPageLogin().getEmailAddress().sendKeys(emailAddress);
        TimeUnit.SECONDS.sleep(1);

    }

    @And("^\\[Admin Portal] User enters Password \"([^\"]*)\"$")
    public void enterPassword(String password) throws InterruptedException {
        getPageLogin().getPassword().sendKeys(password);
        TimeUnit.SECONDS.sleep(1);

    }

    @And("^\\[Admin Portal] Click on login button")
    public void loginButton() throws InterruptedException {
        getPageLogin().loginClick().click();
        TimeUnit.SECONDS.sleep(1);

    }
    @And("^\\[Admin Portal] Go to side menu")
    public void goToSideMenu() throws InterruptedException {
        getPageLogin().sideMenuClick().click();
        TimeUnit.SECONDS.sleep(1);

    }
    @And("^\\[Admin Portal] Click on logout button")
    public void logoutButton() {
        getPageLogin().logoutClick().click();
    }



}