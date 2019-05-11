package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage {
	WebDriver driver;
	
	@FindBy(id="ch_login_icon")
	WebElement login_icon;
	
	@FindBy(id="ch_login_email")
	WebElement TxtEmail;

	@FindBy(id="ch_login_password")
	WebElement TxtPassword;
	
	@FindBy(id="ch_login_btn")
	WebElement login_button;

	public Loginpage(WebDriver driver)
	{
    this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public void LoginIcon_Click()
	{
		login_icon.click();	
	}
	
	public void Set_Credentials(String Username, String Password)
	{
		TxtEmail.sendKeys(Username);
		TxtPassword.sendKeys(Password);
	}
	
	public void Login_Click()
	{
		login_button.click();	
	}
	
}
