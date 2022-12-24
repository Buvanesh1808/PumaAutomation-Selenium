package StepDefinitions;

import Managers.AllDriverManager;
import PageObjects.PumaLoginPage;
import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PumaLoginSteps {

   PumaLoginPage pumaLoginPage;
    TestContext testContext;

   WebDriver webDriver;

    public PumaLoginSteps(TestContext context) {
        testContext = context;
        pumaLoginPage = testContext.getPageObjectManager().getPumaLoginPage();
    }

    @Given("I login the Puma application")
    public void iLoginThePumaApplication() throws IOException {
        pumaLoginPage.login();
        captureScreenshot("I login the Puma application",".jpg");

    }
    public void captureScreenshot(String fileName,String extension) throws IOException {
        File scrFile = ((TakesScreenshot) testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        FileUtils.copyFile(scrFile, new File("target/screenshots/" + fileName+" "+timestamp+extension));
    }

   }
