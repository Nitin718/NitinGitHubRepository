 package comm.actitime.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWUtils  {

	public static void verifyPageTitle(WebDriver driver,String expectedTitle) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		String actualTitle =driver.getTitle();
		if(actualTitle.equals(expectedTitle)){
			System.out.println("the exp. page is displayed--->"+expectedTitle);
		}
		else {
			System.out.println("Page not displayed-->"+actualTitle);
		}
	
	}
	public static String read_XL_Data(String path,String sheet,int row,int cell)
	{
		String data="";
		try
		{
		    Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		    data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	public static int read_XL_RowCount(String path,String sheet)
	{
		int data=0;
		try
		{
		    Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		    data = wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	public static int set_XL_Data(String path,String sheet,int row,int cell,int data)
	{
		
		try
		{
		    Workbook wb = WorkbookFactory.create(new FileInputStream(path));
		    wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(data);
		    
		    wb.write(new FileOutputStream(path));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return data;
	}
	
	
	public static void take_Screen_Shot(WebDriver driver,String path) {
		try {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File des= new File(path);
		FileUtils.copyFile(src, des);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
	}
