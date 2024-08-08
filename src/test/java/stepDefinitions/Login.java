package stepDefinitions;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myHooks.Hooks;
import pages.HomePage;
import pages.LoginPage;

public class Login  {
	
		
	 WebDriver driver = Hooks.driver;
	
	 LoginPage loginPage = new LoginPage(driver);
	 
	 
	 
	 
	
	@Given("User is navigated to Login Page")
	public void User_is_navigated_to_Login_Page() {
		
		//System.out.println("Inside the user is navigated to login page method...");
		HomePage homePage = new HomePage(driver);

			
		homePage.ClickOnMyAccountOption(); // Hard coding of find element is handled by Page Factory
		
	//	driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		
		homePage.ClickOnLoginOption();
		
		
		//driver.findElement(By.linkText("Login")).click();
		
				
		
	}
	
	
	@When("^User enters valid email address (.+)$")
	public void	User_enters_valid_email_address (String emailText) throws InterruptedException {
		
		//Thread.sleep(5);
		
		//LoginPage loginPage = new LoginPage(driver);
		
		loginPage.EnterEmailAddress(emailText);
	//	driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(emailText);
	
	}

	
	@And("^User enters valid password as (.+)$")
	public void user_enters_valid_password_as(String PasswordText) {
	    
		
		loginPage.EnterPassword(PasswordText);
		//driver.findElement(By.name("password")).sendKeys(PasswordText);
	 
	}

	@And("User clicks on Login Button")
	public void user_clicks_on_login_button() {
	    
		
		loginPage.ClickOnLoginButton();
		
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}

	@Then("User should get logged in successfully")
	public void user_should_get_logged_in_successfully() throws InterruptedException {
		
		Thread.sleep(10);
		
	//	WebElement element = driver.findElement(By.linkText("Edit your account information"));
		
		//h2[text()="My Account"]
		
		
		loginPage.LoginSuccessful();
		
		//WebElement element = driver.findElement(By.xpath("//h2[text()=\"My Account\"]"));
		
		WebElement element = loginPage.LoginSuccessful();
        
        // Assert that the element is displayed
//        Assert.assertTrue("Element should be displayed", element.isDisplayed(),0.0001);
//        Assert.isTrue(false, null, null);
   //     Assert.isTrue(element.isDisplayed(), "Element should be displayed");
        
	   Assert.assertTrue("Element should be displayed", element.isDisplayed());
	}
	
	@When("User enters Invalid email address")
	public void user_enters_invalid_email_address() {
		
		loginPage.EnterEmailAddress(getEmailWithTimeStamp());
		
		//driver.findElement(By.name("email")).sendKeys(getEmailWithTimeStamp());
	    
	}
	private String getEmailWithTimeStamp() {
		
		Date date = new Date();
	
		String formatted_input = ("sneha.chougule_" + date + "_@gmail.com").replace(" ","_").replace(":", "_");
		
		System.out.println("value of abc is abc =" + formatted_input);
		
		return formatted_input;
		
	}
	
	
	@And("User enters Invalid password as {string}")
	public void user_enters_invalid_password_as(String InvalidPasswordText) 	{
	   
		
		loginPage.EnterPassword(InvalidPasswordText);
		
		//driver.findElement(By.name("password")).sendKeys(InvalidPasswordText);
		
	}

	
	
	@Then("User should get error about invalid credentials")
	public void user_should_get_error_about_invalid_credentials() {
		
		//div[contains(@class,"alert-dismissible")]
		
		//driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password")

		//Assert.isTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password"), "Warning matching..." );
		
		//loginPage.getErrorMessageInvalidCredentials();
		
		//Assert.assertTrue("Warning matching...", driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password"));
		
		
	//	String getErrorMessage;
		
		
		Assert.assertTrue("Warning matching...", loginPage.getErrorMessageInvalidCredentials().contains("Warning: No match for E-Mail Address and/or Password"));
				
				
				
		
	
	}
	

	@When("User does not enter an email address")
	public void user_does_not_enter_an_email_address() {
		
		System.out.println("Not provided any input as per the method");
	   
	}

	@And("User does not enter a password")
	public void user_does_not_enter_a_password() {
	    
		System.out.println("Not provided any input as per the method");
		
	}

	
}
