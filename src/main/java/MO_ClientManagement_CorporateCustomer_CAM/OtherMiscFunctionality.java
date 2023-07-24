package MO_ClientManagement_CorporateCustomer_CAM;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
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
public class OtherMiscFunctionality {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("OtherMiscFunctionality", "All");
	}

	@Test(dataProvider = "getexceldata")
	public static void travellerProfiling(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String CorporateName, String RuleTitle,
			String SelectProduct, String SelectPrimary, String CriteriaQty, String CriteriaName, String AirlineQty,
			String AirlineName, String JourneyQty, String JourneyName, String SelectAggrementType, String Add,
			String SelectActAs, String SelectActOn, String AddServiceCharge, String SelectChargeActAs,
			String SelectChargeActOn) throws Exception {

		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);

		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("ClientManagement");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("CorporateCustomer");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.PassValue("CompanyName", CorporateName);
		QaRobot.ClickOnElement("SearchCompanyName");
		QaExtentReport.test.log(Status.INFO, "<b><i>Corporate Name</i></b>" + " - " + CorporateName);
		String AccountId = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']")).getText();
		QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + AccountId);
		QaRobot.ClickOnElement("ClickOnSearchCompanyName");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='toolHeader']");
		QaRobot.ClickOnElement("CPCorporateManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("ManageCustomerAgreement");
		QaRobot.ClickOnElement("AddManageCustomerAgreement");
		QaRobot.PassValue("TempletTitle", RuleTitle);
		QaRobot.ClickOnElement("CARProduct");
		if (SelectProduct.equalsIgnoreCase("Flight")) {
			QaRobot.ClickOnElement("Product1");
			QaRobot.ClickOnElement("Primary1");
			int pAS = Integer.parseInt(CriteriaQty);
			if (CriteriaQty.equalsIgnoreCase("1")) {
				for (int i = 1; i <= pAS; i++) {
					String[] tN = CriteriaName.split(",");
					String b = tN[i - 1];
					QaRobot.selectTextByLocator("//select[@id='ddlkey1']", b);
					if (b.equalsIgnoreCase("Airline")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS1 = Integer.parseInt(AirlineQty);
						for (int k = 1; k <= pAS1; k++) {
							String[] tN1 = AirlineName.split(",");
							String b1 = tN1[k - 1];
							QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirline']")).clear();
							QaRobot.PassValue("CAPSearchAirline", b1);
							List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
									"/html/body/div/div/div/div/div/div/div/div/div/div/div[2]/div[1]/select/option"));
							for (WebElement autoRights1 : listOfRights1) {
								if (autoRights1.getText().equalsIgnoreCase(b1)) {
									autoRights1.click();
									QaRobot.ClickOnElement("CAPAddAirline");
								}
							}
						}
						QaRobot.ClickOnElement("CAPAirlineSelectClose");

					} else if (b.equalsIgnoreCase("Journey Type")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS2 = Integer.parseInt(JourneyQty);
						for (int j = 1; j <= pAS2; j++) {
							String[] tN2 = JourneyName.split(",");
							String b2 = tN2[j - 1];
							List<WebElement> listOfRights2 = QaBrowser.driver.findElements(By.xpath(
									"/html/body/div/div/div/div/div/div/div/div/div/div/div[1]/div[1]/select/option"));
							for (WebElement autoRights2 : listOfRights2) {
								if (autoRights2.getText().equalsIgnoreCase(b2)) {
									autoRights2.click();
									QaRobot.ClickOnElement("AddContent");
								}
							}
						}
						QaRobot.ClickOnElement("CARSelectClose");
					}
				}

			} else  {
				for (int i = 1; i <= pAS; i++) {
					String[] tN = CriteriaName.split(",");
					String b = tN[i - 1];
					String s = Integer.toString(i);
					if (s.equalsIgnoreCase("1")) {
						QaRobot.selectTextByLocator("//select[@id='ddlkey1']", b);
					} else {
						QaRobot.ClickOnElement("AddNewCriteria");
						QaRobot.selectTextByLocator("//select[@id='ddlkey"+i+"']", b);
					}
					if (b.equalsIgnoreCase("Airline")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS1 = Integer.parseInt(AirlineQty);
						for (int k = 1; k <= pAS1; k++) {
							String[] tN1 = AirlineName.split(",");
							String b1 = tN1[k - 1];
							QaBrowser.driver.findElement(By.xpath("//input[@id='txtAirline']")).clear();
							QaRobot.PassValue("CAPSearchAirline", b1);
							List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
									"/html/body/div/div/div/div/div/div/div/div/div/div/div[2]/div[1]/select/option"));
							for (WebElement autoRights1 : listOfRights1) {
								if (autoRights1.getText().equalsIgnoreCase(b1)) {
									autoRights1.click();
									QaRobot.ClickOnElement("CAPAddAirline");
								}
							}
						}
						QaRobot.ClickOnElement("CAPAirlineSelectClose");

					} else if (b.equalsIgnoreCase("Journey Type")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS2 = Integer.parseInt(JourneyQty);
						for (int j = 1; j <= pAS2; j++) {
							String[] tN2 = JourneyName.split(",");
							String b2 = tN2[j - 1];
							List<WebElement> listOfRights2 = QaBrowser.driver.findElements(By.xpath(
									"/html/body/div/div/div/div/div/div/div/div/div/div/div[1]/div[1]/select/option"));
							for (WebElement autoRights2 : listOfRights2) {
								if (autoRights2.getText().equalsIgnoreCase(b2)) {
									autoRights2.click();
									QaRobot.ClickOnElement("AddContent");
								}
							}
						}
						QaRobot.ClickOnElement("CARSelectClose");
					}
				}
			}

		} else if (SelectProduct.equalsIgnoreCase("Hotel")) {
			QaRobot.ClickOnElement("Product2");
			QaRobot.ClickOnElement("Primary2");
			int pAS = Integer.parseInt(CriteriaQty);
			if (CriteriaQty.equalsIgnoreCase("1")) {
				for (int i = 1; i <= pAS; i++) {
					String[] tN = CriteriaName.split(",");
					String b = tN[i - 1];
					QaRobot.selectTextByLocator("//select[@id='ddlkey1']", b);
					if (b.equalsIgnoreCase("Market")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS1 = Integer.parseInt(AirlineQty);
						for (int k = 1; k <= pAS1; k++) {
							String[] tN1 = AirlineName.split(",");
							String b1 = tN1[k - 1];
							List<WebElement> listOfRights1 = QaBrowser.driver
									.findElements(By.xpath("//select[@id='ddlMarket']/option"));
							for (WebElement autoRights1 : listOfRights1) {
								if (autoRights1.getText().equalsIgnoreCase(b1)) {
									autoRights1.click();
									QaRobot.ClickOnElement("AddMarket");
								}
							}
						}
						QaRobot.ClickOnElement("MarketSelectClose");

					} else if (b.equalsIgnoreCase("Travel Type")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS2 = Integer.parseInt(JourneyQty);
						for (int j = 1; j <= pAS2; j++) {
							String[] tN2 = JourneyName.split(",");
							String b2 = tN2[j - 1];
							List<WebElement> listOfRights2 = QaBrowser.driver
									.findElements(By.xpath("//select[@id='lstTravelType']/option"));
							for (WebElement autoRights2 : listOfRights2) {
								if (autoRights2.getText().equalsIgnoreCase(b2)) {
									autoRights2.click();
									QaRobot.ClickOnElement("AddTrvelType");
								}
							}
						}
						QaRobot.ClickOnElement("TravelTypeSelectClose");
					}
				}

			} else {
				for (int i = 1; i <= pAS; i++) {
					String[] tN = CriteriaName.split(",");
					String b = tN[i - 1];
					String s = Integer.toString(i);
					if (s.equalsIgnoreCase("1")) {
						QaRobot.selectTextByLocator("//select[@id='ddlkey1']", b);
					} else {
						QaRobot.ClickOnElement("AddNewCriteria");
						QaRobot.selectTextByLocator("//select[@id='ddlkey"+i+"']", b);
					}
					if (b.equalsIgnoreCase("Market")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS1 = Integer.parseInt(AirlineQty);
						for (int k = 1; k <= pAS1; k++) {
							String[] tN1 = AirlineName.split(",");
							String b1 = tN1[k - 1];
							List<WebElement> listOfRights1 = QaBrowser.driver
									.findElements(By.xpath("//select[@id='ddlMarket']/option"));
							for (WebElement autoRights1 : listOfRights1) {
								if (autoRights1.getText().equalsIgnoreCase(b1)) {
									autoRights1.click();
									QaRobot.ClickOnElement("AddMarket");
								}
							}
						}
						QaRobot.ClickOnElement("MarketSelectClose");

					} else if (b.equalsIgnoreCase("Travel Type")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS2 = Integer.parseInt(JourneyQty);
						for (int j = 1; j <= pAS2; j++) {
							String[] tN2 = JourneyName.split(",");
							String b2 = tN2[j - 1];
							List<WebElement> listOfRights2 = QaBrowser.driver
									.findElements(By.xpath("//select[@id='lstTravelType']/option"));
							for (WebElement autoRights2 : listOfRights2) {
								if (autoRights2.getText().equalsIgnoreCase(b2)) {
									autoRights2.click();
									QaRobot.ClickOnElement("AddTrvelType");
								}
							}
						}
						QaRobot.ClickOnElement("TravelTypeSelectClose");
					}
				}
			}

		} else if (SelectProduct.equalsIgnoreCase("All")) {
			QaRobot.ClickOnElement("Product1");
			QaRobot.ClickOnElement("Product2");
			if (SelectPrimary.equalsIgnoreCase("Flight")) {
				QaRobot.ClickOnElement("Primary1");
			} else if (SelectPrimary.equalsIgnoreCase("Hotel")) {
				QaRobot.ClickOnElement("Primary2");
			}
			int pAS = Integer.parseInt(CriteriaQty);
			if (CriteriaQty.equalsIgnoreCase("1")) {
				for (int i = 1; i <= pAS; i++) {
					String[] tN = CriteriaName.split(",");
					String b = tN[i - 1];
					QaRobot.selectTextByLocator("//select[@id='ddlkey1']", b);
					if (b.equalsIgnoreCase("Market")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS1 = Integer.parseInt(AirlineQty);
						for (int k = 1; k <= pAS1; k++) {
							String[] tN1 = AirlineName.split(",");
							String b1 = tN1[k - 1];
							List<WebElement> listOfRights1 = QaBrowser.driver
									.findElements(By.xpath("//select[@id='ddlMarket']/option"));
							for (WebElement autoRights1 : listOfRights1) {
								if (autoRights1.getText().equalsIgnoreCase(b1)) {
									autoRights1.click();
									QaRobot.ClickOnElement("AddMarket");
								}
							}
						}
						QaRobot.ClickOnElement("MarketSelectClose");

					} else if (b.equalsIgnoreCase("Travel Type")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS2 = Integer.parseInt(JourneyQty);
						for (int j = 1; j <= pAS2; j++) {
							String[] tN2 = JourneyName.split(",");
							String b2 = tN2[j - 1];
							List<WebElement> listOfRights2 = QaBrowser.driver
									.findElements(By.xpath("//select[@id='lstTravelType']/option"));
							for (WebElement autoRights2 : listOfRights2) {
								if (autoRights2.getText().equalsIgnoreCase(b2)) {
									autoRights2.click();
									QaRobot.ClickOnElement("AddTrvelType");
								}
							}
						}
						QaRobot.ClickOnElement("TravelTypeSelectClose");
					}
				}

			} else {
				for (int i = 1; i <= pAS; i++) {
					String[] tN = CriteriaName.split(",");
					String b = tN[i - 1];
					String s = Integer.toString(i);
					if (s.equalsIgnoreCase("1")) {
						QaRobot.selectTextByLocator("//select[@id='ddlkey1']", b);
					} else {
						QaRobot.ClickOnElement("AddNewCriteria");
						QaRobot.selectTextByLocator("//select[@id='ddlkey"+i+"']", b);
					}
					if (b.equalsIgnoreCase("Market")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS1 = Integer.parseInt(AirlineQty);
						for (int k = 1; k <= pAS1; k++) {
							String[] tN1 = AirlineName.split(",");
							String b1 = tN1[k - 1];
							List<WebElement> listOfRights1 = QaBrowser.driver
									.findElements(By.xpath("//select[@id='ddlMarket']/option"));
							for (WebElement autoRights1 : listOfRights1) {
								if (autoRights1.getText().equalsIgnoreCase(b1)) {
									autoRights1.click();
									QaRobot.ClickOnElement("AddMarket");
								}
							}
						}
						QaRobot.ClickOnElement("MarketSelectClose");

					} else if (b.equalsIgnoreCase("Travel Type")) {
						String ParentWindow = QaBrowser.driver.getWindowHandle();
						Set<String> handles = QaBrowser.driver.getWindowHandles();
						for (String childWindow : handles) {
							if (!childWindow.equals(ParentWindow))
								QaBrowser.driver.switchTo().window(childWindow);
						}
						int pAS2 = Integer.parseInt(JourneyQty);
						for (int j = 1; j <= pAS2; j++) {
							String[] tN2 = JourneyName.split(",");
							String b2 = tN2[j - 1];
							List<WebElement> listOfRights2 = QaBrowser.driver
									.findElements(By.xpath("//select[@id='lstTravelType']/option"));
							for (WebElement autoRights2 : listOfRights2) {
								if (autoRights2.getText().equalsIgnoreCase(b2)) {
									autoRights2.click();
									QaRobot.ClickOnElement("AddTrvelType");
								}
							}
						}
						QaRobot.ClickOnElement("TravelTypeSelectClose");
					}
				}
			}
		}
		if (SelectAggrementType.equalsIgnoreCase("Agreement Fee")) {
			QaRobot.ClickOnElement("AggrementFee");
			QaRobot.PassValue("AddFee", Add);
			QaRobot.selectTextByLocator("//select[@id='ddl_Trans']", SelectActAs);
			QaRobot.selectTextByLocator("//select[@id='ddl_TransBaseFare']", SelectActOn);
		} else if (SelectAggrementType.equalsIgnoreCase("Agreement Markup")) {
			QaRobot.ClickOnElement("AggrementMarkup");
			QaRobot.PassValue("AddMarkup", Add);
			QaRobot.selectTextByLocator("//select[@id='ddl_Markup']", SelectActAs);
			QaRobot.selectTextByLocator("//select[@id='ddl_MarkupBaseFare']", SelectActOn);
		}
		QaRobot.PassValue("AddService", AddServiceCharge);
		QaRobot.selectTextByLocator("//select[@id='ddl_OurAdditional_Chanrges_Markup']", SelectChargeActAs);
		QaRobot.selectTextByLocator("//select[@id='ddl_OurAdditional_Chanrges_BaseFare']", SelectChargeActOn);
		QaRobot.ClickOnElement("SaveManageCustomerAgreement");
		QaRobot.acceptAlert("ManageCustomerAgreementStatus");
		QaRobot.ClickOnElement("CloseManageCustomerAgreement");
	}

	@AfterMethod
	public static void afterMethod() {
//		QaExtentReport.test.getExtent().flush();
	}
}
