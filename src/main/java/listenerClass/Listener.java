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

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class Listener extends TestBase implements ITestListener
{
	public void onTestStart(ITestResult result) 
	{	
//		test = report.createTest("");
	}

	public void onTestSuccess(ITestResult result) {

		try {

			if (result.getStatus() == ITestResult.SUCCESS)
			{
				QaRobot.ScreenshotMethod("Successful Test","<b><i>Screenshot for Successful Test</i></b>");
				QaExtentReport.test.log(Status.PASS, "<b><i>Successful Test</i></b>");
				test.pass(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Successful Test")).build());
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.FAILURE)
			{
				result.getThrowable().printStackTrace();
				//System.out.println(result.getThrowable());
				QaExtentReport.test.log(Status.FAIL, result.getThrowable());
				String text = "Fail Test";
				Date date = new Date();
				DateFormat d = new SimpleDateFormat("dd-MM-yy & HH-mm-ss");
				String NewDate = d.format(date);
				
				TakesScreenshot ts = (TakesScreenshot)QaBrowser.driver;
				File Source = ts.getScreenshotAs(OutputType.FILE);
				File Dest = new File("D:\\Automation\\V12StagingB2C\\Screenshot\\"+NewDate+" "+text+".jpg");
				FileUtils.copyFile(Source, Dest);
				QaExtentReport.test.log(Status.FAIL, "<b><i>Screenshot for Fail Test</i></b>");
				QaExtentReport.test.log(Status.FAIL, "<b><i>Fail Test</i></b>");
				test.fail(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("Fail Test")).build());
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
				QaRobot.ScreenshotMethod("SKIP Test","<b><i>Screenshot for SKIP Test</i></b>");
				QaExtentReport.test.log(Status.SKIP, result.getThrowable());
				test.skip(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot("SKIP Test")).build());
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
