package magBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {


public WebDriver driver;
	
	@BeforeClass
	public void SetUp()
	{
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void openpage()
	{
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
	}
}
