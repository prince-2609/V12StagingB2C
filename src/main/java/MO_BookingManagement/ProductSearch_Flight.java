package MO_BookingManagement;

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
import v12Staging_B2C.B2cConfirmPage;
import v12Staging_B2C.B2cPaymentPage;

@Listeners(listenerClass.Listener.class)
public class ProductSearch_Flight {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("v12StagingBODC_Flight", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void BODCFlightSearch(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String ChooseSalesChannel,
			String TripType, String OriginCityCode, String OriginLocation, String DestinationCityCode,
			String DestinationLocation, String DepartureDate, String ReturnDate, String SelectTraveller, String Adult,
			String Youth, String Child, String Infant, String Class, String PreAirline, String PANumber,
			String PreferredAirlineSelect, String ShowDirectFlight, String MyDatesAreFlexible, String ChooseSupplier,
			String SupNumber, String SelectSupplier, String ModifySearch, String ChangeTrip, String TripTypeM,
			String OriginCityCodeM, String OriginLocationM, String DestinationCityCodeM, String DestinationLocationM,
			String ChangeTripDate, String DepartureDateM, String ReturnDateM, String ChangeTravellers, String AdultM,
			String YouthM, String ChildM, String InfantM, String ChangeClass, String ClassM, String ShowDirectFlightM,
			String MyDatesAreFlexibleM, String AdvanceSearch, String SelectCurrency, String SelectNationality,
			String CountryOfResidence, String ChangeAirline, String PANumberM, String PreferredAirlineSelectM,
			String SupplierChange, String SupNumberM, String SelectSupplierM, String Applyfilter, String FareType,
			String AirLine, String Resultpagestep, String QuoteTitle, String QuoteRemark, String AdultTitle,
			String AdultName, String AdultDate, String AdultEmailAddress, String PhoneNumber,
			String AdultPassportNumber, String AdultPassportcountry, String AdultExpiryDate, String AdultNationality,
			String YouthTitle, String YouthName, String YouthtDate, String YouthEmailAddress, String YouthPhoneNumber,
			String YouthPassportNumber, String YouthPassportcountry, String YouthtExpiryDate, String YouthNationality,
			String ChildTitle, String ChildName, String ChildPassportNumber, String ChildPassportcountry,
			String ChildPassportDate, String ChildNationality, String ChildDOBdate, String InfantTitle,
			String InfantName, String InfantDOBdate, String InfantTravellingwith, String InfantPassportNumber,
			String InfantPassportcountry, String InfantPassportDate, String InfantNationality, String CardType,
			String CreditCardNumber, String CardHolderName, String CardExpiryDate, String CVV, String BillingAddress,
			String BillingState, String CardCity) throws Exception {
		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("BookingManagement");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("ProductSearch");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		if (ChooseSalesChannel.equalsIgnoreCase("DirectCustomer")) {
			QaRobot.ClickOnElement("DirectCustomer");
			Thread.sleep(5000);
			QaRobot.ClickOnElement("DCFlight");
			BODCTripType.flightTriptype(TripType, OriginCityCode, OriginLocation, DestinationCityCode,
					DestinationLocation, DepartureDate, ReturnDate, SelectTraveller, Adult, Youth, Child, Infant, Class,
					PreAirline, PANumber, PreferredAirlineSelect, ShowDirectFlight, MyDatesAreFlexible, ChooseSupplier,
					SupNumber, SelectSupplier);
			BODCResultPage.ResultPageForFlight(TripType, ModifySearch, ChangeTrip, TripTypeM, OriginCityCodeM,
					OriginLocationM, DestinationCityCodeM, DestinationLocationM, ChangeTripDate, DepartureDateM,
					ReturnDateM, ChangeTravellers, AdultM, YouthM, ChildM, InfantM, ChangeClass, ClassM,
					ShowDirectFlightM, MyDatesAreFlexibleM, AdvanceSearch, SelectCurrency, SelectNationality,
					CountryOfResidence, ChangeAirline, PANumberM, PreferredAirlineSelectM, SupplierChange, SupNumberM,
					SelectSupplierM, Applyfilter, FareType, AirLine, Resultpagestep, QuoteTitle, QuoteRemark);
			BODCCheckoutPage.GuestAdultCheckoutForFlight(Adult, AdultTitle, AdultName, AdultDate, AdultEmailAddress,
					PhoneNumber, AdultPassportNumber, AdultPassportcountry, AdultExpiryDate, AdultNationality);

			BODCCheckoutPage.GuestYouthCheckoutForFlight(Youth, YouthTitle, YouthName, YouthtDate, YouthEmailAddress,
					YouthPhoneNumber, YouthPassportNumber, YouthPassportcountry, YouthtExpiryDate, YouthNationality);

			BODCCheckoutPage.GuestChildCheckoutForFlight(Child, ChildTitle, ChildName, ChildPassportNumber,
					ChildPassportcountry, ChildPassportDate, ChildNationality, ChildDOBdate);

			BODCCheckoutPage.GuestInfantCheckoutForFlight(Infant, InfantTitle, InfantName, InfantDOBdate,
					InfantTravellingwith, InfantPassportNumber, InfantPassportcountry, InfantPassportDate,
					InfantNationality);

			QaRobot.ClickOnElement("confirmButton");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on confirm Button</i></b>");
			Thread.sleep(20000);

			B2cPaymentPage.cardPayment(CardType, CreditCardNumber, CardHolderName, CardExpiryDate, CVV, BillingAddress,
					BillingState, CardCity);
			Thread.sleep(35000);

			B2cConfirmPage.confirmpageFlight();

		} else if (ChooseSalesChannel.equalsIgnoreCase("Reseller")) {
 
		} else if (ChooseSalesChannel.equalsIgnoreCase("Corporate")) {

		}
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
