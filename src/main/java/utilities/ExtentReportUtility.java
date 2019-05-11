package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;



public class ExtentReportUtility {

	
	String extentReportFile = System.getProperty("user.dir")+ "\\extentReportFile.html";
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	public void CreateExtentInstance() 
	{
		// Create object of extent report and specify the report file path.
				 extent = new ExtentReports(extentReportFile, true);
	}
	
	public ExtentTest StartExtentReport(String TestTitle, String TestDetails)
	{
		

		// Start the test using the ExtentTest class object.
		 extentTest = extent.startTest(TestTitle,TestDetails);
			
		return extentTest;
		}
	
	public void EndTest()
	{
	extent.endTest(extentTest);
	}
	
	public void PrepareReport()
	{

	// writing everything to document.
	extent.flush();
	extent.close();
	}
}
