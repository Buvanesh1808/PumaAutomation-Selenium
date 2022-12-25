package StepDefinitions;

import PageObjects.ShoeSelection;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ShoeSelectionSteps {

    TestContext testContext;
     ShoeSelection shoeSelection;

    public ShoeSelectionSteps(TestContext context) {
        testContext =context;
        shoeSelection =testContext.getPageObjectManager().shoeSelection();
    }

    @Then("I click on {string} Button")
    public void iClickOnButton(String button) {
        shoeSelection.click();
    }

    @Then("I select the Shoe as {string}")
    public void iSelectTheShoeAs(String Shoename) {
        shoeSelection.shoeSelection(Shoename);
    }
}
