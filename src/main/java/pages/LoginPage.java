package pages;
import utils.ElementUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	//String emailText;
	String getErrorMessage;
	
	ElementUtils eleUtils = new ElementUtils(driver);
	
	public LoginPage(WebDriver driver) {
		
		this.driver =driver;
		
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath= "//input[@id='input-email']")
	private WebElement EmailAddress;
	
	
	@FindBy(name= "password")
	private WebElement PasswordField;

	
	
	public void EnterEmailAddress(String emailText) {
		
		eleUtils.EnterText(EmailAddress,emailText);
		
	//	EmailAddress.sendKeys(emailText);
		
	}



	public void EnterPassword(String passwordText) {
		
		eleUtils.EnterText(PasswordField, passwordText);
		
		//PasswordField.sendKeys(passwordText);
		
	}


	@FindBy(xpath= "//input[@value='Login']")
	private WebElement LoginButtonField;
	
	@FindBy(xpath= "//div[contains(@class,'alert-dismissible')]")
	public WebElement WarningMessage;
	

	public void ClickOnLoginButton() {

		eleUtils.ClickOnElement(LoginButtonField);
		
	//	LoginButtonField.click();
		
		
	}



	public String getErrorMessageInvalidCredentials() {
		// TODO Auto-generated method stub
		
		String getErrorMessage = WarningMessage.getText();
		return getErrorMessage;
	}


	@FindBy(xpath="//h2[text()=\"My Account\"]")
	private WebElement LoginSuccessfulConfirmation;

	public WebElement LoginSuccessful() {
		// TODO Auto-generated method stub
		
		return LoginSuccessfulConfirmation;
		
	}
	
	
}



