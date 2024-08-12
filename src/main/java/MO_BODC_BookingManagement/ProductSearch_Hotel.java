package MO_BODC_BookingManagement;

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
import v12Staging_B2C.B2cCheckoutPage;
import v12Staging_B2C.B2cConfirmPage;
import v12Staging_B2C.B2cPaymentPage;
import v12Staging_B2C.B2cResultPage;
import v12Staging_B2C.B2cTripType;

@Listeners(listenerClass.Listener.class)
public class ProductSearch_Hotel {
	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("v12StagingBODC_Hotel", "Sheet3");
	}

	@Test(dataProvider = "getexceldata")
	public static void BODCHotelSearch(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String ChooseSalesChannel,
			String CityCode, String CityTitle, String CheckInDate, String CheckOutDate, String Rooms, String Adult,
			String Child, String ChildAge, String ChooseSupplier, String SupNumber, String SelectSupplier,
			String MoreOptions, String Currency, String StarRating, String ModifySearch, String ChangeTripLocation,
			String CityCodeM, String CityTitleM, String ChangeTripDate, String CheckInDateM, String CheckOutDateM,
			String ChangeRooms, String RoomsM, String AdultM, String ChildM, String ChildAgeM, String ChangeCurrency,
			String CurrencyM, String ChangeStarRating, String StarRatingM, String Emailid, String AdultTitle,
			String AdultName, String Phone, String ChildTitle, String ChildName, String ChildDOBdate, String Cardtype,
			String CardNumber, String CardName, String CardDate, String CVV, String BillingTitle,
			String BillingUserName, String BillingAddress, String BillingCountry, String BillingCity) throws Exception {
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
			QaRobot.ClickOnElement("DCHotel");
			BODCTripType.hotelTrip(CityCode, CityTitle, CheckInDate, CheckOutDate, Rooms, Adult, Child, ChildAge,
					ChooseSupplier, SupNumber, SelectSupplier, MoreOptions, Currency, StarRating);

			BODCResultPage.ResultPageForHotel(Rooms, ModifySearch, ChangeTripLocation, CityCodeM, CityTitleM,
					ChangeTripDate, CheckInDateM, CheckOutDateM, ChangeRooms, RoomsM, AdultM, ChildM, ChildAgeM,
					ChangeCurrency, CurrencyM, ChangeStarRating, StarRatingM);

			BODCCheckoutPage.GuestAdultCheckoutForHotel(Emailid, Adult, AdultTitle, AdultName, Phone);

			BODCCheckoutPage.GuestChildCheckoutForHotel(CheckInDate, Child, ChildAge, ChildTitle, ChildName,
					ChildDOBdate);
 
			BODCPaymentPage.cardPaymentHotel(Cardtype, CardNumber, CardName, CardDate, CVV);

			BODCCheckoutPage.GuestBillingDetailsCheckoutForHotel(BillingTitle, BillingUserName, BillingAddress,
					BillingCountry, BillingCity);
			
			BODCConfirmPage.confirmpageHotel();

		} else if (ChooseSalesChannel.equalsIgnoreCase("Reseller")) {

		} else if (ChooseSalesChannel.equalsIgnoreCase("Corporate")) {

		}
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
