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
	By leaveElement = By.xpath("//a[@class='oxd-main-menu-item active']");
	By timeElement = By.xpath("//span[normalize-space()='Time']");
	By recruitmentElement = By.xpath("//span[normalize-space()='Recruitment']");
	By myInfoElement = By.xpath("//span[normalize-space()='My Info']");
	
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
	
	public void clickLeave()
	{
		
		WaitUtil.waitForElementClickable(driver, leaveElement);
		driver.findElement(leaveElement);
	}
	
	public void clickTime()
	{
		
		WaitUtil.waitForElementClickable(driver, timeElement);
		driver.findElement(timeElement);
	}
	
	public void clickRecruitment()
	{
		
		WaitUtil.waitForElementClickable(driver, recruitmentElement);
		driver.findElement(recruitmentElement);
	}
	
	public void clickMyInfo()
	{
		
		WaitUtil.waitForElementClickable(driver, myInfoElement);
		driver.findElement(myInfoElement);
	}

}
