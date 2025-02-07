package magTest;

import java.time.Duration;
import magBase.Base;
import magPage.HomePage;
import magPage.LoginPage;
import magUtil.Utility;


public class Test extends Base {

	@org.testng.annotations.Test
	public void Login() throws InterruptedException {
		LoginPage ob = new LoginPage(driver);
		HomePage ob2=new HomePage(driver);
		String file = "C:\\Users\\HP\\OneDrive\\Desktop\\MagentoReg.xlsx";
		String sheet = "Sheet1";

		int rowcount = Utility.getRowCount(file, sheet);
		//ob.SignInPage();
//		for (int i = 1; i <= rowcount; i++) {
//			String email = Utility.getCellValue(file, sheet, i, 0);
//			System.out.println("Email : " + email);
//			String password = Utility.getCellValue(file, sheet, i, 1);
//			System.out.println("Password : " + password);
//
//			ob.Data(email, password);
//			ob.Login();
//			
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//			String expturl="https://magento.softwaretestingboard.com/";
//			String acturl=driver.getCurrentUrl();
//			
//			if(acturl.equalsIgnoreCase(expturl))
//			{
//				System.out.println("Login successful!");
//			}
//			else
//			{
//				System.out.println("Login not successful.");
//			}
//		}
		
		ob2.searchfunction();
		//ob2.EditCart();
		//ob2.OutofstockMSG();
		//ob2.RemoveItemffromCart();
		ob2.checkout();
		
		
	}
}