package TestGroup.TestArtifact;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class BaseTest {
	
public WebDriver driver;
String Screenshotpath;
String url;
String username;
String password;
int ImplicitlywaitTime;

public WebDriver setupBrowser() throws IOException {
			
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)	;	
		driver.manage().window().maximize();		
		return driver;
	}


public Properties ReadConfigData() throws IOException {
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(new File("C:\\Users\\Ashu\\eclipse-workspace\\TestArtifact\\src\\main\\java\\configuration\\Config.properties"));
prop.load(fis);
fis.close();	
return prop;
}	
	
public String Getscreenshot(WebDriver driver, String filename) throws IOException
{
	
	Properties prop = ReadConfigData();
	Screenshotpath=prop.getProperty("Screenshotpath");
	
	TakesScreenshot scn = ((TakesScreenshot)driver);
	File src = scn.getScreenshotAs(OutputType.FILE);
	File dest = new File(Screenshotpath + filename +".png");
	Files.copy(src,dest);	
	return (Screenshotpath + filename +".png");
}
	


}
