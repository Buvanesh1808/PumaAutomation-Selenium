package StepDefinitions;

import PageObjects.CustomiseProduct;
import Utilities.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;


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

    @And("I filter the shoe size as {string}")
    public void iFilterTheShoeSizeAs(String Shoe_size) {
        customiseProduct.selectSize(Shoe_size);
    }
    @And("I Filter the Shoe Colour as below")
    public void iFilterTheShoeColourAs(DataTable dataTable) {
        List<String> values = dataTable.asList();
        customiseProduct.selectColours(values);
    }
}
