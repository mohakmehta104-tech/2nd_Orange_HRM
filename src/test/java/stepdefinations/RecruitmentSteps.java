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

public class RecruitmentSteps {

    @Given("user is on buttons page")
    public void user_Is_On_ButtonsPage() {
        Hooks.loginpage.enterUsername(ConfigReader.getProperty("username"));
        Hooks.loginpage.enterPassword(ConfigReader.getProperty("password"));
        Hooks.loginpage.clickLogin();
        Hooks.test.info("User landed on HomePage successfully");
    }

    @When("user clicks on Recruitment Element")
    public void click_On_RecruitmentElement() {
        Hooks.dashboardPage.clickRecruitment();
        Hooks.test.info("Clicked on Recruitment tab");
    }

    @Then("user should be navigated to Recruitment page")
    public void verify_RecruitmentPage() {
        System.out.println("User is on Recruitment page");
        Hooks.test.pass("User navigated to Recruitment page");
    }
}

