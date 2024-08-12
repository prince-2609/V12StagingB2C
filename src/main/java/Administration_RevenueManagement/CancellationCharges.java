package Administration_RevenueManagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
public class CancellationCharges {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Administration_AvenueManagement_CancellationCharges", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void corporateProfiling(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String RuleTemplateTitle, String Product,
			String SCQty, String SalesChannel, String CriteriaQty, String CriteriaName, String AirQty, String Airlines,
			String CabinQty, String CabinClass, String OriginFor, String OZqty, String OZone, String ORqty,
			String ORegion, String OCqty, String OCountry, String OCiQty, String OCity, String OAqty, String OAirport,
			String DestinationFor, String Zqty, String Zone, String Rqty, String Region, String Cqty, String Country,
			String CiQty, String City, String Aqty, String Airport, String BookingCQty, String BookingClass,
			String PaxQty, String PaxType, String BaseFareF, String BaseFareT, String BookDateFrom, String BookDateTo,
			String FareTQty, String FareType) throws Exception {
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
		QaRobot.ClickOnElement("V12RevenueManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		QaRobot.ClickOnElement("V12RManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("RMCancellationCharges");
		QaRobot.ClickOnElement("RMCCAddNew");
		QaRobot.PassValue("RMCRuleTemplateTitle", RuleTemplateTitle);
		QaRobot.selectTextFromDropdown("RMCProduct", Product);
		int pA = Integer.parseInt(SCQty);
		for (int k = 1; k <= pA; k++) {
			String[] tN1 = SalesChannel.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(
					By.xpath("/html/body/form/div[5]/div[1]/div[3]/div[2]/div/div/div[3]/div/div/ul/li/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}
		int pAS = Integer.parseInt(CriteriaQty);
		if (CriteriaQty.equalsIgnoreCase("1")) {
			for (int i = 1; i <= pAS; i++) {
				String[] tN = CriteriaName.split(",");
				String b = tN[i - 1];
				QaRobot.selectTextByLocator("//select[@id='key1']", b);
				if (b.equalsIgnoreCase("Airline")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(AirQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = Airlines.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxAirline']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("RMCAirlineSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Cabin Class")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(CabinQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = CabinClass.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxCabinClass']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("RMCCabinCSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Origin")) {
					QaRobot.switchToWindow();
					if (OriginFor.equalsIgnoreCase("Zone")) {
						QaRobot.ClickOnElement("IMZone");
						QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxZone']/option");
					} else if (OriginFor.equalsIgnoreCase("Country")) {
						QaRobot.ClickOnElement("IMCountry");
						QaRobot.transferDataWithPassValue(OCqty, OCountry, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					} else if (OriginFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("IMCity");
						QaRobot.transferDataWithPassValue(OCiQty, OCity, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					} else if (OriginFor.equalsIgnoreCase("Airport")) {
						QaRobot.ClickOnElement("IMAirport");
						QaRobot.transferDataWithPassValue(OAqty, OAirport, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					}
					QaRobot.ClickOnElement("IMDestinationSaveClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Destination")) {
					QaRobot.switchToWindow();
					if (DestinationFor.equalsIgnoreCase("Zone")) {
						QaRobot.ClickOnElement("IMZone");
						QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxZone']/option");
					} else if (DestinationFor.equalsIgnoreCase("Country")) {
						QaRobot.ClickOnElement("IMCountry");
						QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					} else if (DestinationFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("IMCity");
						QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					} else if (DestinationFor.equalsIgnoreCase("Airport")) {
						QaRobot.ClickOnElement("IMAirport");
						QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					}
					QaRobot.ClickOnElement("IMDestinationSaveClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Booking Class")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(BookingCQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = BookingClass.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxBookingClass']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("RMCBookingCSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Pax Type")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(PaxQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = PaxType.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxPaxType']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("RMCBookingCSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Base Fare")) {
					QaRobot.switchToWindow();
					QaRobot.PassValue("RMCBaseFareF", BaseFareF);
					QaRobot.PassValue("RMCBaseFareT", BaseFareT);
					QaRobot.ClickOnElement("RMCBookingCSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Booking Date")) {
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("BookDateFrom");
					String DateSelection[] = BookDateFrom.split("-");
					String year = DateSelection[2];
					String month = DateSelection[1];
					String expDate = DateSelection[0];
					QaRobot.selectDateInCalendarIM(expDate, month, year);
					QaRobot.ClickOnElement("BookDateTo");
					String DateSelection1[] = BookDateTo.split("-");
					String year1 = DateSelection1[2];
					String month1 = DateSelection1[1];
					String expDate1 = DateSelection1[0];
					QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
					QaRobot.ClickOnElement("IMBookDateSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Fare Type")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(FareTQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = FareType.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxFareType']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("RMCBookingCSelectClose");
					Thread.sleep(3000);
				}
			}
		} else {
			for (int i = 1; i <= pAS; i++) {
				String[] tN = CriteriaName.split(",");
				String b = tN[i - 1];
				String s = Integer.toString(i);
				if (s.equalsIgnoreCase("1")) {
					QaRobot.selectTextByLocator("//select[@id='key1']", b);
				} else {
					WebElement RMCAddNewCriteria = QaBrowser.driver.findElement(By.xpath("//a[@id='btnAddNew']"));
					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
					js2.executeScript("arguments[0].click()", RMCAddNewCriteria);
					QaRobot.selectTextByLocator("//select[@id='key" + i + "']", b);
				}
				if (b.equalsIgnoreCase("Airline")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(AirQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = Airlines.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxAirline']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("RMCAirlineSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Cabin Class")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(CabinQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = CabinClass.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxCabinClass']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("RMCCabinCSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Origin")) {
					QaRobot.switchToWindow();
					if (OriginFor.equalsIgnoreCase("Zone")) {
						QaRobot.ClickOnElement("IMZone");
						QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxZone']/option");
					} else if (OriginFor.equalsIgnoreCase("Country")) {
						QaRobot.ClickOnElement("IMCountry");
						QaRobot.transferDataWithPassValue(OCqty, OCountry, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					} else if (OriginFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("IMCity");
						QaRobot.transferDataWithPassValue(OCiQty, OCity, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					} else if (OriginFor.equalsIgnoreCase("Airport")) {
						QaRobot.ClickOnElement("IMAirport");
						QaRobot.transferDataWithPassValue(OAqty, OAirport, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					}
					QaRobot.ClickOnElement("IMDestinationSaveClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Destination")) {
					QaRobot.switchToWindow();
					if (DestinationFor.equalsIgnoreCase("Zone")) {
						QaRobot.ClickOnElement("IMZone");
						QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxZone']/option");
					} else if (DestinationFor.equalsIgnoreCase("Country")) {
						QaRobot.ClickOnElement("IMCountry");
						QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					} else if (DestinationFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("IMCity");
						QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					} else if (DestinationFor.equalsIgnoreCase("Airport")) {
						QaRobot.ClickOnElement("IMAirport");
						QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					}
					QaRobot.ClickOnElement("IMDestinationSaveClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Booking Class")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(BookingCQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = BookingClass.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxBookingClass']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("RMCBookingCSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Pax Type")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(PaxQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = PaxType.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxPaxType']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("RMCBookingCSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Base Fare")) {
					QaRobot.switchToWindow();
					QaRobot.PassValue("RMCBaseFareF", BaseFareF);
					QaRobot.PassValue("RMCBaseFareT", BaseFareT);
					QaRobot.ClickOnElement("RMCBookingCSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Booking Date")) {
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("RMCBookDateFrom");
					String DateSelection[] = BookDateFrom.split("-");
					String year = DateSelection[2];
					String month = DateSelection[1];
					String expDate = DateSelection[0];
					QaRobot.selectDateInCalendarIM(expDate, month, year);
					QaRobot.ClickOnElement("RMCBookDateTo");
					String DateSelection1[] = BookDateTo.split("-");
					String year1 = DateSelection1[2];
					String month1 = DateSelection1[1];
					String expDate1 = DateSelection1[0];
					QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
					QaRobot.ClickOnElement("IMBookDateSelectClose");
					Thread.sleep(3000);

				} else if (b.equalsIgnoreCase("Fare Type")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(FareTQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = FareType.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxFareType']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("RMCBookingCSelectClose");
					Thread.sleep(3000);
				}
			}
		}
//		QaRobot.ClickOnElement("RMCCancellationRuleSave");
	}

	@AfterMethod
	public static void afterMethod() {
//		QaExtentReport.test.getExtent().flush();
	}

}
