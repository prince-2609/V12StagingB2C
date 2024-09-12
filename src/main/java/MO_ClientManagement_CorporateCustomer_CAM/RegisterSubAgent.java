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
public class RegisterSubAgent {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Register_SubAgent", "Sheet3");
	}

	@Test(dataProvider = "getexceldata")
	public static void registerSubAgent(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String AgencyName, String EmailAddress,
			String BranchName, String BusinessCurrency, String Address1, String Country, String State, String Ci,
			String City, String PostCode, String Telephone, String Mobile, String Title, String FN, String LN,
			String ATOLNumber, String SCQty, String SelectCharge, String PaymentMode, String CreditLimit,
			String CreditLimitAlert, String TempCreditLimit, String PaymentDetails, String AnnualTurnover,
			String FOPQty, String FOP, String NoOfEmployees, String NoOfBranches, String ProductQty, String ProductType,
			String OtherDetails) throws Exception {
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
		QaRobot.ClickOnElement("v12CAMReseller");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		QaRobot.ClickOnElement("v12CAMResellerClick");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("v12RegisterReseller");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("v12CAMSubmitS");
		Thread.sleep(2000);
		QaRobot.PassValue("ResellerAgencyName", AgencyName);
		QaRobot.PassValue("ResellerEmail", EmailAddress);
		QaRobot.selectTextFromDropdown("ResellerBranchname", BranchName);
		QaRobot.PassValue("ResellerAddress1", Address1);
		QaRobot.selectTextFromDropdown("ResellerCountry", Country);
		Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("ResellerState", State);
		TestBase.listofautosuggestion(By.xpath("//p[@id='dynaSpan0']"), Ci, City, By.xpath("//input[@id='txtSearch']"));
		QaBrowser.driver.findElement(By.xpath("//p[@id='dynaSpan0']")).click();
		Thread.sleep(2000);
		// QaRobot.ClickOnElement("ResellerPostCode");
		QaRobot.PassValue("ResellerPostCode", PostCode);
		Thread.sleep(2000);
		QaRobot.scrollPage(500);
		Thread.sleep(2000);
		QaRobot.PassValue("ResellerTelephone", Telephone);
		QaRobot.PassValue("ResellerMobile", Mobile);
		QaRobot.selectTextFromDropdown("ResellerTitle", Title);
		QaRobot.PassValue("ResellerFN", FN);
		QaRobot.PassValue("ResellerLN", LN);
		Thread.sleep(2000);
		QaRobot.scrollPage(1500);
		Thread.sleep(2000);
		QaRobot.PassValue("ResellerATOLNo", ATOLNumber);
		Thread.sleep(2000);

		// Select Charges Check box
		int pA = Integer.parseInt(SCQty);
		for (int k = 1; k <= pA; k++) {
			String[] tN1 = SelectCharge.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver
					.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div/div/div/div[41]/div/span/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}
//		if (SelectCharge.equalsIgnoreCase("Charge Safi")) {
//			QaRobot.ClickOnElement("ResellerChargeSafi");
//		} else {
//			QaRobot.ClickOnElement("ResellerChargeApc");
//		}
		Thread.sleep(2000);
		QaRobot.scrollPage(-3000);
		Thread.sleep(3000);
		QaExtentReport.extentScreenshot("Sub Agent Profile");
		QaRobot.ClickOnElement("ResellerFinancialDetails");
		Thread.sleep(3000);

		QaRobot.selectTextFromDropdown("ResellerPayment", PaymentMode);
		if (PaymentMode.equalsIgnoreCase("Credit Agent")) {
			Thread.sleep(2000);
			QaRobot.PassValue("ResellerCreditLimit", CreditLimit);
			QaRobot.PassValue("ResellerCreditLimitAlert", CreditLimitAlert);
			QaRobot.PassValue("ResellerTempCreditLimit", TempCreditLimit);
		} else {
			Thread.sleep(2000);
			QaRobot.selectTextFromDropdown("ResellerPayment", PaymentMode);
		}
		Thread.sleep(2000);
		QaRobot.scrollPage(1000);
		// FOP=/html/body/form/div[7]/div[2]/div[4]/div/div/div/div[8]/div/div/div/table/tbody/tr/td[2]/span
		QaRobot.selectTextFromDropdown("ResellerPaymentDetails", PaymentDetails);
		QaRobot.PassValue("ResellerAnnualTurnover", AnnualTurnover);
		Thread.sleep(2000);

		// Select FOP Text & Respective Checkbox from the list
		int pA2 = Integer.parseInt(FOPQty);
		for (int k = 1; k <= pA2; k++) {
			int count = 0;
			String[] tN1 = FOP.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
					"/html/body/form/div[7]/div[2]/div[4]/div/div/div/div[8]/div/div/div/table/tbody/tr/td[2]/span"));
			// FOP Text common xpath
			for (WebElement autoRights1 : listOfRights1) {
				count++;
				System.out.println(count);
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					WebElement SFOP = QaBrowser.driver.findElement(By.xpath(
							"(/html/body/form/div[7]/div[2]/div[4]/div/div/div/div[8]/div/div/div/table/tbody/tr/td[1]//input)["
									+ count + "]"));
					// FOP Check box common xpath
					SFOP.click();
					Thread.sleep(3000);
				}
			}
		}
//		QaRobot.selectTextFromDropdown("ResellerFOP", FOP);
		Thread.sleep(3000);
		QaRobot.PassValue("ResellerNoOfEmp", NoOfEmployees);
		QaRobot.PassValue("ResellerNoOfBranch", NoOfBranches);
		Thread.sleep(2000);
		QaRobot.scrollPage(-2000);
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Financial Details Page");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("ResellerProductAccess");
		Thread.sleep(2000);
		int pA1 = Integer.parseInt(ProductQty);
		for (int k = 1; k <= pA1; k++) {
			String[] tN1 = ProductType.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(
					By.xpath("/html/body/form/div[7]/div[2]/div[3]/div/div/div/div[1]/div/div/div/div/div/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					// autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}
		Thread.sleep(2000);
		QaRobot.ClickOnElement("ResellerEnableB2B2C1");
		Thread.sleep(1000);
		QaRobot.scrollPage(1000);
		Thread.sleep(5000);
		QaRobot.ClickOnElement("ResellerSave");
		QaExtentReport.extentScreenshot("SubAgent registered Successfully");

	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
