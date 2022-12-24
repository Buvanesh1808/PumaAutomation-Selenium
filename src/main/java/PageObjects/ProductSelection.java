package PageObjects;

import Utilities.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSelection {

    private final WebDriver webDriver;

    public ProductSelection(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(css = "button[data-test-id='account-logout-button']")
    public WebElement Account_Page;
    @FindBy(xpath = "//a[@data-link-name='Men']/ancestor::div[2]")
    public WebElement Men;

    @FindBy(xpath = "//ul[@aria-label='Shoes']/li/a[@data-link-name='Running Shoes']")
    public WebElement RunningShoes;

    public void productSelection() {
        Actions action = new Actions(webDriver);
        action.moveToElement(Men).build().perform();
        action.moveToElement(RunningShoes).click().build().perform();
    }
    public void waitForAccount(){
        Wait.untilElementIsVisible(webDriver,Account_Page,15000);
    }
}
