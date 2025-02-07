package magPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import magBase.Base;

public class LoginPage extends Base {
	
	WebDriver driver;
	//FluentWait<WebDriver> wait;
	@FindBy(xpath ="/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
	WebElement signin;
	@FindBy(id = "email")
	WebElement mail;
	@FindBy(id = "pass")
	WebElement pswd;
	@FindBy(name = "send")
	WebElement signinbtn;


	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void SignInPage()
	{
		signin.click();
	}
	
	public void Data(String email, String password)
	{
		mail.clear();
		mail.sendKeys(email);
		pswd.clear();
		pswd.sendKeys(password);
	}
	
	public void Login()
	{
		signinbtn.click();
		
		
	}
	
	
}