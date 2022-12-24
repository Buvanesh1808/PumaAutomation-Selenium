package StepDefinitions;

import PageObjects.PumaLoginPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PumaLoginSteps {

   PumaLoginPage pumaLoginPage;
    TestContext testContext;

    public PumaLoginSteps(TestContext context) {
        testContext = context;
        pumaLoginPage = testContext.getPageObjectManager().getPumaLoginPage();
    }

    @Given("I login the Puma application")
    public void iLoginThePumaApplication() {
        pumaLoginPage.login();
    }


}
