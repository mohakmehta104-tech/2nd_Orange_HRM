package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtil;

public class EmployeeListPage {
	
	WebDriver driver;
	By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	
	public EmployeeListPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public void clickAddButton() {
		
		WaitUtil.waitForElementClickable(driver, addButton);
        driver.findElement(addButton).click();
    }

}
