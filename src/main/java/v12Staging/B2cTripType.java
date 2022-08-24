package v12Staging;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class B2cTripType 
{
	public static void flightTriptype(String TripType,String Trip,String OriginCityCode,String OriginLocation,String DestinationCityCode,String DestinationLocation,
			String DepartureDate,String ReturnDate,String adult,String child,String infant,String MoreOptions,String Currency,String Class,String PANumber,String PreferredAirlineSelect,
			String ShowDirectFlight,String MyDatesAreFlexible) throws Exception 
	{
		String DateSelection[]= DepartureDate.split(",");
		String monthAndYear = DateSelection[1];
		String expDate = DateSelection[0];
		
		String DateSelection1[]= ReturnDate.split(",");
		String monthAndYear1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		
		if(TripType.equalsIgnoreCase("OneWay"))
		{
			QaRobot.ClickOnElement("OneWay");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
			
			if (Trip.equalsIgnoreCase("Domestic"))
			{
				TestBase.listofautosuggestion(By.xpath("//div[@id='divFLDepart']/p"), OriginCityCode, OriginLocation,By.xpath("//input[@id='fromcityAc']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='divFLDepart']/p")).click();
				QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + OriginLocation);
				Thread.sleep(2000);
				
				TestBase.listofautosuggestion(By.xpath("//div[@id='divFLArrival']/p"), DestinationCityCode, DestinationLocation,By.xpath("//input[@id='tocityAc']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>" + DestinationLocation);
				Thread.sleep(2000);
			}
			else if (Trip.equalsIgnoreCase("International"))
			{
				TestBase.listofautosuggestion(By.xpath("//div[@id='divFLDepart']/p"), OriginCityCode, OriginLocation,By.xpath("//input[@id='fromcityAc']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='divFLDepart']/p")).click();
				QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + OriginLocation);
				Thread.sleep(2000);
				
				TestBase.listofautosuggestion(By.xpath("//div[@id='divFLArrival']/p"), DestinationCityCode, DestinationLocation,By.xpath("//input[@id='tocityAc']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='divFLArrival']/p")).click();
				QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>" + DestinationLocation);
				Thread.sleep(2000);
			}
			
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[1]")).click();
			Thread.sleep(2000);
			
			while(true)
			{
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtFlightDepartureDate']")).clear();
				
				String text = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				if(text.equalsIgnoreCase(monthAndYear))
				{
					break;
				}
				else
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				}
			}
			
			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
			
			for(WebElement ele : allDates)
			{
				String dt = ele.getText();
				
				if(dt.equalsIgnoreCase(expDate))
				{
					ele.click();
					break;
				}
			}
			
			QaRobot.ClickOnElement("Travellers");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Travellers</i></b>");
			
			QaRobot.selectValueFromDropdown("v12Adult", adult, "<b><i>Select adult for booking</i></b>");
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("v12Child", child, "<b><i>Select child for booking</i></b>");
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("v12Infant", infant, "<b><i>Select infant for booking</i></b>");
			Thread.sleep(2000);
			
			QaRobot.ClickOnElement("Travellers");
			
			if(MoreOptions.equalsIgnoreCase("Yes"))
			{
				QaRobot.ClickOnElement("MoreOptions");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MoreOptions</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectValueFromDropdown("Currency", Currency, "<b><i>Select Currency for booking</i></b>");
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
					QaRobot.ClickOnElement("ShowDirectFlight");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on ShowDirectFlight</i></b>");
				}
				
				if(MyDatesAreFlexible.equalsIgnoreCase("Yes")) 
				{
					QaRobot.ClickOnElement("MyDatesAreFlexible");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MyDatesAreFlexible</i></b>");
				}
			}	
		}
		
		else if(TripType.equalsIgnoreCase("RoundTrip"))
		{
			QaRobot.ClickOnElement("RoundTrip");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on submit</i></b>");
			
			if (Trip.equalsIgnoreCase("Domestic"))
			{
				TestBase.listofautosuggestion(By.xpath("//div[@id='divFLDepart']/p"), OriginCityCode, OriginLocation,By.xpath("//input[@id='fromcityAc']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='divFLDepart']/p")).click();
				QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + OriginLocation);
				Thread.sleep(2000);
				
				TestBase.listofautosuggestion(By.xpath("//div[@id='divFLArrival']/p"), DestinationCityCode, DestinationLocation,By.xpath("//input[@id='tocityAc']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>" + DestinationLocation);
				Thread.sleep(2000);
			}
			else if (Trip.equalsIgnoreCase("International"))
			{
				TestBase.listofautosuggestion(By.xpath("//div[@id='divFLDepart']/p"), OriginCityCode, OriginLocation,By.xpath("//input[@id='fromcityAc']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='divFLDepart']/p")).click();
				QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + OriginLocation);
				Thread.sleep(2000);
				
				TestBase.listofautosuggestion(By.xpath("//div[@id='divFLArrival']/p"), DestinationCityCode, DestinationLocation,By.xpath("//input[@id='tocityAc']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='divFLArrival']/p")).click();
				QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>" + DestinationLocation);
				Thread.sleep(2000);
			}
			
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[1]")).click();
			Thread.sleep(2000);
			
			while(true)
			{
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtFlightDepartureDate']")).clear();
				
				String text = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				if(text.equalsIgnoreCase(monthAndYear))
				{
					break;
				}
				else
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				}
			}
			
			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
			
			for(WebElement ele : allDates)
			{
				String dt = ele.getText();
				
				if(dt.equalsIgnoreCase(expDate))
				{
					ele.click();
					break;
				}
			}
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[2]")).click();
			Thread.sleep(2000);
			
			while(true)
			{
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtFlightArrivalDate']")).clear();
				
				String text1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				if(text1.equalsIgnoreCase(monthAndYear1))
				{
					break;
				}
				else
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				}
			}
			
			List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
			
			for(WebElement ele1 : allDates1)
			{
				String dt1 = ele1.getText();
				
				if(dt1.equalsIgnoreCase(expDate1))
				{
					ele1.click();
					break;
				}
			}
			
			QaRobot.ClickOnElement("Travellers");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Travellers</i></b>");
			
			QaRobot.selectValueFromDropdown("v12Adult", adult, "<b><i>Select adult for booking</i></b>");
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("v12Child", child, "<b><i>Select child for booking</i></b>");
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("v12Infant", infant, "<b><i>Select infant for booking</i></b>");
			Thread.sleep(2000);
			
			QaRobot.ClickOnElement("Travellers");
			
			if(MoreOptions.equalsIgnoreCase("Yes"))
			{
				QaRobot.ClickOnElement("MoreOptions");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MoreOptions</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectValueFromDropdown("Currency", Currency, "<b><i>Select Currency for booking</i></b>");
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
					QaRobot.ClickOnElement("ShowDirectFlight");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on ShowDirectFlight</i></b>");
				}
				
				if(MyDatesAreFlexible.equalsIgnoreCase("Yes")) 
				{
					QaRobot.ClickOnElement("MyDatesAreFlexible");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MyDatesAreFlexible</i></b>");
				}
			}
		}
		else if(TripType.equalsIgnoreCase("MultiCity"))
		{
			
		}
		QaRobot.ScreenshotMethod("FlightTrip","<b><i>Screenshot for Flight Trip</i></b>");
	}
	
	public static void hotelTrip(String CityCode,String CityTitle,String CheckInDate,String CheckOutDate,String Rooms,String Adult,String Child,
			String ChildAge,String Nationality,String MoreOptions,String Currency,String StarRating) throws Exception 
	{
			TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), CityCode, CityTitle,By.xpath("//input[@id='txtHTCity']"));
			QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + CityTitle);
			Thread.sleep(2000);
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[9]")).click();
			Thread.sleep(2000);
			
			String DateSelection2[]= CheckInDate.split(",");
			String monthAndYear2 = DateSelection2[1];
			String expDate2 = DateSelection2[0];
			
			String DateSelection3[]= CheckOutDate.split(",");
			String monthAndYear3 = DateSelection3[1];
			String expDate3 = DateSelection3[0];
			
			while(true)
			{
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtDepartHotelDateInternational']")).clear();
				
				String text2 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				if(text2.equalsIgnoreCase(monthAndYear2))
				{
					break;
				}
				else
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				}
			}
			
			List<WebElement> allDates2 = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
			
			for(WebElement ele2 : allDates2)
			{
				String dt2 = ele2.getText();
				
				if(dt2.equalsIgnoreCase(expDate2))
				{
					ele2.click();
					break;
				}
			}
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[10]")).click();
			Thread.sleep(2000);
			
			while(true)
			{
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtReturnHotelDateInternational']")).clear();
				
				String text3 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				if(text3.equalsIgnoreCase(monthAndYear3))
				{
					break;
				}
				else
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				}
			}
			
			List<WebElement> allDates3 = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
			
			for(WebElement ele3 : allDates3)
			{
				String dt3 = ele3.getText();
				
				if(dt3.equalsIgnoreCase(expDate3))
				{
					ele3.click();
					break;
				}
			}
			
			int room=Integer.parseInt(Rooms);
			String[] adultcount=Adult.split(",");
			String[] childcount=Child.split(",");
			
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
					WebElement childrenage=QaBrowser.driver.findElement(By.xpath("//select[@id='HtlChildAge"+chdcount+"_"+i+"']"));
					Select selectage=new Select(childrenage);
					selectage.selectByValue(ageofchild[i-1]);
					Thread.sleep(2000);
				}
			}
			
			QaRobot.selectTextFromDropdown("Nationality", Nationality, "<b><i>Select Nationality</i></b>");
			Thread.sleep(2000);
			
			if(MoreOptions.equalsIgnoreCase("Yes"))
			{
				QaRobot.ClickOnElement("MoreOptions");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MoreOptions</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectValueFromDropdown("Currency", Currency, "<b><i>Select Currency for booking</i></b>");
				Thread.sleep(2000);
				
				QaRobot.selectValueFromDropdown("StarRating", StarRating, "<b><i>Select Star Rating for booking</i></b>");
				Thread.sleep(2000);
			}
			QaRobot.ScreenshotMethod("HotelTrip","<b><i>Screenshot for Hotel Trip</i></b>");
	}
	
	public static void flight_HotelTrip(String Trip,String OriginCityCode,String OriginLocation,String DestinationCityCode,String DestinationLocation,
			String DepartureDate,String ReturnDate,String Rooms,String Adult,String Child,String ChildAge,String Infant,String InfantAge,
			String MoreOptions,String Nationality,String Currency,String Class,String ShowDirectFlight,String MyHotelDiffenrentDate,
			String ChangeCheckIn,String ChangeCheckOut) throws Exception 
	{
			String DateSelection[]= DepartureDate.split(",");
			String monthAndYear = DateSelection[1];
			String expDate = DateSelection[0];
		
			String DateSelection1[]= ReturnDate.split(",");
			String monthAndYear1 = DateSelection1[1];
			String expDate1 = DateSelection1[0];
		

			if (Trip.equalsIgnoreCase("Domestic"))
			{
				TestBase.listofautosuggestion(By.xpath("//div[@id='div3']/p"), OriginCityCode, OriginLocation,By.xpath("//input[@id='txtFlightFromDynamic']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='div3']/p")).click();
				QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + OriginLocation);
				Thread.sleep(2000);
				
				TestBase.listofautosuggestion(By.xpath("//div[@id='div7']/p"), DestinationCityCode, DestinationLocation,By.xpath("//input[@id='txtFlightToDynamic']"));
				QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>" + DestinationLocation);
				Thread.sleep(2000);
			}
			else if (Trip.equalsIgnoreCase("International"))
			{
				TestBase.listofautosuggestion(By.xpath("//div[@id='div3']/p"), OriginCityCode, OriginLocation,By.xpath("//input[@id='txtFlightFromDynamic']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='div3']/p")).click();
				QaExtentReport.test.log(Status.INFO, "<b><i>Departure city : </i></b>" + OriginLocation);
				Thread.sleep(2000);
				
				TestBase.listofautosuggestion(By.xpath("//div[@id='div7']/p"), DestinationCityCode, DestinationLocation,By.xpath("//input[@id='txtFlightToDynamic']"));
				QaBrowser.driver.findElement(By.xpath("//div[@id='div7']/p")).click();
				QaExtentReport.test.log(Status.INFO, "<b><i>Arrival city : </i></b>" + DestinationLocation);
				Thread.sleep(2000);
			}
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[11]")).click();
			Thread.sleep(2000);
			
			while(true)
			{
				QaBrowser.driver.findElement(By.xpath("//input[@id='txtDepartDateDomesticHpF']")).clear();
				
				String text = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				if(text.equalsIgnoreCase(monthAndYear))
				{
					break;
				}
				else
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				}
			}
			
			List<WebElement> allDates = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
			
			for(WebElement ele : allDates)
			{
				String dt = ele.getText();
				
				if(dt.equalsIgnoreCase(expDate))
				{
					ele.click();
					break;
				}
			}
			
			QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[12]")).click();
			Thread.sleep(2000);
			
			while(true)
			{
				String text1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
				
				if(text1.equalsIgnoreCase(monthAndYear1))
				{
					break;
				}
				else
				{
					QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
				}
			}
			
			List<WebElement> allDates1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
			
			for(WebElement ele1 : allDates1)
			{
				String dt1 = ele1.getText();
				
				if(dt1.equalsIgnoreCase(expDate1))
				{
					ele1.click();
					break;
				}
			}
			
			int room=Integer.parseInt(Rooms);
			String[] adultcount=Adult.split(",");
			String[] childcount=Child.split(",");
			String[] infantcount=Infant.split(",");
			
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
					WebElement childrenage=QaBrowser.driver.findElement(By.xpath("//select[@id='Htl_fltChildAge"+chdcount+"_"+i+"']"));
					Select selectage=new Select(childrenage);
					selectage.selectByValue(ageofchild[i-1]);
					Thread.sleep(2000);
				}
			} 
			
			String[] ageofinfant=InfantAge.split(",");
			for(String ift:infantcount)
			{
				int iftcount=Integer.parseInt(ift);
				for(int i=1;i<=iftcount;i++)
				{
					WebElement infantrenage=QaBrowser.driver.findElement(By.xpath("//select[@id='Htl_fltInfantAge"+iftcount+"_"+i+"']"));
					Select selectage=new Select(infantrenage);
					selectage.selectByValue(ageofinfant[i-1]);
					Thread.sleep(2000);
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
				
				if(ShowDirectFlight.equalsIgnoreCase("Yes")) 
				{
					QaRobot.ClickOnElement("ShowDirectFlightsOnly");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Show Direct Flights Only</i></b>");
				}
				
				if(MyHotelDiffenrentDate.equalsIgnoreCase("Yes")) 
				{
					QaRobot.ClickOnElement("MyHotelCheckin");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on My Hotel Check In</i></b>");
					
					String DateSelectionFH[]= ChangeCheckIn.split(",");
					String monthAndYearFH = DateSelectionFH[1];
					String expDateFH = DateSelectionFH[0];
				
					String DateSelection1FH1[]= ChangeCheckOut.split(",");
					String monthAndYearFH1 = DateSelection1FH1[1];
					String expDateFH1 = DateSelection1FH1[0];
					
					QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[13]")).click();
					Thread.sleep(2000);
					
					while(true)
					{
						String text = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
						
						if(text.equalsIgnoreCase(monthAndYearFH))
						{
							break;
						}
						else
						{
							QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
						}
					}
					
					List<WebElement> allDatesFH = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
					
					for(WebElement ele : allDatesFH)
					{
						String dt = ele.getText();
						
						if(dt.equalsIgnoreCase(expDateFH))
						{
							ele.click();
							break;
						}
					}
					
					QaBrowser.driver.findElement(By.xpath("(//img[@alt='Popup'])[14]")).click();
					Thread.sleep(2000);
					
					while(true)
					{
						String text1 = QaBrowser.driver.findElement (By.xpath("/html/body/div[4]/div/div[2]/div[1]/div")).getText();
						
						if(text1.equalsIgnoreCase(monthAndYearFH1))
						{
							break;
						}
						else
						{
							QaBrowser.driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/a[3]")).click();
						}
					}
					
					List<WebElement> allDatesFH1 = QaBrowser.driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div[1]/table/tbody/tr/td"));
					
					for(WebElement ele1 : allDatesFH1)
					{
						String dt1 = ele1.getText();
						
						if(dt1.equalsIgnoreCase(expDateFH1))
						{
							ele1.click();
							break;
						}
					}
				}
			}
			QaRobot.ScreenshotMethod("Flight_HotelTrip","<b><i>Screenshot for Flight+Hotel Trip</i></b>");
	 }
}



