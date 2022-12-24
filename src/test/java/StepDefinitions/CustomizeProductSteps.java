package StepDefinitions;

import PageObjects.CustomiseProduct;
import Utilities.TestContext;
import io.cucumber.java.en.And;


public class CustomizeProductSteps {

    TestContext testContext;
    CustomiseProduct customiseProduct;

    public CustomizeProductSteps(TestContext context) {
        testContext = context;
        customiseProduct = testContext.getPageObjectManager().customiseProduct();
    }

    @And("I customize my Shoe Colour and Size")
    public void iCustomizeMyShoeColourAndSize() {
//        customiseProduct.customizeProduct("10", "gray");
    }

    @And("I Filter the Shoe Size as {string}")
    public void iFilterTheShoeSizeAs(String Shoe_size) {
        customiseProduct.selectSize(Shoe_size);

    }

    @And("I Filter the Shoe Colour as {string}")
    public void iFilterTheShoeColourAs(String Shoe_Colours) {
        customiseProduct.selectColours(Shoe_Colours);
    }
}
