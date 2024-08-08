package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import io.cucumber.java.en.*;
//import junit.framework.Assert;
import myHooks.Hooks;
import pages.SearchPage;



public class Search {

	WebDriver driver = Hooks.driver;
	
	SearchPage searchPage = new SearchPage(driver);
	
	@Given("User opens the application")
	public void user_opens_the_application() {
	    
		System.out.println("Application opened using Hooks method");
	}

	@When("User enters {string} in search box")
	public void user_enters_in_search_box(String producttext) {
		
		searchPage.EnterInSearchBox(producttext);
		
		
	    
		//driver.findElement(By.name("search")).sendKeys(producttext);
		
	}

	@And("User clicks on Search button")
	public void user_clicks_on_search_button() {
	   
		//button[contains(@class,"default btn")]
		
		searchPage.ClickOnSearchButton();
		
		
		//driver.findElement(By.xpath("//button[contains(@class,\"default btn\")]")).click();
		
		//select[@id="input-sort"]
		
		
	}

	@Then("User should get valid product list")
	public void user_should_get_valid_product_list() {
		
	//	Assert.isTrue(driver.findElement(By.xpath("//select[@id=\"input-sort\"]")).isDisplayed(), "Product List appeared");
		
		//searchPage.CheckSortButtonforProductList();
		
		
		
		//Assert.assertTrue("Product List appeared", driver.findElement(By.xpath("//select[@id=\"input-sort\"]")).isDisplayed());
		
		
		Assert.assertTrue("Product List appeared", searchPage.CheckSortButtonforProductList().isDisplayed());
		   
	}

	@Then("User should get an error about no product matching")
	public void user_should_get_an_error_about_no_product_matching() {
	   
		
		WebElement element = searchPage.NoProductFound();
		
		
		//WebElement element = driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']"));
		
		String ExpectStr = element.getText();
		
		//Assert.isTrue(driver.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).isDisplayed(), "Product List is NOT appeared");
		//Assert.assertEquals("There is no product that matches the search criteria.", true);
		
		Assert.assertEquals("There is no product that matches the search criteria.", ExpectStr);
	}

	@When("User does NOT enter anything in search box")
	public void user_does_not_enter_anything_in_search_box() {
	    
	}



}
