package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtil;

public class DashBoardPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public DashBoardPage(WebDriver driver)
	{
		
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	By adminElement = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']");
	By directoryElement = By.xpath("//a[@class=\"oxd-main-menu-item active\"]");
	By pimMenu = By.xpath("//span[text()='PIM']");
	
	public void clickAdminElement()
	{
		WaitUtil.waitForElementClickable(driver, adminElement);
		driver.findElement(adminElement).click();
	}
	
	public void clickDirectoryElement()
	{
		WaitUtil.waitForElementClickable(driver, directoryElement);
		driver.findElement(directoryElement).click();
		
	}
	
	public void clickOnPIM()
	{
		
		WaitUtil.waitForElementClickable(driver, pimMenu);
		driver.findElement(pimMenu).click();
		
	}

}
