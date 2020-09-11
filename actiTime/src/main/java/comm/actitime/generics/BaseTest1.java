package comm.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import comm.actitime.pages.LoginPage;


public class BaseTest1 implements IAutoConstant {
	static {
		System.setProperty(CHROM_KEY,CHROM_VALUE);
	}
	public static WebDriver driver;
	@BeforeClass
	@Parameters("sBrowser")
	public void openBrowser(String sBrowser) {
		if(sBrowser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	@BeforeMethod
	public void openApplication() {
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.login();
	}
	
	
	@AfterClass
		public static void closeBrowser() {
			driver.close();
		}
	}


