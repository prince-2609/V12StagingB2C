package Sales_Channel_Setting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class PreferredAirlines {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("SalesChannelSetting_PreferredAirline", "Sheet3");
	}

	@Test(dataProvider = "getexceldata")
	public static void preferredAirlines(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String Air, String PAAirline, String PAOriginType,
			String OCo, String OCountry, String OCi, String OCity, String OAirP, String OAirPort,
			String PADestinationType, String DCo, String DCountry, String DCi, String DCity, String DAirP,
			String DAirPort, String TripStartDate, String TripEndDate) throws Exception {
		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("V12Administration");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("V12SalesChannelSetting");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("V12RManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("SCSPreferredAirline");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("PAAddNew");
		Thread.sleep(2000);

		// Preferred Airline Auto Suggestion Code

		QaRobot.ClickOnElement("AirlineSelect");
		TestBase.listofautosuggestion(By.xpath("(//p[@id='dynaSpan0'])[1]"), Air, PAAirline,
				By.xpath("//input[@id='TxtAirline']"));
		Thread.sleep(3000);
//		int pAS2 = Integer.parseInt(PAirQty);
//		for (int k = 1; k <= pAS2; k++) {
//			String[] tN1 = PAAirline.split(",");
//			String b1 = tN1[k - 1];
//			QaBrowser.driver.findElement(By.xpath("//input[@id='TxtAirline']")).clear();
//			QaRobot.PassValue("PAAirline", b1);
//			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath("//div[@id='divAirCity']/p"));
//			for (WebElement autoRights1 : listOfRights1) {
//				if (autoRights1.getText().equalsIgnoreCase(b1)) {
//					autoRights1.click();
//					autoRights1.click();
//					break;
//				}
//			}
//		}
//		TestBase.listofautosuggestion(By.xpath("//p[@id='dynaSpan1']"), Ci, City, By.xpath("//input[@id='txtcity']"));
//		QaBrowser.driver.findElement(By.xpath("//p[@id='dynaSpan1']")).click();
		Thread.sleep(1000);

		// Selected Origin Type respective Auto Suggestion
		if (PAOriginType.equalsIgnoreCase("Country")) {
			QaRobot.ClickOnElement("PAOCountry");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OCo, OCountry,
					By.xpath("//input[@id='txtOrgin']"));
		} else if (PAOriginType.equalsIgnoreCase("City")) {
			QaRobot.ClickOnElement("PAOCity");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OCi, OCity,
					By.xpath("//input[@id='txtOrgin']"));
		} else if (PAOriginType.equalsIgnoreCase("AirPort")) {
			QaRobot.ClickOnElement("PAOAirPort");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OAirP, OAirPort,
					By.xpath("//input[@id='txtOrgin']"));
		}
		Thread.sleep(3000);

		// Selected Destination Type respective Auto Suggestion
		if (PADestinationType.equalsIgnoreCase("Country")) {
			QaRobot.ClickOnElement("PADCountry");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity1']/p"), DCo, DCountry,
					By.xpath("//input[@id='txtDestination']"));
		} else if (PADestinationType.equalsIgnoreCase("City")) {
			QaRobot.ClickOnElement("PADCity");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity1']/p"), DCi, DCity,
					By.xpath("//input[@id='txtDestination']"));
		} else if (PADestinationType.equalsIgnoreCase("AirPort")) {
			QaRobot.ClickOnElement("PADAirPort");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCity1']/p"), DAirP, DAirPort,
					By.xpath("//input[@id='txtDestination']"));
		}
		Thread.sleep(2000);

		QaRobot.ClickOnElement("PATripStartDateDropdown");
		Thread.sleep(2000);
		selectDate(TripStartDate);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("PATripEndDateDropdown");
		Thread.sleep(2000);
		selectDate1(TripEndDate);

		QaExtentReport.extentScreenshot("Preferred Airline Rule");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("PASave");
		Thread.sleep(1000);
		QaRobot.alertDismiss();
		//QaExtentReport.extentScreenshot("Alert Popup message");

	}
	
	@AfterMethod
	public static void afterMethod() {
		 //QaExtentReport.test.getExtent().flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// Trip Start Date Next Button Calendar
	public static void selectDate(String Day) throws Exception {
		List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
				"/html/body/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/center/div/div[2]/center/table/tbody/tr/td/table/tbody/tr/td/input"));
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

	// // Trip End Date Next Button Calendar
	public static void selectDate1(String Day) throws Exception {
		List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
				"/html/body/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/center/div/div[2]/center/table/tbody/tr/td/table/tbody/tr/td/input"));
		for (WebElement ele : allDates) {
			String dt = ele.getAttribute("value");
			System.out.println(dt);
			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				Thread.sleep(2000);
				break;
			}
		}
	}

//	public static void selectDateInCalendar(String Day, String Month, String Year) throws Exception {
//
//	List<WebElement> allDates = QaBrowser.driver
//			.findElements(By.xpath("/html/body/div[2]/div/div[2]/div[1]/table/tbody/tr/td"));
//	for (WebElement ele : allDates) {
//		String dt = ele.getText();
//
//		if (dt.equalsIgnoreCase(Day)) {
//			ele.click();
//			break;
//		}
//	}
//	}
//	public static List<WebElement> listofautosuggestion(By sugtxt, String CategoryName, By a)
//			throws InterruptedException {
//		QaBrowser.driver.findElement(a).click();
//		QaBrowser.driver.findElement(a).clear();
//		QaBrowser.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		ArrayList<WebElement> autosuggs = (ArrayList<WebElement>) QaBrowser.driver.findElements(sugtxt);
//		for (WebElement autosun : autosuggs) {
//			System.out.println(autosun.getText());
//			if (autosun.getText().equalsIgnoreCase(CategoryName)) {
//				System.out.println("equal");
//				autosun.click();
//				break;
//			}
//		}
//		return autosuggs;
//	}

}
