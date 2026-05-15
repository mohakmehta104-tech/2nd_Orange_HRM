package stepdefinations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.DirectoryPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import pages.PersonalDetailsPage;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class Hooks {
    public static ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest test;

    public static LoginPage loginpage;
    public static DashBoardPage dashboardPage;
    public static EmployeeListPage employeeListPage;
    public static AddEmployeePage addEmployeePage;
    public static PersonalDetailsPage personalDetailsPage;
    public static DirectoryPage directoryPage;
    

    @Before
    public void setUp(Scenario scenario) {
        BaseClass.initializeDriver();

        loginpage = new LoginPage(BaseClass.driver);
        dashboardPage = new DashBoardPage(BaseClass.driver);
        employeeListPage = new EmployeeListPage(BaseClass.driver);
        addEmployeePage = new AddEmployeePage(BaseClass.driver);
        personalDetailsPage = new PersonalDetailsPage(BaseClass.driver);
        directoryPage = new DirectoryPage(BaseClass.driver);
        

        test = ExtentManager.createTest(scenario.getName(), "Scenario execution");
        test.info("Starting scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (test != null) {
            if (scenario.isFailed()) {
                String screenshotPath = ScreenshotUtil.captureScreenshot(scenario.getName());
                test.fail("Scenario failed: " + scenario.getName());
                test.addScreenCaptureFromPath(screenshotPath);
            } else {
                test.pass("Scenario passed: " + scenario.getName());
            }
            extent.flush();
        }
        BaseClass.tearDown();
    }
}

