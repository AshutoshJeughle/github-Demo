package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class neoStoxHomePage 
{
	@FindBy(xpath="//span[@id='lbl_username']")private WebElement UserName;
	@FindBy(xpath="//span[@id='lbl_curbalancetop']")private WebElement ACBalance;
	@FindBy(xpath="//span[text()='Logout']")private WebElement LogOutButton;
	
	
	public neoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public String getUserName()
	{
		String actualName = UserName.getText();
		Reporter.log("Getting actual user name "+actualName, true);
		
		return actualName;
	}
	public String GetingACBalance()
	{
		
		
		
		
		
		
		String Balance = ACBalance.getText();
		Reporter.log("Getting A/C Balanace "+Balance, true);
		return Balance;
	}
	public void ClickOnLogOutButton(WebDriver driver)
	{
		UserName.click();
		Utility.waitTest(driver, 500);
		LogOutButton.click();
		Reporter.log("Click on log out button ", true);
		
	}
	

}
