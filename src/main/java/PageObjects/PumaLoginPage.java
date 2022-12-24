package PageObjects;


import Managers.AllDriverManager;
import Utilities.Wait;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PumaLoginPage {
    private final WebDriver webDriver;

    public PumaLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 30), this);
    }

    @FindBy(css = "form[id='ins-question-group-form']")
    public WebElement Additional_Popup;

    @FindBy(css = "div[id='close-button-1545222288830'] span")
    public WebElement Pop_up_close;

    @FindBy(xpath = "//button[@data-test-id='account-button']")
    public WebElement Account_btn;

    @FindBy(xpath = "//a[@data-test-id='login-button']")
    public WebElement Login_btn;

    @FindBy(xpath = "//div[contains(text(),'Login with Email and Password')]")
    public WebElement Email_Pwd_Link;

    @FindBy(css = "input[data-test-id=auth-field-email]")
    public WebElement Email_id;

    @FindBy(css = "input[data-test-id=auth-field-password]")
    public WebElement Password;

    @FindBy(css = "button[data-test-id=auth-button-login] span")
    public WebElement SignIn_btn;

    @FindBy(css = "button[id='cookie-banner-close-btn']")
    public WebElement CookiePopup_Close;


    public void login() throws IOException {
        if (Additional_Popup.isDisplayed()) {
            Pop_up_close.click();
        }
        if (CookiePopup_Close.isDisplayed()) {
            CookiePopup_Close.click();
        }
        Account_btn.click();
        Login_btn.click();
        Email_Pwd_Link.click();
        Email_id.sendKeys("Testingpuma@gmail.com");
        Password.sendKeys("Puma@2022");
        SignIn_btn.click();
        Wait.untilElementIsVisible(webDriver, Account_btn, 15000);

    }




}
