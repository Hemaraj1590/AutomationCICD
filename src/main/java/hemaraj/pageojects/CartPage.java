package hemaraj.pageojects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hemaraj.AbstractComponets.AbstractComponets;

public class CartPage extends AbstractComponets {
	

	
	 WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
        //page factory
	@FindBy(css=".cartSection h3")
    List< WebElement> cartProduct;
	@FindBy(css=".totalRow button:last-of-type")
     WebElement Checkout;
	
	public Boolean VerifyProductDisplay(String productname)
	{
		Boolean match =	cartProduct.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase(productname));
		 return match;

	}
	
	public CheckoutPage goToCheckout()
	{
		Checkout.click();
		  return new CheckoutPage (driver);

		


	}
	

	
}

	

