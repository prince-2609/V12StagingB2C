package v12Staging;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class B2cTripType 
{
	public static WebDriver driver;
	
	public static void flightTriptype(String TripType,String Trip,String OriginCityCode,String OriginLocation,String DestinationCityCode,String DestinationLocation,
			String DepartureDate,String ReturnDate,String adult,String child,String infant,String MoreOptions,String Currency,String Class,String PANumber,String PreferredAirlineSelect,
			String ShowDirectFlight,String MyDatesAreFlexible) throws Exception 
	{
		String DateSelection[]= DepartureDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		
		String DateSelection1[]= ReturnDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1= DateSelection1[0];
		
		if(TripType.equalsIgnoreCase("OneWay"))
		{
			QaRobot.ClickOnElement("OneWay");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
			
			TestBase.listofautosuggestion(By.xpath("//div[@id='divFLDepart']/p"), OriginCityCode, OriginLocation,By.xpath("//input[@id='fromcityAc']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>"+OriginCityCode+" - " + OriginLocation);
			Thread.sleep(2000);
				
			TestBase.listofautosuggestion(By.xpath("//div[@id='divFLArrival']/p"), DestinationCityCode, DestinationLocation,By.xpath("//input[@id='tocityAc']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>"+DestinationCityCode+" - " + DestinationLocation);
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[1]")).click();
			Thread.sleep(2000);
			
			selectDateInCalendarOneWay(expDate,month,year);
			
			QaRobot.ClickOnElement("Travellers");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Travellers</i></b>");
			
			QaRobot.selectValueFromDropdown("v12Adult", adult, "<b><i>Select adult for booking</i></b>"+" - "+adult);
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("v12Child", child, "<b><i>Select child for booking</i></b>"+" - "+child);
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("v12Infant", infant, "<b><i>Select infant for booking</i></b>"+" - "+infant);
			Thread.sleep(2000);
			
			QaRobot.ClickOnElement("Travellers");
			
			if(MoreOptions.equalsIgnoreCase("Yes"))
			{
				QaRobot.ClickOnElement("MoreOptionsF");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MoreOptions</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectValueFromDropdown("CurrencyF", Currency, "<b><i>Select Currency for booking</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectTextByLocator("//select[@id='ddl_class']", Class, "<b><i>Select Class for booking</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("PreferredAirline");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on PreferredAirline</i></b>");
				Thread.sleep(2000);
				
				int pAS = Integer.parseInt(PANumber);
				for (int i = 1; i <= pAS; i++) 
				{
					String[] tN = PreferredAirlineSelect.split(",");
					String b = tN[i-1];
					TestBase.listofautosuggestion1(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']/li"),b,By.xpath("//input[@placeholder='Search Airline']"));
				}
				
				if(ShowDirectFlight.equalsIgnoreCase("Yes")) 
				{
					QaRobot.ClickOnElement("ShowDirectFlightF");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on ShowDirectFlight</i></b>");
				}
				
				if(MyDatesAreFlexible.equalsIgnoreCase("Yes")) 
				{
					QaRobot.ClickOnElement("MyDatesAreFlexibleF");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MyDatesAreFlexible</i></b>");
				}
			}	
		}
		
		else if(TripType.equalsIgnoreCase("RoundTrip"))
		{
			QaRobot.ClickOnElement("RoundTrip");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
			
			TestBase.listofautosuggestion(By.xpath("//div[@id='divFLDepart']/p"), OriginCityCode, OriginLocation,By.xpath("//input[@id='fromcityAc']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>"+OriginCityCode+" - " + OriginLocation);
			Thread.sleep(2000);
				
			TestBase.listofautosuggestion(By.xpath("//div[@id='divFLArrival']/p"), DestinationCityCode, DestinationLocation,By.xpath("//input[@id='tocityAc']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>"+DestinationCityCode+" - " + DestinationLocation);
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[1]")).click();
			Thread.sleep(2000);
			
			selectDateInCalendarRoundTrip(expDate,month,year,expDate1,month1,year1);
			
			QaRobot.ClickOnElement("Travellers");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Travellers</i></b>");
			
			QaRobot.selectValueFromDropdown("v12Adult", adult, "<b><i>Select Number of adult for booking</i></b>"+" - "+adult);
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("v12Child", child, "<b><i>Select Number of child for booking</i></b>"+" - "+child);
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("v12Infant", infant, "<b><i>Select Number of infant for booking</i></b>"+" - "+infant);
			Thread.sleep(2000);
			
			QaRobot.ClickOnElement("Travellers");
			
			if(MoreOptions.equalsIgnoreCase("Yes"))
			{
				QaRobot.ClickOnElement("MoreOptionsF");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MoreOptions</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectValueFromDropdown("CurrencyF", Currency, "<b><i>Select Currency for booking</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectTextByLocator("//select[@id='ddl_class']", Class, "<b><i>Select Class for booking</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("PreferredAirline");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on PreferredAirline</i></b>");
				Thread.sleep(2000);
				
				int pAS = Integer.parseInt(PANumber);
				for (int i = 1; i <= pAS; i++) 
				{
					String[] tN = PreferredAirlineSelect.split(",");
					String b = tN[i-1];
					TestBase.listofautosuggestion1(By.xpath("//ul[@class='ui-multiselect-checkboxes ui-helper-reset']/li"),b,By.xpath("//input[@placeholder='Search Airline']"));
				}
				
				if(ShowDirectFlight.equalsIgnoreCase("Yes")) 
				{
					QaRobot.ClickOnElement("ShowDirectFlightF");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on ShowDirectFlight</i></b>");
				}
				
				if(MyDatesAreFlexible.equalsIgnoreCase("Yes")) 
				{
					QaRobot.ClickOnElement("MyDatesAreFlexibleF");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MyDatesAreFlexible</i></b>");
				}
			}
		}
		else if(TripType.equalsIgnoreCase("MultiCity"))
		{
			
		}
		
		try
		{
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("FinalSearchF");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FinalSearch</i></b>");
			QaRobot.ScreenshotMethod("FlightTrip","<b><i>Screenshot for Flight Trip</i></b>");
		}
		catch(Exception e)
		{
			throw(e);
		}
	}
	
	public static void hotelTrip(String CityCode,String CityTitle,String CheckInDate,String CheckOutDate,String Rooms,String Adult,String Child,
			String ChildAge,String Nationality,String MoreOptions,String Currency,String StarRating) throws Exception 
	{
			TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), CityCode, CityTitle,By.xpath("//input[@id='txtHTCity']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>City Name : </i></b>"+CityCode+"-"+ CityTitle);
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[9]")).click();
			Thread.sleep(2000);
			
			String DateSelection[]= CheckInDate.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];
			
			String DateSelection1[]= CheckOutDate.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1= DateSelection1[0];
			
			selectDateInCalendarHotel(expDate,month,year,expDate1,month1,year1);
			
			int room=Integer.parseInt(Rooms);
			String[] adultcount=Adult.split(",");
			String[] childcount=Child.split(",");
			
			if(room>5)
			{
				throw new B2cExceptionClass("Invalid Number of Rooms provided "+" : "+room);
			}
			else
			{
				for (int i = 1; i < room; i++) 
				{
					QaRobot.ClickOnElement("AddRoom");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on AddRoom</i></b>");
				}
				
				for(int i=1;i<=room;i++)
				{
					WebElement adultelement=QaBrowser.driver.findElement(By.xpath("//select[@id='HtlSltAdult"+i+"']"));
					Select selectadult=new Select(adultelement);
					selectadult.selectByValue(adultcount[i-1]);
					Thread.sleep(2000);
					
					WebElement childelement=QaBrowser.driver.findElement(By.xpath("//select[@id='HtlChildSlt"+i+"']"));
					Select selectchild=new Select(childelement);
					selectchild.selectByValue(childcount[i-1]);
					Thread.sleep(2000);
				}
				
				String[] ageofchild=ChildAge.split(",");
				for(String chd:childcount)
				{
					int chdcount=Integer.parseInt(chd);
					for(int i=1;i<=chdcount;i++)
					{
						String ac = ageofchild[i-1];
						int ac1 = Integer.parseInt(ac);
						
						if(ac1>17)
						{
							QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Age Selection</i></b>"+" : "+ac1);
							throw new B2cExceptionClass("Invalid Child Age Selection"+" : "+ac1);
						}
						else
						{
							WebElement childrenage=QaBrowser.driver.findElement(By.xpath("//select[@id='HtlChildAge"+chdcount+"_"+i+"']"));
							Select selectage=new Select(childrenage);
							selectage.selectByValue(ageofchild[i-1]);
							Thread.sleep(2000);
						}
					}
				}
			}
			
			QaRobot.selectTextFromDropdown("Nationality", Nationality, "<b><i>Select Nationality</i></b>");
			Thread.sleep(2000);
			
			if(MoreOptions.equalsIgnoreCase("Yes"))
			{
				QaRobot.ClickOnElement("MoreOptionsH");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MoreOptions</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectValueFromDropdown("CurrencyH", Currency, "<b><i>Select Currency for booking</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectValueFromDropdown("StarRating", StarRating, "<b><i>Select Star Rating for booking</i></b>");
				Thread.sleep(2000);
			}
			
			try
			{
				QaExtentReport.extentScreenshot("Search Page");
				QaRobot.ClickOnElement("FinalSearch");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FinalSearch</i></b>");
				QaRobot.ScreenshotMethod("HotelTrip","<b><i>Screenshot for Hotel Trip</i></b>");
			}
			catch(Exception e)
			{
				throw(e);
			}
	}
	
	public static void flight_HotelTrip(String Trip,String OriginCityCode,String OriginLocation,String DestinationCityCode,String DestinationLocation,
			String DepartureDate,String ReturnDate,String Rooms,String Adult,String Child,String ChildAge,String Infant,String InfantAge,
			String MoreOptions,String Nationality,String Currency,String Class,String ShowDirectFlight,String MyHotelDiffenrentDate,
			String ChangeCheckIn,String ChangeCheckOut) throws Exception 
	{
			TestBase.listofautosuggestion(By.xpath("//div[@id='div3']/p"), OriginCityCode, OriginLocation,By.xpath("//input[@id='txtFlightFromDynamic']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + OriginLocation);
			Thread.sleep(2000);
				
			TestBase.listofautosuggestion(By.xpath("//div[@id='div7']/p"), DestinationCityCode, DestinationLocation,By.xpath("//input[@id='txtFlightToDynamic']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>" + DestinationLocation);
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[11]")).click();
			Thread.sleep(2000);
			
			String DateSelection[]= DepartureDate.split("-");
			String year = DateSelection[2];
			String month = DateSelection[1];
			String expDate = DateSelection[0];
			
			String DateSelection1[]= ReturnDate.split("-");
			String year1 = DateSelection1[2];
			String month1 = DateSelection1[1];
			String expDate1= DateSelection1[0];
			
			selectDateInCalendarFlight_Hotel(expDate,month,year,expDate1,month1,year1);
			
			int room=Integer.parseInt(Rooms);
			String[] adultcount=Adult.split(",");
			String[] childcount=Child.split(",");
			String[] infantcount=Infant.split(",");
			
			if(room>5)
			{
				throw new B2cExceptionClass("Invalid Number of Rooms provided "+" : "+room);
			}
			else
			{
				for (int i = 1; i < room; i++) 
				{
					QaRobot.ClickOnElement("AddRoomFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Add Room</i></b>");
				}
				
				for(int i=1;i<=room;i++)
				{
					WebElement adultelement=QaBrowser.driver.findElement(By.xpath("//select[@id='Htl_fltSltAdult"+i+"']"));
					Select selectadult=new Select(adultelement);
					selectadult.selectByValue(adultcount[i-1]);
					Thread.sleep(2000);
					
					WebElement childelement=QaBrowser.driver.findElement(By.xpath("//select[@id='Htl_fltChildSlt"+i+"']"));
					Select selectchild=new Select(childelement);
					selectchild.selectByValue(childcount[i-1]);
					Thread.sleep(2000);
					
					WebElement infantelement=QaBrowser.driver.findElement(By.xpath("//select[@id='Htl_fltInfantSlt"+i+"']"));
					Select selectinfant=new Select(infantelement);
					selectinfant.selectByValue(infantcount[i-1]);
					Thread.sleep(2000);
				}
				
				String[] ageofchild=ChildAge.split(",");
				for(String chd:childcount)
				{
					int chdcount=Integer.parseInt(chd);
					for(int i=1;i<=chdcount;i++)
					{
						String ac = ageofchild[i-1];
						int ac1 = Integer.parseInt(ac);
						
						if(ac1>17)
						{
							QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Age Selection</i></b>"+" : "+ac1);
							throw new B2cExceptionClass("Invalid Child Age Selection"+" : "+ac1);
						}
						else
						{
							WebElement childrenage=QaBrowser.driver.findElement(By.xpath("//select[@id='Htl_fltChildAge"+chdcount+"_"+i+"']"));
							Select selectage=new Select(childrenage);
							selectage.selectByValue(ageofchild[i-1]);
							Thread.sleep(2000);
						}
					}
				} 
				
				String[] ageofinfant=InfantAge.split(",");
				for(String ift:infantcount)
				{
					int iftcount=Integer.parseInt(ift);
					for(int i=1;i<=iftcount;i++)
					{
						String ai = ageofinfant[i-1];
						int ai1 = Integer.parseInt(ai);
						
						if(ai1>2)
						{
							QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Infant Age Selection</i></b>"+" : "+ai1);
							throw new B2cExceptionClass("Invalid Infant Age Selection"+" : "+ai1);
						}
						else
						{
							WebElement infantrenage=QaBrowser.driver.findElement(By.xpath("//select[@id='Htl_fltInfantAge"+iftcount+"_"+i+"']"));
							Select selectage=new Select(infantrenage);
							selectage.selectByValue(ageofinfant[i-1]);
							Thread.sleep(2000);
						}
						
					}
				}
			}
			
			if(MoreOptions.equalsIgnoreCase("Yes"))
			{
				QaRobot.ClickOnElement("MoreOptionsFH");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on More Options</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectTextFromDropdown("NationalityFH", Nationality, "<b><i>Select Nationality</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectValueFromDropdown("CurrencyFH", Currency, "<b><i>Select Currency for booking</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectTextByLocator("//select[@id='dynamic_class']", Class, "<b><i>Select Class for booking</i></b>");
				Thread.sleep(2000);
			}
			
			if(ShowDirectFlight.equalsIgnoreCase("Yes")) 
			{
				QaRobot.ClickOnElement("ShowDirectFlightsOnly");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Show Direct Flights Only</i></b>");
			}
			
			if(MyHotelDiffenrentDate.equalsIgnoreCase("Yes")) 
			{
				QaRobot.ClickOnElement("MyHotelCheckin");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on My Hotel Check In</i></b>");
				
				String DateSelection2[]= ChangeCheckIn.split("-");
				String year2 = DateSelection2[2];
				String month2 = DateSelection2[1];
				String expDate2 = DateSelection2[0];
				
				String DateSelection3[]= ChangeCheckOut.split("-");
				String year3 = DateSelection3[2];
				String month3 = DateSelection3[1];
				String expDate3= DateSelection3[0];
				
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[13]")).click();
				Thread.sleep(2000);
				
				selectDateInCalendarFlight_Hotel1(expDate2,month2,year2,expDate3,month3,year3);
			}
			
			try
			{
				QaExtentReport.extentScreenshot("Search Page");
				QaRobot.ClickOnElement("FinalSearchFH");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Final Search</i></b>");
				QaRobot.ScreenshotMethod("Flight_HotelTrip","<b><i>Screenshot for Flight+Hotel Trip</i></b>");
			}
			catch(Exception e)
			{
				throw(e);
			}
	 }
	
	public static void selectDateInCalendarOneWay(String Day,String Month,String Year) throws ParseException
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
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
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>"+Day+"-"+Month+"-"+Year);
		
		QaBrowser.driver.findElement(By.xpath("//input[@id='txtFlightDepartureDate']")).clear();
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"/"+Month+"/"+Year);
		}
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			while(!(month.equals(Month) && year.equals(Year)))
			{
				QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				
				monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}
			
				List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Day))
					{
						ele.click();
						break;
					}
				}
		}
	  }
	
	public static void selectDateInCalendarRoundTrip(String Day,String Month,String Year,String Day1,String Month1,String Year1) throws InterruptedException, ParseException
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
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
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		String currentMonthNumber1 ="00";
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
		 
		Date date3 = d.parse(Day1+"-"+Integer.parseInt(currentMonthNumber1)+"-"+Year1);
		System.out.println(date3);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>"+Day+"-"+Month+"-"+Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>"+Day1+"-"+Month1+"-"+Year1);
		
		QaBrowser.driver.findElement(By.xpath("//input[@id='txtFlightDepartureDate']")).clear();
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"/"+Month+"/"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Integer.parseInt(Day1)>31)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new B2cExceptionClass("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day1)>28)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new B2cExceptionClass("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			while(!(month.equals(Month) && year.equals(Year)))
			{
				QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				
				monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}
			
				List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Day))
					{
						ele.click();
						break;
					}
				}
				
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[2]")).click();
				Thread.sleep(2000);
				
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtFlightArrivalDate']")).clear();
				
				String monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				String month1 = monthYear1.split(" ")[0];
				String year1 = monthYear1.split(" ")[1];
				
				if(date3.before(date2))
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Return date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
					throw new B2cExceptionClass("Invalid Return date provided "+Day1+"-"+Month1+"-"+Year1);
				}
				else
				{
					while(!(month1.equals(Month1) && year1.equals(Year1)))
					{
						QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
						
						monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
						
						month1 = monthYear1.split(" ")[0];
						year1 = monthYear1.split(" ")[1];
					}
					
						List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
						
						for(WebElement ele1 : allDates1)
						{
							String dt1 = ele1.getText();
							
							if(dt1.equalsIgnoreCase(Day1))
							{
								ele1.click();
								break;
							}
						}
				}
		}
	  }
	
	public static void selectDateInCalendarHotel(String Day,String Month,String Year,String Day1,String Month1,String Year1) throws InterruptedException, ParseException
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
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
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		String currentMonthNumber1 ="00";
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
		 
		Date date3 = d.parse(Day1+"-"+Integer.parseInt(currentMonthNumber1)+"-"+Year1);
		System.out.println(date3);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>"+Day+"-"+Month+"-"+Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>"+Day1+"-"+Month1+"-"+Year1);
		
		QaBrowser.driver.findElement(By.xpath("//input[@id='txtDepartHotelDateInternational']")).clear();
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Integer.parseInt(Day1)>31)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new B2cExceptionClass("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day1)>28)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new B2cExceptionClass("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			while(!(month.equals(Month) && year.equals(Year)))
			{
				QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				
				monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}
			
				List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Day))
					{
						ele.click();
						break;
					}
				}
				
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[10]")).click();
				Thread.sleep(2000);
				
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtReturnHotelDateInternational']")).clear();
				
				String monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				String month1 = monthYear1.split(" ")[0];
				String year1 = monthYear1.split(" ")[1];
				
				if(date3.before(date2))
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Check out date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
					throw new B2cExceptionClass("Invalid Check out date provided "+Day1+"-"+Month1+"-"+Year1);
				}
				else
				{
					while(!(month1.equals(Month1) && year1.equals(Year1)))
					{
						QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
						
						monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
						
						month1 = monthYear1.split(" ")[0];
						year1 = monthYear1.split(" ")[1];
					}
					
						List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
						
						for(WebElement ele1 : allDates1)
						{
							String dt1 = ele1.getText();
							
							if(dt1.equalsIgnoreCase(Day1))
							{
								ele1.click();
								break;
							}
						}
				}
		}
	  }
	
	public static void selectDateInCalendarFlight_Hotel(String Day,String Month,String Year,String Day1,String Month1,String Year1) throws InterruptedException, ParseException
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
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
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		String currentMonthNumber1 ="00";
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
		 
		Date date3 = d.parse(Day1+"-"+Integer.parseInt(currentMonthNumber1)+"-"+Year1);
		System.out.println(date3);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>"+Day+"-"+Month+"-"+Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>"+Day1+"-"+Month1+"-"+Year1);
		
		QaBrowser.driver.findElement(By.xpath("//input[@id='txtDepartDateDomesticHpF']")).clear();
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"/"+Month+"/"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Integer.parseInt(Day1)>31)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new B2cExceptionClass("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day1)>28)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new B2cExceptionClass("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			while(!(month.equals(Month) && year.equals(Year)))
			{
				QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				
				monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}
			
				List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Day))
					{
						ele.click();
						break;
					}
				}
				
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[12]")).click();
				Thread.sleep(2000);
				
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtReturnDateDomesticHpF']")).clear();
				
				String monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				String month1 = monthYear1.split(" ")[0];
				String year1 = monthYear1.split(" ")[1];
				
				if(date3.before(date2))
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Return date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
					throw new B2cExceptionClass("Invalid Return date provided "+Day1+"-"+Month1+"-"+Year1);
				}
				else
				{
					while(!(month1.equals(Month1) && year1.equals(Year1)))
					{
						QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
						
						monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
						
						month1 = monthYear1.split(" ")[0];
						year1 = monthYear1.split(" ")[1];
					}
					
						List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
						
						for(WebElement ele1 : allDates1)
						{
							String dt1 = ele1.getText();
							
							if(dt1.equalsIgnoreCase(Day1))
							{
								ele1.click();
								break;
							}
						}
				}
		}
	  }
	
	public static void selectDateInCalendarFlight_Hotel1(String Day,String Month,String Year,String Day1,String Month1,String Year1) throws InterruptedException, ParseException
	 {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);
		System.out.println(date1);
		
		String currentMonthNumber ="00";
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
		 
		Date date2 = d.parse(Day+"-"+Integer.parseInt(currentMonthNumber)+"-"+Year);
		System.out.println(date2);
		
		String currentMonthNumber1 ="00";
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
		 
		Date date3 = d.parse(Day1+"-"+Integer.parseInt(currentMonthNumber1)+"-"+Year1);
		System.out.println(date3);
		
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>"+Day+"-"+Month+"-"+Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>"+Day1+"-"+Month1+"-"+Year1);
		
		QaBrowser.driver.findElement(By.xpath("//input[@id='txtDepartDateInternationalHpF']")).clear();
		
		if(Integer.parseInt(Day)>31)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"/"+Month+"/"+Year);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day)>28)
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		
		if(Integer.parseInt(Day1)>31)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new B2cExceptionClass("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		if(Month.equals("Feb") && Integer.parseInt(Day1)>28)
		{
			System.out.println("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
			throw new B2cExceptionClass("Invalid date provided "+Day1+"-"+Month1+"-"+Year1);
		}
		
		String monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
		
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];
		
		if(date2.before(date1))
		{
			System.out.println("Invalid date provided "+Day+"-"+Month+"-"+Year);
			QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid date provided  </i></b>"+Day+"-"+Month+"-"+Year);
			throw new B2cExceptionClass("Invalid date provided "+Day+"-"+Month+"-"+Year);
		}
		else
		{
			while(!(month.equals(Month) && year.equals(Year)))
			{
				QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				
				monthYear = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
			}
			
				List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
				
				for(WebElement ele : allDates)
				{
					String dt = ele.getText();
					
					if(dt.equalsIgnoreCase(Day))
					{
						ele.click();
						break;
					}
				}
				
				QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[14]")).click();
				Thread.sleep(2000);
				
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtReturnDateInternationalHpF']")).clear();
				
				String monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				String month1 = monthYear1.split(" ")[0];
				String year1 = monthYear1.split(" ")[1];
				
				if(date3.before(date2))
				{
					QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Return date provided  </i></b>"+Day1+"-"+Month1+"-"+Year1);
					throw new B2cExceptionClass("Invalid Return date provided "+Day1+"-"+Month1+"-"+Year1);
				}
				else
				{
					while(!(month1.equals(Month1) && year1.equals(Year1)))
					{
						QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
						
						monthYear1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
						
						month1 = monthYear1.split(" ")[0];
						year1 = monthYear1.split(" ")[1];
					}
					
						List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
						
						for(WebElement ele1 : allDates1)
						{
							String dt1 = ele1.getText();
							
							if(dt1.equalsIgnoreCase(Day1))
							{
								ele1.click();
								break;
							}
						}
				}
		}
	  }
	}





































