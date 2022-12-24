package PageObjects;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Payment {

    private final WebDriver webDriver;

    public Payment(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 25), this);

    }

    @FindBy(css = "input[id='scheme-radio-input']")
    public WebElement CreditCard_Radio_btn;
    @FindBy(css = "input[id='holder-name']")
    public WebElement CardHolder_Name;
    @FindBy(css = "iframe[title='Iframe for secured card number']")
    public WebElement CardNumber_Iframe;
    @FindBy(css = "input[id='encryptedCardNumber']")
    public WebElement CardNumber;
    @FindBy(css = "iframe[title='Iframe for secured card expiry date']")
    public WebElement ExpiryDate_Iframe;
    @FindBy(css = "input[id='encryptedExpiryDate']")
    public WebElement Card_ExpiryDate;
    @FindBy(css = "iframe[title='Iframe for secured card security code']")
    public WebElement CVV_Iframe;
    @FindBy(css = "input[id='encryptedSecurityCode']")
    public WebElement CVV;
    @FindBy(css = "button[data-test-id='place-order']")
    public WebElement PlaceOrder;

    @FindBy(css = "span[data-test-id='payment-form-error']")
    public WebElement Payment_Error_Msg;

    public void payment() {
        CreditCard_Radio_btn.isDisplayed();
        CreditCard_Radio_btn.click();
        CardHolder_Name.sendKeys("Buvanesh");
        webDriver.switchTo().frame(CardNumber_Iframe);
        CardNumber.sendKeys("378282246310005");
        webDriver.switchTo().defaultContent();
        webDriver.switchTo().frame(ExpiryDate_Iframe);
        Card_ExpiryDate.sendKeys("0523");
        webDriver.switchTo().defaultContent();
        webDriver.switchTo().frame(CVV_Iframe);
        CVV.sendKeys("123");
        webDriver.switchTo().defaultContent();
        PlaceOrder.click();


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-test-id='payment-form-error']")));
//        WebElement Payment_Error_Msg = driver.findElement(By.cssSelector("span[data-test-id='payment-form-error']"));
//        Assert.assertEquals(Payment_Error_Msg.getText(), "Sorry, something went wrong with your payment. Please try a different payment method or contact your payments provider. If issue continues you can contact customer service.");
    }
}
