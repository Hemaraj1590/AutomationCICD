package hemaraj.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import hemaraj.TestComponents.BaseTest;
import hemaraj.pageojects.CartPage;
import hemaraj.pageojects.CheckoutPage;
import hemaraj.pageojects.ConfirmationPage;
import hemaraj.pageojects.LandingPage;
import hemaraj.pageojects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {


	@Test(dataProvider="getData", groups = {"Purchase"})
	public void sumbitOrder(HashMap<String, String> input) throws IOException
	{
		
	
		String productname="ADIDAS ORIGINAL";
		
		ProductCatalogue productCatalogue=	landingpage.loginApplication(input.get("email"), input.get("Password"));
        List<WebElement> products=productCatalogue.getProducts();
		productCatalogue.addToCart(productname);
        CartPage cartPage= productCatalogue.goToCartPage();
		Boolean match=cartPage.VerifyProductDisplay(productname);
	    Assert.assertTrue(match);
	    CheckoutPage checkoutPage  =  cartPage.goToCheckout();
	    checkoutPage.selectCountry("india");
	    ConfirmationPage confirmationPage =checkoutPage.submitOrder();
	    String Confirmessage = confirmationPage.getconfirmMsg();
        Assert.assertTrue(Confirmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	public String getScreenShot(String testCaseName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		ts.getScreenshotAs(OutputType.FILE);
		
		File source = null;
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
		
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{ 
		List<HashMap<String, String>> data =getJsonDataToMap("C:\\Users\\hemar\\eclipse-workspace\\SelenumFrameworkDesign\\src\\test\\java\\hemaraj\\data\\PurchaseOrder.json") ;
		return new Object [][] { {data.get(0)}, {data.get(1)}};
	}
	
}
