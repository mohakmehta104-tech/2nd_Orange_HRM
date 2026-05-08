package stepdefinations;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import pages.PersonalDetailsPage;
import utils.ConfigReader;
import utils.ExtentManager;

public class AddEmployeeSteps {
	
	LoginPage loginpage;
	ExtentTest test;
	DashBoardPage dashboardPage;
	EmployeeListPage employeeListPage;
	AddEmployeePage addEmployeePage;
	PersonalDetailsPage personalDetailsPage; 
	
	@Before
	public void setUp(Scenario scenario)
	{
		BaseClass.initializeDriver();
		
		personalDetailsPage = new PersonalDetailsPage(BaseClass.driver);
		addEmployeePage = new AddEmployeePage(BaseClass.driver);
		loginpage = new LoginPage(BaseClass.driver);
		dashboardPage = new DashBoardPage(BaseClass.driver);
		employeeListPage = new EmployeeListPage(BaseClass.driver);
		test = ExtentManager.createTest(scenario.getName(), "Scenario execution");
	    test.info("Starting scenario: " + scenario.getName());
		
	}
	
	@Given("I am logged into OrangeHRM")
	public void i_am_logged_into_orangehrm()
	{
		loginpage.enterUsername(ConfigReader.getProperty("username"));
		loginpage.enterPassword("admin123");
		loginpage.clickLogin();
		test.pass("Logged into OrangeHRM successfully");
	}
	
    @When("I click on the PIM menu")
    public void i_click_on_the_pim_menu() {
        
        dashboardPage.clickOnPIM();
        test.info("Clicked on PIM menu");
    }
	
    @And ("I click on the Add button")
    public void i_click_on_the_add_button() {
        
        employeeListPage.clickAddButton();
        test.info("Clicked on Add button");
    }
	
    @And("I enter employee details First Name {string}, Middle Name {string}, Last Name {string}")
    public void i_enter_employee_details(String fName, String mName, String lName) {
        
        addEmployeePage.addEmployee(fName, mName, lName);
        test.info("Entered employee details: " + fName + " " + mName + " " + lName);
    }
    
	
    @Then("I should see the employee in Personal Details page")
    public void i_should_see_the_employee_in_personal_details_page(String expectedName) {
       
        Assert.assertTrue(personalDetailsPage.verifyEmployee("Anuj S Mehta"),
                "Employee verification failed!");
        test.pass("Verified employee: " + expectedName);
        
    }

}
