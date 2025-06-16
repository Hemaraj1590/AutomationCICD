package hemaraj.AbstractComponets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hemaraj.pageojects.CartPage;

public class AbstractComponets {
	
	
	
public AbstractComponets(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);

		
	}

@FindBy(xpath="//button[text()='  Cart ']")
 WebElement cartHeader;
WebDriver driver;

public void WaitingForElementToAppear(By findBy)	
{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}

public void WaitingForWebElementToAppear(WebElement findBy)
{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
}

public CartPage goToCartPage()
{
    cartHeader.click();
	CartPage cartPage = new CartPage(driver);
	return cartPage;


}



public void WaitingForElementToDisAppear(WebElement elem)	
{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(elem));
}



}
