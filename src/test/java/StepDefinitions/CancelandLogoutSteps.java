package StepDefinitions;

import PageObjects.CancelandLogout;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class CancelandLogoutSteps {

    TestContext testContext;
    CancelandLogout cancelandLogout;

    public CancelandLogoutSteps(TestContext context) {
        testContext = context;
        cancelandLogout = testContext.getPageObjectManager().cancelandLogout();
    }

    @And("I cancel the Product")
    public void iCancelTheProduct() {
        cancelandLogout.cancelProduct();
    }
    @Then("I Logout the Puma application")
    public void iLogoutThePumaApplication() {
        cancelandLogout.logout();
    }
    @And("I verify the cart is empty message displayed as {string}")
    public void iVerifyTheCartIsEmptyMessageDisplayedAs(String errMsg) {
        Assert.assertEquals(cancelandLogout.Cart_Empty_Msg.getText(), errMsg);
    }
}
