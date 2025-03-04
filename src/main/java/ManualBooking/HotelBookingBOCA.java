package ManualBooking;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
public class HotelBookingBOCA {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("HotelManualBooking", "Sheet4");
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
		QaRobot.ClickOnElement("MBCASelect");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCManualBooking");
		Thread.sleep(3000);
		QaRobot.PassValue("SearchCorporateTraveller", SelectClient);
		Thread.sleep(5000);
		QaRobot.ClickOnElement("MBCATraveller");
		Thread.sleep(5000);
		QaRobot.ClickOnElement("MBCATravellerType");
		Thread.sleep(8000);
		QaExtentReport.extentScreenshot("Select Manual Booking");
		QaRobot.ClickOnElement("MBDCContinue");
//		QaRobot.ClickOnElement("MBDCAddClientDetails");
//		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
//		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
//		for (String childWindow1 : handles1) {
//			if (!childWindow1.equals(ParentWindow1))
//				QaBrowser.driver.switchTo().window(childWindow1);
//		}
//		Thread.sleep(3000);
//		QaRobot.ClickOnElement("MBDCSearchClient");
//		QaRobot.listOfClients(By.xpath("/html/body/form/div[3]/div/div[3]/div/div/table/tbody/tr/td[3]/span"),
//				SelectClient);
//		QaBrowser.driver.switchTo().window(ParentWindow1);
//		QaBrowser.driver.switchTo().parentFrame();
//		QaRobot.switchframe("//frame[@name='login']");
//		QaRobot.switchframe("//frame[@name='main']");
//		QaRobot.switchframe("//frame[@id='frm2']");
		QaExtentReport.extentScreenshot("Select Client");
		Thread.sleep(6000);
		int TotalTraveller = Integer.parseInt(Adult) + Integer.parseInt(Child) + Integer.parseInt(Infant);
		System.out.println(TotalTraveller);
		if (TotalTraveller > 1) {
			QaRobot.ClickOnElement("MBDCTraveller");
			QaRobot.ClickOnElement("MBDCAddTraveller");
			String ParentWindow2 = QaBrowser.driver.getWindowHandle();
			Set<String> handles2 = QaBrowser.driver.getWindowHandles();
			for (String childWindow2 : handles2) {
				if (!childWindow2.equals(ParentWindow2))
					QaBrowser.driver.switchTo().window(childWindow2);
			}
			int adt = Integer.parseInt(Adult);
//			int chd = Integer.parseInt(Child);
//			int inf = Integer.parseInt(Infant);
			if (adt >= 2) {
				AddAdult(Adult, AdultName);
			}
			AddChild(Adult, Child, ChildName, ChildDOB);
			AddInfant(Adult, Child, Infant, InfantName, InfantDOB);
//			QaRobot.selectTextFromDropdown("MBDCAddTravellerTitle", "Mr");
//			QaRobot.PassValue("MBDCAddTravellerPhone", "9865326598");
			WebElement MBDCAddTravellerSave = QaBrowser.driver.findElement(By.xpath("//input[@id='btnSaveClose']"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", MBDCAddTravellerSave);
			Thread.sleep(10000);
			QaBrowser.driver.switchTo().window(ParentWindow2);
			QaBrowser.driver.switchTo().parentFrame();
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
		}
		QaExtentReport.extentScreenshot("Traveller Tab");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCProductsAndServices");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCProductsAndServicesHotel");
		Thread.sleep(3000);
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
		Thread.sleep(3000);
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
		Thread.sleep(3000);
		selectDate(Date, Month, Year);
		Thread.sleep(3000);
		QaBrowser.driver.findElement(By.xpath("//img[@id='Img2']")).click();
		Thread.sleep(5000);
		String DateS1[] = CODate.split("-");
		String Date1 = DateS1[0];
		String Month1 = DateS1[1];
		String Year1 = DateS1[2];
		Thread.sleep(3000);
		selectDate(Date1, Month1, Year1);
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCSelectAllPassenger");
		Thread.sleep(3000);
		QaRobot.selectTextFromDropdown("MBDCSelectStatusH", Hstatus);
		QaRobot.PassValue("MBDCConfirmationH", ConfirmationN);
		QaRobot.ClickOnElement("MBDCSelectManual");
		Thread.sleep(3000);
		QaRobot.PassValue("MBDCRoomTypeH", RoomType);
		QaRobot.PassValue("MBDCMealH", Meal);
		QaRobot.PassValue("MBDCCNH", ConfirmationN);
		QaRobot.PassValue("MBDCNRoomsH", NRooms);
		int adt1 = Integer.parseInt(Adult);
		if (adt1 == 1) {
			QaRobot.PassValue("MBDCAdultH", Adult);
		} else if (adt1 >= 2) {
			int TAdult1 = adt1 + 1;
			String Adult1 = Integer.toString(TAdult1);
			System.out.println(Adult1);
			QaRobot.PassValue("MBDCAdultH", Adult1);
		}

		int chd = Integer.parseInt(Child);
		if (chd > 0) {
			QaRobot.PassValue("MBDCChildH", Child);
		}
		Thread.sleep(3000);
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
		Thread.sleep(4000);
		QaRobot.ClickOnElement("MBDCProvisional");
		String ParentWindow4 = QaBrowser.driver.getWindowHandle();
		Set<String> handles4 = QaBrowser.driver.getWindowHandles();
		for (String childWindow4 : handles4) {
			if (!childWindow4.equals(ParentWindow4))
				QaBrowser.driver.switchTo().window(childWindow4);
		}
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCViewBooking");
		QaBrowser.driver.switchTo().window(ParentWindow4);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(4000);
		QaRobot.ClickOnElement("MBCAAuthorize");
		String ParentWindow5 = QaBrowser.driver.getWindowHandle();
		Set<String> handles5 = QaBrowser.driver.getWindowHandles();
		for (String childWindow5 : handles5) {
			if (!childWindow5.equals(ParentWindow5))
				QaBrowser.driver.switchTo().window(childWindow5);
		}
		Thread.sleep(7000);
		QaRobot.ClickOnElement("MBDCAuthorizeSubmit");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBCAAuthorizeProceedBooking");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("MBDCAuthorizeViewBooking");
		Thread.sleep(7000);
//		QaRobot.ClickOnElement("MBDCAuthorizeSubmit");sad
//		QaRobot.ClickOnElement("MBDCAuthorizeViewBooking");
//		Thread.sleep(7000);
		QaBrowser.driver.switchTo().window(ParentWindow5);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("MBDCDocuments");
		QaExtentReport.extentScreenshot("Documents");
		Thread.sleep(5000);
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
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCReceivePayment");
		String ParentWindow7 = QaBrowser.driver.getWindowHandle();
		Set<String> handles7 = QaBrowser.driver.getWindowHandles();
		for (String childWindow7 : handles7) {
			if (!childWindow7.equals(ParentWindow7))
				QaBrowser.driver.switchTo().window(childWindow7);
		}
		Thread.sleep(10000);
		QaRobot.ClickOnElement("MBDCPaymentSubmit");
		Thread.sleep(3000);
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

	
	public static void AddAdult(String Adult, String AdultName) throws Exception {
		int adt = Integer.parseInt(Adult);
		for (int i = 1; i <= adt; i++) {
			QaRobot.selectTextFromDropdown("MBDCSelectType", "Adult(ADT)");
			QaRobot.selectTextFromDropdown("MBDCAddTravellerTitle", "Mr");
			String AN[] = AdultName.split(",");
			String AN1 = AN[i - 1];
			String TN[] = AN1.split(" ");
			String FN = TN[0];
			String LN = TN[1];
//			if (i >= 2) {
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtFirstName']")).click();
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtFirstName']")).clear();
			QaRobot.PassValue("MBDCTravellerFirstName", FN);
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtLastName']")).click();
			QaBrowser.driver.findElement(By.xpath("//input[@id='txtLastName']")).clear();
			QaRobot.PassValue("MBDCTravellerLastName", LN);
	//		}
//			}
			QaRobot.PassValue("MBDCAddTravellerPhone", "9865326598");
			if (adt > 1 && i != adt) {
				QaRobot.ClickOnElement("MBDCSaveAddNew");
				QaRobot.dismissAlert();
			}
			QaRobot.ClickOnElement("MBDCSaveAddNew");
			QaRobot.dismissAlert();
		}
	}

	public static void AddChild(String Adult, String Child, String ChildName, String ChildDOB) throws Exception {
		int chd = Integer.parseInt(Child);
		for (int i = 1; i <= chd; i++) {
//			QaRobot.ClickOnElement("MBDCSaveAddNew");
//			Thread.sleep(4000);
//			int adt = Integer.parseInt(Adult);
//			if (adt > 1 && i < 2) {
//				QaBrowser.driver.switchTo().alert().dismiss();
//			}
//			Thread.sleep(4000);
			QaRobot.selectTextFromDropdown("MBDCSelectType", "Child(CHD)");
			QaRobot.selectTextFromDropdown("MBDCAddTravellerTitle", "Mstr");
			String CN[] = ChildName.split(",");
			String CN1 = CN[i - 1];
			String TN[] = CN1.split(" ");
			String FN = TN[0];
			String LN = TN[1];
			QaRobot.PassValue("MBDCTravellerFirstName", FN);
			QaRobot.PassValue("MBDCTravellerLastName", LN);
			QaRobot.ClickOnElement("MBDCTravelerCalender");
			String CB[] = ChildDOB.split(",");
			String CB1 = CB[i - 1];
			String DateS3[] = CB1.split("-");
			String Date3 = DateS3[0];
			String Month3 = DateS3[1];
			String Year3 = DateS3[2];
			selectDate(Date3, Month3, Year3);
			QaRobot.PassValue("MBDCAddTravellerPhone", "9865326598");
		}
	}

	public static void AddInfant(String Adult, String Child, String Infant, String InfantName, String InfantDOB)
			throws Exception {
		int ift = Integer.parseInt(Infant);
		for (int i = 1; i <= ift; i++) {
			QaRobot.ClickOnElement("MBDCSaveAddNew");
			Thread.sleep(4000);
			int adt = Integer.parseInt(Adult);
			int chd = Integer.parseInt(Child);
			if (adt > 1 && chd < 1 && i < 2) {
				QaBrowser.driver.switchTo().alert().dismiss();
			}
			Thread.sleep(4000);
			QaRobot.selectTextFromDropdown("MBDCSelectType", "Infant(INF)");
			QaRobot.selectIndexFromDropdown("MBDCInfantAssociate", 1);
			QaRobot.selectTextFromDropdown("MBDCAddTravellerTitle", "Mstr");
			String IN[] = InfantName.split(",");
			String IN1 = IN[i - 1];
			String TN[] = IN1.split(" ");
			String FN = TN[0];
			String LN = TN[1];
			QaRobot.PassValue("MBDCTravellerFirstName", FN);
			QaRobot.PassValue("MBDCTravellerLastName", LN);
			QaRobot.ClickOnElement("MBDCTravelerCalender");
			String IB[] = InfantDOB.split(",");
			String IB1 = IB[i - 1];
			String DateS3[] = IB1.split("-");
			String Date3 = DateS3[0];
			String Month3 = DateS3[1];
			String Year3 = DateS3[2];
			selectDate(Date3, Month3, Year3);
			QaRobot.PassValue("MBDCAddTravellerPhone", "9865326598");
		}
	}

	public static void selectDate(String Day, String Month, String Year) throws Exception {
		String text1 = "/html/body/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[1]/td/span/select[2]";
		QaRobot.selectTextByLocator1(text1, Year, "<b><i>Select year for adult</i></b>" + " - " + Year);
		Thread.sleep(2000);

		String text = "/html/body/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[1]/td/span/select[1]";
		QaRobot.selectTextByLocator1(text, Month, "<b><i>Select month for adult</i></b>" + " - " + Month);
		Thread.sleep(2000);

		List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath(
				"/html/body/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[2]/td/center/div/div[2]/center/table/tbody/tr/td/table/tbody/tr/td//input"));
		for (WebElement ele : allDates) {
			String dt = ele.getAttribute("value").trim();
			System.out.println(dt);
			if (dt.equalsIgnoreCase(Day)) {
				ele.click();
				Thread.sleep(2000);
				break;
			}
		}
	}

//	public static void costingForAdult(String BaseFareA, String SelectBreakupA, String BreakupsA, String TaxQtyA,
//			String TaxesA, String TaxAmountA) throws Exception {
//		QaRobot.ClickOnElement("MBDCBaseFareA");
//		WebElement MBDCBaseFare = QaBrowser.driver.findElement(By.xpath("//input[@id='basefareADT']"));
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		QaRobot.PassValue("MBDCBaseFareA", BaseFareA);
//		if (SelectBreakupA.equalsIgnoreCase("Yes")) {
//			String ChooseB[] = BreakupsA.split(",");
//			String TB = ChooseB[0];
//			String CB = ChooseB[1];
//			if (TB.equalsIgnoreCase("Tax")) {
//				QaRobot.ClickOnElement("MBDCTaxBreakupA");
//				QaRobot.ClickOnElement("MBDCTaxBreakupAddA");
//				int pAS1 = Integer.parseInt(TaxQtyA);
//				for (int k = 1; k <= pAS1; k++) {
//					String[] tN1 = TaxesA.split(",");
//					String b1 = tN1[k - 1];
//					String[] tA1 = TaxAmountA.split(",");
//					String bA = tA1[k - 1];
//
//					WebElement MBDCTaxBreakupAddTax = QaBrowser.driver
//							.findElement(By.xpath("/html/body/form/div[5]/table/tbody/tr[3]/td/table/tbody/tr["
//									+ (k + 1) + "]/td[1]/input[1]"));
//					MBDCTaxBreakupAddTax.sendKeys(b1);
//					WebElement MBDCTaxBreakupAddTax1Amount = QaBrowser.driver.findElement(By.xpath(
//							"/html/body/form/div[5]/table/tbody/tr[3]/td/table/tbody/tr[" + (k + 1) + "]/td[3]/input"));
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(bA);
//					if (pAS1 > 1) {
//						QaRobot.ClickOnElement("MBDCTaxBreakupAddA");
//					}
//				}
//				QaRobot.ClickOnElement("MBDCTaxBreakupAddAndCloseA");
//
//			} else if (CB.equalsIgnoreCase("Commission")) {
//
//			}
//		}
//	}
//
//	public static void costingForChild(String BaseFareC, String SelectBreakupC, String BreakupsC, String TaxQtyC,
//			String TaxesC, String TaxAmountC) throws Exception {
//		QaRobot.ClickOnElement("MBDCBaseFareC");
//		WebElement MBDCBaseFare = QaBrowser.driver.findElement(By.xpath("//input[@id='basefareCHD']"));
//		MBDCBaseFare.clear();
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		QaRobot.PassValue("MBDCBaseFareC", BaseFareC);
//		if (SelectBreakupC.equalsIgnoreCase("Yes")) {
//			String ChooseB[] = BreakupsC.split(",");
//			String TB = ChooseB[0];
//			String CB = ChooseB[1];
//			if (TB.equalsIgnoreCase("Tax")) {
//				QaRobot.ClickOnElement("MBDCTaxBreakupC");
//				QaRobot.ClickOnElement("MBDCTaxBreakupAddC");
//				int pAS1 = Integer.parseInt(TaxQtyC);
//				for (int k = 1; k <= pAS1; k++) {
//					String[] tN1 = TaxesC.split(",");
//					String b1 = tN1[k - 1];
//					String[] tA1 = TaxAmountC.split(",");
//					String bA = tA1[k - 1];
//
//					WebElement MBDCTaxBreakupAddTax = QaBrowser.driver
//							.findElement(By.xpath("/html/body/form/div[8]/table/tbody/tr[3]/td/table/tbody/tr["
//									+ (k + 1) + "]/td[1]/input[1]"));
//					MBDCTaxBreakupAddTax.sendKeys(b1);
//					WebElement MBDCTaxBreakupAddTax1Amount = QaBrowser.driver.findElement(By.xpath(
//							"/html/body/form/div[8]/table/tbody/tr[3]/td/table/tbody/tr[" + (k + 1) + "]/td[3]/input"));
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(bA);
//					if (pAS1 > 1) {
//						QaRobot.ClickOnElement("MBDCTaxBreakupAddC");
//					}
//				}
//				QaRobot.ClickOnElement("MBDCTaxBreakupAddAndCloseC");
//
//			} else if (CB.equalsIgnoreCase("Commission")) {
//
//			}
//		}
//	}
//
//	public static void costingForInfant(String BaseFareI, String SelectBreakupI, String BreakupsI, String TaxQtyI,
//			String TaxesI, String TaxAmountI) throws Exception {
//		QaRobot.ClickOnElement("MBDCBaseFareI");
//		WebElement MBDCBaseFare = QaBrowser.driver.findElement(By.xpath("//input[@id='basefareINF']"));
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		MBDCBaseFare.sendKeys(Keys.BACK_SPACE);
//		QaRobot.PassValue("MBDCBaseFareI", BaseFareI);
//		if (SelectBreakupI.equalsIgnoreCase("Yes")) {
//			String ChooseB[] = BreakupsI.split(",");
//			String TB = ChooseB[0];
//			String CB = ChooseB[1];
//			if (TB.equalsIgnoreCase("Tax")) {
//				QaRobot.ClickOnElement("MBDCTaxBreakupI");
//				QaRobot.ClickOnElement("MBDCTaxBreakupAddI");
//				int pAS1 = Integer.parseInt(TaxQtyI);
//				for (int k = 1; k <= pAS1; k++) {
//					String[] tN1 = TaxesI.split(",");
//					String b1 = tN1[k - 1];
//					String[] tA1 = TaxAmountI.split(",");
//					String bA = tA1[k - 1];
//
//					WebElement MBDCTaxBreakupAddTax = QaBrowser.driver
//							.findElement(By.xpath("/html/body/form/div[9]/table/tbody/tr[3]/td/table/tbody/tr["
//									+ (k + 1) + "]/td[1]/input[1]"));
//					MBDCTaxBreakupAddTax.sendKeys(b1);
//					WebElement MBDCTaxBreakupAddTax1Amount = QaBrowser.driver.findElement(By.xpath(
//							"/html/body/form/div[9]/table/tbody/tr[3]/td/table/tbody/tr[" + (k + 1) + "]/td[3]/input"));
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(Keys.BACK_SPACE);
//					MBDCTaxBreakupAddTax1Amount.sendKeys(bA);
//					if (pAS1 > 1) {
//						QaRobot.ClickOnElement("MBDCTaxBreakupAddI");
//					}
//				}
//				QaRobot.ClickOnElement("MBDCTaxBreakupAddAndCloseI");
//
//			} else if (CB.equalsIgnoreCase("Commission")) {
//
//			}
//		}
//	}
}
