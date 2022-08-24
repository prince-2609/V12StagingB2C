package v12Staging;

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
public class V12StagingForHotel 
{
	@DataProvider
	public Object[][] getexceldata() throws Exception 
	{
		return QaDataProvider.getTestdata("v12StagingHotel","Sheet1");
	}
	
	@Test(dataProvider = "getexceldata")

	public static void v12stagingforhotel( String Usertype, String Source, String URL,String UserName,String Password,String CityCode,String CityTitle, 
			String CheckInDate,String CheckOutDate,String Rooms,String Adult,String Child,String ChildAge,String Nationality,String MoreOptions,String Currency,String StarRating,
			String Emailid,String AdultTitle,String AdultName,String Phone,String ChildTitle, String ChildName,String ChildDOBdate,String Cardtype,String CardNumber,
			String CardName,String CardDate,String CVV,String BillingTitle,String BillingUserName,String BillingAddress,String BillingCountry,String BillingCity) throws Exception 
	{
		TestBase.Companycode(Source,URL); 
		QaRobot.impliwait(30);
		
		QaExtentReport.test = QaExtentReport.report.createTest("Test on Booking For Hotel");
		
		if(Usertype.equalsIgnoreCase("Login"))
		{
			QaRobot.ClickOnElement("SignIn");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
			
			QaRobot.PassValue("User_name",UserName);
			QaExtentReport.test.log(Status.INFO,"<b><i>Write Username</i></b>");
			
			QaRobot.PassValue("Password",Password);
			QaExtentReport.test.log(Status.INFO, "<b><i>Write Password</i></b>");
			
			QaRobot.ClickOnElement("Submit");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
			
			QaRobot.ClickOnElement("Hotels");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Hotel</i></b>");
			
			B2cTripType.hotelTrip(CityCode,CityTitle,CheckInDate,CheckOutDate,Rooms,Adult,Child,ChildAge,Nationality,MoreOptions,Currency,StarRating);
			
			B2cResultPage.ResultPageForHotel(Rooms);
		}
		
		else if (Usertype.equalsIgnoreCase("Guest"))
		{
			QaRobot.ClickOnElement("Hotels");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Hotel</i></b>");
			
			B2cTripType.hotelTrip(CityCode,CityTitle,CheckInDate,CheckOutDate,Rooms,Adult,Child,ChildAge,Nationality,MoreOptions,Currency,StarRating);
			
			B2cResultPage.ResultPageForHotel(Rooms);
			
			B2cCheckoutPage.GuestAdultCheckoutForHotel(Emailid,Adult,AdultTitle,AdultName,Phone);
			
			B2cCheckoutPage.GuestChildCheckoutForHotel(Child,ChildTitle,ChildName,ChildDOBdate);
			
			B2cPaymentPage.cardPaymentForHotel(Cardtype,CardNumber,CardName,CardDate,CVV);
			
			B2cCheckoutPage.GuestBillingDetailsCheckoutForHotel(BillingTitle,BillingUserName,BillingAddress,BillingCountry,BillingCity);
			
			B2cConfirmPage.confirmpageHotel();
		}
	}
	
	@AfterMethod
	public static void afterMetod()
	{
		QaExtentReport.test.getExtent().flush();
	}
}
