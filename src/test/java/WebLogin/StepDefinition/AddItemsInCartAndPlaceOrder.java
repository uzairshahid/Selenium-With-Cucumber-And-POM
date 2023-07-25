package WebLogin.StepDefinition;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import pages.Page;

import java.sql.Driver;
import java.sql.DriverManager;
import java.time.Duration;


public class AddItemsInCartAndPlaceOrder extends Page {

    @And("^\\[Admin Portal] User should be able to add item in cart")
    public void addToCart() {
        getItemsInCart().addProductInCart().click();
    }

    @And("^\\[Admin Portal] User should be able to visit on checkout screen by click on checkout icon")
    public void goToCart() {
        getItemsInCart().goToCart().click();
    }

    @And("^\\[Admin Portal] Click on chckout to continue")
    public void checkOut() {
        getItemsInCart().checkOut().click();
    }

    @And("^\\[Admin Portal] Enter first name as \"([^\"]*)\"$")
    public void enterFirstName(String firstName) {
        getItemsInCart().firstName().sendKeys(firstName);
    }

    @And("^\\[Admin Portal] Enter last name as \"([^\"]*)\"$")
    public void enterLastName(String lastName) {
        getItemsInCart().lastName().sendKeys(lastName);
    }

    @And("^\\[Admin Portal] Enter postal code as \"([^\"]*)\"$")
    public void enterPostalCode(String code) {
        getItemsInCart().postalCode().sendKeys(code);
    }

    @And("^\\[Admin Portal] Click on continue button to continue ordering")
    public void continueOrdering() {
        getItemsInCart().continueOrder().click();
    }
    @And("^\\[Admin Portal] Click on finish button to complete ordering")
    public void finishOrdering() {
        getItemsInCart().finishOrder().click();
    }








//    @And("^\\[Admin Portal] User enters Password \"([^\"]*)\"$")
//    public void enterPassword(String password) {
//        getPageLogin().getPassword().sendKeys(password);
//    }
//
//    @And("^\\[Admin Portal] Click on login button")
//    public void enterPassword() {
//        getPageLogin().loginClick().click();
//    }
//
//    And   [Admin Portal]
//    And   [Admin Portal] User should be able to visit on checkout screen by click on checkout icon
//    And   [Admin Portal] Click on place order



}

