package hemaraj.testcases;

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

import hemaraj.pageojects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/client");
		LandingPage landingpage = new LandingPage(driver);
		driver.findElement(By.id("userEmail")).sendKeys("hemaraj@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Uber12345");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));


		
	List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	WebElement pro=products.stream().filter(product->
	product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
	pro.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	driver.findElement(By.xpath("//button[text()='  Cart ']")).click();
	
List<WebElement> cart=driver.findElements(By.cssSelector(".cartSection h3"));
Boolean carts =	cart.stream().anyMatch(cartproduct-> cartproduct.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
Assert.assertTrue(carts);
 
 driver.findElement(By.cssSelector(".totalRow button:last-of-type")).click();
 
 Actions a = new Actions(driver);
     
  a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
  
  
  driver.findElement(By.cssSelector(".ta-item:last-of-type")).click();
  driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
  String confirmMsg =driver.findElement(By.cssSelector(".hero-primary")).getText();
Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	
	
	
	
	
	
	



	}

}
