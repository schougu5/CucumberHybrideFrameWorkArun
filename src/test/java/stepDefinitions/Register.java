package stepDefinitions;

import java.util.Date;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import dev.failsafe.internal.util.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import myHooks.Hooks;
import pages.HomePage;
import pages.RegisterPage;

public class Register {

	 WebDriver driver = Hooks.driver;
	 
	 HomePage homePage = new HomePage(driver);
	 RegisterPage registPage = new RegisterPage(driver);
	
	
	@Given("User navigates to Register Account Page")
	public void user_navigates_to_register_account_page() {
		
		
		
		homePage.ClickOnMyAccountOption();
		homePage.ClickOnRegisterOption();
		
		
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
		
	    
	}

	@When("User enters below field")
	public void user_enters_below_field(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
			
				
		registPage.FirstName.sendKeys(dataMap.get("firstname"));
		
		
	//	driver.findElement(By.name("firstname")).sendKeys(dataMap.get("firstname"));
		
	//	driver.findElement(By.name("lastname")).sendKeys(dataMap.get("lastname"));
		
		registPage.LastName.sendKeys(dataMap.get("lastname"));
		
		
	//	driver.findElement(By.name("email")).sendKeys(getEmailWithTimeStamp());
		
		registPage.Email.sendKeys(getEmailWithTimeStamp());
		
		
	//	driver.findElement(By.name("telephone")).sendKeys(dataMap.get("telephone"));
		
		registPage.telephone.sendKeys(dataMap.get("telephone"));
		
		
		
	//	driver.findElement(By.name("password")).sendKeys(dataMap.get("password"));
		
		registPage.password.sendKeys(dataMap.get("password"));
		
	//	driver.findElement(By.name("confirm")).sendKeys(dataMap.get("password"));
		
		registPage.confirmPassword.sendKeys(dataMap.get("password"));
		
		
	}

	private String getEmailWithTimeStamp() {
		
		Date date = new Date();
	
		String formatted_input = ("sneha.chougule_" + date + "_@gmail.com").replace(" ","_").replace(":", "_");
		
		System.out.println("value of abc is abc =" + formatted_input);
		
		return formatted_input;
		
	}
	
	@When("User enters below field with duplicate emailID")
	public void User_enters_below_field_with_duplicate_emailID(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		driver.findElement(By.name("firstname")).sendKeys(dataMap.get("firstname"));
		
		driver.findElement(By.name("lastname")).sendKeys(dataMap.get("lastname"));
				
		driver.findElement(By.name("email")).sendKeys(dataMap.get("emailID"));
		
		driver.findElement(By.name("telephone")).sendKeys(dataMap.get("telephone"));
		
		driver.findElement(By.name("password")).sendKeys(dataMap.get("password"));
		
		driver.findElement(By.name("confirm")).sendKeys(dataMap.get("password"));
		
		
	}

	
	@And("User selects privacy policy checkbox")
	public void user_selects_privacy_policy_checkbox() {
		
	
		registPage.ClickOnPrivacyPolicy();
		
		
		//driver.findElement(By.name("agree")).click();
	    
	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		
		//driver.findElement(By.linkText("Continue")).click();
	   
		registPage.ClickOnContinueButton();
		
		//driver.findElement(By.xpath("//input[contains(@value,\"Continue\")]")).click();
		
	}

	@Then("User Account should get created successfully")
	public void user_account_should_get_created_successfully() throws InterruptedException {
		
	 //Assert.isTrue(true, "Account got created successfully...");
		Thread.sleep(5);
		//div[contains(@id,"content")]//text()
	  // WebElement element = driver.findElement(By.xpath("//div[contains(@id,\"content\")]"));
		
	   WebElement element = registPage.getCongratulationMessage();
	   
	   String ExpeStr = element.getText();
	   
	   
	   System.out.println("Expected String is..." + ExpeStr);
		
	
	   Assert.assertTrue("Test case passed...acct created.",ExpeStr.contains("Congratulations"));
	// Below one is also correct
	//  assertTrue("Test case passed...acct created.", ExpeStr.contains("Congratulations"));
	
	
	
	}

	@And("User selects Yes for NewsLetter")
	public void user_selects_yes_for_news_letter() {
		
		//driver.findElement(By.xpath("//input[contains(@value,\"0\")]")).click();
		
		//input[@name="newsletter"][@value="1"]
		
		
		registPage.ClickOnYesToNewsLetter();
		//driver.findElement(By.xpath("//input[@name=\"newsletter\"][@value=\"1\"]")).click();
				
		
	}

	@Then("User should get an error about DuplicateID is not allowed")
	public void user_should_get_an_error_about_duplicate_id_is_not_allowed() {
		
		// WebElement element = driver.findElement(By.xpath("//div[contains(@class,\"alert-dismissible\")]"));
		 
		 WebElement element = registPage.getDuplicateErrorMessage();
		 
		 
		 String WarningText = element.getText();
		 System.out.println("Warning text in sysout"+ WarningText);
		//div[contains(@class,"alert-dismissible")]/text()
		
		//assertEquals(WarnigText, "E-Mail Address is already registered!");

		Assert.assertTrue("Yes, You are trying with duplicate ID", WarningText.contains("already registered"));
		
	}

	@When("User does NOT enter any field")
	public void user_does_not_enter_any_field() {
		
			
	   
	}

	@Then("User should get an error about saying no input is given.")
	public void user_should_get_an_error_about_saying_no_input_is_given() {
		
				
		//WebElement element = driver.findElement(By.xpath("//div[contains(@class,\"alert-dismissible\")]"));
		
		WebElement element = registPage.getNoInputGivenErrorMessage();
		
		String NoInputText = element.getText();
		//div[contains(@class,"alert-dismissible")]/text()
		
		//assertEquals(NoInputText, "Warning: E-mail Address is already registered!");

		Assert.assertTrue("Opps...You have not provided any input man", NoInputText.contains("must agree to the Privacy Policy"));
		
	   // Assert.fail();
	}

}
