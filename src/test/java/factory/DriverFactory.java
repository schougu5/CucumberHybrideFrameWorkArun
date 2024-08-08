package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static WebDriver driver;
			
	public static WebDriver InitiaseDriver(String browserName) {
		
		//System.out.println(browserName + "Inside method");
		
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			 driver = new ChromeDriver();
			
		}else {
			
			System.out.println("BrowserName is NOT provided...");
			
			
		}
		return driver;
		
	}
	
	
	public static WebDriver getDriver() {
		
		return driver;
	}
	
}
