package pages;
import utils.ElementUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	ElementUtils eleUtils = new ElementUtils(driver);
	
	public RegisterPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	@FindBy(name= "firstname")
	public WebElement FirstName;
	
	@FindBy(name= "lastname")
	public WebElement LastName;

	@FindBy(name= "email")
	public WebElement Email;

	@FindBy(name= "telephone")
	public WebElement telephone;

	@FindBy(name= "password")
	public WebElement password;

	
	@FindBy(name= "confirm")
	public WebElement confirmPassword;

	@FindBy(name= "agree")
	private WebElement PrivacyPolicyCheckbox;

	
	@FindBy(xpath= "//input[contains(@value,\"Continue\")]")
	private WebElement ContinueButton;

	
	@FindBy(xpath = "//div[contains(@class,\"alert-dismissible\")]")
	private WebElement getDuplicateErrorMessageField;

	
	@FindBy(xpath= "//div[contains(@id,\"content\")]")
	private WebElement getCongratulationMessageText;

	
	@FindBy(xpath ="//input[@name=\"newsletter\"][@value=\"1\"]")
	private WebElement YesToNewsLetterField;

	
	

	public void ClickOnPrivacyPolicy() {
		
		eleUtils.ClickOnCheckbox(PrivacyPolicyCheckbox);
		
		
	//	PrivacyPolicyCheckbox.click();
		
	}


	public void ClickOnContinueButton() {
		
		eleUtils.ClickOnElement(ContinueButton, 10);
		
		//ContinueButton.click();
		
	}


	public WebElement getDuplicateErrorMessage() {
		
		return getDuplicateErrorMessageField;
		
	}


	public WebElement getCongratulationMessage() {
		
		return getCongratulationMessageText;
		
	}
	
	public void ClickOnYesToNewsLetter() {
		
		eleUtils.ClickOnElement(YesToNewsLetterField, 10);
		
		//YesToNewsLetterField.click();
	}

	@FindBy(xpath = "//div[contains(@class,\"alert-dismissible\")]")
	private WebElement getNoInputGivenErrorMessageField;
	
	
	public WebElement getNoInputGivenErrorMessage() {
		// TODO Auto-generated method stub
		return getNoInputGivenErrorMessageField;
	}
	
	
	
	
	
	
}
