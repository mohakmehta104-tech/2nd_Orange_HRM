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

public class LeaveSteps {

    @Given("user is on Home page")
    public void user_Is_On_HomePage() {
        Hooks.loginpage.enterUsername(ConfigReader.getProperty("username"));
        Hooks.loginpage.enterPassword(ConfigReader.getProperty("password"));
        Hooks.loginpage.clickLogin();
        Hooks.test.info("User landed on HomePage successfully");
    }

    @When("user clicks on Leave Element")
    public void user_Clicks_On_Leave() {
        Hooks.dashboardPage.clickLeave();
        Hooks.test.info("Clicked on Leave Tab");
    }

    @Then("user should be navigated to Leave page")
    public void user_Navigated_To_LeavePage() {
        System.out.println("User is on Leave page");
        Hooks.test.pass("User navigated to Leave page");
    }
}

