package comm.actitime.scriptss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import comm.actitime.generics.BaseTest;
import comm.actitime.generics.FWUtils;
import comm.actitime.pages.EnterTimeTrackPage;
import comm.actitime.pages.LicencesPage;
import comm.actitime.pages.LoginPage;

public class TestProductionEdition extends BaseTest{
	
	
@Test
	public void test_ProductEdition() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://localhost/login.do"); 
		
		LoginPage lp=new LoginPage(driver);
	    lp.login();
		
		EnterTimeTrackPage etp=new EnterTimeTrackPage(driver) ;
		FWUtils.verifyPageTitle(driver, "actiTIME - Enter Time-Track");
		etp.clickOnSettingMenu();
		etp.clickOnLicensesLink();
		
		LicencesPage lcp = new LicencesPage(driver);
		FWUtils.verifyPageTitle(driver, "actiTIME - Licenses");
		lcp.verifyProductEdition();
		etp.clickOnLogoutLink();
		driver.close();
		
		
		
	}

}
