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

public class ConfirmationPage extends AbstractComponets {
	

	
	 WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
        //page factory
	
	@FindBy(css=".hero-primary")
     WebElement text;
	
	public String getconfirmMsg()
	{
		  String confirmMsg =text.getText();
		  return confirmMsg;



	}


	

	
}

	

