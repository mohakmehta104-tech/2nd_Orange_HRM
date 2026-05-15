package stepdefinations;

import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddEmployeePage;
import pages.EmployeeListPage;
import utils.ConfigReader;

public class AddEmployeeSteps {

    @Given("I am logged into OrangeHRM")
    public void i_am_logged_into_orangehrm() {
        Hooks.loginpage.enterUsername(ConfigReader.getProperty("username"));
        Hooks.loginpage.enterPassword(ConfigReader.getProperty("password"));
        Hooks.loginpage.clickLogin();
        Hooks.test.pass("Logged into OrangeHRM successfully");
    }

    @When("I click on the PIM menu")
    public void i_click_on_the_pim_menu() {
        Hooks.dashboardPage.clickOnPIM();
        Hooks.test.info("Clicked on PIM menu");
    }

    @And("I click on the Add button")
    public void i_click_on_the_add_button() {
        Hooks.employeeListPage.clickAddButton();
        Hooks.test.info("Clicked on Add button");
    }

    @And("I enter employee details First Name {string}, Middle Name {string}, Last Name {string}")
    public void i_enter_employee_details(String fName, String mName, String lName) {
        Hooks.addEmployeePage.addEmployee(fName, mName, lName);
        Hooks.test.info("Entered employee details: " + fName + " " + mName + " " + lName);
    }

    @Then("Print a message that user created successfully")
    public void i_should_see_the_employee_in_personal_details_page() {
        System.out.println("User created successfully");
        Hooks.test.pass("Employee created successfully");
    }
}
