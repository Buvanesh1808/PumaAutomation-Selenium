package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoeSelection {

    private final WebDriver webDriver;

    public ShoeSelection(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//ul[@id='product-list-items']/li//a")
    public List<WebElement> All_Shoes;

    @FindBy(xpath = "//div[@data-test-id='size-picker']//span[contains(text(),'11')]")
    public WebElement Shoe_size;

    @FindBy(xpath = "//button[@data-test-id='pdp-add-to-cart']")
    public WebElement AddToCart_btn;

    @FindBy(css = "a[data-test-id='minicart-cart-link']")
    public WebElement ViewCartandCheckout;

    public void shoeSelection(String ShoeName) {
        for (WebElement Shoes : All_Shoes) {
            String value = Shoes.getAttribute("aria-label");
            if (value.contains(ShoeName)) {
                webDriver.findElement(By.xpath("//ul[@id='product-list-items']/li//a[contains(@aria-label,'" + ShoeName + "')]")).click();
                break;
            }
        }
    }

    public void click(){
        Shoe_size.click();
        AddToCart_btn.click();
//            wait.until(ExpectedConditions.visibilityOf(ViewCartandCheckout));
        ViewCartandCheckout.click();
    }
}
