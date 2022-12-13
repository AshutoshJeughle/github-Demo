package neoStoxBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base 
{
	
	protected WebDriver driver;
	public void launchNeoStox()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\aksha\\eclipse-workspace\\Selenium\\Driver\\chromedriver_win32\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.get("https://neostox.com/");
	Reporter.log("Launching Browser ",true);
	
	}
	public static void closingBrowser(WebDriver driver) throws InterruptedException
	{
		
		
		
		
		
		
		
		
		driver.close();
		Thread.sleep(500);
		Reporter.log("Closing Browser ",true);
	}
	//closing browser
}
