package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxSignInPage 
{
	@FindBy(id= "lnk_signup1") private WebElement SignInBUtton;
	@FindBy(xpath ="(//input[@type='number'])[1]") private WebElement MoNum;
	
	
	public NeoStoxSignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickOnSignInBUtton()
	{
		SignInBUtton.click();
		Reporter.log("Click on Sign In Button", true);
	}
	public void EnterMoNum(String userMO)
	{
		MoNum.sendKeys(userMO);
	    Reporter.log("Sendng Mobile Number", true);
	
	}
	

}
