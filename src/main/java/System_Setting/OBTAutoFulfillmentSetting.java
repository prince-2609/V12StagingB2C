package System_Setting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class OBTAutoFulfillmentSetting {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("SystemSetting_OBTAutoFulfillmentSetting", "Sheet3");
	}

	@Test(dataProvider = "getexceldata")
	public static void OBTFulfillment(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String SupplierOBT, String OfficeHourBranch,
			String OfficeHourTicketPCC, String AfterOfficeHourBranch, String AfterOfficeHourTicketPCC,
			String AuthorizedBookingQueue, String ExceptionQueue, String EffectiveDateFrom, String NotificationEmail,
			String CheckQty, String Checkname) throws Exception {
		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);

		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Successfully Login");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("V12Administration");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("v12SystemSetting");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("OBTConfigurationClick");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(5000);	
		QaExtentReport.extentScreenshot("OBT setting click");
		QaRobot.ClickOnElement("OBTSettingClick");
		Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("SupplierSelect", SupplierOBT);
		Thread.sleep(3000);
		QaRobot.selectTextFromDropdown("OfficeHourBranch", OfficeHourBranch);
		Thread.sleep(3000);
		QaRobot.selectTextFromDropdown("OfficeHourTicketPCC", OfficeHourTicketPCC);
		Thread.sleep(3000);
		QaRobot.selectTextFromDropdown("AfterOfficeHourBranch", AfterOfficeHourBranch);
		Thread.sleep(3000);
		QaRobot.selectTextFromDropdown("AfterOfficeHourTicketPCC", AfterOfficeHourTicketPCC);
		Thread.sleep(3000);
		QaRobot.PassValue("AuthorizedBookingQueue", AuthorizedBookingQueue);
		Thread.sleep(1000);
		QaRobot.PassValue("ExceptionQueue", ExceptionQueue);
		Thread.sleep(1000);
		QaExtentReport.extentScreenshot("Detail filled");
		QaRobot.scrollPage(1000);

		QaRobot.ClickOnElement("EffectiveDateFromClick");
		Thread.sleep(1000);
		QaBrowser.driver.findElement(By.xpath("//input[@id='btnMonthNext']")).click();
		selectDate(EffectiveDateFrom);
		Thread.sleep(1000);
		QaRobot.PassValue("NotificationEmail", NotificationEmail);
		Thread.sleep(1000);

		QaRobot.scrollPage(1000);
		Thread.sleep(1000);

		// Choose Rules checkbox from list
		int SC = Integer.parseInt(CheckQty);
		for (int k = 1; k <= SC; k++) {
			String[] tN1 = Checkname.split(",");
			String b1 = tN1[k - 1];
			System.out.println(b1);
			List<WebElement> listOfSC = QaBrowser.driver.findElements(
					By.xpath("/html/body/form/div[5]/div/div/div/div/div/div[1]/div/div[2]/div/div/div/div/div/label"));
			for (WebElement autoSC : listOfSC) {
				if (autoSC.getText().equalsIgnoreCase(b1)) {
					// System.out.println(autoSC.getText());
					autoSC.click();
					break;
				}
			}
		}
		QaExtentReport.extentScreenshot("Detail filled");
		QaRobot.scrollPage(500);
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Rules");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("SaveOBTRules");
	}

	@AfterMethod
	public static void afterMethod() {
	//	QaExtentReport.test.getExtent().flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	// Effective Date Calendar Next Button
	public static void selectDate(String Day) throws Exception {
		List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
				"/html/body/form/div[4]/div/table/tbody/tr/td/table/tbody/tr[2]/td/center/div/div[2]/center/table/tbody/tr/td/table/tbody/tr/td/input"));
		for (WebElement ele : allDates) {
			String dt = ele.getAttribute("value");
			System.out.println(dt);
			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				// ele.click();
				Thread.sleep(2000);
				break;
			}
		}
	}

//	List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
//			"/html/body/form/div[4]/div/table/tbody/tr/td/table/tbody/tr[2]/td/center/div/div[2]/center/table/tbody/tr/td/table/tbody/tr/td/input"));
//	for (WebElement ele : allDates) {
//		String dt = ele.getAttribute("value");
//		if (dt.equalsIgnoreCase(EffectiveDateFrom)) {
//			ele.click();
//		//	ele.click();
//			break;
//		}
//	}

//	String DateSelection[] = EffectiveDateFrom.split("-");
//	String year = DateSelection[2];
//	String month = DateSelection[1];
//	String expDate = DateSelection[0];
//	selectDateInCalendarOneWayNew(expDate, month, year);

//	List<WebElement> allDates = QaBrowser.driver
//			.findElements(By.xpath("/html/body/form/div[4]/div/table/tbody/tr/td/table/tbody/tr[2]/td/center/div/div[2]/center/table/tbody/tr/td/table/tbody/tr/td/input"));
//
//	for (WebElement ele : allDates) {
//		String dt = ele.getText();
//
//		if (dt.equalsIgnoreCase(Day)) {
//			ele.click();
//			ele.click();
//			break;
//		}
//	}
//

	public static void selectDateInCalendarOneWayNew(String Day, String Month, String Year) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-mm-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>" + Day + "-" + Month + "-" + Year);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Thread.sleep(3000);
		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div"))
				.getAttribute(currentMonthNumber);
		Thread.sleep(5000);
		String month = ((String) monthYear).split(" ")[0];
		Thread.sleep(4000);
		String year = ((String) monthYear).split(" ")[1];
		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/a[3]")).click();
			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/div")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
		}
		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("/html/body/div[6]/div/div[2]/div[1]/table/tbody/tr/td"));
		for (WebElement ele : allDates) {
			String dt = ele.getText();
			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				ele.click();
				break;
			}
		}

	}
}
