package hemaraj.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import hemaraj.TestComponents.BaseTest;
import hemaraj.pageojects.CartPage;
import hemaraj.pageojects.CheckoutPage;
import hemaraj.pageojects.ConfirmationPage;
import hemaraj.pageojects.LandingPage;
import hemaraj.pageojects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinationImple extends BaseTest {
	
	LandingPage landingPage;
	ProductCatalogue productCatalogue;
	 ConfirmationPage confirmationPage;

	 @Given ("i landed on ecommerce page")
	 public void i_landed_on_ecommerce_page() throws IOException
	 {
		landingPage= launchApplication();
	 }
	 
	    @Given ("^Login with username (.+) and password (.+)$")
	    public void login_in_with_username_and_password(String username, String password)
	    {
	    	
			 productCatalogue=	landingpage.loginApplication(username, password);

	    }
	    
	   @ When ("^i added product (.+) to the cart$")
	   public void i_added_product_to_cart(String productname)
	   {
			productCatalogue.addToCart(productname);
	   }
	   
	    @When  ("checkout product (.+) and submit the order$")
	    public void checkout_product_and_sumbit_the_order(String productname)
	    {
	    	CartPage cartPage= productCatalogue.goToCartPage();
			Boolean match=cartPage.VerifyProductDisplay(productname);
		    Assert.assertTrue(match);
		    CheckoutPage checkoutPage  =  cartPage.goToCheckout();
		    checkoutPage.selectCountry("india");
		        confirmationPage =checkoutPage.submitOrder();
	     }
	    
	    @Then ("{string} message displayed on the confirmation page")
	    public void message_displayed_on_the_confirmation_page(String string)
	    {
	    	 String Confirmessage = confirmationPage.getconfirmMsg();
	         Assert.assertTrue(Confirmessage.equalsIgnoreCase(string));
	    }


	   
	   


	
	
}
