package PageObjects;

import Utilities.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Checkout {
    private final WebDriver webDriver;
    public Checkout(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 25), this);
    }

    @FindBy(css = "a[data-test-id='cart-summary-checkout']")
    public WebElement Checkout_btn;

    @FindBy(css = "h3[data-test-id='cart-product-title']")
    public WebElement Product_Title;

    @FindBy(css = "input[data-test-id='shipping-address-first-name']")
    public WebElement FirstName;

    @FindBy(css = "input[data-test-id='shipping-address-last-name']")
    public WebElement LastName;

    @FindBy(css = "input[data-test-id='shipping-address-postal-code']")
    public WebElement PinCode;

    @FindBy(css = "input[data-test-id='shipping-address-address1']")
    public WebElement Street;

    @FindBy(css = "input[data-test-id='shipping-address-address2']")
    public WebElement Address2;

    @FindBy(css = "input[data-test-id='shipping-address-city']")
    public WebElement City;

    @FindBy(css = "select[data-test-id='shipping-address-state-code']")
    public WebElement State;

    @FindBy(css = "input[data-test-id='checkout-email-field']")
    public WebElement Checkout_Email;

    @FindBy(css = "input[data-test-id='shipping-address-phone-number']")
    public WebElement PhoneNumber;

    @FindBy(css = "button[data-test-id='continue-to-payment']")
    public WebElement ContinuetoPay;



    public void checkOut() {
        Wait.untilElementIsVisible(webDriver,Checkout_btn,10000);
        Checkout_btn.click();

     }
}
