package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;

public class MyInfoSteps {
	
	
	@Given ("user is on Homee")
	public void user_Is_Home()
	{
		Hooks.loginpage.enterUsername(ConfigReader.getProperty("username"));
        Hooks.loginpage.enterPassword(ConfigReader.getProperty("password"));
        Hooks.loginpage.clickLogin();
        Hooks.test.info("User landed on HomePage successfully");
		
	}
	
	@When ("user clicks on MyInfo Element")
	public void user_Clicks_On_MyInfo()
	{
		Hooks.dashboardPage.clickMyInfo();
		Hooks.test.info("User clicked on MyInfo");
		
	}
	
	@Then ("user is navigated to MyInfo Page")
	public void verify_MyInfoPage()
	{
		System.out.println("User is on MyInfo Page");
		Hooks.test.info("User is on MyInfo page");
		
	}

}
