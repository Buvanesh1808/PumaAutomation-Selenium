package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PumaLoginPage {

    public PumaLoginPage(WebDriver webDriver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 30), this);
    }

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


    public void login() {

        if(CookiePopup_Close.isDisplayed()){
            CookiePopup_Close.click();
        }
        Account_btn.click();
        Login_btn.click();
        Email_Pwd_Link.click();
        Email_id.sendKeys("Testingpuma@gmail.com");
        Password.sendKeys("Puma@2022");
        SignIn_btn.click();
    }
}
