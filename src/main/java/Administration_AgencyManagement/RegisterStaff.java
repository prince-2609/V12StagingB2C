package Administration_AgencyManagement;

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
public class RegisterStaff {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Administration_AvenueManagement_RegisterStaff", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void corporateProfiling(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String Branch, String PrimaryRole,
			String EmployeeName, String PhoneCountry, String PhoneNumbar, String Email, String LoginName)
			throws Exception {
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
		QaRobot.ClickOnElement("V12AgencyManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		QaRobot.ClickOnElement("V12StaffManagemnt");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("V12RegisterStaff");
		QaRobot.selectTextFromDropdown("SFSelectBranch", Branch);
		QaRobot.ClickOnElement("RSSelectAll");
		QaRobot.selectTextFromDropdown("SFPrimaryRole", PrimaryRole);
		QaRobot.PassValue("RSEmployeeName", EmployeeName);
		QaRobot.selectTextFromDropdown("RSPhoneCountry", PhoneCountry);
		QaRobot.PassValue("RSPhoneNumber", PhoneNumbar);
		QaRobot.PassValue("RSEmail", Email);
		QaRobot.PassValue("RSLoginName", LoginName);
		QaRobot.scrollPage(5000);
		Thread.sleep(3000);
		QaRobot.ClickOnElement("RSGeneratePW");
//		QaRobot.ClickOnElement("BUSave");
//		QaRobot.acceptAlert("Register Staff status");
	}

	@AfterMethod
	public static void afterMethod() {
//		QaExtentReport.test.getExtent().flush();
	}

}
