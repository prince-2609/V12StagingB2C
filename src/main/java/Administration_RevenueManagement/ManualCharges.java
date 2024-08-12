package Administration_RevenueManagement;

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
public class ManualCharges {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Administration_AvenueManagement_ManualCharges", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void corporateProfiling(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String ChargeCode, String ChargeDescription,
			String GrossAmount, String NetAmount) throws Exception {
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
		QaRobot.ClickOnElement("RMManualCharges");
		QaRobot.ClickOnElement("RMAddNew");
		QaRobot.PassValue("MCChargeCode", ChargeCode);
		QaRobot.PassValue("MCChargeDescription", ChargeDescription);
		QaRobot.clearValue("MCGrossAmount");
		QaRobot.PassValue("MCGrossAmount", GrossAmount);
		QaRobot.clearValue("MCNetAmount");
		QaRobot.PassValue("MCNetAmount", NetAmount);
//		QaRobot.ClickOnElement("MCSave");
//		QaRobot.acceptAlert("Manual charges status");
	}

	@AfterMethod
	public static void afterMethod() {
//		QaExtentReport.test.getExtent().flush();
	}
}
