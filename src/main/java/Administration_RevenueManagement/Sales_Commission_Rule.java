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
public class Sales_Commission_Rule {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("Administration_RevenueManagement_SalesCommissionRule", "Sheet7");
	}

	@Test(dataProvider = "getexceldata")
	public static void corporateProfiling(String TestCaseId, String TCType, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String RuleTemplateTitle, String Product,
			String Supplier, String SCQty, String SalesChannel, String CriteriaQty, String CriteriaName, String AirQty,
			String Airlines, String CabinQty, String CabinClass, String OriginFor, String OZqty, String OZone,
			String ORqty, String ORegion, String OCqty, String OCountry, String OCi, String OCity, String OAir,
			String OAirport, String DestinationFor, String Zqty, String Zone, String Rqty, String Region, String Cqty,
			String Country, String Ci, String City, String Air, String Airport, String BookingCQty,
			String BookingClass, String PaxQty, String PaxType, String BaseFareF, String BaseFareT, String BookDateFrom,
			String BookDateTo, String FareTQty, String FareType, String DefineSalesCommission, String Give,
			String Commission, String ApplyOn, String Pass, String TransactionFeeAsDis, String Add, String CommissionN,
			String ApplyOnN) throws Exception {
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
		QaRobot.ClickOnElement("RMSalesCommissionRule");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("SCRAddNewRule");
		Thread.sleep(6000);
		QaRobot.PassValue("SCRRuleTemplateTitle", RuleTemplateTitle);

		// Select product from the list
		QaRobot.selectTextFromDropdown("SCRProduct", Product);
		Thread.sleep(5000);
		// QaRobot.selectTextFromDropdown("SCRSupplier", Supplier);
		QaRobot.ClickOnElement("SCRSupplierSel");

		// Click Sales Channel Checkbox from list
		int pA = Integer.parseInt(SCQty);
		for (int k = 1; k <= pA; k++) {
			String[] tN1 = SalesChannel.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
					"/html/body/form/div[4]/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td/div[1]/fieldset[1]/table/tbody/tr[2]/td/fieldset/table/tbody/tr[3]/td[2]/table/tbody/tr/td"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}

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
						QaRobot.ClickOnElement("SCRAirlineShowAll");
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
					Thread.sleep(2000);
					QaRobot.ClickOnElement("SCRBookDateSelectClose");
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
//						QaRobot.transferDataWithPassValue(Ci, City, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					} 
//					else if (DestinationFor.equalsIgnoreCase("Airport")) {
//						QaRobot.ClickOnElement("IMAirport");
//						QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					}
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
						QaRobot.ClickOnElement("SCRAirlineShowAll");
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ListBoxAirlineFiller']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
								QaRobot.ClickOnElement("SCRAddAirline");
							}
						}
					}
					Thread.sleep(2000);
					QaRobot.ClickOnElement("SCRBookDateSelectClose");
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
//						QaRobot.transferDataWithPassValue(Ci, City, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					}
	
//					else if (DestinationFor.equalsIgnoreCase("Airport")) {
//						QaRobot.ClickOnElement("IMAirport");
//						QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
//								"//div[@id='divSearch']/p");
//					}
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
					QaRobot.ClickOnElement("SCRBookDateFrom");
					String DateSelection[] = BookDateFrom.split("-");
					String year = DateSelection[2];
					String month = DateSelection[1];
					String expDate = DateSelection[0];
					QaRobot.selectDateInCalendarIM(expDate, month, year);
					QaRobot.ClickOnElement("SCRBookDateTo");
					String DateSelection1[] = BookDateTo.split("-");
					String year1 = DateSelection1[2];
					String month1 = DateSelection1[1];
					String expDate1 = DateSelection1[0];
					QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
					Thread.sleep(1000);
					QaRobot.ClickOnElement("SCRAirlineAdd");
					Thread.sleep(1000);
					QaRobot.ClickOnElement("IMBookDateSelectClose");
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

		if (DefineSalesCommission.equalsIgnoreCase("Commissionable")) {
			QaRobot.ClickOnElement("SCRCommissionable");
			QaRobot.PassValue("SCRGive", Give);
			Thread.sleep(1000);
			QaRobot.selectTextFromDropdown("SCRCommission", Commission);
			Thread.sleep(1000);
			QaRobot.selectTextFromDropdown("SCRApplyOn", ApplyOn);

		}

		else if (DefineSalesCommission.equalsIgnoreCase("Net Fare")) {
			QaRobot.ClickOnElement("SCRNetfare");
			QaRobot.PassValue("SCRAdd", Add);
			Thread.sleep(1000);
			QaRobot.selectTextFromDropdown("SCRCommissionN", CommissionN);
			Thread.sleep(1000);
			QaRobot.selectTextFromDropdown("SCRApplyOnN", ApplyOnN);
		}
		Thread.sleep(1000);
		if (Pass.equalsIgnoreCase("Yes")) {
			QaRobot.PassValue("SCRPass", TransactionFeeAsDis);
		}

		QaRobot.scrollPage(-1000);
		QaExtentReport.extentScreenshot("Sales commission Rule");
		QaRobot.ClickOnElement("SCRSave");
		Thread.sleep(8000);
		QaExtentReport.extentScreenshot("Sales commission Rule Page");

	}

	@AfterMethod
	public static void afterMethod() {
		 QaExtentReport.test.getExtent().flush();
	}

//											//  Date Dropdown Month & Year

//public static void selectDateInCalendarIM(String Day, String Month, String Year) throws Exception {
//
//Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
//Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
//"Invalid date provided " + Day + "-" + Month + "-" + Year);
//Thread.sleep(3000);
//QaRobot.selectTextByLocator("/html/body/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[1]/td/span/select[2]",
//Year);
//QaRobot.selectTextByLocator("/html/body/form/div[3]/div/table/tbody/tr/td/table/tbody/tr[1]/td/span/select[1]",
//Month);
//
//QaBrowser.driver.findElement(By.xpath("//input[@value='" + Day + " ']")).click();
//}
}
