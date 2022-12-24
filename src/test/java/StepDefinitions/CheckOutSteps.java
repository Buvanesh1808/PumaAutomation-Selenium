package StepDefinitions;

import PageObjects.Checkout;
import Utilities.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Map;
import java.util.function.BiConsumer;

public class CheckOutSteps {

    TestContext testContext;

    Checkout checkout;

    public CheckOutSteps(TestContext context) {
        testContext = context;
        checkout = testContext.getPageObjectManager().checkout();
    }

    @And("I verify shoe name is displayed as {string}")
    public void iVerifyShoeNameIsDisplayedAs(String Shoename) {
        Assert.assertEquals(checkout.Product_Title.getText(), Shoename);
    }

    @And("I click on Proceed the Checkout")
    public void iClickOnProceedTheCheckout() {
        checkout.checkOut();

    }

    @Then("I Fill the Shipping Address details as below")
    public void iFillTheShippingAddressDetailsAsBelow(Map<String, String> formdata) throws Throwable {
        fillForm(formdata, this::fillShippingAddress);
        checkout.ContinuetoPay.click();
    }

    public static void fillForm(Map<String, String> formdata, BiConsumer<String, String> formfillWithActionConsumer) {
        for (Map.Entry<String, String> formMapKeyValue : formdata.entrySet()) {
            formfillWithActionConsumer.accept(formMapKeyValue.getKey(), formMapKeyValue.getValue());
        }
    }

    public void fillShippingAddress(String label, String value) {
        switch (label) {
            case "FirstName":
                checkout.FirstName.clear();
                checkout.FirstName.sendKeys(value);
                break;
            case "LastName":
                checkout.LastName.clear();
                checkout.LastName.sendKeys(value);
                break;
            case "PinCode":
                checkout.PinCode.clear();
                checkout.PinCode.sendKeys(value);
                break;
            case "Street":
                checkout.Street.clear();
                checkout.Street.sendKeys(value);
                break;
            case "Address 2":
                checkout.Address2.clear();
                checkout.Address2.sendKeys(value);
                break;
            case "City":
                checkout.City.clear();
                checkout.City.sendKeys(value);
                break;
            case "Email":
                checkout.Checkout_Email.clear();
                checkout.Checkout_Email.sendKeys(value);
                break;
            case "PhoneNumber":
                checkout.PhoneNumber.clear();
                checkout.PhoneNumber.sendKeys(value);
                break;
            default:
                System.out.println("Given label is not found");
        }
    }
}
