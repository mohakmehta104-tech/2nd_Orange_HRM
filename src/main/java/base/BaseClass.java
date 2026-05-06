package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ConfigReader;
import utils.LoggerUtil;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void initializeDriver()
	{
		
		String browser = ConfigReader.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			LoggerUtil.logger.info("Browser was launched");
			
		}
		
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("url"));
		LoggerUtil.logger.info("URL is opened successfully");
		
	}
	
	public static void tearDown()
	{
		
		driver.quit();
	}
}
