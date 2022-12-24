package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelandLogout {

    private final WebDriver webDriver;

    public CancelandLogout(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "a[data-test-id='checkout-breadcrumb-0']")
    public WebElement GoToCart;

    @FindBy(css = "button[data-test-id='remove-product-button']")
    public WebElement Remove_Product;

    @FindBy(css = "div[data-test-id='cart-remove-item-modal']")
    public WebElement Remove_Item_Model;

    @FindBy(css = "button[id='confirm-button']")
    public WebElement Confirm_btn;

    @FindBy(xpath = "//div[@data-test-id='no-cart-items']/p[1]")
    public WebElement Cart_Empty_Msg;

    @FindBy(xpath = "//button[@data-test-id='account-button']")
    public WebElement Account_btn;

    @FindBy(css = "button[data-test-id='logout-button']")
    public WebElement Logout;

    public void cancelAndLogout() {
        GoToCart.click();
        Remove_Product.click();
        Remove_Item_Model.isDisplayed();
        Confirm_btn.click();
        Cart_Empty_Msg.isDisplayed();

    }
    public void logout() {
        Account_btn.click();
        Logout.click();
    }
}
