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
public class ApprovalWorkflow {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("ApprovalWorkflow", "ApprovalWorkflow");
	}

	@Test(dataProvider = "getexceldata")
	public static void travellerProfiling(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String CorporateName,
			String TCategoryName, String TCategoryCode, String TCategoryType, String PolicyTitle,
			String SelectTravelPurpose, String SelectTravelCategory, String SelectProduct, String RuleAppliedOn,
			String SelectQty, String SelectFromList, String CriteriaQty, String CriteriaName, String AirlineCriteria,
			String StarCriteria, String OriginFor, String OZqty, String OZone, String ORqty, String ORegion,
			String OCqty, String OCountry, String OCiQty, String OCity, String DestinationFor, String DZqty,
			String DZone, String DRqty, String DRegion, String DCqty, String DCountry, String DCiQty, String DCity,
			String CostFrom, String CostTo, String BookDateFrom, String BookDateTo, String TripDateFrom,
			String TripDateTo, String MarketType, String SelectMarketType, String CAWProduct, String CAWTravelCategory,
			String WorkflowAppliedOn, String TotalApprover, String CAWSelectQty, String CAWSelectFromList,
			String SelectApprovalFlow, String IPALevel1, String IPALevel2, String OPALevel1, String OPALevel2,
			String MPReasonFor, String MPRLanguage, String MPRCode, String MPRName, String MPRType, String MPRSelectQty,
			String MPRProducts) throws Exception {
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
//		QaRobot.ClickOnElement("ManageTravelCategory");
//		QaRobot.ClickOnElement("AddTravelCategory");
//		QaRobot.PassValue("TravelCategory", TCategoryName);
//		QaRobot.PassValue("TravelCategoryCode", TCategoryCode);
//		if (TCategoryType.equalsIgnoreCase("Business Trip")) {
//			QaRobot.ClickOnElement("CTBusinessTrip");
//		} else if (TCategoryType.equalsIgnoreCase("Family Trip")) {
//			QaRobot.ClickOnElement("CTFamilyTrip");
//		} else if (TCategoryType.equalsIgnoreCase("Expense")) {
//			QaRobot.ClickOnElement("CTExpence");
//		} else if (TCategoryType.equalsIgnoreCase("Guest User")) {
//			QaRobot.ClickOnElement("CTGuestUser");
//		}
//		QaRobot.ClickOnElement("ApplyTravelPolicy");
//		QaRobot.ClickOnElement("MarkActive");
//		QaRobot.ClickOnElement("AddTravelCategory");
//		QaRobot.acceptAlert("TravelCategoryStatus");
//		QaRobot.ClickOnElement("TravelCategoryClose");
//		QaRobot.ClickOnElement("ManageTravelPolicy");
//		QaRobot.ClickOnElement("AddManageTravelPolicy");
//		QaRobot.PassValue("PolicyTitle", PolicyTitle);
//		if (SelectTravelPurpose.equalsIgnoreCase("Business Trip")) {
//			QaRobot.ClickOnElement("PTBusinessTrip");
//		} else if (SelectTravelPurpose.equalsIgnoreCase("Family Trip")) {
//			QaRobot.ClickOnElement("PTFamilyTrip");
//		} else if (SelectTravelPurpose.equalsIgnoreCase("Guest User")) {
//			QaRobot.ClickOnElement("PTGuestUser");
//		}
//		QaRobot.selectTextByLocator("//select[@id='ddlTravelCategory']", SelectTravelCategory);
//		QaRobot.selectTextByLocator("//select[@id='ddlCategory']", SelectProduct);
//		QaRobot.selectTextByLocator("//select[@id='ddlAppliedOn']", RuleAppliedOn);
//		Thread.sleep(5000);
//		int pAS = Integer.parseInt(SelectQty);
//		for (int i = 1; i <= pAS; i++) {
//			String[] tN = SelectFromList.split(",");
//			String b = tN[i - 1];
//			List<WebElement> listOfRights = QaBrowser.driver.findElements(By.xpath(
//					"/html/body/div/form/div[5]/div/div/div[2]/div[3]/div[2]/div/div/div/div[4]/div[3]/div/div/div[1]/div/div/select/option"));
//			for (WebElement autoRights : listOfRights) {
//				if (autoRights.getText().equalsIgnoreCase(b)) {
//					autoRights.click();
//					QaRobot.ClickOnElement("AddList");
//				}
//			}
//		}
//		if (SelectProduct.equalsIgnoreCase("Flight")) {
//			int pAS3 = Integer.parseInt(CriteriaQty);
//			if (CriteriaQty.equalsIgnoreCase("1")) {
//				for (int i = 1; i <= pAS3; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					QaRobot.selectTextByLocator("//select[@id='grdFlight_ctl02_ddlFlightKey']", b);
//					if (b.equalsIgnoreCase("Origin")) {
//						QaRobot.switchToWindow();
//						if (OriginFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("SORegion");
//							QaRobot.transferData(ORqty, ORegion, "//select[@id='ListBoxOriginRegion']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOCountry");
//							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOCountry");
//							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
//							QaRobot.ClickOnElement("SOCity");
//							QaRobot.transferData(OCiQty, OCity, "//select[@id='ListBoxOriginCity']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						}
//						QaRobot.ClickOnElement("OriginSaveClose");
//					} else if (b.equalsIgnoreCase("Destination")) {
//						QaRobot.switchToWindow();
//						if (DestinationFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("SDRegion");
//							QaRobot.transferData(DRqty, DRegion, "//select[@id='ListBoxDestinationRegion']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDCity");
//							QaRobot.transferData(DCiQty, DCity, "//select[@id='ListBoxDestinationCity']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						}
//						QaRobot.ClickOnElement("DestinationSaveClose");
//					} else if (b.equalsIgnoreCase("Cost Range")) {
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("CostFrom", CostFrom);
//						QaRobot.PassValue("CostTo", CostTo);
//						QaRobot.ClickOnElement("CostRangeSelectClose");
//					} else if (b.equalsIgnoreCase("Booking Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("BookDateFrom");
////						String DateSelection[] = BookDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("BookDateTo");
////						String DateSelection1[] = BookDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddBookDate");
////						QaRobot.ClickOnElement("IMBookDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Trip Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("TripDateFrom");
////						String DateSelection[] = TripDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("TripDateTo");
////						String DateSelection1[] = TripDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddTripDate");
////						QaRobot.ClickOnElement("IMTripDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Market Type")) {
//						QaRobot.switchToWindow();
//						if (MarketType.equalsIgnoreCase("Domestic")) {
//							QaRobot.ClickOnElement("MARDomestic");
//						} else if (MarketType.equalsIgnoreCase("International")) {
//							QaRobot.ClickOnElement("MARInternational");
//						}
//						QaRobot.ClickOnElement("MARSaveClose");
//					}
//				}
//			} else {
//				for (int i = 1; i <= pAS3; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					String s = Integer.toString(i);
//					if (s.equalsIgnoreCase("1")) {
//						QaRobot.selectTextByLocator("//select[@id='grdFlight_ctl02_ddlFlightKey']", b);
//					} else {
//						Thread.sleep(3000);
//						QaRobot.ClickOnElement("SAddNewCriteriaFlight");
//						QaRobot.selectTextByLocator("//select[@id='grdFlight_ctl0" + (i + 1) + "_ddlFlightKey']", b);
//					}
//					if (b.equalsIgnoreCase("Origin")) {
//						QaRobot.switchToWindow();
//						if (OriginFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("SORegion");
//							QaRobot.transferData(ORqty, ORegion, "//select[@id='ListBoxOriginRegion']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOCountry");
//							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOCountry");
//							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
//							QaRobot.ClickOnElement("SOCity");
//							QaRobot.transferData(OCiQty, OCity, "//select[@id='ListBoxOriginCity']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						}
//						QaRobot.ClickOnElement("OriginSaveClose");
//					} else if (b.equalsIgnoreCase("Destination")) {
//						QaRobot.switchToWindow();
//						if (DestinationFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("SDRegion");
//							QaRobot.transferData(DRqty, DRegion, "//select[@id='ListBoxDestinationRegion']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDCity");
//							QaRobot.transferData(DCiQty, DCity, "//select[@id='ListBoxDestinationCity']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						}
//						QaRobot.ClickOnElement("DestinationSaveClosePolicy");
//					} else if (b.equalsIgnoreCase("Cost Range")) {
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("CostFrom", CostFrom);
//						QaRobot.PassValue("CostTo", CostTo);
//						QaRobot.ClickOnElement("CostRangeSelectClose");
//					} else if (b.equalsIgnoreCase("Booking Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("BookDateFrom");
////						String DateSelection[] = BookDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("BookDateTo");
////						String DateSelection1[] = BookDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddBookDate");
////						QaRobot.ClickOnElement("IMBookDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Trip Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("TripDateFrom");
////						String DateSelection[] = TripDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("TripDateTo");
////						String DateSelection1[] = TripDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddTripDate");
////						QaRobot.ClickOnElement("IMTripDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Market Type")) {
//						QaRobot.switchToWindow();
//						if (MarketType.equalsIgnoreCase("Domestic")) {
//							QaRobot.ClickOnElement("MARDomestic");
//						} else if (MarketType.equalsIgnoreCase("International")) {
//							QaRobot.ClickOnElement("MARInternational");
//						}
//						QaRobot.ClickOnElement("MARSaveClose");
//					}
//				}
//			}
//			Thread.sleep(3000);
//			QaRobot.scrollPage("1000");
//			QaRobot.ClickOnElement("SaveFlightPolicy");
//		} else if (SelectProduct.equalsIgnoreCase("Hotel")) {
//			int pAS3 = Integer.parseInt(CriteriaQty);
//			if (CriteriaQty.equalsIgnoreCase("1")) {
//				for (int i = 1; i <= pAS3; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					QaRobot.selectTextByLocator("//select[@id='grdHotel_ctl02_ddlHotelKey']", b);
//					if (b.equalsIgnoreCase("Destination")) {
//						QaRobot.switchToWindow();
//						if (DestinationFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("SDRegion");
//							QaRobot.transferData(DRqty, DRegion, "//select[@id='ListBoxDestinationRegion']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDCity");
//							QaRobot.transferData(DCiQty, DCity, "//select[@id='ListBoxDestinationCity']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						}
//						QaRobot.ClickOnElement("DestinationSaveClose");
//					} else if (b.equalsIgnoreCase("Cost Range")) {
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("CostFrom", CostFrom);
//						QaRobot.PassValue("CostTo", CostTo);
//						QaRobot.ClickOnElement("CostRangeSelectClose");
//					} else if (b.equalsIgnoreCase("Booking Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("BookDateFrom");
////						String DateSelection[] = BookDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("BookDateTo");
////						String DateSelection1[] = BookDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddBookDate");
////						QaRobot.ClickOnElement("IMBookDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Trip Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("TripDateFrom");
////						String DateSelection[] = TripDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("TripDateTo");
////						String DateSelection1[] = TripDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddTripDate");
////						QaRobot.ClickOnElement("IMTripDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Market Type")) {
//						QaRobot.switchToWindow();
//						if (MarketType.equalsIgnoreCase("Domestic")) {
//							QaRobot.ClickOnElement("MARDomestic");
//						} else if (MarketType.equalsIgnoreCase("International")) {
//							QaRobot.ClickOnElement("MARInternational");
//						}
//						QaRobot.ClickOnElement("MARSaveClose");
//					}
//				}
//			} else {
//				for (int i = 1; i <= pAS3; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					String s = Integer.toString(i);
//					if (s.equalsIgnoreCase("1")) {
//						QaRobot.selectTextByLocator("//select[@id='grdHotel_ctl02_ddlHotelKey']", b);
//					} else {
//						Thread.sleep(3000);
//						QaRobot.ClickOnElement("SAddNewCriteriaHotel");
//						QaRobot.selectTextByLocator("//select[@id='grdHotel_ctl0" + (i + 1) + "_ddlHotelKey']", b);
//					}
//					if (b.equalsIgnoreCase("Destination")) {
//						QaRobot.switchToWindow();
//						if (DestinationFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("SDRegion");
//							QaRobot.transferData(DRqty, DRegion, "//select[@id='ListBoxDestinationRegion']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDCity");
//							QaRobot.transferData(DCiQty, DCity, "//select[@id='ListBoxDestinationCity']/option");
//							QaRobot.ClickOnElement("SDAdd");
//							QaRobot.acceptAlert("DestinationStatus");
//						}
//						QaRobot.ClickOnElement("DestinationSaveClosePolicy");
//					} else if (b.equalsIgnoreCase("Cost Range")) {
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("CostFrom", CostFrom);
//						QaRobot.PassValue("CostTo", CostTo);
//						QaRobot.ClickOnElement("CostRangeSelectClose");
//					} else if (b.equalsIgnoreCase("Booking Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("BookDateFrom");
////						String DateSelection[] = BookDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("BookDateTo");
////						String DateSelection1[] = BookDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddBookDate");
////						QaRobot.ClickOnElement("IMBookDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Trip Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("TripDateFrom");
////						String DateSelection[] = TripDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("TripDateTo");
////						String DateSelection1[] = TripDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddTripDate");
////						QaRobot.ClickOnElement("IMTripDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Market Type")) {
//						QaRobot.switchToWindow();
//						if (MarketType.equalsIgnoreCase("Domestic")) {
//							QaRobot.ClickOnElement("MARDomestic");
//						} else if (MarketType.equalsIgnoreCase("International")) {
//							QaRobot.ClickOnElement("MARInternational");
//						}
//						QaRobot.ClickOnElement("MARSaveClose");
//					}
//				}
//			}
//			QaRobot.scrollPage("500");
//			QaRobot.ClickOnElement("SaveHotelPolicy");
//
//		} else if (SelectProduct.equalsIgnoreCase("Car")) {
//			int pAS3 = Integer.parseInt(CriteriaQty);
//			if (CriteriaQty.equalsIgnoreCase("1")) {
//				for (int i = 1; i <= pAS3; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					QaRobot.selectTextByLocator("//select[@id='grdCar_ctl02_ddlCarKey']", b);
//					if (b.equalsIgnoreCase("Origin")) {
//						QaRobot.switchToWindow();
//						if (OriginFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("SORegion");
//							QaRobot.transferData(ORqty, ORegion, "//select[@id='ListBoxOriginRegion']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOCountry");
//							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOCountry");
//							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
//							QaRobot.ClickOnElement("SOCity");
//							QaRobot.transferData(OCiQty, OCity, "//select[@id='ListBoxOriginCity']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						}
//						QaRobot.ClickOnElement("OriginSaveClose");
//					} else if (b.equalsIgnoreCase("Destination")) {
//						QaRobot.switchToWindow();
//						if (DestinationFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("SDRegion");
//							QaRobot.transferData(DRqty, DRegion, "//select[@id='ListBoxDestinationRegion']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDCity");
//							QaRobot.transferData(DCiQty, DCity, "//select[@id='ListBoxDestinationCity']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						}
//						QaRobot.ClickOnElement("DestinationSaveClose");
//					} else if (b.equalsIgnoreCase("Cost Range")) {
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("CostFrom", CostFrom);
//						QaRobot.PassValue("CostTo", CostTo);
//						QaRobot.ClickOnElement("CostRangeSelectClose");
//					} else if (b.equalsIgnoreCase("Booking Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("BookDateFrom");
////						String DateSelection[] = BookDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("BookDateTo");
////						String DateSelection1[] = BookDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddBookDate");
////						QaRobot.ClickOnElement("IMBookDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Trip Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("TripDateFrom");
////						String DateSelection[] = TripDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("TripDateTo");
////						String DateSelection1[] = TripDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddTripDate");
////						QaRobot.ClickOnElement("IMTripDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Market Type")) {
//						QaRobot.switchToWindow();
//						if (MarketType.equalsIgnoreCase("Domestic")) {
//							QaRobot.ClickOnElement("MARDomestic");
//						} else if (MarketType.equalsIgnoreCase("International")) {
//							QaRobot.ClickOnElement("MARInternational");
//						}
//						QaRobot.ClickOnElement("MARSaveClose");
//					}
//				}
//			} else {
//				for (int i = 1; i <= pAS3; i++) {
//					String[] tN = CriteriaName.split(",");
//					String b = tN[i - 1];
//					String s = Integer.toString(i);
//					if (s.equalsIgnoreCase("1")) {
//						QaRobot.selectTextByLocator("//select[@id='grdCar_ctl02_ddlCarKey']", b);
//					} else {
//						Thread.sleep(3000);
//						QaRobot.ClickOnElement("SAddNewCriteriaCar");
//						QaRobot.selectTextByLocator("//select[@id='grdCar_ctl0" + (i + 1) + "_ddlCarKey']", b);
//					}
//					if (b.equalsIgnoreCase("Origin")) {
//						QaRobot.switchToWindow();
//						if (OriginFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("SORegion");
//							QaRobot.transferData(ORqty, ORegion, "//select[@id='ListBoxOriginRegion']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOCountry");
//							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						} else if (OriginFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("SOZone");
//							QaRobot.transferData(OZqty, OZone, "//select[@id='ListBoxOriginZone']/option");
//							QaRobot.ClickOnElement("SOCountry");
//							QaRobot.transferData(OCqty, OCountry, "//select[@id='ListBoxOriginCountry']/option");
//							QaRobot.ClickOnElement("SOCity");
//							QaRobot.transferData(OCiQty, OCity, "//select[@id='ListBoxOriginCity']/option");
//							QaRobot.ClickOnElement("SOAdd");
//						}
//						QaRobot.ClickOnElement("OriginSaveClose");
//					} else if (b.equalsIgnoreCase("Destination")) {
//						QaRobot.switchToWindow();
//						if (DestinationFor.equalsIgnoreCase("Zone")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Region")) {
//							QaRobot.ClickOnElement("SDRegion");
//							QaRobot.transferData(DRqty, DRegion, "//select[@id='ListBoxDestinationRegion']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("Country")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						} else if (DestinationFor.equalsIgnoreCase("City")) {
//							QaRobot.ClickOnElement("SDZone");
//							QaRobot.transferData(DZqty, DZone, "//select[@id='ListBoxDestinationZone']/option");
//							QaRobot.ClickOnElement("SDCountry");
//							QaRobot.transferData(DCqty, DCountry, "//select[@id='ListBoxDestinationCountry']/option");
//							QaRobot.ClickOnElement("SDCity");
//							QaRobot.transferData(DCiQty, DCity, "//select[@id='ListBoxDestinationCity']/option");
//							QaRobot.ClickOnElement("SDAdd");
//						}
//						QaRobot.ClickOnElement("DestinationSaveClosePolicy");
//					} else if (b.equalsIgnoreCase("Cost Range")) {
//						QaRobot.switchToWindow();
//						QaRobot.PassValue("CostFrom", CostFrom);
//						QaRobot.PassValue("CostTo", CostTo);
//						QaRobot.ClickOnElement("CostRangeSelectClose");
//					} else if (b.equalsIgnoreCase("Booking Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("BookDateFrom");
////						String DateSelection[] = BookDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("BookDateTo");
////						String DateSelection1[] = BookDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddBookDate");
////						QaRobot.ClickOnElement("IMBookDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Trip Date")) {
////						QaRobot.switchToWindow();
////						QaRobot.ClickOnElement("TripDateFrom");
////						String DateSelection[] = TripDateFrom.split("-");
////						String year = DateSelection[2];
////						String month = DateSelection[1];
////						String expDate = DateSelection[0];
////						QaRobot.selectDateInCalendarIM(expDate, month, year);
////						QaRobot.ClickOnElement("TripDateTo");
////						String DateSelection1[] = TripDateTo.split("-");
////						String year1 = DateSelection1[2];
////						String month1 = DateSelection1[1];
////						String expDate1 = DateSelection1[0];
////						QaRobot.selectDateInCalendarIM(expDate1, month1, year1);
////						QaRobot.ClickOnElement("AddTripDate");
////						QaRobot.ClickOnElement("IMTripDateSelectClose");
//
//					} else if (b.equalsIgnoreCase("Market Type")) {
//						QaRobot.switchToWindow();
//						if (MarketType.equalsIgnoreCase("Domestic")) {
//							QaRobot.ClickOnElement("MARDomestic");
//						} else if (MarketType.equalsIgnoreCase("International")) {
//							QaRobot.ClickOnElement("MARInternational");
//						}
//						QaRobot.ClickOnElement("MARSaveClose");
//					}
//				}
//			}
//			QaRobot.scrollPage("500");
//			QaRobot.ClickOnElement("SaveCarPolicy");
//		}
//		QaRobot.ClickOnElement("TravelPolicyClose");
//		QaBrowser.driver.switchTo().parentFrame();
//		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("ManageCorporateApprovalWorkflow");
		QaRobot.ClickOnElement("AddManageCorporateApprovalWorkflow");
		QaRobot.selectTextByLocator("//select[@id='ddlProduct']", CAWProduct);
		Thread.sleep(3000);
		QaRobot.selectTextByLocator("//select[@id='ddltravelcategory']", CAWTravelCategory);
		QaRobot.selectTextByLocator("//select[@id='ddlAppliedOn']", WorkflowAppliedOn);
		QaRobot.selectTextByLocator("//select[@id='ddlApproverLevel']", TotalApprover);
		int pAS1 = Integer.parseInt(CAWSelectQty);
		for (int i = 1; i <= pAS1; i++) {
			String[] tN1 = CAWSelectFromList.split(",");
			String b1 = tN1[i - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
					"/html/body/div/form/div[4]/div/div/div/div[2]/div[1]/div[2]/ul/li[2]/div/div/div[1]/div/div/select/option"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					QaRobot.ClickOnElement("AddList");
				}
			}
		}
		if (SelectApprovalFlow.equalsIgnoreCase("Parallel")) {
			QaRobot.ClickOnElement("AFParallel");
		} else if (SelectApprovalFlow.equalsIgnoreCase("Sequential")) {
			QaRobot.ClickOnElement("AFSequential");
		}
		Thread.sleep(3000);
		if (TotalApprover.equalsIgnoreCase("1")) {
			String Name[] = IPALevel1.split(",");
			String N1 = Name[0];
			String N2 = Name[1];
			TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover1']/p"), N1, N2,
					By.xpath("//input[@id='txtInPolicyApprover1']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover1']/p[2]")).click();
			Thread.sleep(2000);
			String Name1[] = OPALevel1.split(",");
			String N3 = Name1[0];
			String N4 = Name1[1];
			TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover1']/p"), N3, N4,
					By.xpath("//input[@id='txtOutPolicyApprover1']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover1']/p[2]")).click();
			Thread.sleep(2000);
		} else if (TotalApprover.equalsIgnoreCase("2")) {
			String Name[] = IPALevel1.split(",");
			String N1 = Name[0];
			String N2 = Name[1];
			TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover1']/p"), N1, N2,
					By.xpath("//input[@id='txtInPolicyApprover1']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover1']/p[2]")).click();
			Thread.sleep(2000);
			String Name1[] = OPALevel1.split(",");
			String N3 = Name1[0];
			String N4 = Name1[1];
			TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover1']/p"), N3, N4,
					By.xpath("//input[@id='txtOutPolicyApprover1']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover1']/p[2]")).click();
			Thread.sleep(2000);
			String Name2[] = IPALevel2.split(",");
			String N5 = Name2[0];
			String N6 = Name2[1];
			TestBase.listofautosuggestion(By.xpath("//div[@id='divInPolicyApprover2']/p"), N5, N6,
					By.xpath("//input[@id='txtInPolicyApprover2']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divInPolicyApprover2']/p[2]")).click();
			Thread.sleep(2000);
			String Name3[] = OPALevel2.split(",");
			String N7 = Name3[0];
			String N8 = Name3[1];
			TestBase.listofautosuggestion(By.xpath("//div[@id='divOutPolicyApprover2']/p"), N7, N8,
					By.xpath("//input[@id='txtOutPolicyApprover2']"));
			QaBrowser.driver.findElement(By.xpath("//div[@id='divOutPolicyApprover2']/p[2]")).click();
			Thread.sleep(2000);
		}
		QaRobot.ClickOnElement("SaveManageCorporateApprovalWorkflow");
		QaRobot.ClickOnElement("CloseManageCorporateApprovalWorkflow");
		QaRobot.ClickOnElement("ManagePredefiendReasons");
		QaRobot.ClickOnElement("AddManagePredefiendReasons");
		if (MPReasonFor.equalsIgnoreCase("InPolicy")) {
			QaRobot.ClickOnElement("MPRInPolicy");
		} else if (MPReasonFor.equalsIgnoreCase("OutPolicy")) {
			QaRobot.ClickOnElement("MPROutPolicy");
		}
		QaRobot.selectTextByLocator("//select[@id='ddlLanguage_Code']", MPRLanguage);
		QaRobot.PassValue("MPRCode", MPRCode);
		QaRobot.PassValue("MPRName", MPRName);
		if (MPRType.equalsIgnoreCase("Acceptance")) {
			QaRobot.ClickOnElement("MPRTypeAcceptance");
		} else if (MPRType.equalsIgnoreCase("Denied")) {
			QaRobot.ClickOnElement("MPRTypeDenied");
		}
		int pAS2 = Integer.parseInt(MPRSelectQty);
		for (int i = 1; i <= pAS2; i++) {
			String[] tN2 = MPRProducts.split(",");
			String b2 = tN2[i - 1];
			List<WebElement> listOfRights2 = QaBrowser.driver.findElements(By.xpath(
					"/html/body/div/form/div[4]/div/div/div/div[1]/div[2]/div/div/div/div[7]/div/div/ul/li/label"));
			for (WebElement autoRights2 : listOfRights2) {
				if (autoRights2.getText().equalsIgnoreCase(b2)) {
					autoRights2.click();
				}
			}
		}
		QaRobot.ClickOnElement("MPRActive");
		QaRobot.ClickOnElement("AddManagePredefiendReasons");
		QaRobot.acceptAlert("ManagePredefiendReasonsStatus");
		QaRobot.ClickOnElement("CloseManagePredefiendReasons");
	}

	@AfterMethod
	public static void afterMethod() {
//		QaExtentReport.test.getExtent().flush();
	}
}
