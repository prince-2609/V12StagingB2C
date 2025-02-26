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
public class DiscountCouponRule {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("DiscountCouponRule", "Sheet6");
	}

	@Test(dataProvider = "getexceldata")
	public static void discountCouponRule(String TestCaseId, String TCType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String AddNewOption,
			String RuleTemplateTitle, String SelectMediaType, String CouponNumber, String User, String UpperLimit,
			String CouponStart1, String CouponStart2, String CouponEnd1, String CouponEnd2, String BinStartWith,
			String BinEndWith, String ValidFrom, String ValidTo, String ProductQty, String Product, String CriteriaQty,
			String CriteriaName, String AirQty, String Airlines, String JourneyQty, String JourneyType, String CabinQty,
			String CabinClass, String MarketQty, String MarketType, String OriginFor, String OZqty, String OZone,
			String ORqty, String ORegion, String OCqty, String OCountry, String OCi, String OCity, String OAqty,
			String OAirport, String DestinationFor, String Zqty, String Zone, String Rqty, String Region, String Cqty,
			String Country, String DCi, String City, String Aqty, String Airport, String BookingCQty,
			String BookingClass, String PaxQty, String PaxType, String BaseFareF, String BaseFareT, String BookDateFrom,
			String BookDateTo, String FareTQty, String FareType, String Discount, String DiscountType,
			String DiscountApplyOn) throws Exception {

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
		QaRobot.ClickOnElement("DiscountCouponClick");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("DCAddNew");
		Thread.sleep(3000);
		if (AddNewOption.equalsIgnoreCase("Media")) {
			QaRobot.ClickOnElement("DCAddNewMedia");
			Thread.sleep(3000);
			QaRobot.PassValue("DCRuleTemplateTitle", RuleTemplateTitle);
			QaRobot.selectTextFromDropdown("DCSelectMediaType", SelectMediaType);
			Thread.sleep(2000);
			QaRobot.PassValue("DCCouponNumber", CouponNumber);
			Thread.sleep(2000);

			if (User.equalsIgnoreCase("Single Use")) {
				QaRobot.ClickOnElement("DCSingleUser");
			} else {
				QaRobot.ClickOnElement("DCMultiUser");
				QaRobot.PassValue("DCUpperLimit", UpperLimit);
			}
			Thread.sleep(2000);
		}

		// else if (AddNewOption.equalsIgnoreCase("Stock")) {
		else {
//			QaRobot.ClickOnElement("DCAddNew");
//			Thread.sleep(3000);
			QaRobot.ClickOnElement("DCAddNewStock");
			Thread.sleep(3000);
			QaRobot.PassValue("DCRuleTemplateTitle", RuleTemplateTitle);
			QaRobot.PassValue("DCCouponStart1", CouponStart1);
			QaRobot.PassValue("DCCouponStart2", CouponStart2);
			QaRobot.PassValue("DCCouponEnd2", CouponEnd2);

		}

		Thread.sleep(2000);
		QaRobot.ClickOnElement("DCValidFrom");
		String DateSelection[] = ValidFrom.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		QaRobot.selectDateInCalendarIM(expDate, month, year);
		Thread.sleep(2000);
		QaRobot.ClickOnElement("DCValidTo");
		String DateSelection1[] = ValidTo.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
		// QaRobot.ClickOnElement("IMBookDateSelectClose");
		Thread.sleep(3000);
		int pA = Integer.parseInt(ProductQty);
		for (int k = 1; k <= pA; k++) {
			String[] tN1 = Product.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
					"/html/body/form/div[4]/div/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div/div/ul/li/span/label"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}
		QaExtentReport.extentScreenshot("Discount Coupon Rule");
		QaRobot.scrollPage(1500);
		Thread.sleep(2000);
		// Airline Criteria from list of Airlines from child window
		int pAS = Integer.parseInt(CriteriaQty);
		if (CriteriaQty.equalsIgnoreCase("1")) {
			for (int i = 1; i <= pAS; i++) {
				String[] tN = CriteriaName.split(",");
				String b = tN[i - 1];
				QaRobot.selectTextByLocator("//select[@id='ddlkey1']", b);

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
								QaRobot.ClickOnElement("AirlineCriteriaAdd");
							}
						}
					}
//					Thread.sleep(2000);
//					QaRobot.ClickOnElement("AirlineCriteriaAdd");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("RMCAirlineSelectClose");
					Thread.sleep(3000);
				}

				else if (b.equalsIgnoreCase("Journey Type")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(JourneyQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = JourneyType.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ddlJourney']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCCabinAdd");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCJourneySelectClose");
					Thread.sleep(3000);
				}

				else if (b.equalsIgnoreCase("Passenger Type")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(PaxQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = PaxType.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ddlPax']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("DCCabinAdd");
					Thread.sleep(1000);
					QaRobot.ClickOnElement("PaxSelectClose");
					Thread.sleep(3000);
				}

				// Select Cabin Class from child window
				else if (b.equalsIgnoreCase("Cabin Class")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(CabinQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = CabinClass.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ddlCabin']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCCabinAdd");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCCabinClassSelectClose");
					Thread.sleep(3000);
				}

				else if (b.equalsIgnoreCase("Market Type")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(MarketQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = MarketType.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ddlMarket']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCCabinAdd");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCMarketSelectClose");
					Thread.sleep(3000);
				}

				// Select Zone, Country, City & Airport auto suggestion
				else if (b.equalsIgnoreCase("Origin")) {
					QaRobot.switchToWindow();
					if (OriginFor.equalsIgnoreCase("Zone")) {
						QaRobot.ClickOnElement("DCOriginZone1");
						QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
					} else if (OriginFor.equalsIgnoreCase("Country")) {
						QaRobot.ClickOnElement("DCOriginCountry1");
						QaRobot.transferDataWithPassValue(OCqty, OCountry, "//input[@id='txtOriginSearch']",
								"//div[@id='divCity']/p");
					} else if (OriginFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("DCOriginCity1");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OCi, OCity,
								By.xpath("//input[@id='txtOriginSearch']"));
					}
//						else if (OriginFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("DCOriginCity");
//							QaRobot.transferDataWithPassValue(OCiQty, OCity, "//input[@id='txtOriginSearch']",
//									"//div[@id='divCity']/p");
//						}
//						else if (OriginFor.equalsIgnoreCase("Airport")) {
//							QaRobot.ClickOnElement("IMAirport");
//							QaRobot.transferDataWithPassValue(OAqty, OAirport, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						}
					QaRobot.ClickOnElement("DCOriginSelectClose");
					Thread.sleep(3000);
				}
				// Select Zone, Country, City & Airport auto suggestion
				else if (b.equalsIgnoreCase("Destination")) {
					QaRobot.switchToWindow();
					if (DestinationFor.equalsIgnoreCase("Zone")) {
						QaRobot.ClickOnElement("DCDestinationZone1");
						QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxDestinationZone']/option");
					} else if (DestinationFor.equalsIgnoreCase("Country")) {
						QaRobot.ClickOnElement("DCDestinationCountry1");
						QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtDestinationSearch']",
								"//div[@id='divCityDestination']/p");
					} else if (DestinationFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("DCDestinationCity1");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divCityDestination']/p"), OCi, OCity,
								By.xpath("//input[@id='txtDestinationSearch']"));
					}
//						else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("DCDestinationCity");
//							QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtDestinationSearch']",
//									"//div[@id='divCityDestination']/p");
//						}
//						else if (DestinationFor.equalsIgnoreCase("Airport")) {
//							QaRobot.ClickOnElement("IMAirport");
//							QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						}
					QaRobot.ClickOnElement("DCDestinationSelectClose");
					Thread.sleep(3000);
				}
				// Select Booking class from list
//					} 
//					else if (b.equalsIgnoreCase("Booking Class")) {
//						QaRobot.switchToWindow();
//						int pAS1 = Integer.parseInt(BookingCQty);
//						for (int k = 1; k <= pAS1; k++) {
//							String[] tN1 = BookingClass.split(",");
//							String b1 = tN1[k - 1];
//							List<WebElement> listOfRights1 = QaBrowser.driver
//									.findElements(By.xpath("//select[@id='ListBoxBookingClass']/option"));
//							for (WebElement autoRights1 : listOfRights1) {
//								if (autoRights1.getText().equalsIgnoreCase(b1)) {
//									autoRights1.click();
//								}
//							}
//						}
//						QaRobot.ClickOnElement("RMCBookingCSelectClose");
//						Thread.sleep(3000);

				// Select Pax type from list

//					} else if (b.equalsIgnoreCase("Base Fare")) {
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("RMCBaseFareF", BaseFareF);
//						QaRobot.PassValue("RMCBaseFareT", BaseFareT);
//						QaRobot.ClickOnElement("RMCBookingCSelectClose");
//						Thread.sleep(3000);

				// Date Dropdown Month & Year
				else if (b.equalsIgnoreCase("Trip Dates")) {
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("DCTripDateFrom");
					String DateSelection2[] = BookDateFrom.split("-");
					String year2 = DateSelection2[2];
					String month2 = DateSelection2[1];
					String expDate2 = DateSelection2[0];
					QaRobot.selectDateInCalendarIM(expDate2, month2, year2);
					QaRobot.ClickOnElement("DCTripDateTo");
					String DateSelection3[] = BookDateTo.split("-");
					String year3 = DateSelection3[2];
					String month3 = DateSelection3[1];
					String expDate3 = DateSelection3[0];
					QaRobot.selectDateInCalendarIM(expDate3, month3, year3);
					QaRobot.ClickOnElement("DCTripDateSelectClose");
					Thread.sleep(3000);
				}
//					} else if (b.equalsIgnoreCase("Fare Type")) {
//						QaRobot.switchToWindow();
//						int pAS1 = Integer.parseInt(FareTQty);
//						for (int k = 1; k <= pAS1; k++) {
//							String[] tN1 = FareType.split(",");
//							String b1 = tN1[k - 1];
//							List<WebElement> listOfRights1 = QaBrowser.driver
//									.findElements(By.xpath("//select[@id='ListBoxFareType']/option"));
//							for (WebElement autoRights1 : listOfRights1) {
//								if (autoRights1.getText().equalsIgnoreCase(b1)) {
//									autoRights1.click();
//								}
//							}
//						}
//						QaRobot.ClickOnElement("RMCBookingCSelectClose");
//						Thread.sleep(3000);

			}
		}

		else {
			for (int i = 1; i <= pAS; i++) {
				QaRobot.scrollPage(5000);
				String[] tN = CriteriaName.split(",");
				String b = tN[i - 1];
				String s = Integer.toString(i);
				if (s.equalsIgnoreCase("1")) {
					QaRobot.selectTextByLocator("//select[@id='ddlkey1']", b);
				} else {
					WebElement RMCAddNewCriteria = QaBrowser.driver.findElement(By.xpath(
							"/html/body/form/div[4]/div/div[1]/div/div[2]/div/div[3]/div[2]/div[3]/div/div[2]/button"));
					JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
					js2.executeScript("arguments[0].click()", RMCAddNewCriteria);
					// QaRobot.selectTextByLocator("//select[@id='ddlkey1']", b);
					QaRobot.selectTextByLocator("//select[@id='ddlkey" + i + "']", b);
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
								QaRobot.ClickOnElement("AirlineCriteriaAdd");
							}
						}
					}
//					Thread.sleep(2000);
//					QaRobot.ClickOnElement("AirlineCriteriaAdd");
					Thread.sleep(3000);
					QaRobot.ClickOnElement("RMCAirlineSelectClose");
					Thread.sleep(3000);

				}

				else if (b.equalsIgnoreCase("Journey Type")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(JourneyQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = JourneyType.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ddlJourney']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCCabinAdd");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCJourneySelectClose");
					Thread.sleep(3000);
				}

				else if (b.equalsIgnoreCase("Passenger Type")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(PaxQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = PaxType.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ddlPax']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					QaRobot.ClickOnElement("DCCabinAdd");
					Thread.sleep(1000);
					QaRobot.ClickOnElement("PaxSelectClose");
					Thread.sleep(3000);
				}

				else if (b.equalsIgnoreCase("Cabin Class")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(CabinQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = CabinClass.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ddlCabin']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCCabinAdd");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCCabinClassSelectClose");
					Thread.sleep(3000);

				}

				else if (b.equalsIgnoreCase("Market Type")) {
					QaRobot.switchToWindow();
					int pAS1 = Integer.parseInt(MarketQty);
					for (int k = 1; k <= pAS1; k++) {
						String[] tN1 = MarketType.split(",");
						String b1 = tN1[k - 1];
						List<WebElement> listOfRights1 = QaBrowser.driver
								.findElements(By.xpath("//select[@id='ddlMarket']/option"));
						for (WebElement autoRights1 : listOfRights1) {
							if (autoRights1.getText().equalsIgnoreCase(b1)) {
								autoRights1.click();
							}
						}
					}
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCCabinAdd");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("DCMarketSelectClose");
					Thread.sleep(3000);
				}

				// Select Zone, Country, City & Airport auto suggestion
				else if (b.equalsIgnoreCase("Origin")) {
					QaRobot.switchToWindow();
					if (OriginFor.equalsIgnoreCase("Zone")) {
						QaRobot.ClickOnElement("DCOriginZone1");
						QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
					} else if (OriginFor.equalsIgnoreCase("Country")) {
						QaRobot.ClickOnElement("DCOriginCountry1");
						QaRobot.transferDataWithPassValue(OCqty, OCountry, "//input[@id='txtOriginSearch']",
								"//div[@id='divCity']/p");
					} else if (OriginFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("DCOriginCity1");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), OCi, OCity,
								By.xpath("//input[@id='txtOriginSearch']"));
					}
//						else if (OriginFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("DCOriginCity");
//							QaRobot.transferDataWithPassValue(OCiQty, OCity, "//input[@id='txtOriginSearch']",
//									"//div[@id='divCity']/p");
//						}
//						else if (OriginFor.equalsIgnoreCase("Airport")) {
//							QaRobot.ClickOnElement("IMAirport");
//							QaRobot.transferDataWithPassValue(OAqty, OAirport, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						}
					QaRobot.ClickOnElement("DCOriginSelectClose");
					Thread.sleep(3000);
				}
				// Select Zone, Country, City & Airport auto suggestion
				else if (b.equalsIgnoreCase("Destination")) {
					QaRobot.switchToWindow();
					if (DestinationFor.equalsIgnoreCase("Zone")) {
						QaRobot.ClickOnElement("DCDestinationZone1");
						QaRobot.transferData(Zqty, Zone, "//select[@id='ListBoxDestinationZone']/option");
					} else if (DestinationFor.equalsIgnoreCase("Country")) {
						QaRobot.ClickOnElement("DCDestinationCountry1");
						QaRobot.transferDataWithPassValue(Cqty, Country, "//input[@id='txtDestinationSearch']",
								"//div[@id='divCityDestination']/p");
					} else if (DestinationFor.equalsIgnoreCase("City")) {
						QaRobot.ClickOnElement("DCDestinationCity1");
						TestBase.listofautosuggestion(By.xpath("//div[@id='divCityDestination']/p"), OCi, OCity,
								By.xpath("//input[@id='txtDestinationSearch']"));
					}
//						else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("DCDestinationCity");
//							QaRobot.transferDataWithPassValue(CiQty, City, "//input[@id='txtDestinationSearch']",
//									"//div[@id='divCityDestination']/p");
//						}
//						else if (DestinationFor.equalsIgnoreCase("Airport")) {
//							QaRobot.ClickOnElement("IMAirport");
//							QaRobot.transferDataWithPassValue(Aqty, Airport, "//input[@id='txtSearch']",
//									"//div[@id='divSearch']/p");
//						}
					QaRobot.ClickOnElement("DCDestinationSelectClose");
					Thread.sleep(3000);
				}

//					 else if (b.equalsIgnoreCase("Booking Class")) {
//						QaRobot.switchToWindow();
//						int pAS1 = Integer.parseInt(BookingCQty);
//						for (int k = 1; k <= pAS1; k++) {
//							String[] tN1 = BookingClass.split(",");
//							String b1 = tN1[k - 1];
//							List<WebElement> listOfRights1 = QaBrowser.driver
//									.findElements(By.xpath("//select[@id='ListBoxBookingClass']/option"));
//							for (WebElement autoRights1 : listOfRights1) {
//								if (autoRights1.getText().equalsIgnoreCase(b1)) {
//									autoRights1.click();
//								}
//							}
//						}
//						QaRobot.ClickOnElement("RMCBookingCSelectClose");
//						Thread.sleep(3000);
//				}

//					} else if (b.equalsIgnoreCase("Base Fare")) {
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("RMCBaseFareF", BaseFareF);
//						QaRobot.PassValue("RMCBaseFareT", BaseFareT);
//						QaRobot.ClickOnElement("RMCBookingCSelectClose");
//						Thread.sleep(3000);

				// Date Dropdown Month & Year from child window
				else if (b.equalsIgnoreCase("Trip Dates")) {
					QaRobot.switchToWindow();
					QaRobot.ClickOnElement("DCTripDateFrom");
					String DateSelection2[] = BookDateFrom.split("-");
					String year2 = DateSelection2[2];
					String month2 = DateSelection2[1];
					String expDate2 = DateSelection2[0];
					QaRobot.selectDateInCalendarIM(expDate2, month2, year2);
					QaRobot.ClickOnElement("DCTripDateTo");
					String DateSelection3[] = BookDateTo.split("-");
					String year3 = DateSelection3[2];
					String month3 = DateSelection3[1];
					String expDate3 = DateSelection3[0];
					QaRobot.selectDateInCalendarIM(expDate3, month3, year3);
					QaRobot.ClickOnElement("DCTripDateSelectClose");
					Thread.sleep(3000);
				}
				// Select Fare Dropdown from child window
//					} else if (b.equalsIgnoreCase("Fare Type")) {
//						QaRobot.switchToWindow();
//						int pAS1 = Integer.parseInt(FareTQty);
//						for (int k = 1; k <= pAS1; k++) {
//							String[] tN1 = FareType.split(",");
//							String b1 = tN1[k - 1];
//							List<WebElement> listOfRights1 = QaBrowser.driver
//									.findElements(By.xpath("//select[@id='ListBoxFareType']/option"));
//							for (WebElement autoRights1 : listOfRights1) {
//								if (autoRights1.getText().equalsIgnoreCase(b1)) {
//									autoRights1.click();
//								}
//							}
//						}

			}
		}
		QaRobot.scrollPage(1000);
		Thread.sleep(2000);
		QaRobot.PassValue("DCDiscount", Discount);
		QaRobot.selectTextFromDropdown("DCDiscountType", DiscountType);
		Thread.sleep(2000);
		QaRobot.selectTextFromDropdown("DCDiscountApplyOn", DiscountApplyOn);
		Thread.sleep(2000);
		QaExtentReport.extentScreenshot("Discount Coupon Rule");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("DCSave");
		Thread.sleep(2000);
		QaRobot.alertAccept();
		QaExtentReport.extentScreenshot("Discount Coupon Rules page");
//		}
//
//		else if (AddNewOption.equalsIgnoreCase("Stock")) {
//			QaRobot.ClickOnElement("DCAddNewStock");
//
//		}
//
//		else if (AddNewOption.equalsIgnoreCase("Credit Card")) {
//			QaRobot.ClickOnElement("DCAddNewCreditCard");
//
//		}

		// QaRobot.ClickOnElement("DCSave");
	}

	@AfterMethod
	public static void afterMethod() {
		//QaExtentReport.test.getExtent().flush();
	}
}
