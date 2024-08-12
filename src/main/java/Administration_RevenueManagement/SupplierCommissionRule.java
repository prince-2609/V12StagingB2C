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
public class SupplierCommissionRule {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Administration_AvenueManagement_CancellationCharges", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void corporateProfiling(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String RuleTemplateTitle, String Product,
			String SCQty, String SalesChannel, String CriteriaQty, String CriteriaName, String AirQty, String Airlines,
			String CabinQty, String CabinClass, String OriginFor, String OZqty, String OZone, String ORqty,
			String ORegion, String OCqty, String OCountry, String OCiQty, String OCity, String OAqty, String OAirport,
			String DestinationFor, String Zqty, String Zone, String Rqty, String Region, String Cqty, String Country,
			String CiQty, String City, String Aqty, String Airport, String BookingCQty, String BookingClass,
			String PaxQty, String PaxType, String BaseFareF, String BaseFareT, String BookDateFrom, String BookDateTo,
			String FareTQty, String FareType) throws Exception {
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
		QaRobot.ClickOnElement("RMCancellationCharges");
		QaRobot.ClickOnElement("RMCCAddNew");
	}

	@AfterMethod
	public static void afterMethod() {
//		QaExtentReport.test.getExtent().flush();
	}
}
