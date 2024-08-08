package myHooks;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.*;
import utils.ConfigReader;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public static void setup() throws IOException {
		
		
		Properties prop = ConfigReader.InitiliazeProperties();
		
		String browser = prop.getProperty("browser");
		System.out.println("Browser is: " + browser);  
		
		String url = prop.getProperty("url");
		System.out.println("url is: " + url);  //
		
		
		
		driver = DriverFactory.InitiaseDriver(browser);
		
		driver = DriverFactory.getDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		//read.sleep(10);
		
		//driver.manage().timeouts().implicitlyWait(TimeUnit.SECONDS(1));
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		
		driver.get(url);
		
		//Thread.sleep(10);
		
			
		}
	
	
	

	@After
	public static void tearDown(Scenario scenario) {
		
		String ScenarioName = scenario.getName().replaceAll(" ","_");
		
		System.out.println(ScenarioName + "Scenario Name fetched in Sysout");	
		
		if (scenario.isFailed()) {
			
			byte[] scrScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(scrScreenshot,"image/png", ScenarioName);
			
		}
		
		
		
		
	driver.quit();

		
	}
	

}
