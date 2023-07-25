package WebLogin.StepDefinition;

import io.cucumber.java.en.And;
import pages.Page;

import java.util.concurrent.TimeUnit;


public class AddItemsInCartAndPlaceOrder extends Page {

    @And("^\\[Admin Portal] User should be able to add item in cart")
    public void addToCart() throws InterruptedException {
        getItemsInCart().addProductInCart().click();
        TimeUnit.SECONDS.sleep(1);

    }

    @And("^\\[Admin Portal] User should be able to visit on checkout screen by click on checkout icon")
    public void goToCart() {
        getItemsInCart().goToCart().click();

    }

    @And("^\\[Admin Portal] Click on chckout to continue")
    public void checkOut() throws InterruptedException {
        getItemsInCart().checkOut().click();
        TimeUnit.SECONDS.sleep(1);

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
    public void enterPostalCode(String code) throws InterruptedException {
        getItemsInCart().postalCode().sendKeys(code);
        TimeUnit.SECONDS.sleep(1);

    }

    @And("^\\[Admin Portal] Click on continue button to continue ordering")
    public void continueOrdering() {
        getItemsInCart().continueOrder().click();
    }

    @And("^\\[Admin Portal] Click on finish button to complete ordering")
    public void finishOrdering() {
        getItemsInCart().finishOrder().click();

    }


}