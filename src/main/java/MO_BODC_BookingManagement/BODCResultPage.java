package MO_BODC_BookingManagement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;
import v12Staging_B2C.B2cExceptionClass;

public class BODCResultPage {
	public static void ResultPageForFlight(String Trip, String TripType, String ModifySearch, String ChangeTrip,
			String MarketTypeM, String TripTypeM, String OriginCityCodeM, String OriginLocationM,
			String DestinationCityCodeM, String DestinationLocationM, String ChangeTripDate, String DepartureDateM,
			String ReturnDateM, String ChangeTravellers, String AdultM, String YouthM, String ChildM, String InfantM,
			String ChangeClass, String ClassM, String ShowDirectFlightM, String MyDatesAreFlexibleM,
			String AdvanceSearch, String SelectCurrency, String SelectNationality, String CountryOfResidence,
			String ChangeAirline, String PANumberM, String PreferredAirlineSelectM, String SupplierChange,
			String SupNumberM, String SelectSupplierM, String Applyfilter, String FareType, String Stops,
			String AirLine, String Resultpagestep, String QuoteTitle, String QuoteRemark) throws Exception {
		Thread.sleep(30000);
		QaRobot.ScreenshotMethod("ResultPage", "<b><i>Screenshot for Result Page</i></b>");
//		String url = QaBrowser.driver.getCurrentUrl();
//		String[] uid = url.split("=");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		String DateSelection[] = DepartureDateM.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = ReturnDateM.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		if (ModifySearch.equalsIgnoreCase("Yes")) {
//			QaRobot.switchframe("//frame[@name='login']");
//			QaRobot.switchframe("//frame[@name='main']");
			QaRobot.ClickOnElement("DCModifySearchF");
			Thread.sleep(3000);
			if (ChangeTrip.equalsIgnoreCase("Yes")) {
				if (TripTypeM.equalsIgnoreCase("OneWay")) {
					QaRobot.ClickOnElement("DCOneWayMF");
				} else if (TripTypeM.equalsIgnoreCase("RoundTrip")) {
					QaRobot.ClickOnElement("DCRoundTripMF");
				}
				Assert.assertFalse(OriginCityCodeM == DestinationCityCodeM,
						"Modified Origin And Destination City Code Can't Be Same");
				Assert.assertFalse(OriginLocationM == DestinationLocationM,
						"Modified Origin And Destination City Location Can't Be Same");
				TestBase.listofautosuggestion4(By.xpath("//div[@id='divDepartureCity0']/p"), OriginCityCodeM,
						OriginLocationM, By.xpath("//input[@id='MtxtDepartureCity0']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='divDepartureCity0']/p[1]")).click();
				QaExtentReport.test.log(Status.INFO,
						"<b><i>Modified Departure city : </i></b>" + OriginCityCodeM + " - " + OriginLocationM);
				Thread.sleep(2000);
				TestBase.listofautosuggestion4(By.xpath("//div[@id='divDestinationCity0']/p"), DestinationCityCodeM,
						DestinationLocationM, By.xpath("//input[@id='MtxtDestinationCity0']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='divDestinationCity0']/p[1]")).click();
				QaExtentReport.test.log(Status.INFO,
						"<b><i>Modified Arrival city : </i></b>" + DestinationCityCodeM + " - " + DestinationLocationM);
				Thread.sleep(2000);
				if (ChangeTripDate.equalsIgnoreCase("Yes")) {
					if (TripTypeM.equalsIgnoreCase("OneWay")) {
						QaRobot.ClickOnElement("DCOneWayMF");
						Thread.sleep(3000);
						QaBrowser.driver.findElement(By.xpath("(//i[@class='fa fa-calendar input-icon'])[1]")).click();
						Thread.sleep(2000);
						selectDateInCalendarOneWay(expDate, month, year);
					} else if (TripTypeM.equalsIgnoreCase("RoundTrip")) {
						QaRobot.ClickOnElement("DCRoundTripMF");
						Thread.sleep(3000);
						QaBrowser.driver.findElement(By.xpath("(//i[@class='fa fa-calendar input-icon'])[1]")).click();
						Thread.sleep(2000);
						selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);
					}
				}
				if (ChangeTravellers.equalsIgnoreCase("Yes")) {
					QaRobot.ClickOnElement("TravellersMF");
					QaRobot.selectValueFromDropdown("DCAdultMF", AdultM,
							"<b><i>Select adult for booking</i></b>" + " - " + AdultM);
					Thread.sleep(2000);
					QaRobot.selectValueFromDropdown("DCYouthMF", YouthM,
							"<b><i>Select adult for booking</i></b>" + " - " + YouthM);
					Thread.sleep(2000);
					QaRobot.selectValueFromDropdown("DCChildMF", ChildM,
							"<b><i>Select child for booking</i></b>" + " - " + ChildM);
					Thread.sleep(2000);
					QaRobot.selectValueFromDropdown("DCInfantMF", InfantM,
							"<b><i>Select infant for booking</i></b>" + " - " + InfantM);
					Thread.sleep(2000);
					QaRobot.ClickOnElement("TravellersMF");
				}
				if (ChangeClass.equalsIgnoreCase("Yes")) {
					QaRobot.ClickOnElement("TravellersMF");
					QaRobot.selectTextByLocator("//select[@id='ddlClass']", ClassM,
							"<b><i>Select Modified Class for booking</i></b>");
					Thread.sleep(2000);
					QaRobot.ClickOnElement("TravellersMF");
				}
				if (ShowDirectFlightM.equalsIgnoreCase("Yes")) {
					QaRobot.ClickOnElement("DCShowDirectFlightMF");
				}
				if (MyDatesAreFlexibleM.equalsIgnoreCase("Yes")) {
					QaRobot.ClickOnElement("DCMyDatesAreFlexibleMF");
				}
				if (AdvanceSearch.equalsIgnoreCase("Yes")) {
					QaRobot.ClickOnElement("AdvanceSearch");
					QaRobot.selectTextByLocator("//select[@id='ddlCurrency']", SelectCurrency,
							"<b><i>Select Currency for booking </i></b>" + SelectCurrency);
					QaRobot.selectTextByLocator("//select[@id='ddlNationality']", SelectCurrency,
							"<b><i>Select Nationality for booking </i></b>" + SelectCurrency);
					QaRobot.selectTextByLocator("//select[@id='ddlCountryOfResidence']", CountryOfResidence,
							"<b><i>Select Nationality for booking </i></b>" + CountryOfResidence);
					if (ChangeAirline.equalsIgnoreCase("Yes")) {
						QaRobot.ClickOnElement("PreferredAirlineMF");
						Thread.sleep(2000);
						int pAS = Integer.parseInt(PANumberM);
						for (int i = 1; i <= pAS; i++) {
							String[] tN = PreferredAirlineSelectM.split(",");
							String b = tN[i - 1];
							TestBase.listofautosuggestion1(
									By.xpath("//ul[@class='dropdown-menu-form  dropdown-menu']/li"), b, By.xpath(
											"//div[@id='Return']/div/div/div[1]/div[1]/div[2]/div/div[4]/div[3]/div/div/div/div[1]/input"));
						}
						QaRobot.ClickOnElement("PreferredAirlineMF");
					}
				}
				if (SupplierChange.equalsIgnoreCase("Yes")) {
					QaRobot.ClickOnElement("SelectAll");
					int pAS = Integer.parseInt(SupNumberM);
					for (int i = 1; i <= pAS; i++) {
						String[] tN = SelectSupplierM.split(",");
						String b = tN[i - 1];
						List<WebElement> listOfSupplier = QaBrowser.driver
								.findElements(By.xpath("//div[@id='divSuppliers']/div/label"));
						for (WebElement autoSupplier : listOfSupplier) {
							if (autoSupplier.getText().equalsIgnoreCase(b)) {
								autoSupplier.click();
								QaExtentReport.test.log(Status.INFO,
										"<b><i>Select Supplier</i></b>" + " " + i + " " + b);
								break;
							}
						}
					}
				}
				QaRobot.ClickOnElement("ModifySearchMF");
				QaExtentReport.extentScreenshot("Modified Search");
				Thread.sleep(15000);
			}
		}

		if (Applyfilter.equalsIgnoreCase("Yes")) {
			if (FareType.equalsIgnoreCase("All")) {
				JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
				mo.executeScript("window.scrollBy(0,500)", "");
				QaRobot.ClickOnElement("Refundable");
				Thread.sleep(3000);
				QaRobot.ClickOnElement("NonRefundable");
				Thread.sleep(3000);
			} else if (FareType.equalsIgnoreCase("Refundable")) {
				QaRobot.ClickOnElement("Refundable");
				Thread.sleep(3000);
			} else if (FareType.equalsIgnoreCase("Non-Refundable")) {
				QaRobot.ClickOnElement("NonRefundable");
				Thread.sleep(3000);
			}
			List<WebElement> listOfStop = QaBrowser.driver.findElements(By.xpath(
					"/html/body/div[1]/div[1]/div/section/div[2]/div[2]/div/div/div[1]/div/div/div[3]/div[4]/div[2]/ul/li/span"));
			for (WebElement autoStop : listOfStop) {
//				System.out.println(autoAirline.getText());
				if (autoStop.getText().equalsIgnoreCase(Stops)) {
					autoStop.click();
					break;
				}
			}
			Thread.sleep(3000);
			List<WebElement> listOfAirLine = QaBrowser.driver
					.findElements(By.xpath("(//div[@id='tdContainerTblAirlines'])[2]//li//span"));
			for (WebElement autoAirline : listOfAirLine) {
				if (autoAirline.getText().equalsIgnoreCase(AirLine)) {
					autoAirline.click();
					break;
				}
			}
			QaExtentReport.extentScreenshot("Apply filter");
		}
		if (Trip.equalsIgnoreCase("Domestic") || MarketTypeM.equalsIgnoreCase("Domestic")) {
			if (TripType.equalsIgnoreCase("OneWay") || TripTypeM.equalsIgnoreCase("OneWay")) {
				JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
				mo.executeScript("window.scrollBy(0,-800)", "");
//				JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
//				mo.executeScript("window.scrollBy(0,400)", "");

//				WebElement FlightItinerary = QaBrowser.driver
//						.findElement(By.xpath("(//a[@class='flght-itnry ng-binding'])[1]"));
//				JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
//				js1.executeScript("arguments[0].click()", FlightItinerary);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FlightItinerary</i></b>");
//				Thread.sleep(5000);
//				QaExtentReport.extentScreenshot("FlightItinerary");
//
//				WebElement FareBreakup = QaBrowser.driver
//						.findElement(By.xpath("(//a[@class='fare-brkp ng-binding'])[1]"));
//				JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//				js2.executeScript("arguments[0].click()", FareBreakup);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreakup</i></b>");
//				Thread.sleep(5000);
//				QaExtentReport.extentScreenshot("FareBreakup");
//
//				QaRobot.ScreenshotMethod("FareBreakup", "<b><i>Screenshot for Fare Breakup</i></b>");
//
//				WebElement FareRules = QaBrowser.driver
//						.findElement(By.xpath("(//a[@class='fare-rule ng-binding'])[1]"));
//				JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
//				js3.executeScript("arguments[0].click()", FareRules);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareRules</i></b>");
//				Thread.sleep(5000);
//				QaExtentReport.extentScreenshot("FareRules");
//
//				QaRobot.ScreenshotMethod("FareRules", "<b><i>Screenshot for Fare Rules</i></b>");
//
//				WebElement BaggegeInformation = QaBrowser.driver
//						.findElement(By.xpath("(//a[@class='bgag-infrmtn ng-binding'])[1]"));
//				JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
//				js4.executeScript("arguments[0].click()", BaggegeInformation);
//				QaExtentReport.test.log(Status.INFO, "<b><i>Click on BaggegeInformation</i></b>");
//				Thread.sleep(5000);
//				QaExtentReport.extentScreenshot("BaggegeInformation");
//
//				QaRobot.ScreenshotMethod("BaggegeInformation", "<b><i>Screenshot for Baggege Information</i></b>");

				WebElement BookNow = QaBrowser.driver
						.findElement(By.xpath("(//input[@class='btn_smallyellow ng-scope'])[1]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", BookNow);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on BookNow</i></b>");
				Thread.sleep(20000);
			} else if (TripType.equalsIgnoreCase("RoundTrip") || TripTypeM.equalsIgnoreCase("RoundTrip")) {
//				QaRobot.ClickOnElement("RDFareBreakup");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
//				Thread.sleep(3000);
//				QaExtentReport.extentScreenshot("FareBreakup");
//				QaRobot.ScreenshotMethod("FareBreakup", "<b><i>Screenshot for Fare Breakup</i></b>");
//
//				String ParentWindow = QaBrowser.driver.getWindowHandle();
//				Set<String> handles = QaBrowser.driver.getWindowHandles();
//				for (String childWindow : handles) {
//					if (!childWindow.equals(ParentWindow))
//						QaBrowser.driver.switchTo().window(childWindow);
//				}
//				QaRobot.ClickOnElement("RDFareBreakupClose");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
//				Thread.sleep(2000);
//				QaBrowser.driver.switchTo().window(ParentWindow);
//
//				QaRobot.ClickOnElement("RDRulesBaggage");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
//				Thread.sleep(3000);
//				QaExtentReport.extentScreenshot("RulesBaggage");
//				QaRobot.ScreenshotMethod("RulesBaggage", "<b><i>Screenshot for Rules Baggage</i></b>");
//
//				String ParentWindow1 = QaBrowser.driver.getWindowHandle();
//				Set<String> handles1 = QaBrowser.driver.getWindowHandles();
//				for (String childWindow1 : handles1) {
//					if (!childWindow1.equals(ParentWindow1))
//						QaBrowser.driver.switchTo().window(childWindow1);
//				}
//				Thread.sleep(3000);
//
//				QaRobot.ClickOnElement("RDBaggageInformation");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
//				Thread.sleep(2000);
//				QaExtentReport.extentScreenshot("BaggageInformation");
//				QaRobot.ScreenshotMethod("BaggageInformation", "<b><i>Screenshot for Baggage Information</i></b>");
//
//				QaRobot.ClickOnElement("RDRulesBaggageClose");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
//				Thread.sleep(2000);
//				QaBrowser.driver.switchTo().window(ParentWindow1);
//
//				QaRobot.ClickOnElement("RDRFareBreakup");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
//				Thread.sleep(3000);
//				QaExtentReport.extentScreenshot("RFareBreakup");
//				QaRobot.ScreenshotMethod("FareBreakup", "<b><i>Screenshot for Fare Breakup</i></b>");
//
//				String ParentWindow2 = QaBrowser.driver.getWindowHandle();
//				Set<String> handles2 = QaBrowser.driver.getWindowHandles();
//				for (String childWindow2 : handles2) {
//					if (!childWindow2.equals(ParentWindow2))
//						QaBrowser.driver.switchTo().window(childWindow2);
//				}
//				QaRobot.ClickOnElement("RDRFareBreakupClose");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
//				Thread.sleep(2000);
//				QaBrowser.driver.switchTo().window(ParentWindow2);
//
//				QaRobot.ClickOnElement("RDRRulesBaggage");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
//				Thread.sleep(3000);
//				QaExtentReport.extentScreenshot("RRulesBaggage");
//				QaRobot.ScreenshotMethod("RulesBaggage", "<b><i>Screenshot for Rules Baggage</i></b>");
//
//				String ParentWindow3 = QaBrowser.driver.getWindowHandle();
//				Set<String> handles3 = QaBrowser.driver.getWindowHandles();
//				for (String childWindow3 : handles3) {
//					if (!childWindow3.equals(ParentWindow3))
//						QaBrowser.driver.switchTo().window(childWindow3);
//				}
//				Thread.sleep(3000);
//
//				QaRobot.ClickOnElement("RDRFareRules");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
//				Thread.sleep(2000);
//				QaExtentReport.extentScreenshot("RFareRules");
//				QaRobot.ScreenshotMethod("FareRules", "<b><i>Screenshot for Fare Rules</i></b>");
//
//				QaRobot.ClickOnElement("RDRRulesBaggageClose");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
//				Thread.sleep(2000);
//				QaBrowser.driver.switchTo().window(ParentWindow);

				QaRobot.ClickOnElement("ContinueButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(20000);
			}
		} else if (Trip.equalsIgnoreCase("International") || MarketTypeM.equalsIgnoreCase("International")) {
			JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
			mo.executeScript("window.scrollBy(0,360)", "");

			WebElement FlightItinerary = QaBrowser.driver
					.findElement(By.xpath("(//a[@class='flght-itnry ng-binding'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", FlightItinerary);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FlightItinerary</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("FlightItinerary");

			WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-brkp ng-binding'])[1]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", FareBreakup);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreakup</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("FareBreakup");
			QaRobot.ScreenshotMethod("FareBreakup", "<b><i>Screenshot for Fare Breakup</i></b>");

			WebElement FareRules = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-rule ng-binding'])[1]"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", FareRules);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareRules</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("FareRules");
			QaRobot.ScreenshotMethod("FareRules", "<b><i>Screenshot for Fare Rules</i></b>");

			WebElement BaggegeInformation = QaBrowser.driver
					.findElement(By.xpath("(//a[@class='bgag-infrmtn ng-binding'])[1]"));
			JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
			js4.executeScript("arguments[0].click()", BaggegeInformation);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on BaggegeInformation</i></b>");
			Thread.sleep(5000);
			QaExtentReport.extentScreenshot("BaggegeInformation");
			QaRobot.ScreenshotMethod("BaggegeInformation", "<b><i>Screenshot for Baggege Information</i></b>");

			WebElement BookNow = QaBrowser.driver
					.findElement(By.xpath("(//input[@class='btn_smallyellow ng-scope'])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", BookNow);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on BookNow</i></b>");
			Thread.sleep(20000);
		}
//		if (TripType.equalsIgnoreCase("OneWay") || TripTypeM.equalsIgnoreCase("OneWay")) {
//		JavascriptExecutor mo = (JavascriptExecutor) QaBrowser.driver;
//		mo.executeScript("window.scrollBy(0,-800)", "");

//		WebElement FlightItinerary = QaBrowser.driver
//				.findElement(By.xpath("(//a[@class='flght-itnry ng-binding'])[1]"));
//		JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
//		js1.executeScript("arguments[0].click()", FlightItinerary);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FlightItinerary</i></b>");
//		Thread.sleep(5000);
//		QaExtentReport.extentScreenshot("FlightItinerary");
//
//		WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-brkp ng-binding'])[1]"));
//		JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
//		js2.executeScript("arguments[0].click()", FareBreakup);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreakup</i></b>");
//		Thread.sleep(5000);
//		QaExtentReport.extentScreenshot("FareBreakup");
//
//		QaRobot.ScreenshotMethod("FareBreakup", "<b><i>Screenshot for Fare Breakup</i></b>");
//
//		WebElement FareRules = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-rule ng-binding'])[1]"));
//		JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
//		js3.executeScript("arguments[0].click()", FareRules);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareRules</i></b>");
//		Thread.sleep(5000);
//		QaExtentReport.extentScreenshot("FareRules");
//
//		QaRobot.ScreenshotMethod("FareRules", "<b><i>Screenshot for Fare Rules</i></b>");
//
//		WebElement BaggegeInformation = QaBrowser.driver
//				.findElement(By.xpath("(//a[@class='bgag-infrmtn ng-binding'])[1]"));
//		JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
//		js4.executeScript("arguments[0].click()", BaggegeInformation);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on BaggegeInformation</i></b>");
//		Thread.sleep(5000);
//		QaExtentReport.extentScreenshot("BaggegeInformation");
//
//		QaRobot.ScreenshotMethod("BaggegeInformation", "<b><i>Screenshot for Baggege Information</i></b>");
//
//		WebElement BookNow = QaBrowser.driver.findElement(By.xpath("(//input[@class='btn_smallyellow ng-scope'])[1]"));
//		JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
//		js.executeScript("arguments[0].click()", BookNow);
//		QaExtentReport.test.log(Status.INFO, "<b><i>Click on BookNow</i></b>");
//		Thread.sleep(20000);
	}

	public static void selectDateInCalendarOneWay(String Day, String Month, String Year) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		QaExtentReport.test.log(Status.INFO, "<b><i>Modified Select Date  </i></b>" + Day + "-" + Month + "-" + Year);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid Modified date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid Modified date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new Exception("Invalid Modified date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid Modified date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid Modified date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new Exception("Invalid Modified date provided " + Day + "/" + Month + "/" + Year);
		}
		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];

		String currentMonthNumber2 = "00";
		if (month.equalsIgnoreCase("Jan")) {
			currentMonthNumber2 = "01";
		} else if (month.equalsIgnoreCase("Feb")) {
			currentMonthNumber2 = "02";
		} else if (month.equalsIgnoreCase("Mar")) {
			currentMonthNumber2 = "03";
		} else if (month.equalsIgnoreCase("Apr")) {
			currentMonthNumber2 = "04";
		} else if (month.equalsIgnoreCase("May")) {
			currentMonthNumber2 = "05";
		} else if (month.equalsIgnoreCase("Jun")) {
			currentMonthNumber2 = "06";
		} else if (month.equalsIgnoreCase("Jul")) {
			currentMonthNumber2 = "07";
		} else if (month.equalsIgnoreCase("Aug")) {
			currentMonthNumber2 = "08";
		} else if (month.equalsIgnoreCase("Sep")) {
			currentMonthNumber2 = "09";
		} else if (month.equalsIgnoreCase("Oct")) {
			currentMonthNumber2 = "10";
		} else if (month.equalsIgnoreCase("Nov")) {
			currentMonthNumber2 = "11";
		} else if (month.equalsIgnoreCase("Dec")) {
			currentMonthNumber2 = "12";
		}
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid Modified date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid Modified date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new Exception("Invalid Modified date provided " + Day + "-" + Month + "-" + Year);
		} else {
			if (Integer.parseInt(currentMonthNumber) < Integer.parseInt(currentMonthNumber2) && year.equals(Year)) {
				while (!(month.equals(Month) && year.equals(Year))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[1]")).click();

					monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div"))
							.getText();

					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			} else {
				while (!(month.equals(Month) && year.equals(Year))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

					monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div"))
							.getText();

					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}
			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
		}
	}

	public static void selectDateInCalendarRoundTrip(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month1.equalsIgnoreCase("Jan")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("Feb")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("Mar")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("Apr")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("Jul")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("Aug")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("Sep")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("Oct")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("Nov")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("Dec")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO,
				"<b><i>Select Modified Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO,
				"<b><i>Select Modified Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid Modified date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid Modified date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new Exception("Invalid Modified date provided " + Day + "/" + Month + "/" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid Modified date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid Modified date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new Exception("Invalid Modified date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Integer.parseInt(Day1) > 31) {
			System.out.println("Invalid Modified date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid Modified date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			throw new Exception("Invalid Modified date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day1) > 28) {
			System.out.println("Invalid Modified date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid Modified date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			throw new Exception("Invalid Modified date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];

		String currentMonthNumber2 = "00";
		if (month.equalsIgnoreCase("Jan")) {
			currentMonthNumber2 = "01";
		} else if (month.equalsIgnoreCase("Feb")) {
			currentMonthNumber2 = "02";
		} else if (month.equalsIgnoreCase("Mar")) {
			currentMonthNumber2 = "03";
		} else if (month.equalsIgnoreCase("Apr")) {
			currentMonthNumber2 = "04";
		} else if (month.equalsIgnoreCase("May")) {
			currentMonthNumber2 = "05";
		} else if (month.equalsIgnoreCase("Jun")) {
			currentMonthNumber2 = "06";
		} else if (month.equalsIgnoreCase("Jul")) {
			currentMonthNumber2 = "07";
		} else if (month.equalsIgnoreCase("Aug")) {
			currentMonthNumber2 = "08";
		} else if (month.equalsIgnoreCase("Sep")) {
			currentMonthNumber2 = "09";
		} else if (month.equalsIgnoreCase("Oct")) {
			currentMonthNumber2 = "10";
		} else if (month.equalsIgnoreCase("Nov")) {
			currentMonthNumber2 = "11";
		} else if (month.equalsIgnoreCase("Dec")) {
			currentMonthNumber2 = "12";
		}
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid Modified date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid Modified date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new Exception("Invalid Modified date provided " + Day + "-" + Month + "-" + Year);
		} else {
			if (Integer.parseInt(currentMonthNumber) < Integer.parseInt(currentMonthNumber2) && year.equals(Year)) {
				while (!(month.equals(Month) && year.equals(Year))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[1]")).click();

					monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div"))
							.getText();

					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}

			} else {
				while (!(month.equals(Month) && year.equals(Year))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

					monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div"))
							.getText();

					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}

			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}
			QaBrowser.driver.findElement(By.xpath("(//i[@class='fa fa-calendar input-icon'])[2]")).click();
			Thread.sleep(2000);

			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div"))
					.getText();

			String month1 = monthYear1.split(" ")[0];
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				QaExtentReport.test.log(Status.FAIL,
						"<b><i>Invalid Return Modified date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
				throw new Exception("Invalid Return Modified date provided " + Day1 + "-" + Month1 + "-" + Year1);
			} else {
				while (!(month1.equals(Month1) && year1.equals(Year1))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

					monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div"))
							.getText();

					month1 = monthYear1.split(" ")[0];
					year1 = monthYear1.split(" ")[1];
				}

				List<WebElement> allDates1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

				for (WebElement ele1 : allDates1) {
					String dt1 = ele1.getText();

					if (dt1.equalsIgnoreCase(Day1)) {
						ele1.click();
						break;
					}
				}
			}
		}
	}

	public static void ResultPageForHotel(String Rooms, String ModifySearch, String ChangeTripLocation,
			String CityCodeM, String CityTitleM, String ChangeTripDate, String CheckInDateM, String CheckOutDateM,
			String ChangeRooms, String RoomsM, String AdultM, String ChildM, String ChildAgeM, String ChangeCurrency,
			String CurrencyM, String ChangeStarRating, String StarRatingM) throws Exception {
		Thread.sleep(20000);

//		String url = QaBrowser.driver.getCurrentUrl();
//		String[] uid = url.split("=");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);

		String DateSelection[] = CheckInDateM.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];

		String DateSelection1[] = CheckOutDateM.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		if (ModifySearch.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("DCModifySearchM");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modify Search</i></b>");

			if (ChangeTripLocation.equalsIgnoreCase("Yes")) {
				TestBase.listofautosuggestion4(By.xpath("//div[@id='ModifydivHTCity']/p"), CityCodeM, CityTitleM,
						By.xpath("//input[@id='txtHotelSearch']"));
				Thread.sleep(2000);
				QaBrowser.driver.findElement(By.xpath("//div[@id='ModifydivHTCity']/p[1]")).click();
				QaBrowser.driver.findElement(By.xpath("//div[@id='ModifydivHTCity']/p[1]")).click();
				QaExtentReport.test.log(Status.INFO,
						"<b><i>Modified City Name : </i></b>" + CityCodeM + "-" + CityTitleM);
				Thread.sleep(2000);
			}

			if (ChangeTripDate.equalsIgnoreCase("Yes")) {
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[1]")).click();
				Thread.sleep(2000);

				selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);
			}

			if (ChangeRooms.equalsIgnoreCase("Yes")) {
				int room = Integer.parseInt(RoomsM);
				String[] adultcount = AdultM.split(",");
				String[] childcount = ChildM.split(",");

				if (room > 5) {
					throw new BODCExceptionClass("Invalid Number of Rooms provided " + " : " + room);
				} else {
					WebElement roomelement = QaBrowser.driver.findElement(By.xpath("//select[@id='HtlRooms']"));
					Select selectroom = new Select(roomelement);
					selectroom.selectByValue(RoomsM);
					Thread.sleep(2000);

					for (int i = 1; i <= room; i++) {
						WebElement adultelement = QaBrowser.driver
								.findElement(By.xpath("//select[@id='htlsltadult" + i + "']"));
						Select selectadult = new Select(adultelement);
						selectadult.selectByValue(adultcount[i - 1]);
						Thread.sleep(2000);

						WebElement childelement = QaBrowser.driver
								.findElement(By.xpath("//select[@id='HtlChildSlt" + i + "']"));
						Select selectchild = new Select(childelement);
						selectchild.selectByValue(childcount[i - 1]);
						Thread.sleep(2000);
					}

					String[] ageofchild = ChildAgeM.split(",");
					for (String chd : childcount) {
						int chdcount = Integer.parseInt(chd);
						for (int i = 1; i <= chdcount; i++) {
							String ac = ageofchild[i - 1];
							int ac1 = Integer.parseInt(ac);

							if (ac1 > 17) {
								QaExtentReport.test.log(Status.FAIL,
										"<b><i>Invalid Child Age Selection</i></b>" + " : " + ac1);
								throw new BODCExceptionClass("Invalid Child Age Selection" + " : " + ac1);
							} else {
								WebElement childrenage = QaBrowser.driver
										.findElement(By.xpath("//select[@id='htl" + chdcount + "child" + i + "age']"));
								Select selectage = new Select(childrenage);
								selectage.selectByValue(ageofchild[i - 1]);
								Thread.sleep(2000);
							}
						}
					}
				}
			}

			if (ChangeCurrency.equalsIgnoreCase("Yes")) {
				QaRobot.selectValueFromDropdown("CurrencyMH", CurrencyM,
						"<b><i>Select Modified Currency for booking</i></b>");
				Thread.sleep(2000);
			}

			if (ChangeStarRating.equalsIgnoreCase("Yes")) {
				QaRobot.selectTextByLocator1("//select[@id='ddlstarRating']", StarRatingM,
						"<b><i>Select Star Rating for booking</i></b>");
				Thread.sleep(2000);
			}

			QaRobot.ClickOnElement("DCModifiedSearchM");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Modified Search</i></b>");
		}
		Thread.sleep(10000);

		QaRobot.ClickOnElement("SelectRoom");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on SelectRoom</i></b>");
		Thread.sleep(7000);

		if (Rooms.equalsIgnoreCase("1")) {
//			QaRobot.ClickOnElement("CancellationPolicy");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicy</i></b>");
//			Thread.sleep(3000);
//			QaExtentReport.extentScreenshot("CancellationPolicy");
//			QaRobot.ScreenshotMethod("CancellationPolicy", "<b><i>Screenshot for Cancellation Policy</i></b>");
//
//			String ParentWindow4 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles4 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow4 : handles4) {
//				if (!childWindow4.equals(ParentWindow4))
//					QaBrowser.driver.switchTo().window(childWindow4);
//			}
//
//			QaRobot.ClickOnElement("CPClose");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicyClose</i></b>");
//			Thread.sleep(2000);
//			QaBrowser.driver.switchTo().window(ParentWindow4);
//
//			QaRobot.ClickOnElement("FareBreakup");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
//			Thread.sleep(3000);
//			QaExtentReport.extentScreenshot("FareBreakup");
//			QaRobot.ScreenshotMethod("FareBreakup", "<b><i>Screenshot for Fare Breakup</i></b>");
//
//			String ParentWindow5 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles5 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow5 : handles5) {
//				if (!childWindow5.equals(ParentWindow5))
//					QaBrowser.driver.switchTo().window(childWindow5);
//			}
//
//			QaRobot.ClickOnElement("FareBreakupClose");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakupClose</i></b>");
//			Thread.sleep(2000);
//			QaBrowser.driver.switchTo().window(ParentWindow5);

			QaRobot.ClickOnElement("DCBook");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
			Thread.sleep(20000);
		} else {
//			QaRobot.ClickOnElement("DCCancellationPolicy1");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicy</i></b>");
//			Thread.sleep(3000);
//			QaExtentReport.extentScreenshot("CancellationPolicy");
//			QaRobot.ScreenshotMethod("CancellationPolicy","<b><i>Screenshot for Cancellation Policy</i></b>");
//			
//			String ParentWindow4 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles4 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow4 : handles4) 
//			{
//				if (!childWindow4.equals(ParentWindow4))
//					QaBrowser.driver.switchTo().window(childWindow4);
//			}
//			
//			QaRobot.ClickOnElement("DCCPClose1");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicyClose</i></b>");
//			Thread.sleep(2000);
//			QaBrowser.driver.switchTo().window(ParentWindow4);
//			
//			QaRobot.ClickOnElement("FareBreakup1");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
//			Thread.sleep(3000);
//			QaExtentReport.extentScreenshot("FareBreakup");
//			QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
//			
//			String ParentWindow5 = QaBrowser.driver.getWindowHandle();
//			Set<String> handles5 = QaBrowser.driver.getWindowHandles();
//			for (String childWindow5 : handles5) 
//			{
//				if (!childWindow5.equals(ParentWindow5))
//					QaBrowser.driver.switchTo().window(childWindow5);
//			}
//			
//			QaRobot.ClickOnElement("FareBreakupClose1");
//			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakupClose</i></b>");
//			Thread.sleep(2000);
//			QaBrowser.driver.switchTo().window(ParentWindow5);

			QaRobot.ClickOnElement("DCBook1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
			Thread.sleep(20000);
		}
		QaExtentReport.extentScreenshot("Result Page");
//		QaRobot.ClickOnElement("CFareBreakup");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
//		Thread.sleep(3000);
//		QaExtentReport.extentScreenshot("FareBreakup");
//		QaRobot.ScreenshotMethod("FareBreakup", "<b><i>Screenshot for Fare Breakup</i></b>");
//
//		String ParentWindow4 = QaBrowser.driver.getWindowHandle();
//		Set<String> handles4 = QaBrowser.driver.getWindowHandles();
//		for (String childWindow4 : handles4) {
//			if (!childWindow4.equals(ParentWindow4))
//				QaBrowser.driver.switchTo().window(childWindow4);
//		}
//
//		QaRobot.ClickOnElement("CFareBreakupClose");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Breakup Close</i></b>");
//		Thread.sleep(2000);
//		QaBrowser.driver.switchTo().window(ParentWindow4);
//
//		QaRobot.ClickOnElement("MoreDetails");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on More Details</i></b>");
//		Thread.sleep(3000);
//		QaExtentReport.extentScreenshot("MoreDetails");
//		QaRobot.ScreenshotMethod("MoreDetails", "<b><i>Screenshot for More Details</i></b>");
//
//		String ParentWindow5 = QaBrowser.driver.getWindowHandle();
//		Set<String> handles5 = QaBrowser.driver.getWindowHandles();
//		for (String childWindow5 : handles5) {
//			if (!childWindow5.equals(ParentWindow5))
//				QaBrowser.driver.switchTo().window(childWindow5);
//		}
//
//		QaRobot.ClickOnElement("MoreDetailsClose");
//		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on More Details Close</i></b>");
//		Thread.sleep(2000);
//		QaBrowser.driver.switchTo().window(ParentWindow5);
	}

	public static void selectDateInCalendarHotel(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws InterruptedException, ParseException {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);

		String currentMonthNumber = "00";
		if (Month.equalsIgnoreCase("Jan")) {
			currentMonthNumber = "01";
		} else if (Month.equalsIgnoreCase("Feb")) {
			currentMonthNumber = "02";
		} else if (Month.equalsIgnoreCase("Mar")) {
			currentMonthNumber = "03";
		} else if (Month.equalsIgnoreCase("Apr")) {
			currentMonthNumber = "04";
		} else if (Month.equalsIgnoreCase("May")) {
			currentMonthNumber = "05";
		} else if (Month.equalsIgnoreCase("Jun")) {
			currentMonthNumber = "06";
		} else if (Month.equalsIgnoreCase("Jul")) {
			currentMonthNumber = "07";
		} else if (Month.equalsIgnoreCase("Aug")) {
			currentMonthNumber = "08";
		} else if (Month.equalsIgnoreCase("Sep")) {
			currentMonthNumber = "09";
		} else if (Month.equalsIgnoreCase("Oct")) {
			currentMonthNumber = "10";
		} else if (Month.equalsIgnoreCase("Nov")) {
			currentMonthNumber = "11";
		} else if (Month.equalsIgnoreCase("Dec")) {
			currentMonthNumber = "12";
		}

		Date date2 = d.parse(Day + "-" + Integer.parseInt(currentMonthNumber) + "-" + Year);
		System.out.println(date2);

		String currentMonthNumber1 = "00";
		if (Month1.equalsIgnoreCase("Jan")) {
			currentMonthNumber1 = "01";
		} else if (Month1.equalsIgnoreCase("Feb")) {
			currentMonthNumber1 = "02";
		} else if (Month1.equalsIgnoreCase("Mar")) {
			currentMonthNumber1 = "03";
		} else if (Month1.equalsIgnoreCase("Apr")) {
			currentMonthNumber1 = "04";
		} else if (Month1.equalsIgnoreCase("May")) {
			currentMonthNumber1 = "05";
		} else if (Month1.equalsIgnoreCase("Jun")) {
			currentMonthNumber1 = "06";
		} else if (Month1.equalsIgnoreCase("Jul")) {
			currentMonthNumber1 = "07";
		} else if (Month1.equalsIgnoreCase("Aug")) {
			currentMonthNumber1 = "08";
		} else if (Month1.equalsIgnoreCase("Sep")) {
			currentMonthNumber1 = "09";
		} else if (Month1.equalsIgnoreCase("Oct")) {
			currentMonthNumber1 = "10";
		} else if (Month1.equalsIgnoreCase("Nov")) {
			currentMonthNumber1 = "11";
		} else if (Month1.equalsIgnoreCase("Dec")) {
			currentMonthNumber1 = "12";
		}

		Date date3 = d.parse(Day1 + "-" + Integer.parseInt(currentMonthNumber1) + "-" + Year1);
		System.out.println(date3);

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Check In Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO,
				"<b><i>Select Check Out Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		if (Integer.parseInt(Day) > 31) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new BODCExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day) > 28) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new BODCExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		}

		if (Integer.parseInt(Day1) > 31) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			throw new BODCExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		if (Month.equals("Feb") && Integer.parseInt(Day1) > 28) {
			System.out.println("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
			throw new BODCExceptionClass("Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		}

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

		String month = monthYear.split(" ")[0];

		String currentMonthNumber2 = "00";
		if (month.equalsIgnoreCase("Jan")) {
			currentMonthNumber2 = "01";
		} else if (month.equalsIgnoreCase("Feb")) {
			currentMonthNumber2 = "02";
		} else if (month.equalsIgnoreCase("Mar")) {
			currentMonthNumber2 = "03";
		} else if (month.equalsIgnoreCase("Apr")) {
			currentMonthNumber2 = "04";
		} else if (month.equalsIgnoreCase("May")) {
			currentMonthNumber2 = "05";
		} else if (month.equalsIgnoreCase("Jun")) {
			currentMonthNumber2 = "06";
		} else if (month.equalsIgnoreCase("Jul")) {
			currentMonthNumber2 = "07";
		} else if (month.equalsIgnoreCase("Aug")) {
			currentMonthNumber2 = "08";
		} else if (month.equalsIgnoreCase("Sep")) {
			currentMonthNumber2 = "09";
		} else if (month.equalsIgnoreCase("Oct")) {
			currentMonthNumber2 = "10";
		} else if (month.equalsIgnoreCase("Nov")) {
			currentMonthNumber2 = "11";
		} else if (month.equalsIgnoreCase("Dec")) {
			currentMonthNumber2 = "12";
		}
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new BODCExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			if (Integer.parseInt(currentMonthNumber) < Integer.parseInt(currentMonthNumber2) && year.equals(Year)) {
				while (!(month.equals(Month) && year.equals(Year))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[1]")).click();

					monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div"))
							.getText();

					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			} else {
				while (!(month.equals(Month) && year.equals(Year))) {
					QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

					monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div"))
							.getText();

					month = monthYear.split(" ")[0];
					year = monthYear.split(" ")[1];
				}
			}

			List<WebElement> allDates = QaBrowser.driver
					.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

			for (WebElement ele : allDates) {
				String dt = ele.getText();

				if (dt.equalsIgnoreCase(Day)) {
					ele.click();
					break;
				}
			}

			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[2]")).click();
			Thread.sleep(2000);

			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div"))
					.getText();

			String month1 = monthYear1.split(" ")[0];

			String currentMonthNumber3 = "00";
			if (month1.equalsIgnoreCase("Jan")) {
				currentMonthNumber3 = "01";
			} else if (month1.equalsIgnoreCase("Feb")) {
				currentMonthNumber3 = "02";
			} else if (month1.equalsIgnoreCase("Mar")) {
				currentMonthNumber3 = "03";
			} else if (month1.equalsIgnoreCase("Apr")) {
				currentMonthNumber3 = "04";
			} else if (month1.equalsIgnoreCase("May")) {
				currentMonthNumber3 = "05";
			} else if (month1.equalsIgnoreCase("Jun")) {
				currentMonthNumber3 = "06";
			} else if (month1.equalsIgnoreCase("Jul")) {
				currentMonthNumber3 = "07";
			} else if (month1.equalsIgnoreCase("Aug")) {
				currentMonthNumber3 = "08";
			} else if (month1.equalsIgnoreCase("Sep")) {
				currentMonthNumber3 = "09";
			} else if (month1.equalsIgnoreCase("Oct")) {
				currentMonthNumber3 = "10";
			} else if (month1.equalsIgnoreCase("Nov")) {
				currentMonthNumber3 = "11";
			} else if (month1.equalsIgnoreCase("Dec")) {
				currentMonthNumber3 = "12";
			}
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				QaExtentReport.test.log(Status.FAIL,
						"<b><i>Invalid Check out date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
				throw new BODCExceptionClass("Invalid Check out date provided " + Day1 + "-" + Month1 + "-" + Year1);
			} else {
				if (Integer.parseInt(currentMonthNumber) < Integer.parseInt(currentMonthNumber3) && year.equals(Year)) {
					while (!(month1.equals(Month1) && year1.equals(Year1))) {
						QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[1]")).click();

						monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div"))
								.getText();

						month1 = monthYear1.split(" ")[0];
						year1 = monthYear1.split(" ")[1];
					}
				} else {
					while (!(month1.equals(Month1) && year1.equals(Year1))) {
						QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

						monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div"))
								.getText();

						month1 = monthYear1.split(" ")[0];
						year1 = monthYear1.split(" ")[1];
					}
				}

				List<WebElement> allDates1 = QaBrowser.driver
						.findElements(By.xpath("/html/body/div[3]/div/div[2]/div[1]/table/tbody/tr/td"));

				for (WebElement ele1 : allDates1) {
					String dt1 = ele1.getText();

					if (dt1.equalsIgnoreCase(Day1)) {
						ele1.click();
						break;
					}
				}
			}
		}
	}
}