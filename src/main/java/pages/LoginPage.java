package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtil;

public class LoginPage {

	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");
	
	public void enterUsername(String user)
	{
		WaitUtil.waitForElementVisible(driver, username);
		driver.findElement(username).sendKeys(user);
		
	}
	
	public void enterPassword(String pass)
	{
		WaitUtil.waitForElementVisible(driver, password);
		driver.findElement(password).sendKeys(pass);
		
	}
	
	public void clickLogin()
	{
		
		WaitUtil.waitForElementClickable(driver, loginBtn);
		driver.findElement(loginBtn).click();
	}
	
	
}
