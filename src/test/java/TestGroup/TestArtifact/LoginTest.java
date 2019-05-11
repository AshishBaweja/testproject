package TestGroup.TestArtifact;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import Pages.*;
import utilities.ExtentReportUtility;



public class LoginTest extends BaseTest {

WebDriver driver;
Properties prop ;
String url;
String username;
String password;
int ImplicitlywaitTime;
String filename;
Logger Log = Logger.getLogger("LoginTest");
ExtentTest extentTest;
String TestTitle = "Login Test";
String TestDetails = "Verify User is able to Login";
ExtentReportUtility ex ;
Loginpage lg ;
Homepage hm ;


@BeforeTest
public void setup() throws IOException
{
this.driver = setupBrowser();
this.prop = ReadConfigData();
DOMConfigurator.configure("log4j.xml");
ImplicitlywaitTime= Integer.parseInt(prop.getProperty("ImplicitlywaitTime"));
url=prop.getProperty("url");
username=prop.getProperty("username");
password=prop.getProperty("password");
driver.get(url);
ex = new ExtentReportUtility();
ex.CreateExtentInstance();
lg = new Loginpage(driver);
hm = new Homepage(driver);

}


	
	@Test(priority=0)
	public void logintoMMT() throws IOException 
	{	
		extentTest=ex.StartExtentReport(TestTitle, TestDetails);
		lg.LoginIcon_Click();
        Log.info("Clicking on Login Icon");
        extentTest.log(LogStatus.INFO, "Clicking on Login Icon");
        
		lg.Set_Credentials(username, password);
	     Log.info("Entering Credentials");
	     extentTest.log(LogStatus.INFO, "Entering Credentials");
	     
	     lg.Login_Click();
	     Log.info("Clicking on login button");
	     extentTest.log(LogStatus.INFO, "Clicking on login button");
			
		
		String loggedinU= hm.getloggedinuser();
	  //  Getscreenshot(driver, "login");
		System.out.println("login user is " + loggedinU);
		extentTest.log(LogStatus.INFO, "login user is " + loggedinU);
		
		try {
		Assert.assertEquals("HEY ASHIS..", loggedinU);
		Reporter.log("User logged in successfully");
		extentTest.log(LogStatus.PASS, "Test Passed successfully");
		}		
		catch(AssertionError e)
		{
			extentTest.log(LogStatus.FAIL, "Asserion Error, User name did not match");
		}
		
		String screenShotPath = Getscreenshot(driver, "Username");
		extentTest.log(LogStatus.INFO," Snapshot : "+ extentTest.addScreenCapture(screenShotPath));
	}
	
	@Test(priority=1)
	public void VerifyWalletBalance() throws InterruptedException
	{
		extentTest=ex.StartExtentReport("Verify Wallet Balance", "Test");
		String WalletMoney= hm.getWalletBalance();
		System.out.println("Wallet Money " + WalletMoney);
		try {
			Assert.assertEquals("Rs. 0", WalletMoney);
			extentTest.log(LogStatus.PASS, "Wallet Money Verified");
			}		
			catch(AssertionError e)
			{
				extentTest.log(LogStatus.FAIL, "Asserion Error, Wallet Money Verified did not match");
			}
	}
	
	@Test(priority=2)
	public void VerifyWalletBalanceagain() throws InterruptedException
	{
		extentTest=ex.StartExtentReport("Verify Wallet Balance again", "again");
		String WalletMoney= hm.getWalletBalance();
		System.out.println("Wallet Money " + WalletMoney);
		SoftAssert sf = new SoftAssert();
		try {
		sf.assertEquals("Rs. 0", WalletMoney);
	    sf.assertAll();
		}
		catch(AssertionError e)
		{
			extentTest.log(LogStatus.FAIL, "Asserion Error, Wallet Money Verified did not match");
		}
	}
	
	 
	 @AfterMethod
	 public void logtoReport(){

		 ex.EndTest();
	 }
	
	@AfterTest
	public void Closebrowser()
	{
		driver.close();
		Log.info("Closing browser");
		extentTest.log(LogStatus.INFO, "Closing browser");
		ex.PrepareReport();
	}
	
}
