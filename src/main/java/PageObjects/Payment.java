package PageObjects;

import Utilities.Wait;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
//        webDriver.switchTo().frame(0);
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
//        js.executeScript("document.getElementById('encryptedCardNumber').value='378282246310005';");
        js.executeScript("arguments[0].value='0523'",Card_ExpiryDate);
        js.executeScript("arguments[0].value='123'",CVV);
//        CardNumber.sendKeys("378282246310005");
//        webDriver.switchTo().defaultContent();
//        webDriver.switchTo().frame(1);
//        Card_ExpiryDate.sendKeys("0523");
//        webDriver.switchTo().defaultContent();
//        webDriver.switchTo().frame(2);
//        CVV.sendKeys("123");
//        webDriver.switchTo().defaultContent();
        Wait.untilElementIsVisible(webDriver,PlaceOrder,10000);
        PlaceOrder.click();
        Wait.untilElementIsVisible(webDriver, Payment_Error_Msg, 10000);
    }
}
