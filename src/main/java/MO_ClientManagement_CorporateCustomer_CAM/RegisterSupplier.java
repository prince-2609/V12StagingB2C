package MO_ClientManagement_CorporateCustomer_CAM;

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
public class RegisterSupplier {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Register_Supplier", "Sheet2");
	}

	@Test(dataProvider = "getexceldata")
	public static void registerSupplier(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String SupplierCode, String SupplierName,
			String EmailAddress, String Address1, String Country, String State, String Ci, String City, String PostCode,
			String CountryMob, String Mobile, String ExchangeOrder, String BankName, String AccountNo, String RTGSCode,
			String SettlementCurrency, String SettlePeriodQty, String SettlementPeriod, String PaymentApprovalRequired,
			String ProductQty, String ProductType) throws Exception {
		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("v12Clientmanagement");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("v12CAMSupplier");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("v12CAMSupplierClick");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("v12CAMRegisterSupplier");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("v12CAMSubmitS");
		Thread.sleep(2000);
		QaRobot.PassValue("CAMSupplierCode", SupplierCode);
		QaRobot.PassValue("CAMSupplierName", SupplierName);
		QaRobot.PassValue("CAMSupplierEmail", EmailAddress);
		QaRobot.PassValue("SupplierAddress", Address1);
		QaRobot.selectTextFromDropdown("SupplierCountry", Country);
		Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("SupplierState", State);
		TestBase.listofautosuggestion(By.xpath("//p[@id='dynaSpan0']"), Ci, City, By.xpath("//input[@id='txtSearch']"));
		QaBrowser.driver.findElement(By.xpath("//p[@id='dynaSpan0']")).click();
		// QaRobot.PassValue("SupplierCity", City);

		QaRobot.PassValue("SupplierPostCode", PostCode);
		QaRobot.selectTextFromDropdown("SupplierCountryMobile", CountryMob);
		QaRobot.PassValue("SupplierMobile", Mobile);
		Thread.sleep(2000);
		QaRobot.scrollPage(6000);
		Thread.sleep(2000);
		if (ExchangeOrder.equalsIgnoreCase("Regular Voucher to be generated")) {
			QaRobot.ClickOnElement("SupplierRegularVoucher");
		} else {
			QaRobot.ClickOnElement("SupplierExchangeOrder");
		}
		Thread.sleep(3000);
		QaRobot.scrollPage(-3000);
		QaExtentReport.extentScreenshot("Supplier Profile Page");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("ClickFinancialDetails");
		Thread.sleep(3000);
		QaRobot.PassValue("SupplierBankName", BankName);
		QaRobot.PassValue("SupplierAccountNo", AccountNo);
		QaRobot.PassValue("SupplierRTGSCode", RTGSCode);
		QaRobot.selectTextFromDropdown("SupplierSettCurrency", SettlementCurrency);
//		QaRobot.selectTextByLocator("//select[@id='drpCountry']", SettlementCurrency);

//		if (SettlementPeriod.equalsIgnoreCase("7 Days")) {
//			QaBrowser.driver.findElement(By.xpath(
//							"/html/body/form/div[3]/div[3]/div/div/div/div/div[7]/div/div/ul/li[1]/label/text()")).click();
//			// QaRobot.ClickOnElement("PaymentApproval");
//		} else if (SettlementPeriod.equalsIgnoreCase("14 Days")) {
//			QaBrowser.driver.findElement(By.xpath(
//							"/html/body/form/div[3]/div[3]/div/div/div/div/div[7]/div/div/ul/li[2]/label/text()")).click();
//		} else if (SettlementPeriod.equalsIgnoreCase("21 Days")) {
//			QaBrowser.driver.findElement(By.xpath(
//							"/html/body/form/div[3]/div[3]/div/div/div/div/div[7]/div/div/ul/li[3]/label/text()")).click();
//		} else if (SettlementPeriod.equalsIgnoreCase("30 Days")) {
//			QaBrowser.driver.findElement(By.xpath(
//							"/html/body/form/div[3]/div[3]/div/div/div/div/div[7]/div/div/ul/li[4]/label/text()")).click();
//		} else if (SettlementPeriod.equalsIgnoreCase("45 Days")) {
//			QaBrowser.driver.findElement(By.xpath(
//							"/html/body/form/div[3]/div[3]/div/div/div/div/div[7]/div/div/ul/li[5]/label/text()")).click();
//		} else if (SettlementPeriod.equalsIgnoreCase("60 Days")) {
//			QaBrowser.driver.findElement(By.xpath(
//							"/html/body/form/div[3]/div[3]/div/div/div/div/div[7]/div/div/ul/li[6]/label/text()")).click();
//		}

		// Choose Settlement Period from Available radio Button
		int pAS1 = Integer.parseInt(SettlePeriodQty);
		for (int k = 1; k <= pAS1; k++) {
			String[] tN1 = SettlementPeriod.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver
					.findElements(By.xpath("/html/body/form/div[3]/div[3]/div/div/div/div/div[7]/div/div/ul/li/label"));
			for (WebElement autoRights1 : listOfRights1) {

				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					// String autoRights2 = autoRights1.getAttribute("value");
					// System.out.println(autoRights2);
					autoRights1.click();
				}
			}
		}
		if (PaymentApprovalRequired.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("PaymentApprovalRequired");
		}
		QaExtentReport.extentScreenshot("Bank & Payment Details Page");
		Thread.sleep(5000);
		QaRobot.ClickOnElement("ClickOnProduct");
		Thread.sleep(3000);
//		int pA = Integer.parseInt(ProductQty);
//		for (int k = 1; k <= pA; k++) {
//			String[] tN1 = ProductType.split(",");
//			String b1 = tN1[k - 1];
//			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(
//					By.xpath("/html/body/form/div[3]/div[5]/div/div/div/div[1]/div/div/table/tbody/tr/td/span[2]"));
//			for (WebElement autoRights1 : listOfRights1) {
//				if (autoRights1.getText().equalsIgnoreCase(b1)) {
//					autoRights1.click();
//					Thread.sleep(3000);
//				}
//			}
//		}

		// Product Check box & respective Apply Tax
		int pA = Integer.parseInt(ProductQty);
		for (int k = 1; k <= pA; k++) {
			String[] tN1 = ProductType.split(",");
			String b1 = tN1[k - 1];
			if (b1.equalsIgnoreCase("Bus")) {
				Thread.sleep(1000);
				QaRobot.ClickOnElement("ClickOnBus");
				Thread.sleep(1000);
				QaRobot.ClickOnElement("ApplyTaxBus");
			} else if (b1.equalsIgnoreCase("Transfer")) {
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ClickOnTransfer");
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ApplyTaxTransfer");
			} else if (b1.equalsIgnoreCase("Hotel")) {
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ClickOnHotel");
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ApplyTaxHotel");
			} else if (b1.equalsIgnoreCase("Flight")) {
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ClickOnFlight");
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ApplyTaxFlight");
			} else if (b1.equalsIgnoreCase("Insurance")) {
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ClickOnInsurance");
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ApplyTaxInsurance");
			} else if (b1.equalsIgnoreCase("Car")) {
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ClickOnCar");
				Thread.sleep(2000);
				QaRobot.ClickOnElement("ApplyTaxCar");
			}
		}
		QaExtentReport.extentScreenshot("Product Page");
		Thread.sleep(2000);
		QaRobot.scrollPage(2000);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("SupplierSave");
		Thread.sleep(7000);

	}
//	int pAS = Integer.parseInt(TotalRights);
//	for (int i = 1; i <= pAS; i++) {
//		String[] tN = RightNames.split(",");
//		String b = tN[i - 1];
//		List<WebElement> listOfRights = QaBrowser.driver.findElements(
//				By.xpath("/html/body/div/form/div[5]/div/div/div/div[2]/div[2]/div/div[46]/div/label/span/label"));
//		for (WebElement autoRights : listOfRights) {
//			if (autoRights.getText().equalsIgnoreCase(b)) {
//				autoRights.click();
//				break;
//			} else {
//			}
//		}
//	}

//	int pA = Integer.parseInt(SCQty);
//	for (int k = 1; k <= pA; k++) {
//		String[] tN1 = SalesChannel.split(",");
//		String b1 = tN1[k - 1];
//		List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
//				"/html/body/form/div[4]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[2]/td/fieldset/table/tbody/tr[3]/td[2]/table/tbody/tr/td"));
//		for (WebElement autoRights1 : listOfRights1) {
//			if (autoRights1.getText().equalsIgnoreCase(b1)) {
//				autoRights1.click();
//				Thread.sleep(3000);
//			}
//		}
//	}

//	String City[] = CityName.split(",");
//	String City1 = City[0];
//	String City2 = City[1];
//	TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), City1, City2,
//			By.xpath("//input[@id='txtCity']"));
//	Thread.sleep(3000);
//	QaBrowser.driver.findElement(By.xpath("//div[@id='divCity']/p")).click();

	@AfterMethod
	public static void afterMethod() {
		//QaExtentReport.test.getExtent().flush();
	}
}
