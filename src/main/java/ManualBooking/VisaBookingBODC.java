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
public class VisaBookingBODC {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("VisaManualBooking", "Sheet6");
	}

	@Test(dataProvider = "getexceldata")
	public static void corporateProfiling(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String SelectClient, String Adult, String Child,
			String Infant, String AdultName, String ChildName, String InfantName, String ChildDOB, String InfantDOB,
			String CT, String Country, String DC, String City, String SDate, String EDate, String TypeOfVisa,
			String NoOfEntries, String DestiAdd, String Supplier, String Status, String ApplicationId, String VC,
			String VisaC, String CRT, String CityT, String Gender, String PAddT, String EmbassyF, String AddCharges,
			String OCN, String OtherCharges, String OGrossCharges, String PassportN, String ExpiryD, String PCR,
			String PCity, String Nationality, String ModeOfPayment) throws Exception {
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
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCContinue");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCAddClientDetails");
		String ParentWindow1 = QaBrowser.driver.getWindowHandle();
		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
		for (String childWindow1 : handles1) {
			if (!childWindow1.equals(ParentWindow1))
				QaBrowser.driver.switchTo().window(childWindow1);
		}
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCSearchClient");
		Thread.sleep(3000);
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
		int adt = Integer.parseInt(Adult);
		int chd = Integer.parseInt(Child);
		int ift = Integer.parseInt(Infant);

		if (adt > 0) {
			AddAdult(Adult, AdultName, CT, Country, DC, City, SDate, EDate, TypeOfVisa, NoOfEntries, DestiAdd, Supplier,
					Status, ApplicationId, VC, VisaC, CRT, CityT, Gender, PAddT, EmbassyF, AddCharges, OCN,
					OtherCharges, OGrossCharges, PassportN, ExpiryD, PCR, PCity, Nationality);
		}
		if (chd > 0) {
			if (adt > 0) {
				QaRobot.ClickOnElement("MBDCTraveller");
				QaRobot.ClickOnElement("MBDCAddTraveller");
			}
			AddChild(Adult, Child, ChildName, ChildDOB, CT, Country, DC, City, SDate, EDate, TypeOfVisa, NoOfEntries,
					DestiAdd, Supplier, Status, ApplicationId, VC, VisaC, CRT, CityT, Gender, PAddT, EmbassyF,
					AddCharges, OCN, OtherCharges, OGrossCharges, PassportN, ExpiryD, PCR, PCity, Nationality);
		}
		if (ift > 0) {
			if (adt > 0) {
				QaRobot.ClickOnElement("MBDCTraveller");
				QaRobot.ClickOnElement("MBDCAddTraveller");
			}
			AddInfant(Adult, Child, Infant, InfantName, InfantDOB, CT, Country, DC, City, SDate, EDate, TypeOfVisa,
					NoOfEntries, DestiAdd, Supplier, Status, ApplicationId, VC, VisaC, CRT, CityT, Gender, PAddT,
					EmbassyF, AddCharges, OCN, OtherCharges, OGrossCharges, PassportN, ExpiryD, PCR, PCity,
					Nationality);
		}

//		String ParentWindow2 = QaBrowser.driver.getWindowHandle();
//		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
//		for (String childWindow2 : handles2) {
//			if (!childWindow2.equals(ParentWindow2))
//				QaBrowser.driver.switchTo().window(childWindow2);
//		}
//		AddAdult(Adult, AdultName);
//		AddChild(Adult, Child, ChildName, ChildDOB);
//		AddInfant(Adult, Child, Infant, InfantName, InfantDOB);
////		QaRobot.selectTextFromDropdown("MBDCAddTravellerTitle", "Mr");
////		QaRobot.PassValue("MBDCAddTravellerPhone", "9865326598");
//		WebElement MBDCAddTravellerSave = QaBrowser.driver.findElement(By.xpath("//input[@id='btnSaveClose']"));
//		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//		js2.executeScript("arguments[0].click()", MBDCAddTravellerSave);
//		Thread.sleep(10000);
//		QaBrowser.driver.switchTo().window(ParentWindow2);
//		QaBrowser.driver.switchTo().parentFrame();
//		QaRobot.switchframe("//frame[@name='login']");
//		QaRobot.switchframe("//frame[@name='main']");
//		QaRobot.switchframe("//frame[@id='frm2']");
//		QaExtentReport.extentScreenshot("Traveller Tab");
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
		QaRobot.ClickOnElement("MBDCAuthorize");
		String ParentWindow5 = QaBrowser.driver.getWindowHandle();
		Set<String> handles5 = QaBrowser.driver.getWindowHandles();
		for (String childWindow5 : handles5) {
			if (!childWindow5.equals(ParentWindow5))
				QaBrowser.driver.switchTo().window(childWindow5);
		}
		Thread.sleep(20000);
		QaRobot.ClickOnElement("MBDCAuthorizeSubmit");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCAuthorizeViewBooking");
		Thread.sleep(7000);
		QaBrowser.driver.switchTo().window(ParentWindow5);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(5000);
		QaRobot.ClickOnElement("MBDCDocuments");
		QaExtentReport.extentScreenshot("Documents");
		Thread.sleep(5000);
		int TotalTraveller = Integer.parseInt(Adult) + Integer.parseInt(Child) + Integer.parseInt(Infant);
		System.out.println(TotalTraveller);
		for (int i = 1; i <= TotalTraveller; i++) {
			WebElement MBDCSelectPax = QaBrowser.driver
					.findElement(By.xpath("//span[@id='MODocument_[lblCURRENT INVOICE]" + (i - 1) + "0']/span"));
			MBDCSelectPax.click();
			String ParentWindow6 = QaBrowser.driver.getWindowHandle();
			Set<String> handles6 = QaBrowser.driver.getWindowHandles();
			for (String childWindow6 : handles6) {
				if (!childWindow6.equals(ParentWindow6))
					QaBrowser.driver.switchTo().window(childWindow6);
			}
			Thread.sleep(10000);
			QaRobot.ClickOnElement("MBDCVoucherClose");
			Thread.sleep(5000);
			QaBrowser.driver.switchTo().window(ParentWindow6);
			QaBrowser.driver.switchTo().parentFrame();
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
		}
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
		Thread.sleep(15000);
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
		//QaExtentReport.test.getExtent().flush();
	}

	public static void Process(String CT, String Country, String DC, String City, String SDate, String EDate,
			String TypeOfVisa, String NoOfEntries, String DestiAdd, String Supplier, String Status,
			String ApplicationId, String VC, String VisaC, String CRT, String CityT, String Gender, String PAddT,
			String EmbassyF, String AddCharges, String OCN, String OtherCharges, String OGrossCharges, String PassportN,
			String ExpiryD, String PCR, String PCity, String Nationality) throws Exception {
		QaRobot.ClickOnElement("MBDCProductsAndServices");
		QaRobot.ClickOnElement("MBDCProductsAndServicesVisa");
		String ParentWindow3 = QaBrowser.driver.getWindowHandle();
		Set<String> handles3 = QaBrowser.driver.getWindowHandles();
		for (String childWindow3 : handles3) {
			if (!childWindow3.equals(ParentWindow3))
				QaBrowser.driver.switchTo().window(childWindow3);
		}
		Thread.sleep(8000);
		QaRobot.ClickOnElement("MBDCVisaSubmit");
		TestBase.listofautosuggestion(By.xpath("//div[@id='divCountryOfTravel']/p"), CT, Country,
				By.xpath("//input[@id='txtCountryOfTravel']"));
		TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), DC, City,
				By.xpath("//input[@id='txtDestinationCity']"));
		QaBrowser.driver.findElement(By.xpath("//div[@id='divtxtStartDateofTravel']/a")).click();
		Thread.sleep(3000);
		selectDate1(SDate);
		QaBrowser.driver.findElement(By.xpath("//div[@id='divtxtEndDateofTravel']/a")).click();
		Thread.sleep(3000);
		selectDate1(EDate);
		QaRobot.selectTextFromDropdown("MBDCTypeOfVisa", TypeOfVisa);
		QaRobot.selectTextFromDropdown("MBDCNoOfEntries", NoOfEntries);
		QaRobot.PassValue("MBDCDestinationAddV", DestiAdd);
		QaRobot.selectTextFromDropdown("MBDCVisaSupplier", Supplier);
		QaRobot.selectTextFromDropdown("MBDCVisaStatus", Status);
		QaRobot.PassValue("MBDCAppId", ApplicationId);
		QaRobot.scrollPage(1000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divIssuingCity']/p"), VC, VisaC,
				By.xpath("//input[@id='txtIssuingCity']"));
		QaRobot.ClickOnElement("MBDCVisaNext1");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCAssociateTraveler");
		Thread.sleep(3000);
//		int TotalTraveller = Integer.parseInt(Adult) + Integer.parseInt(Child) + Integer.parseInt(Infant);
//		System.out.println(TotalTraveller);
//		for (int i = 1; i <= TotalTraveller; i++) {
		WebElement MBDCSelectPax = QaBrowser.driver
				.findElement(By.xpath("//input[@id='gvDependant_ctl02_ChkAssociatePax']"));
		MBDCSelectPax.click();
//		}
		Thread.sleep(5000);
		QaRobot.ClickOnElement("MBDCAssociatePax1");
		QaRobot.ClickOnElement("MBDCSelectAssociateTraveler");
		TestBase.listofautosuggestion(By.xpath("//div[@id='divCountryOfResidence']/p"), CRT, CityT,
				By.xpath("//input[@id='txtCountryOfResidence']"));
		QaRobot.selectTextFromDropdown("MBDCGenderT", Gender);
		QaRobot.PassValue("MBDCPresentAddT", PAddT);
		QaRobot.scrollPage(5000);
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCVisaNext2");
		Thread.sleep(3000);
		WebElement MBDCEmbassyFT = QaBrowser.driver.findElement(By.xpath("//input[@id='txtVisaEmbcyFare']"));
		MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
		MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
		MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
		MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
		QaRobot.PassValue("MBDCEmbassyFT", EmbassyF);
		if (AddCharges.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("MBDCAddChargesT");
			int OCNo = Integer.parseInt(OCN);
			for (int i = 1; i <= OCNo; i++) {
				String OCharge[] = OtherCharges.split(",");
				WebElement ChargesName = QaBrowser.driver
						.findElement(By.xpath("//select[@id='MOCharge_NewMddlCharge" + (i) + "']"));
				Select s = new Select(ChargesName);
				s.selectByVisibleText(OCharge[i - 1]);
//				WebElement MBDCSelectPax = QaBrowser.driver
//						.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice" + (i - 1) + "']"));
//				MBDCSelectPax.click();
				String GCharge[] = OGrossCharges.split(",");
				WebElement MBDCATime1 = QaBrowser.driver
						.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice" + (i) + "']"));
				MBDCATime1.clear();
				MBDCATime1.sendKeys(GCharge[i - 1]);
				if (OCNo >= 2) {
					QaRobot.ClickOnElement("MBDCAddChargesT");
				}
			}
		}
		QaRobot.scrollPage(5000);
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCApplyTax");
		Thread.sleep(3000);
		QaRobot.scrollPage(5000);
		Thread.sleep(3000);
		QaRobot.ClickOnElement("MBDCVisaNext3");
		QaRobot.PassValue("MBDCPassportT", PassportN);
		QaRobot.PassValue("MBDCExpiryDateT", ExpiryD);
		Thread.sleep(3000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divPassIssuingCountry']/p"), PCR, PCity,
				By.xpath("//input[@id='txtPassIssuingCountry']"));
		QaRobot.selectTextFromDropdown("MBDCNationalityT", Nationality);
		QaRobot.ClickOnElement("MBDCPassportSaveT");
		QaRobot.acceptAlert("");
		Thread.sleep(7000);
		QaBrowser.driver.switchTo().window(ParentWindow3);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaExtentReport.extentScreenshot("Product and Services");

	}

	public static void AddAdult(String Adult, String AdultName, String CT, String Country, String DC, String City,
			String SDate, String EDate, String TypeOfVisa, String NoOfEntries, String DestiAdd, String Supplier,
			String Status, String ApplicationId, String VC, String VisaC, String CRT, String CityT, String Gender,
			String PAddT, String EmbassyF, String AddCharges, String OCN, String OtherCharges, String OGrossCharges,
			String PassportN, String ExpiryD, String PCR, String PCity, String Nationality) throws Exception {
		String ParentWindow2 = QaBrowser.driver.getWindowHandle();
		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
		for (String childWindow2 : handles2) {
			if (!childWindow2.equals(ParentWindow2))
				QaBrowser.driver.switchTo().window(childWindow2);
		}
		int adt = Integer.parseInt(Adult);
		for (int i = 1; i <= adt; i++) {
			QaRobot.selectTextFromDropdown("MBDCSelectType", "Adult(ADT)");
			QaRobot.selectTextFromDropdown("MBDCAddTravellerTitle", "Mr");
			String AN[] = AdultName.split(",");
			String AN1 = AN[i - 1];
			String TN[] = AN1.split(" ");
			String FN = TN[0];
			String LN = TN[1];
			if (i >= 2) {
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtFirstName']")).click();
				QaRobot.PassValue("MBDCTravellerFirstName", FN);
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtLastName']")).click();
				QaRobot.PassValue("MBDCTravellerLastName", LN);
			}
			QaRobot.PassValue("MBDCAddTravellerPhone", "9865326598");
//			if (adt > 1 && i != adt) {
//				QaRobot.ClickOnElement("MBDCSaveAddNew");
//			}
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
			Thread.sleep(6000);
			QaRobot.ClickOnElement("MBDCProductsAndServices");
			QaRobot.ClickOnElement("MBDCProductsAndServicesVisa");
			String ParentWindow3 = QaBrowser.driver.getWindowHandle();
			Set<String> handles3 = QaBrowser.driver.getWindowHandles();
			for (String childWindow3 : handles3) {
				if (!childWindow3.equals(ParentWindow3))
					QaBrowser.driver.switchTo().window(childWindow3);
			}
			Thread.sleep(8000);
			QaRobot.ClickOnElement("MBDCVisaSubmit");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCountryOfTravel']/p"), CT, Country,
					By.xpath("//input[@id='txtCountryOfTravel']"));
			TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), DC, City,
					By.xpath("//input[@id='txtDestinationCity']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divtxtStartDateofTravel']/a")).click();
			Thread.sleep(3000);
			selectDate1(SDate);
			QaBrowser.driver.findElement(By.xpath("//div[@id='divtxtEndDateofTravel']/a")).click();
			Thread.sleep(3000);
			selectDate1(EDate);
			Thread.sleep(3000);
			QaRobot.selectTextFromDropdown("MBDCTypeOfVisa", TypeOfVisa);
			QaRobot.selectTextFromDropdown("MBDCNoOfEntries", NoOfEntries);
			QaRobot.PassValue("MBDCDestinationAddV", DestiAdd);
			QaRobot.selectTextFromDropdown("MBDCVisaSupplier", Supplier);
			QaRobot.selectTextFromDropdown("MBDCVisaStatus", Status);
			QaRobot.PassValue("MBDCAppId", ApplicationId);
			QaRobot.scrollPage(1000);
			TestBase.listofautosuggestion(By.xpath("//div[@id='divIssuingCity']/p"), VC, VisaC,
					By.xpath("//input[@id='txtIssuingCity']"));
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCVisaNext1");
			QaRobot.ClickOnElement("MBDCAssociateTraveler");
			Thread.sleep(3000);
//			int TotalTraveller = Integer.parseInt(Adult) + Integer.parseInt(Child) + Integer.parseInt(Infant);
//			System.out.println(TotalTraveller);
//			for (int i = 1; i <= TotalTraveller; i++) {
			WebElement MBDCSelectPax = QaBrowser.driver
					.findElement(By.xpath("//input[@id='gvDependant_ctl02_ChkAssociatePax']"));
			MBDCSelectPax.click();
//			}
			Thread.sleep(5000);
			QaRobot.ClickOnElement("MBDCAssociatePax1");
			QaRobot.ClickOnElement("MBDCSelectAssociateTraveler");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCountryOfResidence']/p"), CRT, CityT,
					By.xpath("//input[@id='txtCountryOfResidence']"));
			QaRobot.selectTextFromDropdown("MBDCGenderT", Gender);
			QaRobot.PassValue("MBDCPresentAddT", PAddT);
			QaRobot.scrollPage(5000);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCVisaNext2");
			WebElement MBDCEmbassyFT = QaBrowser.driver.findElement(By.xpath("//input[@id='txtVisaEmbcyFare']"));
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("MBDCEmbassyFT", EmbassyF);
			if (AddCharges.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("MBDCAddChargesT");
				int OCNo = Integer.parseInt(OCN);
				for (int j = 1; j <= OCNo; j++) {
					String OCharge[] = OtherCharges.split(",");
					WebElement ChargesName = QaBrowser.driver
							.findElement(By.xpath("//select[@id='MOCharge_NewMddlCharge" + (j) + "']"));
					Select s = new Select(ChargesName);
					s.selectByVisibleText(OCharge[j - 1]);
//					WebElement MBDCSelectPax = QaBrowser.driver
//							.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice" + (i - 1) + "']"));
//					MBDCSelectPax.click();
					String GCharge[] = OGrossCharges.split(",");
					WebElement MBDCATime1 = QaBrowser.driver
							.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice" + (j) + "']"));
					MBDCATime1.clear();
					MBDCATime1.sendKeys(GCharge[j - 1]);
					if (OCNo >= 2) {
						QaRobot.ClickOnElement("MBDCAddChargesT");
					}
				}
			}
			QaRobot.scrollPage(5000);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCApplyTax");
			Thread.sleep(3000);
			QaRobot.scrollPage(5000);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCVisaNext3");
			QaRobot.PassValue("MBDCPassportT", PassportN);
			QaRobot.PassValue("MBDCExpiryDateT", ExpiryD);
			TestBase.listofautosuggestion(By.xpath("//div[@id='divPassIssuingCountry']/p"), PCR, PCity,
					By.xpath("//input[@id='txtPassIssuingCountry']"));
			QaRobot.selectTextFromDropdown("MBDCNationalityT", Nationality);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCPassportSaveT");
			QaRobot.acceptAlert("");
			Thread.sleep(7000);
			QaBrowser.driver.switchTo().window(ParentWindow3);
			QaBrowser.driver.switchTo().parentFrame();
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			QaExtentReport.extentScreenshot("Product and Services");
		}
	}

	public static void AddChild(String Adult, String Child, String ChildName, String ChildDOB, String CT,
			String Country, String DC, String City, String SDate, String EDate, String TypeOfVisa, String NoOfEntries,
			String DestiAdd, String Supplier, String Status, String ApplicationId, String VC, String VisaC, String CRT,
			String CityT, String Gender, String PAddT, String EmbassyF, String AddCharges, String OCN,
			String OtherCharges, String OGrossCharges, String PassportN, String ExpiryD, String PCR, String PCity,
			String Nationality) throws Exception {
		String ParentWindow2 = QaBrowser.driver.getWindowHandle();
		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
		for (String childWindow2 : handles2) {
			if (!childWindow2.equals(ParentWindow2))
				QaBrowser.driver.switchTo().window(childWindow2);
		}
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
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCTravelerCalender");
			String CB[] = ChildDOB.split(",");
			String CB1 = CB[i - 1];
			String DateS3[] = CB1.split("-");
			String Date3 = DateS3[0];
			String Month3 = DateS3[1];
			String Year3 = DateS3[2];
			selectDate(Date3, Month3, Year3);
			Thread.sleep(3000);
			QaRobot.PassValue("MBDCAddTravellerPhone", "9865326598");
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
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCProductsAndServices");
			QaRobot.ClickOnElement("MBDCProductsAndServicesVisa");
			String ParentWindow3 = QaBrowser.driver.getWindowHandle();
			Set<String> handles3 = QaBrowser.driver.getWindowHandles();
			for (String childWindow3 : handles3) {
				if (!childWindow3.equals(ParentWindow3))
					QaBrowser.driver.switchTo().window(childWindow3);
			}
			Thread.sleep(8000);
			QaRobot.ClickOnElement("MBDCVisaSubmit");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCountryOfTravel']/p"), CT, Country,
					By.xpath("//input[@id='txtCountryOfTravel']"));
			TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), DC, City,
					By.xpath("//input[@id='txtDestinationCity']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divtxtStartDateofTravel']/a")).click();
			Thread.sleep(3000);
			selectDate1(SDate);
			Thread.sleep(3000);
			QaBrowser.driver.findElement(By.xpath("//div[@id='divtxtEndDateofTravel']/a")).click();
			Thread.sleep(3000);
			selectDate1(EDate);
			QaRobot.selectTextFromDropdown("MBDCTypeOfVisa", TypeOfVisa);
			QaRobot.selectTextFromDropdown("MBDCNoOfEntries", NoOfEntries);
			QaRobot.PassValue("MBDCDestinationAddV", DestiAdd);
			QaRobot.selectTextFromDropdown("MBDCVisaSupplier", Supplier);
			QaRobot.selectTextFromDropdown("MBDCVisaStatus", Status);
			QaRobot.PassValue("MBDCAppId", ApplicationId);
			QaRobot.scrollPage(1000);
			TestBase.listofautosuggestion(By.xpath("//div[@id='divIssuingCity']/p"), VC, VisaC,
					By.xpath("//input[@id='txtIssuingCity']"));
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCVisaNext1");
			QaRobot.ClickOnElement("MBDCAssociateTraveler");
			Thread.sleep(3000);
//			int TotalTraveller = Integer.parseInt(Adult) + Integer.parseInt(Child) + Integer.parseInt(Infant);
//			System.out.println(TotalTraveller);
//			for (int i = 1; i <= TotalTraveller; i++) {
//			int adt = Integer.parseInt(Adult);
//			if (adt < 0 && chd > 0) {
			WebElement MBDCSelectPax = QaBrowser.driver
					.findElement(By.xpath("//input[@id='gvDependant_ctl02_ChkAssociatePax']"));
			MBDCSelectPax.click();
//			} else if (adt > 0 && chd > 0) {
//				WebElement MBDCSelectPax = QaBrowser.driver
//						.findElement(By.xpath("//input[@id='gvDependant_ctl03_ChkAssociatePax']"));
//				MBDCSelectPax.click();
//			}

//			}
			Thread.sleep(5000);
//			QaRobot.ClickOnElement("MBDCAssociatePax1");
			QaRobot.ClickOnElement("MBDCSelectAssociateTraveler");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCountryOfResidence']/p"), CRT, CityT,
					By.xpath("//input[@id='txtCountryOfResidence']"));
			Thread.sleep(3000);
			QaRobot.selectTextFromDropdown("MBDCSelectTypeV", "Child(CHD)");
			QaRobot.selectTextFromDropdown("MBDCGenderT", Gender);
			QaRobot.selectTextFromDropdown("MBDCAddChildTitle", "Master");
			QaRobot.PassValue("MBDCPresentAddT", PAddT);
			QaRobot.PassValue("MBDCChildEmailV", "test1@quadlabs.com");
			QaRobot.scrollPage(5000);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCVisaNext2");
			WebElement MBDCEmbassyFT = QaBrowser.driver.findElement(By.xpath("//input[@id='txtVisaEmbcyFare']"));
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("MBDCEmbassyFT", EmbassyF);
			if (AddCharges.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("MBDCAddChargesT");
				int OCNo = Integer.parseInt(OCN);
				for (int j = 1; j <= OCNo; j++) {
					String OCharge[] = OtherCharges.split(",");
					WebElement ChargesName = QaBrowser.driver
							.findElement(By.xpath("//select[@id='MOCharge_NewMddlCharge" + (j) + "']"));
					Select s = new Select(ChargesName);
					s.selectByVisibleText(OCharge[j - 1]);
//					WebElement MBDCSelectPax = QaBrowser.driver
//							.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice" + (i - 1) + "']"));
//					MBDCSelectPax.click();
					String GCharge[] = OGrossCharges.split(",");
					WebElement MBDCATime1 = QaBrowser.driver
							.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice" + (j) + "']"));
					MBDCATime1.clear();
					MBDCATime1.sendKeys(GCharge[j - 1]);
					if (OCNo >= 2) {
						QaRobot.ClickOnElement("MBDCAddChargesT");
					}
				}
			}
			QaRobot.scrollPage(5000);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCApplyTax");
			Thread.sleep(3000);
			QaRobot.scrollPage(5000);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCVisaNext3");
			QaRobot.PassValue("MBDCPassportT", PassportN);
			QaRobot.PassValue("MBDCExpiryDateT", ExpiryD);
			TestBase.listofautosuggestion(By.xpath("//div[@id='divPassIssuingCountry']/p"), PCR, PCity,
					By.xpath("//input[@id='txtPassIssuingCountry']"));
			QaRobot.selectTextFromDropdown("MBDCNationalityT", Nationality);
			QaRobot.ClickOnElement("MBDCPassportSaveT");
			QaRobot.acceptAlert("");
			Thread.sleep(7000);
			QaBrowser.driver.switchTo().window(ParentWindow3);
			QaBrowser.driver.switchTo().parentFrame();
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			QaExtentReport.extentScreenshot("Product and Services");
		}
	}

	public static void AddInfant(String Adult, String Child, String Infant, String InfantName, String InfantDOB,
			String CT, String Country, String DC, String City, String SDate, String EDate, String TypeOfVisa,
			String NoOfEntries, String DestiAdd, String Supplier, String Status, String ApplicationId, String VC,
			String VisaC, String CRT, String CityT, String Gender, String PAddT, String EmbassyF, String AddCharges,
			String OCN, String OtherCharges, String OGrossCharges, String PassportN, String ExpiryD, String PCR,
			String PCity, String Nationality) throws Exception {
		String ParentWindow2 = QaBrowser.driver.getWindowHandle();
		Set<String> handles2 = QaBrowser.driver.getWindowHandles();
		for (String childWindow2 : handles2) {
			if (!childWindow2.equals(ParentWindow2))
				QaBrowser.driver.switchTo().window(childWindow2);
		}
		int ift = Integer.parseInt(Infant);
		for (int i = 1; i <= ift; i++) {
//			QaRobot.ClickOnElement("MBDCSaveAddNew");
//			Thread.sleep(4000);
//			int adt = Integer.parseInt(Adult);
//			int chd = Integer.parseInt(Child);
//			if (adt > 1 && chd < 1 && i < 2) {
//				QaBrowser.driver.switchTo().alert().dismiss();
//			}
//			Thread.sleep(4000);
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
			QaRobot.ClickOnElement("MBDCProductsAndServicesVisa");
			String ParentWindow3 = QaBrowser.driver.getWindowHandle();
			Set<String> handles3 = QaBrowser.driver.getWindowHandles();
			for (String childWindow3 : handles3) {
				if (!childWindow3.equals(ParentWindow3))
					QaBrowser.driver.switchTo().window(childWindow3);
			}
			Thread.sleep(8000);
			QaRobot.ClickOnElement("MBDCVisaSubmit");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCountryOfTravel']/p"), CT, Country,
					By.xpath("//input[@id='txtCountryOfTravel']"));
			TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), DC, City,
					By.xpath("//input[@id='txtDestinationCity']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divtxtStartDateofTravel']/a")).click();
			Thread.sleep(3000);
			selectDate1(SDate);
			QaBrowser.driver.findElement(By.xpath("//div[@id='divtxtEndDateofTravel']/a")).click();
			Thread.sleep(3000);
			selectDate1(EDate);
			QaRobot.selectTextFromDropdown("MBDCTypeOfVisa", TypeOfVisa);
			QaRobot.selectTextFromDropdown("MBDCNoOfEntries", NoOfEntries);
			QaRobot.PassValue("MBDCDestinationAddV", DestiAdd);
			QaRobot.selectTextFromDropdown("MBDCVisaSupplier", Supplier);
			QaRobot.selectTextFromDropdown("MBDCVisaStatus", Status);
			QaRobot.PassValue("MBDCAppId", ApplicationId);
			QaRobot.scrollPage(1000);
			TestBase.listofautosuggestion(By.xpath("//div[@id='divIssuingCity']/p"), VC, VisaC,
					By.xpath("//input[@id='txtIssuingCity']"));
			QaRobot.ClickOnElement("MBDCVisaNext1");
			QaRobot.ClickOnElement("MBDCAssociateTraveler");
			Thread.sleep(3000);
//			int TotalTraveller = Integer.parseInt(Adult) + Integer.parseInt(Child) + Integer.parseInt(Infant);
//			System.out.println(TotalTraveller);
//			for (int i = 1; i <= TotalTraveller; i++) {
//			int adt = Integer.parseInt(Adult);
//			int chd = Integer.parseInt(Child);
//			if (adt > 0 && chd < 0 && ift > 0) {
			WebElement MBDCSelectPax = QaBrowser.driver
					.findElement(By.xpath("//input[@id='gvDependant_ctl02_ChkAssociatePax']"));
			MBDCSelectPax.click();
//			} else if (adt > 0 && chd > 0 && ift > 0) {
//				WebElement MBDCSelectPax = QaBrowser.driver
//						.findElement(By.xpath("//input[@id='gvDependant_ctl04_ChkAssociatePax']"));
//				MBDCSelectPax.click();
//			}
//			}
			Thread.sleep(5000);
			QaRobot.ClickOnElement("MBDCSelectAssociateTraveler");
			TestBase.listofautosuggestion(By.xpath("//div[@id='divCountryOfResidence']/p"), CRT, CityT,
					By.xpath("//input[@id='txtCountryOfResidence']"));
			QaRobot.selectTextFromDropdown("MBDCSelectTypeV", "Infant(INF)");
			QaRobot.selectTextFromDropdown("MBDCGenderT", Gender);
			QaRobot.selectTextFromDropdown("MBDCAddChildTitle", "Master");
			QaRobot.PassValue("MBDCPresentAddT", PAddT);
			QaRobot.PassValue("MBDCChildEmailV", "test2@quadlabs.com");
			QaRobot.scrollPage(5000);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCVisaNext2");
			WebElement MBDCEmbassyFT = QaBrowser.driver.findElement(By.xpath("//input[@id='txtVisaEmbcyFare']"));
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			MBDCEmbassyFT.sendKeys(Keys.BACK_SPACE);
			QaRobot.PassValue("MBDCEmbassyFT", EmbassyF);
			if (AddCharges.equalsIgnoreCase("Yes")) {
				QaRobot.ClickOnElement("MBDCAddChargesT");
				int OCNo = Integer.parseInt(OCN);
				for (int j = 1; j <= OCNo; j++) {
					String OCharge[] = OtherCharges.split(",");
					WebElement ChargesName = QaBrowser.driver
							.findElement(By.xpath("//select[@id='MOCharge_NewMddlCharge" + (j) + "']"));
					Select s = new Select(ChargesName);
					s.selectByVisibleText(OCharge[j - 1]);
//					WebElement MBDCSelectPax = QaBrowser.driver
//							.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice" + (i - 1) + "']"));
//					MBDCSelectPax.click();
					String GCharge[] = OGrossCharges.split(",");
					WebElement MBDCATime1 = QaBrowser.driver
							.findElement(By.xpath("//input[@id='MOCharge_txtNewMEndCustPrice" + (j) + "']"));
					MBDCATime1.clear();
					MBDCATime1.sendKeys(GCharge[j - 1]);
					if (OCNo >= 2) {
						QaRobot.ClickOnElement("MBDCAddChargesT");
					}
				}
			}
			QaRobot.scrollPage(5000);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCApplyTax");
			Thread.sleep(3000);
			QaRobot.scrollPage(5000);
			Thread.sleep(3000);
			QaRobot.ClickOnElement("MBDCVisaNext3");
			QaRobot.PassValue("MBDCPassportT", PassportN);
			QaRobot.PassValue("MBDCExpiryDateT", ExpiryD);
			TestBase.listofautosuggestion(By.xpath("//div[@id='divPassIssuingCountry']/p"), PCR, PCity,
					By.xpath("//input[@id='txtPassIssuingCountry']"));
			QaRobot.selectTextFromDropdown("MBDCNationalityT", Nationality);
			QaRobot.ClickOnElement("MBDCPassportSaveT");
			QaRobot.acceptAlert("");
			Thread.sleep(7000);
			QaBrowser.driver.switchTo().window(ParentWindow3);
			QaBrowser.driver.switchTo().parentFrame();
			QaRobot.switchframe("//frame[@name='login']");
			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.switchframe("//frame[@id='frm2']");
			QaExtentReport.extentScreenshot("Product and Services");
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

	public static void selectDate1(String Day) throws Exception {
		List<WebElement> allDates = QaBrowser.driver
				.findElements(By.xpath("//div[@id='Calendar1']/center/table/tbody/tr/td/table/tbody/tr/td/input"));
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
}
