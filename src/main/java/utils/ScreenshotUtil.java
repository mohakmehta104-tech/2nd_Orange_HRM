package utils;

import java.io.File;
import org.openqa.selenium.io.FileHandler;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseClass;

public class ScreenshotUtil {
	
	public static String captureScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\mohak\\eclipse-workspace\\OrangeHRMProject\\screenshots\\" + testName + ".jpg");
        String path = "C:\\Users\\mohak\\eclipse-workspace\\OrangeHRMProject\\screenshots\\" + testName + ".jpg";
        
        try {
            FileHandler.copy(src, dest);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
	
	
    }
	


