package hemaraj.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import hemaraj.pageojects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException 
	{
		
		Properties prop= new Properties();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\hemaraj\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName	=System.getProperty("browser")!= null ? System.getProperty("browser") : prop.getProperty("browser");
		
	//	String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{	
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
	        System.setProperty("webdriver.edge.driver", "C:\\Users\\hemar\\eclipse-workspace\\indroduction\\src\\msedgedriver.exe");
			 driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json into string
		String jsonContent = FileUtils.readFileToString(
			    new File(filePath),
			    StandardCharsets.UTF_8	);// string to hashmap
	ObjectMapper mapper = new 	ObjectMapper();
	List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
	return data;
	}
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		driver =initializeDriver();
		landingpage = new LandingPage(driver);
		landingpage.getTo();
		 return landingpage;
	}
	@AfterMethod
	public void teardown() {
	    if (driver != null) {
	        driver.quit();  // clean shutdown of driver and browser
	    }
	}

	
	
	

}
