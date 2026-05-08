package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtil;

public class DirectoryPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public DirectoryPage(WebDriver driver)
	{
		
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	By employeeNameTextbox = By.xpath("//div[@class=\"oxd-autocomplete-text-input oxd-autocomplete-text-input--active\"]");
	
	public void enterEmployeeNameText(String employee1)
	{
		WaitUtil.waitForElementVisible(driver, employeeNameTextbox);
		driver.findElement(employeeNameTextbox).sendKeys(employee1);
		
	}
	
	By employeeNameValues = By.xpath("//div[@role='listbox']//div[@class='oxd-autocomplete-option']");
	
	public void selectEmployeeName(String employee1)
	{
		WaitUtil.waitForElementVisible(driver, employeeNameValues);
		List<WebElement> nameSuggestions = driver.findElements(employeeNameValues);
		for(WebElement option : nameSuggestions)
		{
			if(option.getText().equalsIgnoreCase(employee1))
			{
				
				option.click();
				break;
			}
			
		}
		
	}
	
	By submitSearch = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");

	public void clickSearch()
	{
		WaitUtil.waitForElementClickable(driver, submitSearch);
		driver.findElement(submitSearch).click();
		
	}
}
