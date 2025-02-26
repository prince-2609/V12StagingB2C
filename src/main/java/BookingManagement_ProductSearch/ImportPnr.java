package BookingManagement_ProductSearch;

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
public class ImportPnr {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("BookingManagement_ProductSearch_ImportPnr", "Sheet3");
	}

	@Test(dataProvider = "getexceldata")
	public static void importPnr(String TestCaseId, String TCType, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String SelectGDS, String PnrNumber, String PNRType,
			String JourneyType, String CabinClass, String Dest, String Destination, String DOB, String Phone,
			String Email, String FOP1, String ReceiptNo, String ChooseCardType, String CreditCardNumber,
			String CardHolderName, String ValidityMonth, String ValidityYear, String SecurityCode, String Title,
			String FN, String LN, String AddressLine1, String Ci, String City, String Email1) throws Exception {
		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + " - " + TCType + " - " + TestScenario);
		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("BookingManagement");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("ProductSearch");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("DirectCustomerClick");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ImportPnrClick");
		Thread.sleep(8000);
		QaRobot.selectTextFromDropdown("IPSelectGDS", SelectGDS);
		Thread.sleep(2000);
		QaRobot.PassValue("IPPnrNumber", PnrNumber);
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Import Pnr for Direct Customer");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("IPProceedClick");
		Thread.sleep(4000);
		if (PNRType.equalsIgnoreCase("Existing")) {
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Pnr Number Already Exist");
			// Thread.sleep(3000);
			QaRobot.ClickOnElement("IPExistingProceed");

		}

		// Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("IPJourneyType", JourneyType);
		Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("IPCabinClass", CabinClass);
		Thread.sleep(2000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='DivDestination']/p"), Dest, Destination,
				By.xpath("//input[@id='txtDestination']"));
		Thread.sleep(2000);
		QaRobot.ClickOnElement("IPCheckAllClick");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Passenger Details");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("IPItenaryProceedWithoutReprice");
		Thread.sleep(5000);
		QaExtentReport.extentScreenshot("Itenary Pricing");
		Thread.sleep(6000);
		// QaRobot.alertAccept();
		QaRobot.ClickOnElement("IPItenaryPricingBookNow");
		Thread.sleep(3000);
//		String DateSelection[] = DOB.split("-");
//		String year = DateSelection[2];
//		String month = DateSelection[1];
//		String expDate = DateSelection[0];
//		QaRobot.selectDateInCalendarIM(expDate, month, year);
//		Thread.sleep(2000);
		QaRobot.PassValue("IPTravellerPhone", Phone);
		QaRobot.PassValue("IPTravellerEmail", Email);
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Traveller Details");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("IPFulfillment");
		QaRobot.alertAccept();
		Thread.sleep(4000);
		if (FOP1.equalsIgnoreCase("Cash")) {
			QaRobot.selectTextFromDropdown("IPFOP1", FOP1);
			Thread.sleep(2000);
			QaRobot.PassValue("IPReceiptNo", ReceiptNo);
		} else if (FOP1.equalsIgnoreCase("Credit Card")) {
			QaRobot.selectTextFromDropdown("IPFOP1", FOP1);
			Thread.sleep(2000);
			QaRobot.selectTextFromDropdown("IPChooseCardType", ChooseCardType);
			Thread.sleep(2000);
			QaRobot.PassValue("IPCreditCardNumber", CreditCardNumber);
			QaRobot.PassValue("IPCardHolderName", CardHolderName);
			Thread.sleep(2000);
			QaRobot.selectTextFromDropdown("IPValidityMonth", ValidityMonth);
			Thread.sleep(2000);
			QaRobot.selectTextFromDropdown("IPValidityYear", ValidityYear);
			Thread.sleep(2000);
			QaRobot.PassValue("IPSecurityCode", SecurityCode);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Payment Page");
			Thread.sleep(2000);
			QaRobot.selectTextFromDropdown("IPBillingTitle", Title);
			Thread.sleep(2000);
			QaRobot.PassValue("IPBillingFN", FN);
			QaRobot.PassValue("IPBillingLN", LN);
			QaRobot.PassValue("IPAddressLine1", AddressLine1);
			Thread.sleep(2000);
		
			
			// city
			TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), Dest, Destination,
					By.xpath("//input[@id='ctl00_contentMain_payeeCity']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divHTCity']/p")).click();
			Thread.sleep(2000);
			QaRobot.PassValue("IPEmail", Email);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Billing Details");
			Thread.sleep(2000);
		}

		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Payment Page");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("IPPaymentProceed");
		Thread.sleep(4000);
		QaExtentReport.extentScreenshot("Booking Created");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("IPOpenBookingClick");

	}

	@AfterMethod
	public static void afterMethod() {
		 //QaExtentReport.test.getExtent().flush();
	}
}
