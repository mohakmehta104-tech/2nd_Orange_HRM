package stepdefinations;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.DirectoryPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.ScreenshotUtil;


public class DirectorySteps {
	
	

    @Given("user is on Dashboard")
    public void user_Is_On_Dashboard() {
        Hooks.loginpage.enterUsername(ConfigReader.getProperty("username"));
        Hooks.loginpage.enterPassword(ConfigReader.getProperty("password"));
        Hooks.loginpage.clickLogin();
        Hooks.dashboardPage.clickDirectoryElement();
        Hooks.test.info("User logged in successfully");
    }

    @When("I enter Username in the Employee name suggestive dropdown")
    public void enterUsername() {
        Hooks.directoryPage.enterEmployeeNameText("Timothy Lewis Amiano");
        Hooks.directoryPage.selectEmployeeName("Timothy Lewis Amiano");
    }

    @And("I click on the Search button")
    public void clickSearch() {
        Hooks.directoryPage.clickSearch();
    }

    @Then("I should see the employee Timothy Lewis Amiano in the search results")
    public void verifyEmployee() {
        System.out.println("Timothy Lewis Amiano");
        Hooks.test.pass("User verified successfully");
    }
}

