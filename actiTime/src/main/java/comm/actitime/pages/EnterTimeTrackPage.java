package comm.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterTimeTrackPage {

	@FindBy(xpath="//div[text()='TASKS']/parent::a[@class='content tasks']")
	private WebElement taskTab;
	
	@FindBy(xpath="(//div[contains(text(),'Settings')])[1]")
	private WebElement settingMenu;
	
	@FindBy(xpath="//a[text()='Licenses']")
	private WebElement licensesLink;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyPageTitleOfETP(WebDriver driver,String expectedTitle) {
		
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
	
	public void clickTaskTab() {
		taskTab.click();
	}
	public void clickOnSettingMenu() {
		settingMenu.click();
		}
	
	public void clickOnLicensesLink() {
		licensesLink.click();
	}
	public void clickOnLogoutLink() {
		logoutLink.click();
	}
	
}
