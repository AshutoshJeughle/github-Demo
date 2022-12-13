package neoStoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HiddenPopUpPage 
{
	@FindBy(xpath ="(//a[@class='btn btn-sm neobutton'])[7]") private WebElement OkButton;
	@FindBy(xpath ="(//a[text()='Close'])[5]") private WebElement closeButton;
	
	public HiddenPopUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickOnOKButton()
	{
		if(OkButton.isDisplayed())
		{
		OkButton.click();
		Reporter.log("Clicking on popUp Ok button", true);
	    }
		else
		{
			Reporter.log("popUp Ok button is not display", true);
		}
	}
	public void clickOnColseButton()
	{ 
		if(closeButton.isDisplayed())
		{
		closeButton.click();
		Reporter.log("Clicking on popUp close button", true);
		}
		else
		{
			Reporter.log("popUp close button is not display", true);
		}
	}

}
