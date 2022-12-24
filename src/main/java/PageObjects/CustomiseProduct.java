package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import java.util.List;

public class CustomiseProduct {

    private final WebDriver webDriver;

    public CustomiseProduct(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "div[data-test-id='size-filter-pill'] button")
    public WebElement ShoeSize_Filter;

    @FindBy(css = "div[data-test-id='size-filter-values'] button")
    public List<WebElement> All_Sizes;

    @FindBy(css = "div[data-test-id='color-filter-pill']>button")
    public WebElement ShoeColour_Filter;

    @FindBy(xpath = "//div[@data-test-id=\"color-filter-values\"]/button")
    public List<WebElement> All_Colours;

    public void selectSize(String Size){
        ShoeSize_Filter.click();
        for (WebElement Sizes : All_Sizes) {
            String value = Sizes.getText();
            if (value.equals(Size)) {
                webDriver.findElement(By.xpath("//button[contains(text(),'" + Size + "')]")).click();
            }
        }
    }
    public void selectColours(List<String> datatable){
        ShoeColour_Filter.click();
        for (String colour : datatable) {
            String value = colour.toLowerCase();
            webDriver.findElement(By.xpath("//div[@data-test-id='color-filter-values']/button[@data-value='" + value + "']")).click();
        }
    }

}
