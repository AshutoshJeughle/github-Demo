package neoStoxTestCase;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBase.Base;
import neoStoxPOM.HiddenPopUpPage;
import neoStoxPOM.NeoStoxPasswordPage;
import neoStoxPOM.NeoStoxSignInPage;
import neoStoxPOM.Utility;
import neoStoxPOM.neoStoxHomePage;


public class ValidationNeoStoxUserId extends Base
{
  NeoStoxSignInPage SignIn;
  NeoStoxPasswordPage Password;
  HiddenPopUpPage popUp;
  neoStoxHomePage Home;
  
  @BeforeClass
  public void LaunchBrowser()
  {
	  launchNeoStox();
	  SignIn= new NeoStoxSignInPage(driver);
	  Password = new NeoStoxPasswordPage(driver);
	  Home = new neoStoxHomePage(driver);
	  popUp = new HiddenPopUpPage(driver);
	 
  }
  @BeforeMethod
  public void LogInToNeoStox() throws EncryptedDocumentException, IOException
  {
	  Utility.waitTest(driver, 500);
	  SignIn.EnterMoNum(Utility.readDataFromExcel(5, 0));
	  SignIn.ClickOnSignInBUtton();
	  Utility.waitTest(driver, 500);
	  Password.EnterPassword(Utility.readDataFromExcel(4, 1));
	  
	  Utility.waitTest(driver, 1000);
	  Password.ClickOnSubmitButton(driver);
	  
	  Utility.waitTest(driver, 1500);
	  popUp.ClickOnOKButton();
	  Utility.waitTest(driver, 1000);

	  popUp.clickOnColseButton();
	  
  }
  @Test()
  public void ValidationUserName() throws EncryptedDocumentException, IOException
  {
	  Utility.waitTest(driver, 2000);
	  Home.getUserName();
	  Assert.assertEquals(Home.getUserName(), Utility.readDataFromExcel(4, 2), "TC is failed, Actual user name and Expected user name is not maching ");
	  Utility.waitTest(driver, 500);
	  
	  
  }
  @Test(priority = 1)
  public void ValidationACBalance() throws EncryptedDocumentException, IOException
  {
	  Utility.waitTest(driver, 500);
	 Home.GetingACBalance();
	 Assert.assertNotEquals(Home.GetingACBalance(), "A/C Balance is null ");
	  
	  
  }
  @AfterMethod
  public void LogOutFromNeoStox()
  {
	  Utility.waitTest(driver, 1000);
	  Home.ClickOnLogOutButton(driver);
	  
  }
  @AfterClass
  public void exitFromBrowser() throws InterruptedException
  {
	  Utility.waitTest(driver, 500);
	  closingBrowser(driver);
  }

}
