package Managers;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectManager {

    private final WebDriver webDriver;
    private PumaLoginPage pumaLoginPage;
    private ProductSelection productSelection;
    public CustomiseProduct customiseProduct;
    public ShoeSelection shoeSelection;
    public Checkout checkout;
    public Payment payment;
    public CancelandLogout cancelandLogout;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public PumaLoginPage getPumaLoginPage() {
        return (pumaLoginPage == null) ? pumaLoginPage = new PumaLoginPage(webDriver) : pumaLoginPage;
    }
    public ProductSelection productSelection() {
        return (productSelection == null) ? productSelection = new ProductSelection(webDriver) : productSelection;
    }
    public CustomiseProduct customiseProduct() {
        return (customiseProduct == null) ? customiseProduct = new CustomiseProduct(webDriver) : customiseProduct;
    }
    public ShoeSelection shoeSelection() {
        return (shoeSelection == null) ? shoeSelection = new ShoeSelection(webDriver) : shoeSelection;
    }
    public Checkout checkout() {
        return (checkout == null) ? checkout = new Checkout(webDriver) : checkout;
    }
    public Payment payment() {
        return (payment == null) ? payment = new Payment(webDriver) : payment;
    }
    public CancelandLogout cancelandLogout() {
        return (cancelandLogout == null) ? cancelandLogout = new CancelandLogout(webDriver) : cancelandLogout;
    }
}
