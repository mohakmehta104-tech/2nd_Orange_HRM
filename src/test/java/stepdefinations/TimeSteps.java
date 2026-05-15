package stepdefinations;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExtentManager;

public class TimeSteps {

    @Given("user is on Home")
    public void use_Is_On_Home() {
        Hooks.loginpage.enterUsername(ConfigReader.getProperty("username"));
        Hooks.loginpage.enterPassword(ConfigReader.getProperty("password"));
        Hooks.loginpage.clickLogin();
        Hooks.test.info("User logged in successfully");
    }

    @When("user clicks on Time Element")
    public void user_Clicks_On_TimeElement() {
        Hooks.dashboardPage.clickTime();
        Hooks.test.info("User Clicked on Time Element");
    }

    @Then("user is on Time page")
    public void verify_TimePage() {
        System.out.println("User is on Time page");
        Hooks.test.pass("User navigated to Time page");
    }
}

