package pages;
import utils.ElementUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	

	WebDriver driver;
	
	ElementUtils eleUtils = new ElementUtils(driver);
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
			
		
	}
	
		
	@FindBy(xpath= "//span[text()='My Account']")
	private WebElement MyAccountOption;
	
	
	public void ClickOnMyAccountOption() {
		
		
		eleUtils.ClickOnElement(MyAccountOption);
		
		//MyAccountOption.click();
		
	}

	
	@FindBy(linkText = "Login")
	private WebElement LoginOption;
	
	@FindBy(linkText = "Register")
	private WebElement RegisterOption;
	
	
	public void ClickOnLoginOption() {
		
		eleUtils.ClickOnElement(LoginOption);
		
		//LoginOption.click();
	}


	public void ClickOnRegisterOption() {
		// TODO Auto-generated method stub
		
		RegisterOption.click();
		
	}
	
	
}
