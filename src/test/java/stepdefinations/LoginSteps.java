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
	
	LoginPage loginpage;
	ExtentTest test;
	
	
	@Before
	public void setUp(Scenario scenario)
	{
		BaseClass.initializeDriver();
		loginpage = new LoginPage(BaseClass.driver);
		test = ExtentManager.createTest(scenario.getName(), "Scenario execution");
	    test.info("Starting scenario: " + scenario.getName());
		
	}
	
	@Given("user is on login page")
	public void user_is_on_login_page()
	{
		
	}
	
	@When("user enters username and password")
	public void user_enters_credintial()
	{
		
		loginpage.enterUsername(ConfigReader.getProperty("username"));
		loginpage.enterPassword("admin123");
		
		
	}
	
	@And("user clicks on login button")
	public void clicks_login()
	{
		
		loginpage.clickLogin();
	}
	@Then("user should be navigated to Dashboard page")
	public void verify_dashboard()
	{
		new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.urlContains("dashboard"));
		String currenturl = BaseClass.driver.getCurrentUrl();
		Assert.assertTrue(currenturl.contains("dashboard"),"Login Failed!");
	}
	
	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        ScreenshotUtil.captureScreenshot(scenario.getName());
	        LoggerUtil.logger.error("Test failed. Screenshot captured.");
	    }
	   //BaseClass.tearDown();
	}
	
		
		
	

}
