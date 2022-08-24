package v12Staging;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class B2cResultPage 
{
	public static void ResultPageForFlight(String TripType,String Applyfilter,String FareType,String AirLine,String Trip) throws Exception
	{
		QaRobot.ClickOnElement("FinalSearchF");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FinalSearch</i></b>");
		Thread.sleep(15000);
		
		QaRobot.ScreenshotMethod("ResultPage","<b><i>Screenshot for Result Page</i></b>");
		
		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		if(Applyfilter.equalsIgnoreCase("Yes"))
		{
			if(FareType.equalsIgnoreCase("All"))
			{
				QaRobot.ClickOnElement("Refundable");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ClickOnElement("NonRefundable");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(3000);
			}
			else if(FareType.equalsIgnoreCase("Refundable"))
			{
				QaRobot.ClickOnElement("Refundable");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(3000);
			}
			else if(FareType.equalsIgnoreCase("Non-Refundable"))
			{
				QaRobot.ClickOnElement("NonRefundable");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(3000);
			}
			
			List<WebElement> listOfAirLine = QaBrowser.driver.findElements(By.xpath("(//div[@id='tdContainerTblAirlines'])[2]//li//span"));
			
			for (WebElement autoAirline : listOfAirLine) 
			  {
				if (autoAirline.getText().equalsIgnoreCase(AirLine)) 
				{
					autoAirline.click();
					break;
				} 
				else 
				{
					
				}
			  }
			QaRobot.ScreenshotMethod("Applyfilter","<b><i>Screenshot for Apply filter</i></b>");
		}
		
		if (Trip.equalsIgnoreCase("Domestic"))
		{
			if(TripType.equalsIgnoreCase("OneWay"))
			{
				WebElement FlightItinerary = QaBrowser.driver.findElement(By.xpath("(//a[@class='flght-itnry ng-binding'])[1]"));
				JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
				js1.executeScript("arguments[0].click()", FlightItinerary);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FlightItinerary</i></b>");
				Thread.sleep(5000);
				
				WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-brkp ng-binding'])[1]"));
				JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
				js2.executeScript("arguments[0].click()", FareBreakup);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreakup</i></b>");
				Thread.sleep(5000);
				
				QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
				
				WebElement FareRules = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-rule ng-binding'])[1]"));
				JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
				js3.executeScript("arguments[0].click()", FareRules);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareRules</i></b>");
				Thread.sleep(5000);
				
				QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
				
				WebElement BaggegeInformation = QaBrowser.driver.findElement(By.xpath("(//a[@class='bgag-infrmtn ng-binding'])[1]"));
				JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
				js4.executeScript("arguments[0].click()", BaggegeInformation);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on BaggegeInformation</i></b>");
				Thread.sleep(5000);
				
				QaRobot.ScreenshotMethod("BaggegeInformation","<b><i>Screenshot for Baggege Information</i></b>");
				
				WebElement BookNow = QaBrowser.driver.findElement(By.xpath("(//input[@class='btn_smallyellow ng-scope'])[1]"));
				JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
				js.executeScript("arguments[0].click()", BookNow);
				QaExtentReport.test.log(Status.INFO, "<b><i>Click on BookNow</i></b>");
				Thread.sleep(50000);
			}
			else if(TripType.equalsIgnoreCase("RoundTrip"))
			{
				QaRobot.ClickOnElement("RDFareBreakup");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
				
				String ParentWindow = QaBrowser.driver.getWindowHandle();
				Set<String> handles = QaBrowser.driver.getWindowHandles();
				for (String childWindow : handles) 
				{
					if (!childWindow.equals(ParentWindow))
						QaBrowser.driver.switchTo().window(childWindow);
				}
				QaRobot.ClickOnElement("RDFareBreakupClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow);
				
				QaRobot.ClickOnElement("RDRulesBaggage");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("RulesBaggage","<b><i>Screenshot for Rules Baggage</i></b>");
				
				String ParentWindow1 = QaBrowser.driver.getWindowHandle();
				Set<String> handles1 = QaBrowser.driver.getWindowHandles();
				for (String childWindow1 : handles1) 
				{
					if (!childWindow1.equals(ParentWindow1))
						QaBrowser.driver.switchTo().window(childWindow1);
				}
				Thread.sleep(3000);
				
				QaRobot.ClickOnElement("RDBaggageInformation");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ScreenshotMethod("BaggageInformation","<b><i>Screenshot for Baggage Information</i></b>");
				
				QaRobot.ClickOnElement("RDRulesBaggageClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow1);
				
				QaRobot.ClickOnElement("RDRFareBreakup");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
				
				String ParentWindow2 = QaBrowser.driver.getWindowHandle();
				Set<String> handles2 = QaBrowser.driver.getWindowHandles();
				for (String childWindow2 : handles2) 
				{
					if (!childWindow2.equals(ParentWindow2))
						QaBrowser.driver.switchTo().window(childWindow2);
				}
				QaRobot.ClickOnElement("RDRFareBreakupClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow2);
				
				QaRobot.ClickOnElement("RDRRulesBaggage");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(3000);
				
				QaRobot.ScreenshotMethod("RulesBaggage","<b><i>Screenshot for Rules Baggage</i></b>");
				
				String ParentWindow3 = QaBrowser.driver.getWindowHandle();
				Set<String> handles3 = QaBrowser.driver.getWindowHandles();
				for (String childWindow3 : handles3) 
				{
					if (!childWindow3.equals(ParentWindow3))
						QaBrowser.driver.switchTo().window(childWindow3);
				}
				Thread.sleep(3000);
				
				QaRobot.ClickOnElement("RDRFareRules");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
				
				QaRobot.ClickOnElement("RDRRulesBaggageClose");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(2000);
				QaBrowser.driver.switchTo().window(ParentWindow);
				
				QaRobot.ClickOnElement("ContinueButton");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FlightItinerary</i></b>");
				Thread.sleep(30000);
			}
			
		}
		else if (Trip.equalsIgnoreCase("International"))
		{
			WebElement FlightItinerary = QaBrowser.driver.findElement(By.xpath("(//a[@class='flght-itnry ng-binding'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", FlightItinerary);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FlightItinerary</i></b>");
			Thread.sleep(5000);
			
			WebElement FareBreakup = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-brkp ng-binding'])[1]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", FareBreakup);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareBreakup</i></b>");
			Thread.sleep(5000);
			
			QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
			
			WebElement FareRules = QaBrowser.driver.findElement(By.xpath("(//a[@class='fare-rule ng-binding'])[1]"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", FareRules);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareRules</i></b>");
			Thread.sleep(5000);
			
			QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
			
			WebElement BaggegeInformation = QaBrowser.driver.findElement(By.xpath("(//a[@class='bgag-infrmtn ng-binding'])[1]"));
			JavascriptExecutor js4 = (JavascriptExecutor) QaBrowser.driver;
			js4.executeScript("arguments[0].click()", BaggegeInformation);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on BaggegeInformation</i></b>");
			Thread.sleep(5000);
			
			QaRobot.ScreenshotMethod("BaggegeInformation","<b><i>Screenshot for Baggege Information</i></b>");
			
			WebElement BookNow = QaBrowser.driver.findElement(By.xpath("(//input[@class='btn_smallyellow ng-scope'])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", BookNow);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on BookNow</i></b>");
			Thread.sleep(30000);
		}
		
		QaRobot.ClickOnElement("FareBreakup1F");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Checkout FareBreakup</i></b>");
		Thread.sleep(7000);
		
		QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
		
		QaRobot.ClickOnElement("FareRules1F");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Checkout FareRules</i></b>");
		Thread.sleep(7000);
		
		QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
		
		QaRobot.ClickOnElement("BaggegeInformation1F");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Checkout BaggegeInformation</i></b>");
		Thread.sleep(7000);
		
		QaRobot.ScreenshotMethod("BaggegeInformation","<b><i>Screenshot for Baggege Information</i></b>");
	}
	
	public static void ResultPageForHotel(String Rooms) throws Exception
	{
		QaRobot.ClickOnElement("FinalSearch");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FinalSearch</i></b>");
		Thread.sleep(20000);
		
		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		QaRobot.ClickOnElement("SelectRoom");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on SelectRoom</i></b>");
		Thread.sleep(3000);
		
		if (Rooms.equalsIgnoreCase("1"))
		{
			QaRobot.ClickOnElement("CancellationPolicy");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicy</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("CancellationPolicy","<b><i>Screenshot for Cancellation Policy</i></b>");
			
			String ParentWindow4 = QaBrowser.driver.getWindowHandle();
			Set<String> handles4 = QaBrowser.driver.getWindowHandles();
			for (String childWindow4 : handles4) 
			{
				if (!childWindow4.equals(ParentWindow4))
					QaBrowser.driver.switchTo().window(childWindow4);
			}
			
			QaRobot.ClickOnElement("CPClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicyClose</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow4);
			
			QaRobot.ClickOnElement("FareBreakup");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
			
			String ParentWindow5 = QaBrowser.driver.getWindowHandle();
			Set<String> handles5 = QaBrowser.driver.getWindowHandles();
			for (String childWindow5 : handles5) 
			{
				if (!childWindow5.equals(ParentWindow5))
					QaBrowser.driver.switchTo().window(childWindow5);
			}
			
			QaRobot.ClickOnElement("FareBreakupClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakupClose</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow5);
			
			QaRobot.ClickOnElement("Book");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
			Thread.sleep(20000);
		}
		else 
		{
			QaRobot.ClickOnElement("CancellationPolicy1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicy</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("CancellationPolicy","<b><i>Screenshot for Cancellation Policy</i></b>");
			
			String ParentWindow4 = QaBrowser.driver.getWindowHandle();
			Set<String> handles4 = QaBrowser.driver.getWindowHandles();
			for (String childWindow4 : handles4) 
			{
				if (!childWindow4.equals(ParentWindow4))
					QaBrowser.driver.switchTo().window(childWindow4);
			}
			
			QaRobot.ClickOnElement("CPClose1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicyClose</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow4);
			
			QaRobot.ClickOnElement("FareBreakup1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
			
			String ParentWindow5 = QaBrowser.driver.getWindowHandle();
			Set<String> handles5 = QaBrowser.driver.getWindowHandles();
			for (String childWindow5 : handles5) 
			{
				if (!childWindow5.equals(ParentWindow5))
					QaBrowser.driver.switchTo().window(childWindow5);
			}
			
			QaRobot.ClickOnElement("FareBreakupClose1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakupClose</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow5);
			
			QaRobot.ClickOnElement("Book1");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
			Thread.sleep(20000);
		}
		
		QaRobot.ClickOnElement("CFareBreakup");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicy</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("FareBreakup","<b><i>Screenshot for Fare Breakup</i></b>");
		
		String ParentWindow4 = QaBrowser.driver.getWindowHandle();
		Set<String> handles4 = QaBrowser.driver.getWindowHandles();
		for (String childWindow4 : handles4) 
		{
			if (!childWindow4.equals(ParentWindow4))
				QaBrowser.driver.switchTo().window(childWindow4);
		}
		
		QaRobot.ClickOnElement("CFareBreakupClose");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on CancellationPolicyClose</i></b>");
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().window(ParentWindow4);
		
		QaRobot.ClickOnElement("MoreDetails");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakup</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
		
		String ParentWindow5 = QaBrowser.driver.getWindowHandle();
		Set<String> handles5 = QaBrowser.driver.getWindowHandles();
		for (String childWindow5 : handles5) 
		{
			if (!childWindow5.equals(ParentWindow5))
				QaBrowser.driver.switchTo().window(childWindow5);
		}
		
		QaRobot.ClickOnElement("MoreDetailsClose");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FareBreakupClose</i></b>");
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().window(ParentWindow5);
	}
	
	public static void ResultPageForFlight_Hotel(String Applyfilter,String StarRating,String PropertyType,String RateType,String ChooseAnotherFlight,
			String FlightFilter,String FareType,String AirLine) throws Exception
	{
		QaRobot.ClickOnElement("FinalSearchFH");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Final Search</i></b>");
		Thread.sleep(20000);
		
		String url = QaBrowser.driver.getCurrentUrl();
		String[] uid = url.split("=");
		QaExtentReport.test.log(Status.INFO, "<b><i>Session id is </i></b>" + uid[1]);
		
		if(Applyfilter.equalsIgnoreCase("Yes"))
		{
			if(StarRating.equalsIgnoreCase("All"))
			{
				
			}
			else if(StarRating.equalsIgnoreCase("1 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			else if(StarRating.equalsIgnoreCase("2 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("3 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("4 StarAndAbove"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TreeStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("5 Star"))
			{
				QaRobot.ClickOnElement("NotRatedStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TreeStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("FourStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(StarRating.equalsIgnoreCase("NotRatedStar"))
			{
				QaRobot.ClickOnElement("OneStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TwoStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("TreeStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("FourStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
				
				QaRobot.ClickOnElement("FiveStar");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			if(PropertyType.equalsIgnoreCase("All"))
			{
				
			}
			
			else if(PropertyType.equalsIgnoreCase("Hotel"))
			{
				QaRobot.ClickOnElement("Apartment");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(PropertyType.equalsIgnoreCase("Apartment"))
			{
				QaRobot.ClickOnElement("Hotel");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			if(RateType.equalsIgnoreCase("All"))
			{
				
			}
			
			else if(RateType.equalsIgnoreCase("RoomRate"))
			{
				QaRobot.ClickOnElement("PackageRate");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
			
			else if(RateType.equalsIgnoreCase("PackageRate"))
			{
				QaRobot.ClickOnElement("RoomRate");
				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
				Thread.sleep(2000);
			}
		}
		QaRobot.ScreenshotMethod("Applyfilter","<b><i>Screenshot for Apply filter</i></b>");
		
		if(ChooseAnotherFlight.equalsIgnoreCase("Yes"))
		{
			QaRobot.ClickOnElement("chooseAnotherFlight");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
			Thread.sleep(3000);
			
			if(FlightFilter.equalsIgnoreCase("Yes"))
			{
				if(FareType.equalsIgnoreCase("All"))
				{
					QaRobot.ClickOnElement("RefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
					Thread.sleep(3000);
					
					QaRobot.ClickOnElement("NonRefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
					Thread.sleep(3000);
				}
				else if(FareType.equalsIgnoreCase("Refundable"))
				{
					QaRobot.ClickOnElement("RefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Refundable</i></b>");
					Thread.sleep(3000);
				}
				else if(FareType.equalsIgnoreCase("Non-Refundable"))
				{
					QaRobot.ClickOnElement("NonRefundableFH");
					QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on NonRefundable</i></b>");
					Thread.sleep(3000);
				}
				
				List<WebElement> listOfAirLine = QaBrowser.driver.findElements(By.xpath("//div[@id='tdContainerTblAirlines']//li//span"));
				
				for (WebElement autoAirline : listOfAirLine) 
				  {
					if (autoAirline.getText().equalsIgnoreCase(AirLine)) 
					{
						autoAirline.click();
						break;
					} 
					else 
					{
						
					}
				  }
			}
			QaRobot.ScreenshotMethod("FlightFilter","<b><i>Screenshot for Flight Filter</i></b>");
			
			WebElement FareRules = QaBrowser.driver.findElement(By.xpath("(//a[contains(@title,'Fare Rules')])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) QaBrowser.driver;
			js.executeScript("arguments[0].click()", FareRules);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on FareRules</i></b>");
			Thread.sleep(5000);
			
			QaRobot.ScreenshotMethod("FareRules","<b><i>Screenshot for Fare Rules</i></b>");
			
			String ParentWindow = QaBrowser.driver.getWindowHandle();
			Set<String> handles = QaBrowser.driver.getWindowHandles();
			for (String childWindow : handles) 
			{
				if (!childWindow.equals(ParentWindow))
					QaBrowser.driver.switchTo().window(childWindow);
			}
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules Close</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow);
			
			WebElement BaggegeInformation = QaBrowser.driver.findElement(By.xpath("(//a[@id='BaggageDetails_1'])[1]"));
			JavascriptExecutor js1 = (JavascriptExecutor) QaBrowser.driver;
			js1.executeScript("arguments[0].click()", BaggegeInformation);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Baggege Information</i></b>");
			Thread.sleep(5000);
			
			QaRobot.ScreenshotMethod("BaggegeInformation","<b><i>Screenshot for Baggege Information</i></b>");
			
			String ParentWindow1 = QaBrowser.driver.getWindowHandle();
			Set<String> handles1 = QaBrowser.driver.getWindowHandles();
			for (String childWindow1 : handles1) 
			{
				if (!childWindow1.equals(ParentWindow1))
					QaBrowser.driver.switchTo().window(childWindow1);
			}
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggege Information Close</i></b>");
			Thread.sleep(2000);
			QaBrowser.driver.switchTo().window(ParentWindow1);
			
			WebElement MoreDetails = QaBrowser.driver.findElement(By.xpath("(//a[@id='fl_1'])[1]"));
			JavascriptExecutor js2 = (JavascriptExecutor) QaBrowser.driver;
			js2.executeScript("arguments[0].click()", MoreDetails);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on More Details</i></b>");
			Thread.sleep(5000);
			
			QaRobot.ScreenshotMethod("MoreDetails","<b><i>Screenshot for More Details</i></b>");
			
			WebElement BookNow = QaBrowser.driver.findElement(By.xpath("(//input[contains(@id,'Anchor_01UAP')])[1]"));
			JavascriptExecutor js3 = (JavascriptExecutor) QaBrowser.driver;
			js3.executeScript("arguments[0].click()", BookNow);
			QaExtentReport.test.log(Status.INFO, "<b><i>Click on Book Flight</i></b>");
			Thread.sleep(50000);
		}
		
		else if(ChooseAnotherFlight.equalsIgnoreCase("No"))
		{
			QaRobot.ClickOnElement("FlightFareRule");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("FlightFareRule","<b><i>Screenshot for Flight Fare Rule</i></b>");
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Fare Rules Close</i></b>");
			Thread.sleep(2000);
			
			QaRobot.ClickOnElement("BaggegeDetails");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggege Information</i></b>");
			Thread.sleep(3000);
			
			QaRobot.ScreenshotMethod("BaggegeDetails","<b><i>Screenshot for Baggege Details</i></b>");
			
			QaRobot.ClickOnElement("FRBClose");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Baggege Information Close</i></b>");
			Thread.sleep(2000);
		}
		
		QaRobot.ClickOnElement("FHSelectRoom");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Select Room</i></b>");
		Thread.sleep(3000);
		
		QaRobot.ClickOnElement("RoomCancellationPolicy");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Room Cancellation Policy</i></b>");
		Thread.sleep(2000);
		
		QaRobot.ScreenshotMethod("RoomCancellationPolicy","<b><i>Screenshot for Room Cancellation Policy</i></b>");
		
		QaRobot.ClickOnElement("RoomCancellationPolicyClose");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Room Cancellation Policy Close</i></b>");
		Thread.sleep(2000);
		
		QaRobot.ClickOnElement("FHBook");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Book</i></b>");
		Thread.sleep(15000);
	}
}



























