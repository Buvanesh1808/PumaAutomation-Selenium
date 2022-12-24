package StepDefinitions;

import PageObjects.Payment;
import Utilities.TestContext;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class PaymentSteps {

    TestContext testContext;

    Payment payment;
    PumaLoginSteps pumaLoginSteps;

    public PaymentSteps(TestContext context) {
        testContext = context;
        payment = testContext.getPageObjectManager().payment();
    }

    @Then("I fill the CreditCard details for Payment")
    public void iFillTheCreditCardDetailsForPayment() throws IOException {
        payment.payment();
        pumaLoginSteps.captureScreenshot("Fill_Credit_card",".jpg");
    }
}
