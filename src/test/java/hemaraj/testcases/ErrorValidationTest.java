package hemaraj.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import hemaraj.TestComponents.BaseTest;
import hemaraj.pageojects.CartPage;
import hemaraj.pageojects.CheckoutPage;
import hemaraj.pageojects.ConfirmationPage;
import hemaraj.pageojects.LandingPage;
import hemaraj.pageojects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest {


	@Test
	public void loginPageErrorValidation() throws IOException
	{
		String productname="ADIDAS ORIGINAL";
		ProductCatalogue productCatalogue=	landingpage.loginApplication("hemaravj@gmail.com", "Uber123456");
		landingpage.getErrorMessage();
       Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	
	
	}
	@Test
	public void productErrorValidation() throws IOException
	{
		
	
		String productname="ADIDAS ORIGINAL";
		
		ProductCatalogue productCatalogue=	landingpage.loginApplication("hemaraj@gmail.com", "Uber12345");
        List<WebElement> products=productCatalogue.getProducts();
		productCatalogue.addToCart(productname);
        CartPage cartPage= productCatalogue.goToCartPage();
		Boolean match=cartPage.VerifyProductDisplay("ADIDASD ORIGINAL");
	    Assert.assertFalse(match);
	   
	}

}
