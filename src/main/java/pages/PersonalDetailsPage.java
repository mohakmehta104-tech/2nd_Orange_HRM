package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalDetailsPage {
	
	WebDriver driver;
	
	By employeeNameHeader = By.xpath("//div[@class='orangehrm-edit-employee-name']/h6");
	
	public PersonalDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public boolean verifyEmployee(String expectedName) {
        String actualName = driver.findElement(employeeNameHeader).getText();
        return actualName.contains(expectedName);
    }
	
	
	
	

}
