package hemaraj.pageojects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hemaraj.AbstractComponets.AbstractComponets;

public class ProductCatalogue extends AbstractComponets {
	

	
	 WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
        //page factory
	@FindBy(css=".mb-3")
    List< WebElement> products;
	@FindBy(css=".ng-animating")
     WebElement spinning;
	@FindBy(xpath="//button[text()='  Cart ']")
    By clickingCart;
	
	
	
	By productsby =By.cssSelector(".mb-3");
	By addToCart =By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	public List<WebElement> getProducts() {
	    new WebDriverWait(driver, Duration.ofSeconds(10))
	        .until(ExpectedConditions.visibilityOfElementLocated(productsby));
	    return products;
	}

	
	public WebElement  getTheProductName(String productname)
	{
		WebElement prod=getProducts().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
	
	public void addToCart(String productname) {
	    WebElement prod = getTheProductName(productname);

	    if (prod == null) {
	        System.out.println("ERROR: Product '" + productname + "' not found.");
	        throw new RuntimeException("Product '" + productname + "' not found on the page.");
	    }

	    prod.findElement(addToCart).click();
	    WaitingForElementToAppear(toastmessage);
	    WaitingForElementToDisAppear(spinning);
	}

	
}

	

