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
import magBase.Base;

public class HomePage extends Base {

	WebDriver driver;
	FluentWait<WebDriver> wait; 
	JavascriptExecutor js;
	

	// SEARCH FUNCTIONALITY ELEMENTS
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

	// EDIT CART
	@FindBy(xpath = "/html/body/div[2]/header/div[2]/div[1]/a/span[2]")
	WebElement carticon;
	@FindBy(xpath = "//input[contains(@class,'item-qty cart-item-qty')  and @type='number']")
	WebElement editqty;
	@FindBy(xpath = "//button[contains(@class,'update-cart-item')]")
	WebElement update;
	@FindBy(id = "btn-minicart-close")
	WebElement cartclose;

	// OUT OF STOCK MESSAGE
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

	// REMOVE ITEM FROM CART
	@FindBy(xpath = "//*[@id=\"mini-cart\"]/li[1]/div/div/div[3]/div[2]/a")
	WebElement removeitem;
	@FindBy(xpath = "//button[@class='action-primary action-accept']")
	WebElement okbtn;

	// CHECKOUT
	@FindBy(id = "top-cart-btn-checkout")
	WebElement chktbtn;
	@FindBy(xpath = "//button[contains(@type,'submit') and @class='button action continue primary']")
	WebElement nextbtn;
	@FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")
	WebElement placeorder;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div/div/a/span")
	WebElement cont;
	
	// LOG OUT
	@FindBy(xpath = "//li[@class='customer-welcome active']//a[contains(text(),'Sign Out')]")
	WebElement logout;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
		wait = new FluentWait<WebDriver>(driver);

	}

	public void searchfunction() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(searchfield);
		act.perform();
		searchfield.sendKeys("shirts for women", Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", tshirt);
		tshirt.click();
		js.executeScript("arguments[0].scrollIntoView();", addtocartbtn1);
		size.click();
		colour.click();
		qty.clear();
		qty.sendKeys("2");
		addtocartbtn1.click();
		// wait.withTimeout(Duration.ofSeconds(5));
		Thread.sleep(6000);
	}

	public void EditCart() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", carticon);
		carticon.click();
		// wait.withTimeout(Duration.ofSeconds(3));
		Thread.sleep(3000);
		editqty.sendKeys(Keys.BACK_SPACE);
		editqty.sendKeys("1");
		wait.until(ExpectedConditions.elementToBeClickable(update));
		update.click();
		cartclose.click();
		homebtn.click();
	}

	public void OutofstockMSG() throws InterruptedException {
		bag.click();
		addtocartbtn1.click();
		Thread.sleep(3000);
		String acttext = outofstockmsg.getText();
		String expttext = "The requested qty is not available";
		if (acttext.equals(expttext)) {
			System.out.println("Message for out of stock item displayed");
		} else {
			System.out.println("Message for out of stock item is not displayed");
		}
		homebtn.click();
	}

	public void RemoveItemffromCart() throws InterruptedException {
		hoodie.click();
		addtocartbtn1.click();
		js.executeScript("arguments[0].scrollIntoView();", addtocartbtn3);
		size2.click();
		colour2.click();
		addtocartbtn3.click();
		js.executeScript("arguments[0].scrollIntoView();", homebtn);
		homebtn.click();
		wait.withTimeout(Duration.ofSeconds(3));
		carticon.click();
		removeitem.click();
		wait.until(ExpectedConditions.elementToBeClickable(okbtn));
		okbtn.click();
		homebtn.click();
	}

	public void checkout() throws InterruptedException {

		carticon.click();
		chktbtn.click();
		Thread.sleep(6000);
		js.executeScript("arguments[0].scrollIntoView();", nextbtn);
		//wait.until(ExpectedConditions.elementToBeClickable(nextbtn));
		nextbtn.click();
		Thread.sleep(6000);
		//js.executeScript("arguments[0].scrollIntoView();", placeorder);
		placeorder.click();
		Thread.sleep(5000);
		cont.click();
	}

	public void Logout() throws InterruptedException {
		wait.withTimeout(Duration.ofSeconds(3));
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
		wait.withTimeout(Duration.ofSeconds(3));
		logout.click();
		wait.withTimeout(Duration.ofSeconds(3));
		driver.close();

	}
}
	

