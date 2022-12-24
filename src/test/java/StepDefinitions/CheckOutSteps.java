package StepDefinitions;

import PageObjects.Checkout;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import org.testng.Assert;

public class CheckOutSteps {

    TestContext testContext;

    Checkout checkout;

    public CheckOutSteps(TestContext context) {
        testContext = context;
        checkout = testContext.getPageObjectManager().checkout();
    }
    @And("I Verify the Shoe and Proceed the Checkout")
    public void iVerifyTheShoeAndProceedTheCheckout() {
        checkout.checkOut();
//        Assert.assertEquals(checkout.Checkout_Email.getText(),"TestingPuma@gmail.com");
    }

    @And("I verify shoe name is displayed as {string}")
    public void iVerifyShoeNameIsDisplayedAs(String Shoename) {
        Assert.assertEquals(checkout.Product_Title.getText(),Shoename);
    }
}
