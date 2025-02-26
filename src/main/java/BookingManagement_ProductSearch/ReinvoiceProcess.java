package BookingManagement_ProductSearch;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
public class ReinvoiceProcess {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("BookinManagement_ReinvoiceProcess", "Sheet4");
	}

	@Test(dataProvider = "getexceldata")
	public static void reinvoiceProcess(String TestCaseId, String TCType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String BookingRef, String ReinvoiceQty,
			String ReasonForReinvoice, String Edit, String FlightNumber, String DepartureDate, String ArrivalDate,
			String BaseFare, String SupplierCommission, String AirlineTransFee, String MarkupFee, String DiscountName,
			String NoOfUnit, String GrossCharges, String SalesChannel, String Title, String FN1, String LN1,
			String Nationality, String Email, String Mobile1, String PassportNo, String PassportExpiry,
			String PassportIssueCountry, String Title1, String FN, String MN, String LN, String Mobile,
			String AgencyName, String ReinvoiceQty1, String ReasonForReinvoice1) throws Exception {
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
		QaRobot.ClickOnElement("BMOpenExistingBooking");
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(2000);
		QaRobot.PassValue("BMBookingRef", BookingRef);
		QaRobot.ClickOnElement("OpenExistingBookingSearch");
		Thread.sleep(5000);
		QaRobot.ClickOnElement("OEBDocumentsTabClick");
		QaRobot.scrollPage(1000);
		Thread.sleep(4000);
		QaExtentReport.extentScreenshot("Click on Reinvoice Request");
		Thread.sleep(5000);
		QaRobot.ClickOnElement("OEBReinvoiceRequestClick2");
		String ParentWindow2 = QaBrowser.driver.getWindowHandle();
		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
		for (String childWindow2 : handles2) {
			if (!childWindow2.equals(ParentWindow2))
				QaBrowser.driver.switchTo().window(childWindow2);
		}
		Thread.sleep(3000);
		int pA = Integer.parseInt(ReinvoiceQty);
		for (int k = 1; k <= pA; k++) {
			String[] tN1 = ReasonForReinvoice.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
					"/html/body/form/div[3]/div/div/div/div/div/div/div/div[2]/div[2]/ul/li[2]/div/div/div[2]/div/div/div/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Select ReInvoice Reason");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("OEBContinueClick");
		Thread.sleep(5000);

//		if (SalesChannel.equalsIgnoreCase("BOSA")) {
		if (Edit.equalsIgnoreCase("Itenary and Costing Edit1")) {
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Tax Invoice");
			Thread.sleep(1000);
			QaRobot.ClickOnElement("ItenaryAndCostingEdit");
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Before Editing Itenary Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("FlightNumberChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='flightno0']")).clear();
			QaRobot.PassValue("FlightNumberChange", FlightNumber);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBFlightDepartureDate");
			String DateSelection[] = DepartureDate.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];
			QaRobot.selectDateInCalendarIM1(expDate, month, year);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBFlightArrivalDate");
			String DateSelection1[] = ArrivalDate.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1 = DateSelection1[0];
			QaRobot.selectDateInCalendarIM1(expDate1, month1, year1);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Itenary Details");
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Before Editing Costing Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("BaseFareChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='basefareADT']")).clear();
			WebElement MBDCATime = QaBrowser.driver.findElement(By.xpath("//input[@id='basefareADT']"));
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("BaseFareChange", BaseFare);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("SupplierCommissionChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='commissionADT']")).clear();
			WebElement MBDCATime1 = QaBrowser.driver.findElement(By.xpath("//input[@id='commissionADT']"));
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("SupplierCommissionChange", SupplierCommission);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("AirlineTransFeeChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirlineTransFeeADT']")).clear();
			WebElement MBDCATime2 = QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirlineTransFeeADT']"));
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("AirlineTransFeeChange", AirlineTransFee);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("MarkUpFeeChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='transfeeADT']")).clear();
			WebElement MBDCATime3 = QaBrowser.driver.findElement(By.xpath("//input[@id='transfeeADT']"));
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("MarkUpFeeChange", MarkupFee);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("AddCharges");
			QaRobot.selectTextFromDropdown("OEBDiscountName", DiscountName);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBNoOfUnit");
			QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMQuantity1']")).clear();
			WebElement MBDCATime4 = QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMQuantity1']"));
			MBDCATime4.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("OEBNoOfUnit", NoOfUnit);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBGrossCharges");
			QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice1']")).clear();
			WebElement MBDCATime5 = QaBrowser.driver
					.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice1']"));
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("OEBGrossCharges", GrossCharges);
			QaRobot.scrollPage(1000);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Costing Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBUpdate");
			Thread.sleep(2000);
			QaRobot.scrollPage(1000);
		} else if (Edit.equalsIgnoreCase("Traveller Details Edit")) {
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Tax Invoice");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("TravellerDetailsEdit");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Before Editing Passenger Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("EditTravellerFN");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtFirstName']")).clear();
			QaRobot.PassValue("EditTravellerFN", FN);
			Thread.sleep(2000);
			QaRobot.PassValue("OEBTravellerMN", MN);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("EditTravellerLN");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtLastName']")).clear();
			QaRobot.PassValue("EditTravellerLN", LN);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("EditTravellerMobile");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txt_phoneAdt_H']")).clear();
			QaRobot.PassValue("EditTravellerMobile", Mobile);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Passenger Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OBTTravellerUpdateClick");
			QaRobot.scrollPage(1000);
		} else if (Edit.equalsIgnoreCase("Itenary Edit")) {
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Tax Invoice");
			Thread.sleep(1000);
			QaRobot.ClickOnElement("ItenaryAndCostingEdit");
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Before Editing Itenary Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("FlightNumberChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='flightno0']")).clear();
			QaRobot.PassValue("FlightNumberChange", FlightNumber);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBFlightDepartureDate");
			String DateSelection[] = DepartureDate.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];
			QaRobot.selectDateInCalendarIM1(expDate, month, year);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBFlightArrivalDate");
			String DateSelection1[] = ArrivalDate.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1 = DateSelection1[0];
			QaRobot.selectDateInCalendarIM1(expDate1, month1, year1);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Itenary Details");
			Thread.sleep(2000);
			QaRobot.scrollPage(1000);
			QaRobot.ClickOnElement("OEBUpdate");
			Thread.sleep(8000);
			QaRobot.scrollPage(1000);
		} else if (Edit.equalsIgnoreCase("Costing Edit")) {
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Tax Invoice");
			Thread.sleep(1000);
			QaRobot.ClickOnElement("ItenaryAndCostingEdit");
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Before Editing Costing Details");
			Thread.sleep(3000);
			QaRobot.ClickOnElement("BaseFareChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='basefareADT']")).clear();
			WebElement MBDCATime = QaBrowser.driver.findElement(By.xpath("//input[@id='basefareADT']"));
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("BaseFareChange", BaseFare);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("SupplierCommissionChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='commissionADT']")).clear();
			WebElement MBDCATime1 = QaBrowser.driver.findElement(By.xpath("//input[@id='commissionADT']"));
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("SupplierCommissionChange", SupplierCommission);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("AirlineTransFeeChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirlineTransFeeADT']")).clear();
			WebElement MBDCATime2 = QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirlineTransFeeADT']"));
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("AirlineTransFeeChange", AirlineTransFee);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("MarkUpFeeChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='transfeeADT']")).clear();
			WebElement MBDCATime3 = QaBrowser.driver.findElement(By.xpath("//input[@id='transfeeADT']"));
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("MarkUpFeeChange", MarkupFee);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("AddCharges");
			QaRobot.selectTextFromDropdown("OEBDiscountName", DiscountName);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBNoOfUnit");
			QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMQuantity1']")).clear();
			WebElement MBDCATime4 = QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMQuantity1']"));
			MBDCATime4.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("OEBNoOfUnit", NoOfUnit);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBGrossCharges");
			QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice1']")).clear();
			WebElement MBDCATime5 = QaBrowser.driver
					.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice1']"));
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("OEBGrossCharges", GrossCharges);
			QaRobot.scrollPage(1000);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Costing Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBUpdate");
			Thread.sleep(2000);
			QaRobot.scrollPage(1000);
		} else if (Edit.equalsIgnoreCase("Itenary and Costing Edit2")) {
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Tax Invoice");
			QaRobot.ClickOnElement("ItenaryAndCostingEdit");
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Before Editing Itenary Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("FlightNumberChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='flightno0']")).clear();
			QaRobot.PassValue("FlightNumberChange", FlightNumber);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBFlightDepartureDate");
			String DateSelection[] = DepartureDate.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];
			QaRobot.selectDateInCalendarIM1(expDate, month, year);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBFlightArrivalDate");
			String DateSelection1[] = ArrivalDate.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1 = DateSelection1[0];
			QaRobot.selectDateInCalendarIM1(expDate1, month1, year1);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Itenary Details");
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Before Editing Costing Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("BaseFareChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='basefareADT']")).clear();
			WebElement MBDCATime = QaBrowser.driver.findElement(By.xpath("//input[@id='basefareADT']"));
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("BaseFareChange", BaseFare);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("SupplierCommissionChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='commissionADT']")).clear();
			WebElement MBDCATime1 = QaBrowser.driver.findElement(By.xpath("//input[@id='commissionADT']"));
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("SupplierCommissionChange", SupplierCommission);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("AirlineTransFeeChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirlineTransFeeADT']")).clear();
			WebElement MBDCATime2 = QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirlineTransFeeADT']"));
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("AirlineTransFeeChange", AirlineTransFee);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("MarkUpFeeChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='transfeeADT']")).clear();
			WebElement MBDCATime3 = QaBrowser.driver.findElement(By.xpath("//input[@id='transfeeADT']"));
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("MarkUpFeeChange", MarkupFee);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("AddCharges");
			QaRobot.selectTextFromDropdown("OEBDiscountName", DiscountName);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBNoOfUnit");
			QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMQuantity1']")).clear();
			WebElement MBDCATime4 = QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMQuantity1']"));
			MBDCATime4.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("OEBNoOfUnit", NoOfUnit);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBGrossCharges");
			QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice1']")).clear();
			WebElement MBDCATime5 = QaBrowser.driver
					.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice1']"));
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("OEBGrossCharges", GrossCharges);
			QaRobot.scrollPage(1000);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Costing Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBUpdate");
			Thread.sleep(8000);
			QaExtentReport.extentScreenshot("Tax Invoice");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("TravellerDetailsEdit");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Before Editing Passenger Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("EditTravellerFN");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtFirstName']")).clear();
			QaRobot.PassValue("EditTravellerFN", FN);
			Thread.sleep(2000);
			QaRobot.PassValue("OEBTravellerMN", MN);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("EditTravellerLN");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtLastName']")).clear();
			QaRobot.PassValue("EditTravellerLN", LN);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("EditTravellerMobile");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txt_phoneAdt_H']")).clear();
			QaRobot.PassValue("EditTravellerMobile", Mobile);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Passenger Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OBTTravellerUpdateClick");
			QaRobot.scrollPage(1000);
		} else if (Edit.equalsIgnoreCase("Itenary and Costing Edit")) {
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Tax Invoice");
			QaRobot.ClickOnElement("ItenaryAndCostingEdit");
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Before Editing Itenary Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("FlightNumberChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='flightno0']")).clear();
			QaRobot.PassValue("FlightNumberChange", FlightNumber);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBFlightDepartureDate");
			String DateSelection[] = DepartureDate.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];
			QaRobot.selectDateInCalendarIM1(expDate, month, year);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBFlightArrivalDate");
			String DateSelection1[] = ArrivalDate.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1 = DateSelection1[0];
			QaRobot.selectDateInCalendarIM1(expDate1, month1, year1);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Itenary Details");
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Before Editing Costing Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("BaseFareChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='basefareADT']")).clear();
			WebElement MBDCATime = QaBrowser.driver.findElement(By.xpath("//input[@id='basefareADT']"));
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			MBDCATime.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("BaseFareChange", BaseFare);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("SupplierCommissionChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='commissionADT']")).clear();
			WebElement MBDCATime1 = QaBrowser.driver.findElement(By.xpath("//input[@id='commissionADT']"));
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			MBDCATime1.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("SupplierCommissionChange", SupplierCommission);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("AirlineTransFeeChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirlineTransFeeADT']")).clear();
			WebElement MBDCATime2 = QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirlineTransFeeADT']"));
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			MBDCATime2.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("AirlineTransFeeChange", AirlineTransFee);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("MarkUpFeeChange");
			QaBrowser.driver.findElement(By.xpath("//input[@id='transfeeADT']")).clear();
			WebElement MBDCATime3 = QaBrowser.driver.findElement(By.xpath("//input[@id='transfeeADT']"));
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			MBDCATime3.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("MarkUpFeeChange", MarkupFee);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("AddCharges");
			QaRobot.selectTextFromDropdown("OEBDiscountName", DiscountName);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBNoOfUnit");
			QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMQuantity1']")).clear();
			WebElement MBDCATime4 = QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMQuantity1']"));
			MBDCATime4.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("OEBNoOfUnit", NoOfUnit);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBGrossCharges");
			QaBrowser.driver.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice1']")).clear();
			WebElement MBDCATime5 = QaBrowser.driver
					.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice1']"));
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			MBDCATime5.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("OEBGrossCharges", GrossCharges);
			QaRobot.scrollPage(1000);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Costing Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBUpdate");
			Thread.sleep(8000);
			// Itenary & costing amendements done
//			QaExtentReport.extentScreenshot("Before Editing SubAgent Profile Details");
//			Thread.sleep(2000);
//			QaRobot.ClickOnElement("OEBClientDetailsEdit");
//			Thread.sleep(5000);
//			QaRobot.ClickOnElement("OEBSubmit");
//			Thread.sleep(2000);
//			QaRobot.ClickOnElement("OEBAgencyName");
//			QaBrowser.driver.findElement(By.xpath("//input[@id='txtCompanyName']")).clear();
//			QaRobot.PassValue("OEBAgencyName", AgencyName);
//			Thread.sleep(2000);
//			QaExtentReport.extentScreenshot("After Editing SubAgent Profile Details");
//			Thread.sleep(2000);
//			QaRobot.scrollPage(5000);
//			Thread.sleep(2000);
//			QaExtentReport.extentScreenshot("SubAgent Profile Save");
//			Thread.sleep(2000);
//			QaRobot.ClickOnElement("OEBBOSASave");
//			Thread.sleep(2000);
//			QaBrowser.driver.close();
//			QaBrowser.driver.switchTo().window(ParentWindow2);
//			QaRobot.switchframe("//frame[@name='login']");
//			QaRobot.switchframe("//frame[@name='main']");
//			QaRobot.switchframe("//frame[@id='frm2']");
//			QaRobot.ClickOnElement("OEBReinvoiceRequestClick");
//			Thread.sleep(3000);
//			String ParentWindow3 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles3 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow3 : handles3) {
//				if (!childWindow3.equals(ParentWindow3))
//					QaBrowser.driver.switchTo().window(childWindow3);
//			}
//			Thread.sleep(3000);
//			QaExtentReport.extentScreenshot("Click on Reinvoice Request");
//			Thread.sleep(2000);
//			QaRobot.ClickOnElement("TravellerEdit");
//			Thread.sleep(3000);
//			QaRobot.ClickOnElement("OEBContinueClick");
//			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Before Editing Passenger Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("TravellerDetailsEdit");
			Thread.sleep(3000);
			QaRobot.PassValue("OEBTravellerMN", MN);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Passenger Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OBTTravellerUpdateClick");
			Thread.sleep(2000);
			QaRobot.scrollPage(1000);
		} else if (Edit.equalsIgnoreCase("Client Details Edit1")) {
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Tax Invoice");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBClientDetailsEdit");
			QaExtentReport.test.log(Status.INFO, "<b><i>Edit client details</i></b>");
			Thread.sleep(5000);
			QaRobot.ClickOnElement("OEBSubmit");
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Before Editing SubAgent Profile Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBAgencyName");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtCompanyName']")).clear();
			QaRobot.PassValue("OEBAgencyName", AgencyName);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing SubAgent Profile Details");
			Thread.sleep(2000);
			QaRobot.scrollPage(5000);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("SubAgent Profile Save");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBBOSASave");
			Thread.sleep(3000);
			QaBrowser.driver.close();
			QaBrowser.driver.switchTo().window(ParentWindow2);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			QaRobot.ClickOnElement("OEBReinvoiceRequestClick");
			Thread.sleep(3000);
			String ParentWindow3 = QaBrowser.driver.getWindowHandle();
			Set<String> handles3 = QaBrowser.driver.getWindowHandles();
			for (String childWindow3 : handles3) {
				if (!childWindow3.equals(ParentWindow3))
					QaBrowser.driver.switchTo().window(childWindow3);
			}
			Thread.sleep(3000);
			int pA1 = Integer.parseInt(ReinvoiceQty1);
			for (int k = 1; k <= pA1; k++) {
				String[] tN1 = ReasonForReinvoice1.split(",");
				String b1 = tN1[k - 1];
				List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
						"/html/body/form/div[3]/div/div/div/div/div/div/div/div[2]/div[2]/ul/li[2]/div/div/div[2]/div/div/div/label"));
				for (WebElement autoRights1 : listOfRights1) {
					System.out.println(autoRights1.getText());
					if (autoRights1.getText().equalsIgnoreCase(b1)) {
						autoRights1.click();
						Thread.sleep(3000);
					}
				}
			}
			Thread.sleep(2000);
//			QaExtentReport.extentScreenshot("Select ReInvoice Reason");
//			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBContinueClick");
			Thread.sleep(5000);
			QaRobot.scrollPage(1000);
		} else if (Edit.equalsIgnoreCase("Client Details Edit")) {
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Tax Invoice");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBClientDetailsEdit");
			Thread.sleep(5000);
			QaRobot.ClickOnElement("OEBSubmit");
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("Before Editing SubAgent Profile Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBAgencyName");
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtCompanyName']")).clear();
			QaRobot.PassValue("OEBAgencyName", AgencyName);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing SubAgent Profile Details");
			Thread.sleep(2000);
			QaRobot.scrollPage(5000);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("SubAgent Profile Save");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBBOSASave");
			Thread.sleep(3000);
			QaBrowser.driver.close();
			QaBrowser.driver.switchTo().window(ParentWindow2);
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			QaRobot.ClickOnElement("OEBReinvoiceRequestClick");
			Thread.sleep(3000);
			String ParentWindow3 = QaBrowser.driver.getWindowHandle();
			Set<String> handles3 = QaBrowser.driver.getWindowHandles();
			for (String childWindow3 : handles3) {
				if (!childWindow3.equals(ParentWindow3))
					QaBrowser.driver.switchTo().window(childWindow3);
			}
			Thread.sleep(3000);
			int pA1 = Integer.parseInt(ReinvoiceQty1);
			for (int k = 1; k <= pA1; k++) {
				String[] tN1 = ReasonForReinvoice1.split(",");
				String b1 = tN1[k - 1];
				List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
						"/html/body/form/div[3]/div/div/div/div/div/div/div/div[2]/div[2]/ul/li[2]/div/div/div[2]/div/div/div/label"));
				for (WebElement autoRights1 : listOfRights1) {
					System.out.println(autoRights1.getText());
					if (autoRights1.getText().equalsIgnoreCase(b1)) {
						autoRights1.click();
						Thread.sleep(3000);
					}
				}
			}
			Thread.sleep(2000);
//			QaExtentReport.extentScreenshot("Select ReInvoice Reason");
//			Thread.sleep(2000);
			QaRobot.ClickOnElement("OEBContinueClick");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("Before Editing Passenger Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("TravellerDetailsEdit");
			Thread.sleep(3000);
			QaRobot.selectTextFromDropdown("TravellersTitleEdit", Title1);
			Thread.sleep(2000);
			QaRobot.PassValue("OEBTravellerMN", MN);
			Thread.sleep(2000);
			QaExtentReport.extentScreenshot("After Editing Passenger Details");
			Thread.sleep(2000);
			QaRobot.ClickOnElement("OBTTravellerUpdateClick");
			Thread.sleep(2000);
			QaRobot.scrollPage(1000);
		}

//			QaRobot.ClickOnElement("SendRequestClick");
//			QaRobot.alertAccept();
//			Thread.sleep(6000);
//		QaBrowser.driver.switchTo().window(ParentWindow2);
//		QaRobot.switchframe("//frame[@name='login']");
//		QaRobot.switchframe("//frame[@name='main']");
//		QaRobot.switchframe("//frame[@id='frm2']");
//		QaRobot.scrollPage(2000);
//		Thread.sleep(3000);
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}

}
