package listenerClass;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;

public class Listener extends TestBase implements ITestListener
{
	public static void ScreenshotMethod(String text) throws IOException 
	{
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("MM-dd-yy & HH-mm-ss");
		String NewDate = d.format(date);
		
		TakesScreenshot ts = (TakesScreenshot)QaBrowser.driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File("D:\\Automation\\V12StagingB2C\\Screenshot\\"+NewDate+text+".jpg");
		FileUtils.copyFile(Source, Dest);
	}
	
	public void onTestStart(ITestResult result) 
	{	
//		test = report.createTest("");
	}

	public void onTestSuccess(ITestResult result) {

		try {

			if (result.getStatus() == ITestResult.SUCCESS) {

				Listener.ScreenshotMethod("Test Case Pass");
//				String screenShotPath = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case Pass.png");
				QaExtentReport.test.log(Status.PASS, "<b><i>Successful Test</i></b>");
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				result.getThrowable().printStackTrace();
				//System.out.println(result.getThrowable());
				QaExtentReport.test.log(Status.FAIL, result.getThrowable());
				Listener.ScreenshotMethod("Test Case Pass");
//				String fail = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case fail.png");
				QaExtentReport.test.log(Status.FAIL, "<b><i>Fail Test</i></b>");		
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.SKIP) {
				Listener.ScreenshotMethod("Test Case Pass");
//				String skip = Logger.takeScreenshot(QaBrowser.driver, "D:\\Automation\\projectb2c1\\Screenshot\\Test Case Skip.png");
				QaExtentReport.test.log(Status.SKIP, result.getThrowable());
				System.out.println("********* Skipped *********");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();;
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) 
	{
		try {
			init();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) 
	{
		// driver.quit();
	}
}
