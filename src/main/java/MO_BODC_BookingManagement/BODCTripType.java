package MO_BODC_BookingManagement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class BODCTripType {
	public static WebDriver driver;

	public static void flightTriptype(String TripType, String OriginCityCode, String OriginLocation,
			String DestinationCityCode, String DestinationLocation, String DepartureDate, String ReturnDate,
			String SelectTraveller, String Adult, String Youth, String Child, String Infant, String Class,
			String PreAirline, String PANumber, String PreferredAirlineSelect, String ShowDirectFlight,
			String MyDatesAreFlexible, String ChooseSupplier, String SupNumber, String SelectSupplier)
			throws Exception {
		String DateSelection[] = DepartureDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		String DateSelection1[] = ReturnDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		if (TripType.equalsIgnoreCase("OneWay")) {
			QaRobot.ClickOnElement("DCOneWay");
		} else if (TripType.equalsIgnoreCase("RoundTrip")) {
			QaRobot.ClickOnElement("DCRoundTrip");
		}
		Assert.assertFalse(OriginCityCode == DestinationCityCode, "Origin And Destination City Code Can't Be Same");
		Assert.assertFalse(OriginLocation == DestinationLocation, "Origin And Destination City Location Can't Be Same");
		TestBase.listofautosuggestion(By.xpath("//div[@id='divDepartureCity']/p"), OriginCityCode, OriginLocation,
				By.xpath("//input[@id='txtDepartureCity']"));
		Thread.sleep(2000);
		QaBrowser.driver.findElement(By.xpath("//div[@id='divDepartureCity']/p")).click();
		QaExtentReport.test.log(Status.INFO,
				"<b><i>Departure city : </i></b>" + OriginCityCode + " - " + OriginLocation);
		Thread.sleep(2000);
		TestBase.listofautosuggestion(By.xpath("//div[@id='divDestinationCity']/p"), DestinationCityCode,
				DestinationLocation, By.xpath("//input[@id='txtDestinationCity']"));
		Thread.sleep(2000);
		QaBrowser.driver.findElement(By.xpath("//div[@id='divDestinationCity']/p")).click();
		QaExtentReport.test.log(Status.INFO,
				"<b><i>Arrival city : </i></b>" + DestinationCityCode + " - " + DestinationLocation);
		Thread.sleep(2000);
		QaBrowser.driver.findElement(By.xpath("//div[@id='flight_way1']/div[2]/div[1]/label/span[2]/a/img")).click();
		Thread.sleep(2000);
		if (TripType.equalsIgnoreCase("OneWay")) {
			selectDateInCalendarOneWay(expDate, month, year);
		} else if (TripType.equalsIgnoreCase("RoundTrip")) {
			selectDateInCalendarRoundTrip(expDate, month, year, expDate1, month1, year1);
		}
		if (SelectTraveller.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("Travellers");
			QaRobot.selectValueFromDropdown("DCAdult", Adult, "<b><i>Select adult for booking</i></b>" + " - " + Adult);
			Thread.sleep(2000);
//			QaRobot.selectValueFromDropdown("DCYouth", Youth, "<b><i>Select adult for booking</i></b>" + " - " + Youth);
//			Thread.sleep(2000);
			QaRobot.selectValueFromDropdown("DCChild", Child, "<b><i>Select child for booking</i></b>" + " - " + Child);
			Thread.sleep(2000);
			QaRobot.selectValueFromDropdown("DCInfant", Infant,
					"<b><i>Select infant for booking</i></b>" + " - " + Infant);
			Thread.sleep(2000);
			QaRobot.ClickOnElement("Travellers");
		}
		QaRobot.selectTextByLocator("//select[@id='ddlClass']", Class,
				"<b><i>Select Class for booking </i></b>" + Class);
		Thread.sleep(2000);
		if (PreAirline.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("PreferredAirline");
			Thread.sleep(2000);
			int pAS = Integer.parseInt(PANumber);
			for (int i = 1; i <= pAS; i++) {
				String[] tN = PreferredAirlineSelect.split(",");
				String b = tN[i - 1];
				TestBase.listofautosuggestion1(By.xpath("//div[@id='DivPreferedAirline']/div/div/div/ul/li"), b,
						By.xpath("//div[@id='DivPreferedAirline']/div/div/div/div[1]/input"));
			}
		}
		if (ShowDirectFlight.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("DCShowDirectFlight");
		}
		if (MyDatesAreFlexible.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("DCMyDatesAreFlexible");
		}
		if (ChooseSupplier.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("SelectAll");
			int pAS = Integer.parseInt(SupNumber);
			for (int i = 1; i <= pAS; i++) {
				String[] tN = SelectSupplier.split(",");
				String b = tN[i - 1];
				List<WebElement> listOfSupplier = QaBrowser.driver
						.findElements(By.xpath("//div[@id='divSuppliers']/div/label"));
				for (WebElement autoSupplier : listOfSupplier) {
					if (autoSupplier.getText().equalsIgnoreCase(b)) {
						autoSupplier.click();
						QaExtentReport.test.log(Status.INFO, "<b><i>Select Supplier</i></b>" + " " + i + " " + b);
						break;
					}
				}
			}
		}
		try {
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("DCFlight");
		} catch (Exception e) {
			throw (e);
		}
	}

	public static void selectDateInCalendarOneWay(String Day, String Month, String Year) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);

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
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Date  </i></b>" + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];
		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
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

	public static void selectDateInCalendarRoundTrip(String Day, String Month, String Year, String Day1, String Month1,
			String Year1) throws Exception {
		Date date = new Date();
		DateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		String NewDate = d.format(date);
		Date date1 = d.parse(NewDate);

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

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

		Assert.assertFalse(Integer.parseInt(Day) > 31, "Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day) > 28,
				"Invalid date provided " + Day + "-" + Month + "-" + Year);
		Assert.assertFalse(Integer.parseInt(Day1) > 31, "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		Assert.assertFalse(Month.equals("Feb") && Integer.parseInt(Day1) > 28,
				"Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);

		String monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		String month = monthYear.split(" ")[0];
		String year = monthYear.split(" ")[1];
		Assert.assertFalse(date2.before(date1), "Invalid date provided " + Day + "-" + Month + "-" + Year);
		while (!(month.equals(Month) && year.equals(Year))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
			monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
			month = monthYear.split(" ")[0];
			year = monthYear.split(" ")[1];
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
//			QaBrowser.driver.findElement(By.xpath("//div[@id='divReturnDate']/div/div[1]/label/span[2]/a/img")).click();
		Thread.sleep(2000);
		String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
		String month1 = monthYear1.split(" ")[0];
		String year1 = monthYear1.split(" ")[1];
		Assert.assertFalse(date3.before(date2), "Invalid date provided " + Day1 + "-" + Month1 + "-" + Year1);
		while (!(month1.equals(Month1) && year1.equals(Year1))) {
			QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();
			monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();
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

	public static void hotelTrip(String CityCode, String CityTitle, String CheckInDate, String CheckOutDate,
			String Rooms, String Adult, String Child, String ChildAge, String ChooseSupplier, String SupNumber,
			String SelectSupplier, String MoreOptions, String Currency, String StarRating) throws Exception {
		TestBase.listofautosuggestion(By.xpath("//div[@id='divHTCity']/p"), CityCode, CityTitle,
				By.xpath("//input[@id='txtHotelSearch']"));
		Thread.sleep(2000);
		QaBrowser.driver.findElement(By.xpath("//div[@id='divHTCity']/p")).click();
		QaExtentReport.test.log(Status.INFO, "<b><i>City Name : </i></b>" + CityCode + "-" + CityTitle);
		Thread.sleep(2000);

		QaBrowser.driver.findElement(By.xpath("//form[@id='HotelSearchCntrl']/div/div[3]/div[1]/label/span[2]/a/img"))
				.click();
		Thread.sleep(2000);

		String DateSelection[] = CheckInDate.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];

		String DateSelection1[] = CheckOutDate.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];

		selectDateInCalendarHotel(expDate, month, year, expDate1, month1, year1);

		int room = Integer.parseInt(Rooms);
		String[] adultcount = Adult.split(",");
		String[] childcount = Child.split(",");

		if (room > 5) {
			throw new BODCExceptionClass("Invalid Number of Rooms provided " + " : " + room);
		} else {
//			for (int i = 1; i < room; i++) {
//				QaRobot.ClickOnElement("AddRoom");
//				QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on AddRoom</i></b>");
//		}
			WebElement roomelement = QaBrowser.driver.findElement(By.xpath("//select[@id='HtlRooms']"));
			Select selectroom = new Select(roomelement);
			selectroom.selectByValue(Rooms);
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

			String[] ageofchild = ChildAge.split(",");
			for (String chd : childcount) {
				int chdcount = Integer.parseInt(chd);
				for (int i = 1; i <= chdcount; i++) {
					String ac = ageofchild[i - 1];
					int ac1 = Integer.parseInt(ac);

					if (ac1 > 17) {
						QaExtentReport.test.log(Status.FAIL, "<b><i>Invalid Child Age Selection</i></b>" + " : " + ac1);
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

//		QaRobot.selectTextFromDropdown("Nationality", Nationality, "<b><i>Select Nationality</i></b>");
//		Thread.sleep(2000);

		if (ChooseSupplier.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("DCSelectAll");
			int pAS = Integer.parseInt(SupNumber);
			for (int i = 1; i <= pAS; i++) {
				String[] tN = SelectSupplier.split(",");
				String b = tN[i - 1];
				List<WebElement> listOfSupplier = QaBrowser.driver
						.findElements(By.xpath("(//div[@id='divSuppliers']/div/label)[2]"));
				for (WebElement autoSupplier : listOfSupplier) {
					if (autoSupplier.getText().equalsIgnoreCase(b)) {
						autoSupplier.click();
						QaExtentReport.test.log(Status.INFO, "<b><i>Select Supplier</i></b>" + " " + i + " " + b);
						break;
					}
				}
			}
		}

		if (MoreOptions.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("DCMoreOptionsH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MoreOptions</i></b>");
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("DCCurrencyH", Currency, "<b><i>Select Currency for booking</i></b>");
			Thread.sleep(2000);

			QaRobot.selectValueFromDropdown("DCStarRating", StarRating, "<b><i>Select Star Rating for booking</i></b>");
			Thread.sleep(2000);
		}

		try {
			QaExtentReport.extentScreenshot("Search Page");
			QaRobot.ClickOnElement("DCHotelFinalSearch");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on FinalSearch</i></b>");
			QaRobot.ScreenshotMethod("HotelTrip", "<b><i>Screenshot for Hotel Trip</i></b>");
		} catch (Exception e) {
			throw (e);
		}
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

		QaExtentReport.test.log(Status.INFO, "<b><i>Select Departure Date  </i></b>" + Day + "-" + Month + "-" + Year);
		QaExtentReport.test.log(Status.INFO, "<b><i>Select Return Date  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);

//		QaBrowser.driver.findElement(By.xpath("//input[@id='txtDepartHotelDateInternational']")).clear();

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
		String year = monthYear.split(" ")[1];

		if (date2.before(date1)) {
			System.out.println("Invalid date provided " + Day + "-" + Month + "-" + Year);
			QaExtentReport.test.log(Status.FAIL,
					"<b><i>Invalid date provided  </i></b>" + Day + "-" + Month + "-" + Year);
			throw new BODCExceptionClass("Invalid date provided " + Day + "-" + Month + "-" + Year);
		} else {
			while (!(month.equals(Month) && year.equals(Year))) {
				QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a[3]")).click();

				monthYear = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div")).getText();

				month = monthYear.split(" ")[0];
				year = monthYear.split(" ")[1];
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

//			QaBrowser.driver
//					.findElement(By.xpath("//form[@id='HotelSearchCntrl']/div/div[3]/div[2]/label/span[2]/a/img"))
//					.click();
//			Thread.sleep(2000);

//			QaBrowser.driver.findElement(By.xpath("//input[@id='txtReturnHotelDateInternational']")).clear();
			Thread.sleep(3000);
			String monthYear1 = QaBrowser.driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div"))
					.getText();
			Thread.sleep(3000);
			String month1 = monthYear1.split(" ")[0];
			Thread.sleep(3000);
			String year1 = monthYear1.split(" ")[1];

			if (date3.before(date2)) {
				QaExtentReport.test.log(Status.FAIL,
						"<b><i>Invalid Check out date provided  </i></b>" + Day1 + "-" + Month1 + "-" + Year1);
				throw new BODCExceptionClass("Invalid Check out date provided " + Day1 + "-" + Month1 + "-" + Year1);
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
}
