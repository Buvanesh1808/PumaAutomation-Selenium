package StepDefinitions;

import PageObjects.ProductSelection;
import Utilities.TestContext;
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
}
