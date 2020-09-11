package comm.actitime.scriptss;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import comm.actitime.generics.BaseTest1;
import comm.actitime.pages.LoginPage;

public class TestInvalidLoginPage  extends BaseTest1{
	
	@Test
	public  void tets_InvalidLogin() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://localhost/login.do"); 
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("admin");
		lp.clickOnLgnBTN();
		lp.VerifyErrMsg(driver);
		Thread.sleep(1000);
		 //1
		
		lp.setPassword("manager");
		lp.clickOnLgnBTN();
		Thread.sleep(1000);
		lp.VerifyErrMsg(driver);  //2
		
		
		
		lp.setUsername("admin111");
        lp.setPassword("manger1111");
        lp.clickOnLgnBTN();
        Thread.sleep(1000);
        lp.VerifyErrMsg(driver);  //3
        
        
		
        lp.setUsername("12466");
        lp.setPassword("5555465");
        lp.clickOnLgnBTN();
        Thread.sleep(1000);
        lp.VerifyErrMsg(driver); //4
        
        
        
        lp.setUsername("");
        lp.setPassword("");
        lp.clickOnLgnBTN();
        Thread.sleep(1000);
        lp.VerifyErrMsg(driver);  //5
        
        
        lp.clickOnLgnBTN();
        Thread.sleep(1000);
        lp.VerifyErrMsg(driver);  //6
        
        driver.close();
	}

}
