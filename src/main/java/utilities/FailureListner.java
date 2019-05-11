package utilities;

import java.io.IOException;

import org.testng.*;
import TestGroup.TestArtifact.BaseTest;

public class FailureListner extends BaseTest implements ITestListener {

	

	public void onTestFailure(ITestResult result) {
	try {
		this.driver = ((BaseTest)result.getInstance()).driver;
	
	     
		Getscreenshot(driver, result.getName());
	}
	catch(IOException e)
	{e.printStackTrace();}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
