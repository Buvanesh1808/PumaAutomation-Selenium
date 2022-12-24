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
                break;
            }
        }
    }

    public void selectColours(String Colours){
        ShoeColour_Filter.click();
        for (WebElement Colour : All_Colours) {
            String value = Colour.getText();
            String val1 = value.replaceAll("\\d", "").replaceAll("\\(", "").replaceAll("\\)", "").trim();
            if (val1.equalsIgnoreCase(Colours)) {
                webDriver.findElement(By.xpath("//div[@data-test-id='color-filter-values']/button[@data-value='" + Colours + "']")).click();
                break;
            }
        }
    }

//    public void customizeProduct(String Size, String Colours) {
//        ShoeSize_Filter.click();
//        for (WebElement Sizes : All_Sizes) {
//            String value = Sizes.getText();
//            if (value.equals(Size)) {
//                webDriver.findElement(By.xpath("//button[contains(text(),'" + Size + "')]")).click();
//                break;
//            }
//        }
//        ShoeColour_Filter.click();
//        for (WebElement Colour : All_Colours) {
//            String value = Colour.getText();
//            String val1 = value.replaceAll("\\d", "").replaceAll("\\(", "").replaceAll("\\)", "").trim();
//            if (val1.equalsIgnoreCase(Colours)) {
//                webDriver.findElement(By.xpath("//div[@data-test-id='color-filter-values']/button[@data-value='" + Colours + "']")).click();
//                break;
//            }
//        }
//    }
}
