package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	
	WebDriver driver;
	
	public static final int IMPLICIT_wait_userDefined = 10;
	
	public ElementUtils(WebDriver driver) {

		this.driver = driver;
						
	}	
	
	
	public void ClickOnElement( WebElement element ) {
		
		ExplicitWait( element, IMPLICIT_wait_userDefined );
		
	
	//	WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
	//	WebElement webElement =wait.until(ExpectedConditions.elementToBeClickable(element));
		
		element.click();
		
		
				
	}


	public void EnterText(WebElement element, String text) {
		
		ExplicitWait( element, IMPLICIT_wait_userDefined );
		
		element.clear();
		
				
	//	WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
	//	WebElement webElement =wait.until(ExpectedConditions.elementToBeClickable(element));
		
		element.sendKeys(text);
		
	}
	
	
	public void ExplicitWait( WebElement element, int durationInSeconds ) {
		
		WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}


	public void ClickOnCheckbox(WebElement Checkbox) {
		
	
		Checkbox.click();
		
		
		
	}
	
}
