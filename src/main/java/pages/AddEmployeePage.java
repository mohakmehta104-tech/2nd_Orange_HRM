package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitUtil;


public class AddEmployeePage {

	WebDriver driver;
	
	By firstName = By.name("firstName");
    By middleName = By.name("middleName");
    By lastName = By.name("lastName");
    By saveButton = By.xpath("//button[@type='submit']");
    
    public AddEmployeePage(WebDriver driver)
    {
    	this.driver=driver;
    	
    }
    
    public void addEmployee(String fName, String mName, String lName) {
    	WaitUtil.waitForElementVisible(driver, firstName);
        driver.findElement(firstName).sendKeys(fName);
        WaitUtil.waitForElementVisible(driver, middleName);
        driver.findElement(middleName).sendKeys(mName);
        WaitUtil.waitForElementVisible(driver, lastName);
        driver.findElement(lastName).sendKeys(lName);
        WaitUtil.waitForElementClickable(driver, saveButton);
        driver.findElement(saveButton).click();
    }

}
