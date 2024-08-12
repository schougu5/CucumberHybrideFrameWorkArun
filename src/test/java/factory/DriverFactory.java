package factory;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static WebDriver driver;
			
	public static WebDriver InitiaseDriver(String browserName) {
		
		//System.out.println(browserName + "Inside method");
		
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			 driver = new ChromeDriver();
			 
			System.out.println("Set the Chrome driver using new keyword");
			
		}else {
			
			System.out.println("BrowserName is NOT provided...");
			
			
		}
		System.out.println("ChromeDriver initialized: " + driver);
		return driver;
		
	}
	
	
	public static WebDriver getDriver() {
		
		System.out.println("ChromeDriver value inside the getDriver method: " + driver);
		return driver;
		
		
	}
	
}
