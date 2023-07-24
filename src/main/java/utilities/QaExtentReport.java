package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class QaExtentReport 
{

	public static ExtentReports report;
	public static ExtentTest test;
	
	public static void test_htmlreport()  
	{
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MMM-yy & HH-mm-ss");
		String NewDate = d.format(date);
		
		report = new ExtentReports();
		
		File file = new File("D:\\Automation\\V12StagingB2C\\Reports\\"+NewDate+" report"+".html");
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(file);
		ExtentSparkReporterConfig config = sparkreporter.config();
		config.setTheme(Theme.DARK);
		config.setReportName("V12StagingB2C");
		config.setDocumentTitle("V12Staging");
		
		report.attachReporter(sparkreporter);
		
//		report
//		.createTest("Pre Approval Queue for Business Trip")
//		.assignAuthor("Shubham Natkar")
//		.assignDevice("Chrome");		
	}	
	
	public static void extentScreenshot(String txt) throws IOException
	{
		test.info(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(txt)).build());
	}
	
	public static String captureScreenshot(String text) throws IOException
	{
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yy & HH-mm-ss");
		String NewDate = d.format(date);
		TakesScreenshot ts = (TakesScreenshot)QaBrowser.driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File("D:\\Automation\\V12StagingB2C\\Screenshot\\"+NewDate+" "+text+".jpg");
		FileUtils.copyFile(Source, Dest);
		return Dest.getAbsolutePath();
	}
}






