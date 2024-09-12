package MO_ClientManagement_CorporateCustomer_CAM;

import org.openqa.selenium.By;
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
public class RegisterClient {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Register_Client", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void corporateProfiling(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String Title, String FN, String LN,
			String PreferredName, String CDOB, String Gender, String UserName1, String EmailId, String StreetAddress,
			String Country, String State, String Ci, String City, String Pincode, String PhoneCountry, String Phone,
			String MobileCountry, String Mobile, String TravellerType, String PassportNo, String PDOB,
			String Nationality, String IssuingCountry, String PlaceIssue, String PlaceOfIssue, String Expiry,
			String Primary, String VisaNo, String CountryOfVisa, String DateOfIssue, String DateOfExpiry)
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
		QaRobot.ClickOnElement("v12Clientmanagement");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("v12DirectCustomer");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		QaRobot.ClickOnElement("v12CAMDirectCustomerClick");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("v12CAMRegisterClient");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("v12CAMSubmitS");
		Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("ClientTitle", Title);
		QaRobot.PassValue("ClientFN", FN);
		QaRobot.PassValue("ClientLN", LN);
		QaRobot.PassValue("ClientPreferredName", PreferredName);
		Thread.sleep(1000);
		QaRobot.ClickOnElement("ClientDOB1");
		String DateSelection[] = CDOB.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		QaRobot.selectDateInCalendar1(expDate, month, year);
		Thread.sleep(2000);
//		QaRobot.ClickOnElement("CDOB");

		// Choose Gender from Radio Button
		if (Gender.equalsIgnoreCase("Male")) {
			QaRobot.ClickOnElement("GenderMale");
		} else if (Gender.equalsIgnoreCase("Female")) {
			QaRobot.ClickOnElement("GenderFemale");
		}
		Thread.sleep(2000);
		QaRobot.PassValue("CUsername", UserName1);
		QaRobot.PassValue("CEmail", EmailId);
		QaRobot.PassValue("CStreetAddress", StreetAddress);
		QaRobot.selectTextFromDropdown("CCountry", Country);
		Thread.sleep(2000);
		QaRobot.scrollPage(1200);
//		QaRobot.selectTextFromDropdown("ClientState", State);
//		Thread.sleep(2000);
		TestBase.listofautosuggestion(By.xpath("//p[@id='dynaSpan1']"), Ci, City, By.xpath("//input[@id='txtcity']"));
		QaBrowser.driver.findElement(By.xpath("//p[@id='dynaSpan1']")).click();
		QaExtentReport.extentScreenshot("Traveller Details Page");
		Thread.sleep(2000);
		QaRobot.PassValue("CPincode", Pincode);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ClickBusinessAddress");
		QaRobot.scrollPage(1000);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ClickDeliveryAddress");
		Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("PhoneCountry", PhoneCountry);
		QaRobot.PassValue("CPhoneNo", Phone);
		QaRobot.selectTextFromDropdown("MobileCountry", MobileCountry);
		QaRobot.PassValue("CMobileNo", Mobile);
		Thread.sleep(2000);

		// Choose Traveller Type
		if (TravellerType.equalsIgnoreCase("VIP")) {
			QaRobot.ClickOnElement("CVIP");
		} else if (TravellerType.equalsIgnoreCase("CIP")) {
			QaRobot.ClickOnElement("CCIP");
		}
		Thread.sleep(2000);
		QaRobot.ClickOnElement("CAcknowledgement1");
		Thread.sleep(1000);
		QaRobot.ClickOnElement("CAcknowledgement2");
		// QaRobot.ClickOnElement("CAcknowledgement2");
		QaExtentReport.extentScreenshot("Traveller Details Page");
		QaRobot.ClickOnElement("CSave");
		Thread.sleep(2000);
		QaRobot.scrollPage(-3000);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ClickOnClientname");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("v12CAMSubmitS");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("CPassportDetails");
		Thread.sleep(4000);
		QaRobot.ClickOnElement("CAddPassport");
		Thread.sleep(4000);
		QaRobot.PassValue("CPassportNo", PassportNo);
		Thread.sleep(2000);

		// Place of Issue Auto Suggestion
		TestBase.listofautosuggestion(By.xpath("//p[@id='dynaSpan0']"), PlaceIssue, PlaceOfIssue,
				By.xpath("//input[@id='txtSearchCity']"));
		QaBrowser.driver.findElement(By.xpath("//p[@id='dynaSpan0']")).click();
		// QaRobot.PassValue("CPlaceOfIssue", PlaceOfIssue);
		Thread.sleep(4000);

		// Choose Expiry date from date Dropdown
		QaRobot.ClickOnElement("CPassportExpiry");
		String DateSelection1[] = Expiry.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		QaRobot.selectDateInCalendar1(expDate1, month1, year1);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("CPrimary");
		Thread.sleep(1000);
		QaRobot.ClickOnElement("CAddPassport");
		QaExtentReport.extentScreenshot("Sigh In Page");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("CClickVisa");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("CClickVisaAddNew");
		Thread.sleep(4000);

		QaRobot.PassValue("CVisaNumber", VisaNo);
		// Choose Country from the list
		QaRobot.selectTextFromDropdown("CCountryOfVisa", CountryOfVisa);
		Thread.sleep(2000);
		// QaRobot.selectTextFromDropdown("CPlaceOfIssue", PlaceOfIssue);

		// Choose DateOfIssue from date Dropdown
		QaRobot.ClickOnElement("CDateOfIssue");
		String DateSelection11[] = DateOfIssue.split("-");
		String year11 = DateSelection11[2];
		String month11 = DateSelection11[1];
		String expDate11 = DateSelection11[0];
		QaRobot.selectDateInCalendar1(expDate11, month11, year11);
		Thread.sleep(3000);

		// Choose DateOfExpiry from date Dropdown
		QaRobot.ClickOnElement("CDateOfExpiry");
		String DateSelection111[] = DateOfExpiry.split("-");
		String year111 = DateSelection111[2];
		String month111 = DateSelection111[1];
		String expDate111 = DateSelection111[0];
		QaRobot.selectDateInCalendar1(expDate111, month111, year111);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("CClickVisaAddNew");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Client Visa Details");
		QaRobot.ClickOnElement("CClickOnClose");
		Thread.sleep(4000);
		QaRobot.ClickOnElement("v12CAMSubmitS");
		Thread.sleep(3000);
		QaRobot.scrollPage(4000);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("CSave");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Registered Clients List");
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
