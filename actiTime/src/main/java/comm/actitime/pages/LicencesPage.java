package comm.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LicencesPage {

	
	@FindBy(xpath="//nobr[text()='Product Edition:']/../../td[2]")
		private WebElement productEdition;
	
	@FindBy(xpath="//nobr[text()='Issue Date:']/../../td[2]")
	private WebElement issueDate;
	
	public LicencesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
public void verifyPageTitleOfLCP(WebDriver driver,String expectedTitle) {
		
	WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.titleContains(expectedTitle));
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("The Expected Page is Displayed-->"+expectedTitle);
		}
		else {
			System.out.println("The Expected Page is Not Displayed-->"+actualTitle);
		}
}
	public void verifyProductEdition() {
		 String expectedProductEdition = "actiTIME 2017.4";
		 String actualProductEdition = productEdition.getText();
		 
		 if(actualProductEdition.equals(expectedProductEdition))
		 {
			 System.out.println("The expected productEdition is Displayed-->"+expectedProductEdition);
			 System.out.println("Test Case is pass");
		 }
		 else {
			 System.out.println("The expected productEdition is not Displayed-->"+actualProductEdition);
			 System.out.println("Test Case is Fail");
		 }
		 
		}
	public void verifyIssueDate() {
		
		
		String expectedIssueDate = "Jul 14, 2017";
		 String actualIssueDate  = issueDate.getText();
		 
		 if(actualIssueDate .equals(expectedIssueDate ))
		 {
			 System.out.println("The expected IssueDate  is Displayed-->"+expectedIssueDate );
			 System.out.println("Test Case is pass");
		 }
		 else {
			 System.out.println("The expected IssueDate  is not Displayed-->"+actualIssueDate );
			 System.out.println("Test Case is Fail");
		 }
		
		
		 
	 }
	
}
