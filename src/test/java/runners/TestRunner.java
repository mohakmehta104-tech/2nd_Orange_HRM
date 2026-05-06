package runners;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import base.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ConfigReader;
import utils.RetryListener;

@CucumberOptions(
		
		features ="src\\test\\resources\\features",
		glue = "stepdefinations",
		 plugin = {"pretty"}
		
		)

@Listeners(RetryListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {

	
	
}
