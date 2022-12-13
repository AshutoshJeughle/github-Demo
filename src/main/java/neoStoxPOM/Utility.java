package neoStoxPOM;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	public static void scrollIntoView(WebDriver driver, String actualName, WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0],scrollIntoView(true)", element);
		
		Reporter.log("Scrolling into viwe "+element.getText(), true);
	}
	
	public static void takScreenshoot( WebDriver driver, String filelName ) throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\aksha\\Pictures\\Selenium\\TC Photos\\"+filelName+".png");
		FileHandler.copy(src, dest);
		Reporter.log("Taking Screenshot", true);
	}
	

	public static void waitTest(WebDriver driver, int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("Wating for "+waitTime+"milis", true);
	}
	
	public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		File MyFile= new File("C:\\Users\\aksha\\eclipse-workspace\\Selenium\\EXCEL FILE\\MyExcel1.xlsx");
		Sheet mySheet =  WorkbookFactory.create(MyFile).getSheet("Sheet6");
		String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		
		Reporter.log("Reading data from Excel", true);
		
		return value;
		
	}

	

}
