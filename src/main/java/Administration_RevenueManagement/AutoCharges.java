package Administration_RevenueManagement;

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
public class AutoCharges {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Administration_RevenueManagement_AutoCharges", "Sheet4");
	}

	@Test(dataProvider = "getexceldata")
	public static void autoCharges(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String ACTitle, String Product, String Apply,
			String CheckIfFixed, String Fees, String ApplyOn, String SupplierFee, String TripSelection, String TripType,
			String AirQty, String SelectAirline, String SCQty, String SalesChannel, String AlertMsg) throws Exception {
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
		QaRobot.ClickOnElement("V12RevenueManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		QaRobot.ClickOnElement("V12RManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("RMAutoCharges");
		QaRobot.ClickOnElement("RMACAddNew");
		QaRobot.PassValue("RMACTitle", ACTitle);

		// Select product from Dropdown
		QaRobot.selectTextFromDropdown("RMACProduct", Product);
		QaRobot.PassValue("RMACApply", Apply);
		if (CheckIfFixed.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("RMCheckIfFixed");
			Thread.sleep(1000);
		}

		QaRobot.selectTextFromDropdown("RMApplyOn", ApplyOn);
		Thread.sleep(1000);
		if (SupplierFee.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("RMSupplierFee");
			Thread.sleep(1000);
		}
		if (TripSelection.equalsIgnoreCase("Yes")) {
			if (TripType.equalsIgnoreCase("Int")) {
				QaRobot.ClickOnElement("RMTripType");
			}

			Thread.sleep(3000);

			// Select Airline from the list then Add
			int pAS1 = Integer.parseInt(AirQty);
			for (int k = 1; k <= pAS1; k++) {
				String[] tN1 = SelectAirline.split(",");
				String b1 = tN1[k - 1];
				List<WebElement> listOfRights1 = QaBrowser.driver
						.findElements(By.xpath("//select[@id='selectAirline']/option"));
				for (WebElement autoRights1 : listOfRights1) {
					if (autoRights1.getText().equalsIgnoreCase(b1)) {
						autoRights1.click();
					}
				}
			}

//				QaRobot.ClickOnElement("RMCAirlineSelectClose");
//				Thread.sleep(3000);
//		QaRobot.selectTextFromDropdown("RMSelectAirline", SelectAirline);	
			QaRobot.ClickOnElement("RMAddAirline");
		}

		// Select Sales Channel from the list
		int pA = Integer.parseInt(SCQty);
		for (int k = 1; k <= pA; k++) {
			String[] tN1 = SalesChannel.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver
					.findElements(By.xpath("/html/body/form/div[3]/div[2]/div/div/div[1]/div[8]/div/div/ul/li/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}

		QaExtentReport.extentScreenshot("Create Auto charges rule");
		Thread.sleep(1000);
		QaRobot.scrollPage(1000);
		Thread.sleep(1000);
		QaRobot.ClickOnElement("RMSave");
		if (TripType.equalsIgnoreCase("Yes")) {
			QaRobot.alertAccept();
		}
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Auto charges list");
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
