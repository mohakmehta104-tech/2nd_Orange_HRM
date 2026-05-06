package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties prop;
	
	static {
		
		
	try {
	FileInputStream fis = new FileInputStream("C:\\Users\\mohak\\eclipse-workspace\\OrangeHRMProject_2\\src\\main\\java\\config\\config.properties");
	prop = new Properties();
	prop.load(fis);
	
	}
	catch(IOException e){
		
		e.printStackTrace();
	}
	}
	
	public static String getProperty(String key)
	{
		return prop.getProperty(key);
		
	}
}
