package StepDefinitions;

import PageObjects.ProductSelection;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProductSelectionSteps {

    TestContext testContext;
    ProductSelection productSelection;

    public ProductSelectionSteps(TestContext context){
        testContext = context;
        productSelection = testContext.getPageObjectManager().productSelection();
    }
    @Then("I navigate to Running Shoe section")
    public void iNavigateToRunningShoeSection() {
        productSelection.productSelection();
    }
    @And("I wait for Account page to be visible")
    public void iWaitForAccountPageToBeVisible() {
        productSelection.waitForAccount();
    }
}
