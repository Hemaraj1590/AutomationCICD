package hemaraj.pageojects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	

	
	 WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
        //page factory
	@FindBy(id="userEmail")
     WebElement userEmail;
	@FindBy(id="userPassword")
    WebElement passwordelement;
	@FindBy(id="login")
    WebElement submit;
	@FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		passwordelement.sendKeys(password);
		 submit.click();
			ProductCatalogue productCatalogue= new ProductCatalogue(driver);
			return productCatalogue;
		  }
	
	public String getErrorMessage()
	{
		 WaitingForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	




	private void WaitingForWebElementToAppear(WebElement errorMessage2) {
		// TODO Auto-generated method stub
		
	}

	public void getTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
