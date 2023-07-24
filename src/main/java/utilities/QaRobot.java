package utilities;

import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Base.TestBase;
/**
 * Selenium Utility
 * @author Anjali.Jain
 *
 */
public class QaRobot extends QaExtentReport


{
	static SoftAssert softassert = new SoftAssert();

	/**
	 * 
	 * @param locator
	 * @return WebElement
	 * @throws Exception
	 */
	// *** This Function returns the Locators in the Web Application *****
	public static WebElement getLocator(String locator) throws Exception 
	{
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
	
		if (locatorType.toLowerCase().equals("xpath")) 
			return QaBrowser.driver.findElement(By.xpath(locatorValue));
		else if (locatorType.toLowerCase().equals("id"))
			return QaBrowser.driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("class"))
			return QaBrowser.driver.findElement(By.className(locatorValue)); 
		else if (locatorType.toLowerCase().equals("tag"))
			return QaBrowser.driver.findElement(By.tagName(locatorValue));
		else if (locatorType.toLowerCase().equals("link"))
			return QaBrowser.driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("css"))
			return QaBrowser.driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return QaBrowser.driver.findElement(By.name(locatorValue));
		else
			throw new Exception("Unknown Locator Type" + locatorType);
	}
	
	public static void scrollPage(String value) {
		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
        mo.executeScript("window.scrollBy(0,"+value+")");
	}
	
	public static void ScreenshotMethod(String text,String text1) throws IOException 
	{
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yy & HH-mm-ss");
		String NewDate = d.format(date);
		
		TakesScreenshot ts = (TakesScreenshot)QaBrowser.driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File("D:\\Automation\\V12StagingB2C\\Screenshot\\"+NewDate+" "+text+".jpg");
		FileUtils.copyFile(Source, Dest);
		QaExtentReport.test.log(Status.INFO, text1);
	}
	

	public static WebElement getWebElement(String locator) throws Exception {
		return getLocator(TestBase.obj.getProperty(locator));
	}
	public static void mouseHover(String sourceXpath,String targetXpath)
	{
		Actions action =new Actions(QaBrowser.driver);
		WebElement mainMenu=QaBrowser.driver.findElement(By.xpath(sourceXpath));
		WebElement subMenu=QaBrowser.driver.findElement(By.xpath(targetXpath));
		action.moveToElement(mainMenu);
		action.moveToElement(subMenu).click().build().perform();;
		
	}
	
	public static void getvalue() 
	{
		WebElement getvalue = QaBrowser.driver.findElement(By.xpath("//input[@id='ctl00_hdnUId']"));
		getvalue.getAttribute("Id");
	}

	// click on element
	public static void ClickOnElement(String locator2) throws Exception {
	
		//QaBrowser.driver.findElement(By.xpath(TestBase.obj.getProperty(locator2))).click();
		WebElement element= getWebElement(locator2);
		element.click();
		
	
//		QaExtentReport.test.log(Status.INFO, text);
	
	}

	//send the value on textbox
	public static void PassValue(String Locator, String value) throws Exception {
	
		getWebElement(Locator).sendKeys(value);
		
//		test.log(Status.INFO, Text);
	
	}

	public static void PassValueByLocator(String Locator, String value, String text) throws Exception {
	
		QaBrowser.driver.findElement(By.xpath(Locator)).sendKeys(value);
		QaExtentReport.test.log(Status.INFO, text);
	}

	/**
	 *  wait till alert is present
	 * @param time
	 */
	public static void explicitwaitalert(int time) {
		TestBase.wait = new WebDriverWait(QaBrowser.driver, time);
		TestBase.wait.until(ExpectedConditions.alertIsPresent());
	
	}

	/**
	 *  implicit wait
	 * @param time
	 */
	public static void impliwait(int time) {
		QaBrowser.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void pageLoad(int time) {
		QaBrowser.driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
	

	/**
	 *  Explicit Wait element to be clickable
	 * @param time
	 * @param e
	 */
	public static void explicitwaitclickable(int time, By e) {
		TestBase.wait = new WebDriverWait(QaBrowser.driver, time);
		TestBase.wait.until(ExpectedConditions.elementToBeClickable(e));
	}

	/**
	 *  Explicit Wait invisibility of element
	 * @param time
	 * @param e
	 */
	public static void explicitwaitinvisible(int time, By e) {
		TestBase.wait = new WebDriverWait(QaBrowser.driver, time);
		TestBase.wait.until(ExpectedConditions.invisibilityOfElementLocated(e));
	
	}

	/**
	 * Visibility of element
	 * @param time
	 * @param e
	 */
	public static void explicitwaitvisible(int time, By e) {
		TestBase.wait = new WebDriverWait(QaBrowser.driver,time);
		TestBase.wait.until(ExpectedConditions.visibilityOfElementLocated(e));
	
	}
	
	public static void explicitwait(int time, By e)
	{
		WebDriverWait wait1 = new WebDriverWait(QaBrowser.driver,time);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(e));
	}

	/**
	 *  select value from drop down by value
	 * @param locator1r
	 * @param value
	 * @param text
	 * @throws Exception
	 */
	public static void selectValueFromDropdown(String locator1, String value, String text) throws Exception {
	
		WebElement element = getWebElement(locator1);
		Select s = new Select(element);
		s.selectByValue(value);
		QaExtentReport.test.log(Status.INFO, text);
	
	}

	public static void selectValueByLocator(String locator1, String value, String text) throws Exception {
	
		WebElement element = QaBrowser.driver.findElement(By.xpath(locator1));
		Select s = new Select(element);
		s.selectByValue(value);
		QaExtentReport.test.log(Status.INFO, text);
	}
	
	public static void selectTextByLocator1(String locator1, String value, String text) throws Exception {
		
		WebElement element = QaBrowser.driver.findElement(By.xpath(locator1));
		Select s = new Select(element);
		s.selectByVisibleText(value);
		QaExtentReport.test.log(Status.INFO, text);
	}

	// select locator
	public static void selectTextByLocator(String xpath, String value, String text) throws Exception {
	
		WebElement element = QaBrowser.driver.findElement(By.xpath(xpath));
		Select s = new Select(element);
		s.selectByVisibleText(value);
		QaExtentReport.test.log(Status.INFO, text);
	}
	
	public static void selectTextByLocator1(String locator1, String value) throws Exception {
		WebElement element = QaBrowser.driver.findElement(By.xpath(locator1));
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	
	public static void selectTextByLocator(String xpath, String value) throws Exception {
		WebElement element = QaBrowser.driver.findElement(By.xpath(xpath));
		Select s = new Select(element);
		s.selectByVisibleText(value);
	}
	
	public static void switchToWindow(){
		String ParentWindow = QaBrowser.driver.getWindowHandle();
		Set<String> handles = QaBrowser.driver.getWindowHandles();
		for (String childWindow : handles) {
			if (!childWindow.equals(ParentWindow))
				QaBrowser.driver.switchTo().window(childWindow);
		}
	}
	
	public static void selectDateInCalendar(String Day, String Month, String Year) throws Exception {

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Thread.sleep(3000);
		QaRobot.selectTextByLocator("/html/body/div[2]/div/div[2]/div/div/select[2]", Year);
		QaRobot.selectTextByLocator("/html/body/div[2]/div/div[2]/div/div/select[1]", Month);

		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/table/tbody/tr/td"));
		for (WebElement ele : allDates) {
			String dt = ele.getText();

			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				break;
			}
		}
	}
	
	public static void acceptAlert(String status) throws IOException {
		Alert alt = QaBrowser.driver.switchTo().alert();
		String text = alt.getText();
		QaExtentReport.test.log(Status.INFO, "<b><i>" + status + "</b></i>" + " - " + "<b><i>" + text + "</b></i>");
		alt.accept();
	}
	
	public static void scrollPage(int value) {
		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
        mo.executeScript("window.scrollBy(0,"+value+")");
	}
	
	public static void transferData(String Qty,String Parameters,String link) {
		int pAS = Integer.parseInt(Qty);
		for (int k = 1; k <= pAS; k++) {
			String[] tN = Parameters.split(",");
			String b = tN[k - 1];
			List<WebElement> listOfRights = QaBrowser.driver
					.findElements(By.xpath(link));
			for (WebElement autoRights : listOfRights) {
				if (autoRights.getText().equalsIgnoreCase(b)) {
					autoRights.click();
					break;
				}
			}
		}
	}
	
	public static void switchframe(String a) {
		QaBrowser.driver.switchTo().frame(QaBrowser.driver.findElement(By.xpath(a)));
	}
	
	public static void selectTextFromDropdown(String locator1, String value, String text) throws Exception {
	
		WebElement element = getWebElement(locator1);
		Select s = new Select(element);
		s.selectByVisibleText(value);
		QaExtentReport.test.log(Status.INFO, text);
	
	}

	// select locator
	public static void selectDropdownValue(String locator1, String value, String text) throws Exception {
	
		WebElement element = QaBrowser.driver.findElement(By.xpath(locator1));
		Select dropdown = new Select(element);
	
		// Get all options
		List<WebElement> dd = dropdown.getOptions();
	
		// Get the length
		System.out.println(dd.size());
	
		// Loop to print one by one
		for (int j = 0; j < dd.size(); j++) {
			// System.out.println(dd.get(j).getText());
	
			if (dd.get(j).getText().equalsIgnoreCase(value)) {
	
				dropdown.selectByIndex(j);
	
				QaExtentReport.test.log(Status.INFO, text);
			}
		}
	
	}
	public static void CompareFareValue(String ActualValue, String ExpectedValue, String Msg) throws Exception {

		softassert.assertEquals(ActualValue, ExpectedValue, Msg);
		if (ActualValue.equalsIgnoreCase(ExpectedValue)) {
			QaExtentReport.test.log(Status.PASS, "Verification Passed for value of " + Msg);
		}

		else {
			QaExtentReport.test.log(Status.FAIL, "Verification Failed for value of " + Msg);
			throw new Exception("Verification Failed for value of " + Msg);
		}
	}

	// select locator
	public static void selectDropdownValuebyLocator(String locator1, String value, String text) throws Exception {
	
		WebElement element = getWebElement(locator1);
		Select dropdown = new Select(element);
	
		// Get all options
		List<WebElement> dd = dropdown.getOptions();
	
		// Get the length
		System.out.println(dd.size());
	
		// Loop to print one by one
		for (int j = 0; j < dd.size(); j++) {
			// System.out.println(dd.get(j).getText());
	
			if (dd.get(j).getText().equalsIgnoreCase(value)) {
	
				dropdown.selectByIndex(j);
	
				QaExtentReport.test.log(Status.INFO, text);
			}
		}
	
	}

	

	

}
