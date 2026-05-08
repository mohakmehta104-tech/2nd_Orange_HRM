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
	
	DirectoryPage directoryPage;
	DashBoardPage dashboardPage ;
	LoginPage loginpage;
	ExtentTest test;
	
	@Before
	public void setUp(Scenario scenario)
	{
		BaseClass.initializeDriver();
		directoryPage = new DirectoryPage(BaseClass.driver);
		loginpage = new LoginPage(BaseClass.driver);
		test = ExtentManager.createTest(scenario.getName(), "Scenario execution");
	    test.info("Starting scenario: " + scenario.getName());
		
	}
	
	@Given("user is on Dashboard")
	public void user_Is_On_Dashboard()
	{
		loginpage.enterUsername(ConfigReader.getProperty("username"));
		loginpage.enterPassword(ConfigReader.getProperty("password"));
		loginpage.clickLogin();
		dashboardPage.clickDirectoryElement();
	
		test.info("User logged in successfully");
		
	}
	
	@When("I enter Username in the Employee name suggestive dropdown")
	public void enterUsername()
	{
		directoryPage.enterEmployeeNameText("Timothy Lewis Amiano");
		directoryPage.selectEmployeeName("Timothy Lewis Amiano");
		
	}
	@And("I select Software Engineer from the Job Title dropdown")
	
	
	@And("I select New York from the Location dropdown")
	
	@And("I click on the Search button")
	public void clickSearch()
	{
		directoryPage.clickSearch();
		
	}
	
	@Then("I should see the employee Timothy Lewis Amiano in the search results")
	public void verifyEmployee()
	{
		
		System.out.println("Timothy Lewis Amiano");
		test.pass("User verified in successfully");
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		
		if(scenario.isFailed())
		{
			String screenshotPath = ScreenshotUtil.captureScreenshot(scenario.getName());
	        test.fail("Scenario failed: " + scenario.getName());
	        test.addScreenCaptureFromPath(screenshotPath);
			
		}
		else
		{
			
			test.pass("Scenario passed: " + scenario.getName());
		}
		BaseClass.tearDown();
		 ExtentManager.getInstance().flush();
	}
	
}
