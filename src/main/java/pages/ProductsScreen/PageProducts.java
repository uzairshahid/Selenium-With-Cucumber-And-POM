package pages.ProductsScreen;

import core.utils.SeleniumHook.SeleniumRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageProducts {

    private String CLICK_PRODUCT_ID = "add-to-cart-sauce-labs-bike-light";
    private String CLICK_GO_TO_CART_SELECTOR = "#shopping_cart_container > a > span";
    private String CLICK_ON_CHECKOUT_ID = "checkout";
    private String ENTER_FIRST_NAME_ID = "first-name";
    private String ENTER_LAST_NAME_ID = "last-name";
    private String ENTER_POSTAL_CODE_ID = "postal-code";
    private String ENTER_CONTINUE_ID = "continue";
    private String ENTER_FINISH_ID= "finish";



    public WebElement addProductInCart() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(CLICK_PRODUCT_ID)); }
    public WebElement goToCart() { return SeleniumRunner.getSeleniumDriver().findElement(By.cssSelector(CLICK_GO_TO_CART_SELECTOR)); }
    public WebElement checkOut() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(CLICK_ON_CHECKOUT_ID)); }
    public WebElement firstName() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(ENTER_FIRST_NAME_ID)); }
    public WebElement lastName() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(ENTER_LAST_NAME_ID)); }
    public WebElement postalCode() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(ENTER_POSTAL_CODE_ID)); }
    public WebElement continueOrder() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(ENTER_CONTINUE_ID)); }
    public WebElement finishOrder() { return SeleniumRunner.getSeleniumDriver().findElement(By.id(ENTER_FINISH_ID)); }

}
