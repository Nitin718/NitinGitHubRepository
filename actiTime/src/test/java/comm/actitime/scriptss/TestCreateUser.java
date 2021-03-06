package comm.actitime.scriptss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import comm.actitime.generics.BaseTest;
import comm.actitime.generics.FWUtils;
import comm.actitime.pages.EnterTimeTrackPage;
import comm.actitime.pages.LoginPage;
import comm.actitime.pages.TestListPage;

public class TestCreateUser extends BaseTest{
	
	@Test
	public void test_Createuser() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://localhost/login.do"); 
		
		LoginPage lp=new LoginPage(driver);
	    lp.login();
		
		EnterTimeTrackPage etp=new EnterTimeTrackPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPageTitle(driver, "actiTIME - Enter Time-Track");
		etp.clickTaskTab();
		
		TestListPage tls= new TestListPage(driver);
		Thread.sleep(1000);
		FWUtils.verifyPageTitle(driver, "actiTIME - Task List");
		tls.clickOnAddNewBTN();
		tls.clickOnPlusNewCustomer();
		Thread.sleep(1000);
		tls.setNewCustomerName("NK2");
		tls.clickOnPlusCreateCustmerBTN();
		tls.listOfCustomer();
		etp.clickOnLogoutLink();
		
	}

}
