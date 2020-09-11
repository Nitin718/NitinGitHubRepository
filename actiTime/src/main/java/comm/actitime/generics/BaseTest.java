package comm.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import comm.actitime.pages.LoginPage;




public class BaseTest implements IAutoConstant {
	static {
		System.setProperty(CHROM_KEY,CHROM_VALUE);
	}
	public static WebDriver driver;
	 public static int passCount=0,failCount=0;
	
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
	@AfterMethod
	public void closeBrowser(ITestResult res) {
		
		
		int status = res.getStatus();
		//status 1 for pass,2 for fail,3 for skip
		String methodName = res.getName();
		if(status==1) {
			passCount++;
		}
		else {
			failCount++;
			//"./photo/methodName.png"-its present in PHOTO_PATH
		      String path = PHOTO_PATH+methodName+".png";
			  FWUtils.take_Screen_Shot(driver,path);
		}
		driver.close();
	}
	@AfterSuite
	public void printReport() {
		Reporter.log("PassCount :"+passCount,true);
		Reporter.log("FailCount :"+failCount,true);
		FWUtils.set_XL_Data(REPORT_PATH,"result", 1, 0,passCount);
		FWUtils.set_XL_Data(REPORT_PATH,"result", 1, 1,failCount);
	}
}


