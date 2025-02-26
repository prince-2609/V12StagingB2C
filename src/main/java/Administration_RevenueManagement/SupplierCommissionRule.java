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
public class SupplierCommissionRule {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Administration_RevenueManagement_SupplierCommissionRule", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void supplierCommRule(String TestCaseId, String TCType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String RuleTemplateTitle, String Product,
			String From, String TSPSupplier, String SBQty, String SelectBranch, String CriteriaQty, String CriteriaName,
			String AirQty, String Airlines, String CabinQty, String CabinClass, String OriginFor, String OZqty,
			String OZone, String ORqty, String ORegion, String OCqty, String OCountry, String OCi, String OCity,
			String OAir, String OAirport, String DestinationFor, String Zqty, String Zone, String Rqty, String Region,
			String Cqty, String Country, String Ci, String City, String Air, String Airport, String BookingCQty,
			String BookingClass, String PaxQty, String PaxType, String BaseFareF, String BaseFareT, String BookDateFrom,
			String BookDateTo, String FareTQty, String FareType, String DefineSalesCommission, String Earn,
			String Commission, String ApplyOn, String Net, String CommissionN) throws Exception {
		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + " - " + TCType + " - " + TestScenario);
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
		Thread.sleep(2000);
		QaRobot.ClickOnElement("V12RManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("SuppCommRuleClick");
		Thread.sleep(4000);
		QaRobot.ClickOnElement("SCRAddNewRule");
		Thread.sleep(4000);
		QaRobot.PassValue("SuppCommRuleTemplateTitle", RuleTemplateTitle);

		QaRobot.selectTextFromDropdown("SCRProduct", Product);
		Thread.sleep(5000);

		if (From.equalsIgnoreCase("Own Stock")) {
			QaRobot.ClickOnElement("SuppCommRuleOwnStock1");
		} else {
			QaRobot.ClickOnElement("SuppCommRuleTPS");
			Thread.sleep(2000);
			QaRobot.selectTextFromDropdown("SuppCommRuleSelectSupplier", TSPSupplier);
		}
		Thread.sleep(2000);
		int pA = Integer.parseInt(SBQty);
		for (int k = 1; k <= pA; k++) {
			String[] tN1 = SelectBranch.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
					"/html/body/form/div[4]/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/div/fieldset/table/tbody/tr[2]/td/fieldset/table/tbody/tr[3]/td[2]/div/table/tbody/tr/td/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}

		//

		// Airline Criteria from list of Airlines from child window
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
						QaRobot.ClickOnElement("SuppCommRuleAirlineShowAll");
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxAirlineFiller']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
								QaRobot.ClickOnElement("SCRAddAirline");
							}
						}
					}
//					Thread.sleep(2000);
//					QaRobot.ClickOnElement("SCRAddAirline");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("SCRSelectClose");
					Thread.sleep(3000);

					// Select Cabin Class from child window
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

					// Select Zone, Country, City & Airport auto suggestion
				} else if (b.equalsIgnoreCase("Origin")) {
					QaRobot.switchToWindow();
					if (OriginFor.equalsIgnoreCase("Zone")) {
						QaRobot.ClickOnElement("IMZone");
						QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxZone']/option");
					} else if (OriginFor.equalsIgnoreCase("Country")) {
						QaRobot.ClickOnElement("IMCountry");
						QaRobot.transferDataWithPassValue(OCqty, OCountry, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					}
					else if (OriginFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("IMCity");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divSearch']/p"), OCi, OCity,
								By.xpath("//input[@id='txtSearch']"));
					}
					else if (OriginFor.equalsIgnoreCase("Airport")) {
						QaRobot.ClickOnElement("IMAirport");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divSearch']/p"), OAir, OAirport,
								By.xpath("//input[@id='txtSearch']"));
					}
//					else if (OriginFor.equalsIgnoreCase("City")) {
//						QaRobot.ClickOnElement("IMCity");
//						QaRobot.transferDataWithPassValue(OCiQty, OCity, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					} 
//					else if (OriginFor.equalsIgnoreCase("Airport")) {
//						QaRobot.ClickOnElement("IMAirport");
//						QaRobot.transferDataWithPassValue(OAqty, OAirport, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					}
					Thread.sleep(2000);
					QaRobot.ClickOnElement("IMDestinationSaveClose");
					Thread.sleep(3000);

					// Select Zone, Country, City & Airport auto suggestion
				} else if (b.equalsIgnoreCase("Destination")) {
					QaRobot.switchToWindow();
					if (DestinationFor.equalsIgnoreCase("Zone")) {
						QaRobot.ClickOnElement("IMZone");
						QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxZone']/option");
					} else if (DestinationFor.equalsIgnoreCase("Country")) {
						QaRobot.ClickOnElement("IMCountry");
						QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtSearch']",
								"//div[@id='divSearch']/p");
					}
					else if (OriginFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("IMCity");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divSearch']/p"), Ci, City,
								By.xpath("//input[@id='txtSearch']"));
					}
					else if (OriginFor.equalsIgnoreCase("Airport")) {
						QaRobot.ClickOnElement("IMAirport");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divSearch']/p"), Air, Airport,
								By.xpath("//input[@id='txtSearch']"));
					}
//					else if (DestinationFor.equalsIgnoreCase("City")) {
//						QaRobot.ClickOnElement("IMCity");
//						QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					} 
//					else if (DestinationFor.equalsIgnoreCase("Airport")) {
//						QaRobot.ClickOnElement("IMAirport");
//						QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					}
					Thread.sleep(2000);
					QaRobot.ClickOnElement("IMDestinationSaveClose");
					Thread.sleep(3000);

					// Select Booking class from list
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

					// Select Pax type from list
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

					// Date Dropdown Month & Year
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
					WebElement RMCAddNewCriteria = QaBrowser.driver.findElement(By.xpath("//input[@id='btnAddNew']"));
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
						QaRobot.ClickOnElement("SuppCommRuleAirlineShowAll");
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxAirlineFiller']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
								QaRobot.ClickOnElement("SCRAddAirline");
							}
						}
					}
//					Thread.sleep(2000);
//					QaRobot.ClickOnElement("SCRAddAirline");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("SCRSelectClose");
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
					}
					else if (OriginFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("IMCity");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divSearch']/p"), OCi, OCity,
								By.xpath("//input[@id='txtSearch']"));
					}
					else if (OriginFor.equalsIgnoreCase("Airport")) {
						QaRobot.ClickOnElement("IMAirport");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divSearch']/p"), OAir, OAirport,
								By.xpath("//input[@id='txtSearch']"));
					}
//					else if (OriginFor.equalsIgnoreCase("City")) {
//						QaRobot.ClickOnElement("IMCity");
//						QaRobot.transferDataWithPassValue(OCiQty, OCity, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					}
//					else if (OriginFor.equalsIgnoreCase("Airport")) {
//						QaRobot.ClickOnElement("IMAirport");
//						QaRobot.transferDataWithPassValue(OAqty, OAirport, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					}
					Thread.sleep(2000);
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
					}
					else if (OriginFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("IMCity");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divSearch']/p"), Ci, City,
								By.xpath("//input[@id='txtSearch']"));
					}
					else if (OriginFor.equalsIgnoreCase("Airport")) {
						QaRobot.ClickOnElement("IMAirport");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divSearch']/p"), Air, Airport,
								By.xpath("//input[@id='txtSearch']"));
					}
//					else if (DestinationFor.equalsIgnoreCase("City")) {
//						QaRobot.ClickOnElement("IMCity");
//						QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					}
//					else if (DestinationFor.equalsIgnoreCase("Airport")) {
//						QaRobot.ClickOnElement("IMAirport");
//						QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					}
					Thread.sleep(2000);
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

					// Date Dropdown Month & Year from child window
				} else if (b.equalsIgnoreCase("Booking Date")) {
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("SuppCommRuleBookDateFrom");
					String DateSelection[] = BookDateFrom.split("-");
					String year = DateSelection[2];
					String month = DateSelection[1];
					String expDate = DateSelection[0];
					QaRobot.selectDateInCalendarIM(expDate, month, year);
					QaRobot.ClickOnElement("SuppCommRuleBookDateTo");
					String DateSelection1[] = BookDateTo.split("-");
					String year1 = DateSelection1[2];
					String month1 = DateSelection1[1];
					String expDate1 = DateSelection1[0];
					QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
					Thread.sleep(1000);

					QaRobot.ClickOnElement("SCRDateAdd");
					Thread.sleep(1000);
					QaRobot.ClickOnElement("SCRBookDateSelectClose");
					Thread.sleep(3000);

					// Select Fare Dropdown from child window
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
		QaExtentReport.extentScreenshot("Supplier Commission Rule");
		Thread.sleep(2000);
		if (DefineSalesCommission.equalsIgnoreCase("Commissionable")) {
			QaRobot.ClickOnElement("SCRCommissionable");
			QaRobot.PassValue("SCRGive", Earn);
			Thread.sleep(1000);
			QaRobot.selectTextFromDropdown("SuppCommRuleCommission", Commission);
			Thread.sleep(1000);
			QaRobot.selectTextFromDropdown("SuppCommRuleApplyOn", ApplyOn);

		}

		else if (DefineSalesCommission.equalsIgnoreCase("Net Fare")) {
			QaRobot.ClickOnElement("SCRNetfare");
			QaRobot.PassValue("SuppCommRuleNet", Net);
			Thread.sleep(1000);
			QaRobot.selectTextFromDropdown("SuppCommRuleCommissionN", CommissionN);
//			Thread.sleep(1000);
//			QaRobot.selectTextFromDropdown("SCRApplyOnN", ApplyOnN);
		}

//		if (Pass.equalsIgnoreCase("Yes")) {
//			QaRobot.PassValue("SCRPass", TransactionFeeAsDis);
//		}//select[@id='ListBox1']

		Thread.sleep(1000);
		QaExtentReport.extentScreenshot("Supplier Commission Rule");
		Thread.sleep(1000);
		QaRobot.scrollPage(-1000);
		QaRobot.ClickOnElement("SCRSave");
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Supplier commission Rule Page");

	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
