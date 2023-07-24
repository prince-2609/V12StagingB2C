package v12Staging_B2C;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class V12StagingForFlight_Hotel 
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("v12StagingFlight+Hotel","TestCases");
	}
	
	@Test(dataProvider = "getexceldata")

	public static void v12stagingforhotel(String TestCaseId,String TestCaseType,String TestScenario,String UserType,String Source,String URL,
			String Username,String Password,String Trip,String OriginCityCode,String OriginLocation,String DestinationCityCode,String DestinationLocation,
			String DepartureDate,String ReturnDate,String Rooms,String Adult,String Child,String ChildAge,String Infant,String InfantAge,
			String MoreOptions,String Nationality,String Currency,String Class,String ShowDirectFlight,String MyHotelDiffenrentDate,
			String ChangeCheckIn,String ChangeCheckOut,String ModifySearch,String ChangeTripLocation,String MarketTypeM,String OriginCityCodeM,
			String OriginLocationM,String DestinationCityCodeM,String DestinationLocationM,String ChangeTripDate,String DepartureDateM,
			String ReturnDateM,String ChangeRooms,String RoomsM,String AdultM,String ChildM,String ChildAgeM,String InfantM,String InfantAgeM,
			String MyHotelDiffenrentDateM,String ChangeCheckInM,String ChangeCheckOutM,String ChangeCurrency,String CurrencyM,
			String ChangeClass,String ClassM,String ChangeAirline,String PANumberM,String PreferredAirlineSelectM,String ShowDirectFlightM,
			String ApplyFilter,String StarRating,String PropertyType,String RateType,String ChooseAnotherFlight,String FlightFilter,String FareType,
			String AirLine,String Emailid,String AdultTitle,String AdultName, String Phone,String AdultDOBdate,String AdultRoomSelection,
			String AdultPassportNumber,String AdultPassportcountry,String AdultExpiryDate,String AdultNationality,String ChildTitle,
			String ChildName,String ChildDOBdate,String ChildRoomSelection,String ChildPassportNumber,String ChildPassportcountry,String ChildPassportDate,
			String ChildNationality,String InfantTitle,String InfantName,String InfantDOBdate,String InfantTravellingwith,String InfantPassportNumber,
			String InfantPassportcountry,String InfantPassportDate,String InfantNationality,String Cardtype,String CardNumber,String CardName,
			String CardDate,String CVV,String BillingTitle, String BillingUserName, String BillingAddress,String BillingCountry,
			String BillingCity) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId);
	
		if (UserType.equalsIgnoreCase("LogIn"))
		{
			QaRobot.ClickOnElement("SignIn");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on SignIn</i></b>");
			
			QaRobot.PassValue("User_name",Username);
			QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			
			QaRobot.PassValue("Password",Password);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
			
			QaRobot.ClickOnElement("Submit");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Submit</i></b>");
			
			QaRobot.ClickOnElement("Flight_Hotel");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Flight+Hotel</i></b>");
			
			B2cTripType.flight_HotelTrip(Trip,OriginCityCode,OriginLocation,DestinationCityCode,DestinationLocation,DepartureDate,ReturnDate,Rooms,Adult,Child,
					ChildAge,Infant,InfantAge,MoreOptions,Nationality,Currency,Class,ShowDirectFlight,MyHotelDiffenrentDate,ChangeCheckIn,ChangeCheckOut);
			
			B2cResultPage.ResultPageForFlight_Hotel(ModifySearch,ChangeTripLocation,MarketTypeM,OriginCityCodeM,OriginLocationM,DestinationCityCodeM,
					DestinationLocationM,ChangeTripDate,DepartureDateM,ReturnDateM,ChangeRooms,RoomsM,AdultM,ChildM,ChildAgeM,InfantM,
					InfantAgeM,MyHotelDiffenrentDateM,ChangeCheckInM,ChangeCheckOutM,ChangeCurrency,CurrencyM,ChangeClass,ClassM,ChangeAirline,
					PANumberM,PreferredAirlineSelectM,ShowDirectFlightM,ApplyFilter,StarRating,PropertyType,RateType,ChooseAnotherFlight,
					FlightFilter,FareType,AirLine);
		}
		
		else if (UserType.equalsIgnoreCase("Guest"))
		{
			QaRobot.ClickOnElement("Flight_Hotel");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Flight+Hotel</i></b>");
			
			B2cTripType.flight_HotelTrip(Trip,OriginCityCode,OriginLocation,DestinationCityCode,DestinationLocation,DepartureDate,ReturnDate,Rooms,Adult,Child,
					ChildAge,Infant,InfantAge,MoreOptions,Nationality,Currency,Class,ShowDirectFlight,MyHotelDiffenrentDate,ChangeCheckIn,ChangeCheckOut);
			
			B2cResultPage.ResultPageForFlight_Hotel(ModifySearch,ChangeTripLocation,MarketTypeM,OriginCityCodeM,OriginLocationM,DestinationCityCodeM,
					DestinationLocationM,ChangeTripDate,DepartureDateM,ReturnDateM,ChangeRooms,RoomsM,AdultM,ChildM,ChildAgeM,InfantM,
					InfantAgeM,MyHotelDiffenrentDateM,ChangeCheckInM,ChangeCheckOutM,ChangeCurrency,CurrencyM,ChangeClass,ClassM,ChangeAirline,
					PANumberM,PreferredAirlineSelectM,ShowDirectFlightM,ApplyFilter,StarRating,PropertyType,RateType,ChooseAnotherFlight,
					FlightFilter,FareType,AirLine);
		
			B2cCheckoutPage.GuestDetailsCheckoutFlight_Hotel();
			
			B2cCheckoutPage.GuestAdultCheckoutForFlight_Hotel(Adult,Trip,Emailid,AdultTitle,AdultName,Phone,AdultDOBdate,AdultRoomSelection,AdultPassportNumber,
					AdultPassportcountry,AdultExpiryDate,AdultNationality);
			
			B2cCheckoutPage.GuestChildCheckoutFlight_Hotel(Child,Trip,ChildTitle,ChildName,ChildDOBdate,ChildRoomSelection,ChildPassportNumber,ChildPassportcountry,
					ChildPassportDate,ChildNationality);
			
			B2cCheckoutPage.GuestInfantCheckoutFlight_Hotel(Infant,Trip,InfantTitle,InfantName,InfantDOBdate,InfantTravellingwith,InfantPassportNumber,InfantPassportcountry,
					InfantPassportDate,InfantNationality);
			
			B2cPaymentPage.cardPaymentFlight_Hotel(Cardtype,CardNumber,CardName,CardDate,CVV);
			
			B2cCheckoutPage.GuestBillingDetailsCheckoutFlight_Hotel(BillingTitle,BillingUserName,BillingAddress,BillingCountry,BillingCity);
			
			B2cConfirmPage.confirmpageFlight_Hotel();
		}
	}
	
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
	}
}
