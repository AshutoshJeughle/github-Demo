package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;



public class NeoStoxPasswordPage 
{
	@FindBy(xpath ="//input[@type='password']") private WebElement password;
	@FindBy(xpath ="//a[@id='lnk_submitaccesspin']") private WebElement SubmitButon;
	

	
	public NeoStoxPasswordPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void EnterPassword(String usrPass)
	{
		password.sendKeys(usrPass);
		Reporter.log("Sendng password", true);
	}
	
	public void ClickOnSubmitButton(WebDriver driver)
	{
		if(SubmitButon.isDisplayed())
		  {
			  SubmitButon.click();	
			  Reporter.log("Click on submit button", true);
			  
		  } 
		 
		
	}

}
