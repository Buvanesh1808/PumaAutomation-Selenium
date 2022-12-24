package StepDefinitions;

import PageObjects.CancelandLogout;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CancelandLogoutSteps {

    TestContext testContext;
    CancelandLogout cancelandLogout;

    public CancelandLogoutSteps(TestContext context) {
        testContext = context;
        cancelandLogout = testContext.getPageObjectManager().cancelandLogout();
    }

    @And("I cancel the Product")
    public void iCancelTheProduct() {
        cancelandLogout.cancelAndLogout();
    }
    @Then("I Logout the Puma application")
    public void iLogoutThePumaApplication() {
        cancelandLogout.logout();
    }
}
