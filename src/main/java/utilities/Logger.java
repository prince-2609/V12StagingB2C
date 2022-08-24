


package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class Logger {

	public static ExtentReports extent = new ExtentReports();
//	public static ExtentKlovReporter klov = new ExtentKlovReporter(QaEnvironment.getProperty("klov.project.name"));
	public static ExtentTest test;

	/**
	 * Take screenshot
	 * 
	 * @param driver
	 * @param fileWithPath
	 * @return
	 * @throws IOException
	 */
	public static String takeScreenshot(WebDriver driver, String fileWithPath) throws IOException {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		return fileWithPath;
	}

	public static String takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		return SrcFile.getAbsolutePath();
	}

	/**
	 * maintain report on server.
	 * 
	 * @throws Exception
	 */
//	public static void initKlovReport() throws Exception {
//		// address, host/port of MongoDB
//		klov.initMongoDbConnection("localhost", 27017);
//		// Klov server address
//		klov.initKlovServerConnection("http://localhost");
//		extent.setSystemInfo("User Name", QaEnvironment.getProperty("user.name"));
//		extent.setSystemInfo("Envirnoment", QaEnvironment.getProperty("environment"));
//		extent.attachReporter(klov);
//	}

//	public static void setProjectName(String projectName) {
//		klov.setProjectName(projectName);
//	}

//	public static void setProjectName() {
//		setProjectName(QaEnvironment.getProperty("klov.project.name"));
//	}

//	public static void setReportName(String reportName) {
//		klov.setReportName(reportName);
//	}

//	public static void setReportName() {
//		setReportName(QaEnvironment.getProperty("klov.report.name"));
//	}

	/**
	 * Log the test in report.
	 * 
	 * @param logInfo
	 */
	public static void log(String logInfo) {
		test.log(Status.INFO, logInfo);
	}

	public static void pass(WebDriver driver) throws IOException {
		String screenShotPath = takeScreenshot(driver);
		String base64File = encodeFiletoBase64Binary(new File(screenShotPath));
		test.log(Status.PASS, "Successful Booking Snapshot Below :",
				MediaEntityBuilder.createScreenCaptureFromBase64String(base64File).build());
		System.out.println("********* Passed *********");
	}

	public static void fail(WebDriver driver) throws IOException {
		String screenShotPath = takeScreenshot(driver);
//		String base64File = encodeFiletoBase64Binary(new File(screenShotPath));
//		test.log(Status.FAIL, "Failed Booking Snapshot Below :",
//				MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
//		System.out.println(base64File);
		String base64File = encodeFiletoBase64Binary(new File(screenShotPath));
		test.log(Status.FAIL, "Failed Booking Snapshot Below :",
				MediaEntityBuilder.createScreenCaptureFromBase64String(base64File).build());

		test.addScreenCaptureFromBase64String(base64File, "Fail");
		System.out.println("********* Failed *********");
	}

//	private static String getBase64EncodedFile(File file) throws IOException {
//		return encodeFiletoBase64Binary(takeScreenshot(driver));
//	}

	private static String encodeFiletoBase64Binary(File file) throws IOException {
		byte[] fileContent = FileUtils.readFileToByteArray(file);
		// String encodedString = Base64.encode(fileContent);
		return fileContent.toString();

	}
}
