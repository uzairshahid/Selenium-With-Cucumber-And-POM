package pages;

import pages.BaseScreen.PageLogin;
import pages.ProductsScreen.PageProducts;

public class Page {

    private final PageLogin pageLogin = new PageLogin();
    private final PageProducts pageProducts = new PageProducts();
    protected PageLogin getPageLogin() { return pageLogin; }
    protected PageProducts getItemsInCart() { return pageProducts; }
}

