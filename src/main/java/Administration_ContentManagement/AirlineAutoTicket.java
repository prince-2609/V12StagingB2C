package Administration_ContentManagement;

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
public class AirlineAutoTicket {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("ContentManagement_AirlineAutoTicket", "Sheet2");
	}

	@Test(dataProvider = "getexceldata")
	public static void autoCharges(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String AirlineQty, String SelectAirline, String SCQty,
			String SalesChannel, String SelectGDS, String TicketsQty, String TicketsRule, String MarketType,
			String XHostBranchQty, String XHostBranch, String Remark) throws Exception {
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
		QaRobot.ClickOnElement("ContentManagementClick");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("V12RManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("CMAirlineAutoChargesSettingClick");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("AirlineAutoTicketAddNew");
		Thread.sleep(3000);

		// Select Airline from the list
		int pAS1 = Integer.parseInt(AirlineQty);
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
		QaRobot.ClickOnElement("AATSelectAirlineAdd");
		Thread.sleep(2000);

		// Choose Sales Channel Check box
		int pA = Integer.parseInt(SCQty);
		for (int k = 1; k <= pA; k++) {
			String[] tN1 = SalesChannel.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver
					.findElements(By.xpath("/html/body/form/div[3]/div[2]/div/div/div/div[2]/div/div/ul/li/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}
		Thread.sleep(2000);

		QaRobot.selectTextFromDropdown("AATSelectGDS", SelectGDS);
		Thread.sleep(3000);

		// Choose Tickets Check box
		int pAS2 = Integer.parseInt(TicketsQty);
		for (int k = 1; k <= pAS2; k++) {
			String[] tN1 = TicketsRule.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(
					By.xpath("/html/body/form/div[3]/div[2]/div/div/div/div[4]/div/div/div/div/label/div/div[2]"));
			// /html/body/form/div[3]/div[2]/div/div/div/div[4]/div/div/div/div/label/div/div[1]/div/div/span
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}
//		if (TicketsRule.equalsIgnoreCase("Issue Tickets on UCCF Payments")) {
//			QaRobot.ClickOnElement("AATTicketsRule1");
//			Thread.sleep(1000);
//		}
//		if (TicketsRule.equalsIgnoreCase("Issue Tickets on UCCF Payments")) {
//			QaRobot.ClickOnElement("AATTicketsRule1");
//			Thread.sleep(1000);
//		}
//		if (TicketsRule.equalsIgnoreCase("Issue Tickets on UCCF Payments")) {
//			QaRobot.ClickOnElement("AATTicketsRule1");
//			Thread.sleep(1000);
//		}
		QaExtentReport.extentScreenshot("Airline Auto Ticket Details filled");
		if (MarketType.equalsIgnoreCase("Int")) {
			QaRobot.ClickOnElement("AATMarketInt");
		}
		QaRobot.scrollPage(400);
		Thread.sleep(2000);

		// Choose XHost Branch Check box
		int pA2 = Integer.parseInt(XHostBranchQty);
		for (int k = 1; k <= pA2; k++) {
			String[] tN1 = XHostBranch.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(
					By.xpath("/html/body/form/div[3]/div[2]/div/div/div/div[6]/div/div[1]/div/ul/li/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}
		Thread.sleep(3000);
		QaRobot.PassValue("AATRemark", Remark);
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Airline Auto Ticket Details filled");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("AATSubmit");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Record Saved Successfully");
	}

	@AfterMethod
	public static void afterMethod() {
		// QaExtentReport.test.getExtent().flush();
	}
}
