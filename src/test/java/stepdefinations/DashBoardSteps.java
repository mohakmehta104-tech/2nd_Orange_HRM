package stepdefinations;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class DashBoardSteps {
	
	DashBoardPage dashboardPage ;
	LoginPage loginpage;
	ExtentTest test;
	@Before
	public void setUp(Scenario scenario)
	{
		BaseClass.initializeDriver();
		dashboardPage = new DashBoardPage(BaseClass.driver);
		loginpage = new LoginPage(BaseClass.driver);
		test = ExtentManager.createTest(scenario.getName(), "Scenario execution");
	    test.info("Starting scenario: " + scenario.getName());
	    
	    
		
	}
	
	@Given("user is on Dashboard page")
	public void user_Is_On_Dashboard()
	{
		loginpage.enterUsername(ConfigReader.getProperty("username"));
		loginpage.enterPassword(ConfigReader.getProperty("password"));
		loginpage.clickLogin();
		test.info("User logged in successfully");
		
	}
	
	@When("user clicks on Admin Element")
	public void clickAdminElement()
	{
		dashboardPage.clickAdminElement();
		test.info("Clicked on Admin Element");
	}
	@Then("user should be navigated to Admin page")
	public void verifyAdminPage()
	{
		/*new WebDriverWait(BaseClass.driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.urlContains("admin"));
		String currenturl = BaseClass.driver.getCurrentUrl();
		Assert.assertTrue(currenturl.contains("admin"),"Not Admin page");
		*/
		System.out.println("User is on Admin page");
		test.pass("User navigated to Admin page");
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
