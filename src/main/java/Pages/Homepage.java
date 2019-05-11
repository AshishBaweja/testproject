package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Homepage {

	@FindBy(xpath="//*[@id=\"ch_logged-in\"]/span[2]")
	WebElement loggedinuser;
	@FindBy(css="span.ch__walletMoneyLeft")
	WebElement WalletBalance;	
	WebDriver driver;
	
	public Homepage(WebDriver driver)
	{
	
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	
	}
	
	public String getloggedinuser()
	{
		 
		new WebDriverWait(driver,6).until(ExpectedConditions.visibilityOf(loggedinuser));
		String loggedinUser = loggedinuser.getText();
		return loggedinUser;
	}
	
	public String getWalletBalance() throws InterruptedException
	{
		 
	//	new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(WalletBalance));
		Thread.sleep(8000);
		String Walletbalance = WalletBalance.getText();
		return Walletbalance;
	}
}
