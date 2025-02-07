package magPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import magBase.Base;

public class HomePage extends Base {

	WebDriver driver;
	FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
	
	
	@FindBy(xpath = "/html/body/div[2]/header/div[2]/a/img")
	WebElement homebtn;
	@FindBy(id = "search")
	WebElement searchfield;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[4]/div/a/span/span/img")
	WebElement tshirt;
	@FindBy(id = "option-label-size-143-item-168")
	WebElement size;
	@FindBy(id = "option-label-color-93-item-50")
	WebElement colour;
	@FindBy(name = "qty")
	WebElement qty;
	@FindBy(id = "product-addtocart-button")
	WebElement addtocartbtn1;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
	WebElement addedmsg;
	@FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a/span[2]")
	WebElement carticon;
	@FindBy(xpath  = "//input[contains(@class,'item-qty cart-item-qty')  and @type='number']")
	WebElement editqty;
	@FindBy(xpath = "//button[contains(@class,'update-cart-item')]")
	WebElement update;
	@FindBy(id = "btn-minicart-close")
	WebElement cartclose;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[5]/div/div/ol/li[5]/div/a/span/span/img")
	WebElement bag;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
	WebElement outofstockmsg;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[5]/div/div/ol/li[4]/div/a/span/span/img")
	WebElement hoodie;
	@FindBy(id = "option-label-size-143-item-169")
	WebElement size2;
	@FindBy(id = "option-label-color-93-item-52")
	WebElement colour2;
	@FindBy(xpath = "//*[@id=\"product-addtocart-button\"]/span")
	WebElement addtocartbtn3;
	@FindBy(xpath = "//*[@id=\"mini-cart\"]/li[1]/div/div/div[3]/div[2]/a")
	WebElement removeitem;
	@FindBy(xpath = "//button[@class='action-primary action-accept']")
	WebElement okbtn;
	@FindBy(id = "top-cart-btn-checkout")
	WebElement chktbtn;
	
	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/div/button")
	WebElement nextbtn;
	
	@FindBy(xpath = "//*[@id=\"error-DVGJIP6\"]/span")
	WebElement missingfieldmsg;
	
	@FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")
	WebElement placeorder;
	
	@FindBy(xpath = "//input[contains(@class,'input-text valid') and @id='customer-email' ]")
	WebElement chkmail;
	@FindBy(xpath = "//input[contains(@class,'input-text') and @type='password' and @id='customer-password' ]")
	WebElement chkpass;
	@FindBy(xpath = "//input[contains(@class,'input-text') and @name='firstname' ]")
	WebElement chkfname;
	@FindBy(xpath = "//input[contains(@class,'input-text') and @name='lastname' ]")
	WebElement chklname;
	@FindBy(xpath = "//input[contains(@class,'input-text') and @type='text' and @name='company']")
	WebElement chkcom;
	@FindBy(xpath = "//input[contains(@class,'input-text') and @type='text' and @name='street[0]']")
	WebElement chkstreet;
	@FindBy(xpath = "//input[contains(@class,'input-text') and @type='text' and @name='city']")
	WebElement chkcity;
	@FindBy(xpath = "//select[(@name='region_id')]")
	WebElement chkstate;
	@FindBy(xpath = "//input[contains(@class,'input-text') and @type='text' and @name='postcode']")
	WebElement chkpin;
	@FindBy(xpath = "//select[(@name='country_id')]")
	WebElement chkcntry;
	@FindBy(xpath = "//input[contains(@class,'input-text') and @type='text' and @name='telephone']")
	WebElement chkmob;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void searchfunction() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(searchfield);
		act.perform();
		searchfield.sendKeys("shirts for women",Keys.ENTER);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",tshirt);
		tshirt.click();
		js.executeScript("arguments[0].scrollIntoView();",addtocartbtn1);
		size.click();
		colour.click();
		qty.clear();
		qty.sendKeys("2");
		addtocartbtn1.click();
		Thread.sleep(6000);
	}
	
	public void EditCart() throws InterruptedException
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",carticon);
		carticon.click();
		Thread.sleep(3000);
		editqty.sendKeys(Keys.BACK_SPACE);
		editqty.sendKeys("1");
		wait=new FluentWait<WebDriver>(driver);
		wait.until(ExpectedConditions.elementToBeClickable(update));
		update.click();
		cartclose.click();
		homebtn.click();
	}
	
	public void OutofstockMSG() throws InterruptedException
	{
		bag.click();
		addtocartbtn1.click();
		Thread.sleep(4000);
		String acttext=outofstockmsg.getText();
		String expttext="The requested qty is not available";
		if(acttext.equals(expttext))
		{
			System.out.println("Message for out of stock item displayed");
		}
		else
		{
			System.out.println("Message for out of stock item is not displayed");
		}
		homebtn.click();
		
	}
	
	public void RemoveItemffromCart() throws InterruptedException
	{
		hoodie.click();
		addtocartbtn1.click();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",addtocartbtn3);
		size2.click();
		colour2.click();
		addtocartbtn3.click();
		js.executeScript("arguments[0].scrollIntoView();",homebtn);
		homebtn.click();
		Thread.sleep(3000);
		carticon.click();
		removeitem.click();
		okbtn.click();
		homebtn.click();
	}
	
	public void checkout() throws InterruptedException
	{
		carticon.click();
		chktbtn.click();
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5)); 

		 
		wait.until(ExpectedConditions.visibilityOf(chkmail));
		chkmail.sendKeys("testingautomation350@gmail.com");
		//WebDriverWait wait1= new WebDriverWait(driver,Duration.ofSeconds(10));
		
//		chkfname.sendKeys("testing");
//		chklname.sendKeys("automation");
//		JavascriptExecutor js= (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView();",chkcom);
//		chkcom.sendKeys("ABC");
//		chkstreet.sendKeys("Xyz Street");
//		chkcity.sendKeys("Trivandrum");
//		js.executeScript("arguments[0].scrollIntoView();",chkcntry);
//		Select country=new Select(chkcntry);
//		country.selectByValue("IN");
//		Select state=new Select(chkstate);
//		state.selectByValue("550");
//		chkpin.sendKeys("123456");
//		chkmob.sendKeys("1122334455");
//		nextbtn.click();
//		Thread.sleep(4000);
//		String expmsg="This is a required field.";
//		String actmsg=missingfieldmsg.getText();
//		if(actmsg.equals(expmsg))
//		{
//			System.out.println("Message for out of stock item displayed");
//		}
//		else
//		{
//			System.out.println("Message for out of stock item is not displayed");
//			driver.findElement(By.name("lastname")).sendKeys("automation");
//		}
//		nextbtn.click();
//		driver.findElement(By.name("billing-address-same-as-shipping")).isEnabled();
//		placeorder.click();
	}
		
}
	
	
	
	
	
	

