package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;
	private static ExtentTest test;
	
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			
			ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport.html");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}
	public static ExtentTest createTest(String testName, String description) {
        test = getInstance().createTest(testName, description);
        return test;
    }
    public static ExtentTest getTest() {
        return test;
    }

}
