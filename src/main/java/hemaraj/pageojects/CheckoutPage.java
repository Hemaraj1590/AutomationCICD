package hemaraj.pageojects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import hemaraj.AbstractComponets.AbstractComponets;

public class CheckoutPage extends AbstractComponets {
	

	
	 WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
        //page factory
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
     WebElement country;
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
    WebElement submit;
	@FindBy(css=".ta-item:last-of-type")
    WebElement selectcountry;
	By results=By.cssSelector(".ta-results");
	
	
	public void selectCountry(String countryName)
	{
		 Actions a = new Actions(driver);
         a.sendKeys((country),  countryName).build().perform();
         WaitingForElementToAppear(results);
         selectcountry.click();
     }
	
	public ConfirmationPage submitOrder()
	{
		submit.click();
		  return new ConfirmationPage (driver);

	}
	

	

	
}

	

