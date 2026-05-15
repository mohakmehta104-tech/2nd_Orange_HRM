package stepdefinations;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.LoggerUtil;
import utils.ScreenshotUtil;

public class LoginSteps {

    @Given("user is on login page")
    public void user_is_on_login_page() {
        // optional: navigate to login URL if not already there
    }

    @When("user enters username and password")
    public void user_enters_credintial() {
        Hooks.loginpage.enterUsername(ConfigReader.getProperty("username"));
        Hooks.loginpage.enterPassword(ConfigReader.getProperty("password"));
        Hooks.test.info("Entered credentials");
    }

    @And("user clicks on login button")
    public void clicks_login() {
        Hooks.loginpage.clickLogin();
        Hooks.test.info("Clicked login button");
    }

    @Then("user should be navigated to Dashboard page")
    public void verify_dashboard() {
        new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("dashboard"));
        String currenturl = BaseClass.driver.getCurrentUrl();
        Assert.assertTrue(currenturl.contains("dashboard"), "Login Failed!");
        Hooks.test.pass("User navigated to Dashboard page");
    }
}

