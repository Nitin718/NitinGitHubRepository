package comm.actitime.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestListPage {

@FindBy(xpath="//div[text()='Add New']")
private WebElement addNewBTN;

@FindBy(xpath="//div[text()='+ New Customer']")
private WebElement plusNewCustomerBTN;

@FindBy(id="customerLightBox_nameField")
private WebElement EnterCustomerNameTB;

@FindBy(xpath="//span[text()='Create Customer']")
private WebElement plusCreateCustomerBTN;

@FindBy(xpath = "//div[@class='itemsContainer']//div[@class='title']")
private List<WebElement>  allCustomername;

public TestListPage(WebDriver driver) {

	PageFactory.initElements(driver, this);
  }

public void verifyPageTitleOfTLP(WebDriver driver,String expectedTitle) {
	
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

    public void clickOnAddNewBTN() {
	addNewBTN.click();
}
	public void clickOnPlusNewCustomer() {
	plusNewCustomerBTN.click();
	}
	
	public void setNewCustomerName(String custName) {
		EnterCustomerNameTB.sendKeys(custName);
	}
	public void clickOnPlusCreateCustmerBTN() {
		plusCreateCustomerBTN.click();
	}
	public void listOfCustomer() {
    int count = allCustomername.size();
    for(WebElement cn:allCustomername) {
    	
    	String s = cn.getText();
    	System.out.println(s);
    	if(s.equals("Nitin")) {
    		System.out.println("customer create Success");
    	}
    	
    }
	}
}

