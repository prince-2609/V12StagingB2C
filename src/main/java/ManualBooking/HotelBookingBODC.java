package ManualBooking;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
public class HotelBookingBODC {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("HotelManualBooking", "BODC");
	}

	@Test(dataProvider = "getexceldata")
	public static void corporateProfiling(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String SelectClient, String Adult, String Child,
			String Infant, String AdultName, String ChildName, String InfantName, String ChildDOB, String InfantDOB,
			String HotelName, String ChooseSupplier, String CCode, String CityCode, String CIDate, String CODate,
			String Hstatus, String ConfirmationN, String RoomType, String Meal, String NRooms, String BaseFare,
			String AddCharges, String OCN, String OtherCharges, String OGrossCharges, String ModeOfPayment)
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
		QaRobot.ClickOnElement("V12BookingManagement");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("V12ProductSearch");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCManualBooking");
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Select Manual Booking");
		QaRobot.ClickOnElement("MBDCContinue");
		QaRobot.ClickOnElement("MBDCAddClientDetails");
		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
		for (String childWindow1 : handles1) {
			if (!childWindow1.equals(ParentWindow1))
				QaBrowser.driver.switchTo().window(childWindow1);
		}
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCSearchClient");
		QaRobot.listOfClients(By.xpath("/html/body/form/div[3]/div/div[3]/div/div/table/tbody/tr/td[3]/span"),
				SelectClient);
		QaBrowser.driver.switchTo().window(ParentWindow1);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaExtentReport.extentScreenshot("Select Client");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCTraveller");
		QaRobot.ClickOnElement("MBDCAddTraveller");
		String ParentWindow2 = QaBrowser.driver.getWindowHandle();
		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
		for (String childWindow2 : handles2) {
			if (!childWindow2.equals(ParentWindow2))
				QaBrowser.driver.switchTo().window(childWindow2);
		}
		FlightBookingBODC.AddAdult(Adult, AdultName);
		FlightBookingBODC.AddChild(Adult, Child, ChildName, ChildDOB);
		FlightBookingBODC.AddInfant(Adult, Child, Infant, InfantName, InfantDOB);
//		QaRobot.selectTextFromDropdown("MBDCAddTravellerTitle", "Mr");
//		QaRobot.PassValue("MBDCAddTravellerPhone", "9865326598");
		WebElement MBDCAddTravellerSave = QaBrowser.driver.findElement(By.xpath("//input[@id='btnSaveClose']"));
		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
		js2.executeScript("arguments[0].click()", MBDCAddTravellerSave);
		Thread.sleep(10000);
		QaBrowser.driver.switchTo().window(ParentWindow2);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaExtentReport.extentScreenshot("Traveller Tab");
		QaRobot.ClickOnElement("MBDCProductsAndServices");
		QaRobot.ClickOnElement("MBDCProductsAndServicesHotel");
		QaRobot.ClickOnElement("MBDCProductsAndServicesFlightContinue");
		Thread.sleep(5000);
		String ParentWindow3 = QaBrowser.driver.getWindowHandle();
		Set<String> handles3 = QaBrowser.driver.getWindowHandles();
		for (String childWindow3 : handles3) {
			if (!childWindow3.equals(ParentWindow3))
				QaBrowser.driver.switchTo().window(childWindow3);
		}
		Thread.sleep(5000);
		QaRobot.ClickOnElement("MBDCHotelSubmit");
		QaRobot.PassValue("MBDCHotelName", HotelName);
		QaRobot.selectTextFromDropdown("MBDCSelectSupplierH", ChooseSupplier);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), CCode, CityCode,
				By.xpath("//input[@id='txtcitycode']"));
		QaBrowser.driver.findElement(By.xpath("//img[@id='Img1']")).click();
		Thread.sleep(5000);
		String DateS[] = CIDate.split("-");
		String Date = DateS[0];
		String Month = DateS[1];
		String Year = DateS[2];
		FlightBookingBODC.selectDate(Date, Month, Year);
		QaBrowser.driver.findElement(By.xpath("//img[@id='Img2']")).click();
		Thread.sleep(5000);
		String DateS1[] = CODate.split("-");
		String Date1 = DateS1[0];
		String Month1 = DateS1[1];
		String Year1 = DateS1[2];
		FlightBookingBODC.selectDate(Date1, Month1, Year1);
		QaRobot.ClickOnElement("MBDCSelectAllPassenger");
		QaRobot.selectTextFromDropdown("MBDCSelectStatusH", Hstatus);
		QaRobot.PassValue("MBDCConfirmationH", ConfirmationN);
		QaRobot.ClickOnElement("MBDCSelectManual");
		QaRobot.PassValue("MBDCRoomTypeH", RoomType);
		QaRobot.PassValue("MBDCMealH", Meal);
		QaRobot.PassValue("MBDCCNH", ConfirmationN);
		QaRobot.PassValue("MBDCNRoomsH", NRooms);
		QaRobot.PassValue("MBDCAdultH", Adult);
		int chd = Integer.parseInt(Child);
		if (chd > 0) {
			QaRobot.PassValue("MBDCChildH", Child);
		}
		QaRobot.ClickOnElement("MBDCBaseFareH");
		QaRobot.PassValue("MBDCBaseFareH", BaseFare);
		if (AddCharges.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("MBDCAddCharges");
			int OCNo = Integer.parseInt(OCN);
			for (int i = 1; i <= OCNo; i++) {
				String OCharge[] = OtherCharges.split(",");
				WebElement ChargesName = QaBrowser.driver
						.findElement(By.xpath("//select[@id='MOCharge_NewMddlCharge" + (i - 1) + "']"));
				Select s = new Select(ChargesName);
				s.selectByVisibleText(OCharge[i - 1]);
				WebElement MBDCSelectPax = QaBrowser.driver
						.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice" + (i - 1) + "']"));
				MBDCSelectPax.click();
				String GCharge[] = OGrossCharges.split(",");
				WebElement MBDCATime1 = QaBrowser.driver
						.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice" + (i - 1) + "']"));
				MBDCATime1.sendKeys(GCharge[i - 1]);
				if (OCNo >= 2) {
					QaRobot.ClickOnElement("MBDCAddCharges");
				}
			}
		}

		QaRobot.ClickOnElement("MBDCApplyTax");
		Thread.sleep(5000);
		QaRobot.ClickOnElement("MBDCSave");
		Thread.sleep(7000);
		QaBrowser.driver.switchTo().window(ParentWindow3);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaExtentReport.extentScreenshot("Product and Services");
		QaRobot.ClickOnElement("MBDCProvisional");
		String ParentWindow4 = QaBrowser.driver.getWindowHandle();
		Set<String> handles4 = QaBrowser.driver.getWindowHandles();
		for (String childWindow4 : handles4) {
			if (!childWindow4.equals(ParentWindow4))
				QaBrowser.driver.switchTo().window(childWindow4);
		}
		QaRobot.ClickOnElement("MBDCViewBooking");
		QaBrowser.driver.switchTo().window(ParentWindow4);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("MBDCAuthorize");
		String ParentWindow5 = QaBrowser.driver.getWindowHandle();
		Set<String> handles5 = QaBrowser.driver.getWindowHandles();
		for (String childWindow5 : handles5) {
			if (!childWindow5.equals(ParentWindow5))
				QaBrowser.driver.switchTo().window(childWindow5);
		}
		Thread.sleep(7000);
		QaRobot.ClickOnElement("MBDCAuthorizeSubmit");
		QaRobot.ClickOnElement("MBDCAuthorizeViewBooking");
		Thread.sleep(7000);
		QaBrowser.driver.switchTo().window(ParentWindow5);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("MBDCDocuments");
		QaExtentReport.extentScreenshot("Documents");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCCreateVoucher");
		String ParentWindow6 = QaBrowser.driver.getWindowHandle();
		Set<String> handles6 = QaBrowser.driver.getWindowHandles();
		for (String childWindow6 : handles6) {
			if (!childWindow6.equals(ParentWindow6))
				QaBrowser.driver.switchTo().window(childWindow6);
		}
		QaRobot.ClickOnElement("MBDCVoucherClose");
		Thread.sleep(5000);
		QaBrowser.driver.switchTo().window(ParentWindow6);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaExtentReport.extentScreenshot("Voucher No.");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCCuctomerPayment");
		QaRobot.ClickOnElement("MBDCReceivePayment");
		String ParentWindow7 = QaBrowser.driver.getWindowHandle();
		Set<String> handles7 = QaBrowser.driver.getWindowHandles();
		for (String childWindow7 : handles7) {
			if (!childWindow7.equals(ParentWindow7))
				QaBrowser.driver.switchTo().window(childWindow7);
		}
		Thread.sleep(10000);
		QaRobot.ClickOnElement("MBDCPaymentSubmit");
		QaRobot.selectTextFromDropdown("MBDCModeOFPayment", ModeOfPayment);
		QaRobot.selectIndexFromDropdown("MBDCInvoice", 1);
		QaExtentReport.extentScreenshot("Payment");
		Thread.sleep(3000);
		WebElement MBDCRecivePayment = QaBrowser.driver.findElement(By.xpath("//input[@id='btnReceived']"));
		JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
		js3.executeScript("arguments[0].click()", MBDCRecivePayment);
		Thread.sleep(15000);
		QaBrowser.driver.switchTo().window(ParentWindow7);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaExtentReport.extentScreenshot("Cutomer Payment");
		Thread.sleep(3000);
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}

}
