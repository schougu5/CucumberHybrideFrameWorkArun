package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class SearchPage {

	
	WebDriver driver;

	ElementUtils eleUtils = new ElementUtils(driver);
	
	public SearchPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver,this);
				
	}

	
	@FindBy(name ="search")
	private WebElement SearchBoxfield;
	
	@FindBy (xpath= "//button[contains(@class,\"default btn\")]")
	private WebElement SearchButtonField;

	
	@FindBy (xpath = "//select[@id=\"input-sort\"]")
	private WebElement SortButtonDisplayed;

	
	@FindBy (xpath = "//p[text()='There is no product that matches the search criteria.']")
	private WebElement NoProductFoundMessageField;
	
	
	public void EnterInSearchBox(String producttext) {
		
		eleUtils.EnterText(SearchBoxfield, 10, producttext);
		
	//	SearchBoxfield.sendKeys(producttext);
				
	}


	public void ClickOnSearchButton() {
		
		eleUtils.ClickOnElement(SearchButtonField, 10);
		
		//SearchButtonField.click();
		
	}


	public WebElement CheckSortButtonforProductList() {
		
		return SortButtonDisplayed;
	}


	public WebElement NoProductFound() {
	
		return NoProductFoundMessageField;
		
		
		
	}
	
		
	
	
}
