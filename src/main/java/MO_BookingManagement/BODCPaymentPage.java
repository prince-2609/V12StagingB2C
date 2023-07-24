package MO_BookingManagement;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import Base.TestBase;
import utilities.QaExtentReport;
import utilities.QaRobot;

public class BODCPaymentPage {
	public static void cardPayment(String CardType, String CreditCardNumber, String CardHolderName,
			String CardExpiryDate, String CVV, String BillingAddress, String BillingState, String CardCity)
			throws Exception {
		if (CardType.equalsIgnoreCase("MasterCard")) {
			QaRobot.ClickOnElement("MasterCard");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MasterCard</i></b>");
			cardDetailsForFlight(CreditCardNumber, CardHolderName, CardExpiryDate, CVV, BillingAddress, BillingState,
					CardCity);
		} else if (CardType.equalsIgnoreCase("VisaCard")) {
			QaRobot.ClickOnElement("VisaCard");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on VisaCard</i></b>");
			cardDetailsForFlight(CreditCardNumber, CardHolderName, CardExpiryDate, CVV, BillingAddress, BillingState,
					CardCity);
		}
	}

	public static void cardPaymentHotel(String Cardtype, String CardNumber, String CardName,
			String CardDate, String CVV) throws Exception {
		if (Cardtype.equalsIgnoreCase("Master Card")) {
			QaRobot.ClickOnElement("MasterCardH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on MasterCard</i></b>");
			cardPaymentForHotel(Cardtype, CardNumber, CardName, CardDate, CVV);
		} else if (Cardtype.equalsIgnoreCase("VisaCard")) {
			QaRobot.ClickOnElement("VisaCardH");
			QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on VisaCard</i></b>");
			cardPaymentForHotel(Cardtype, CardNumber, CardName, CardDate, CVV);
		}
	}

	public static void cardDetailsForFlight(String CreditCardNumber, String CardHolderName, String CardExpiryDate,
			String CVV, String BillingAddress, String BillingState, String CardCity) throws Exception {
		QaRobot.PassValue("CreditCardNumber", CreditCardNumber);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Credit Card Number</i></b>");

		QaRobot.PassValue("CreditHolderName", CardHolderName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Credit Holder Name</i></b>");

		String cardDate[] = CardExpiryDate.split(",");
		String month = cardDate[0];
		String year = cardDate[1];
		String cardMonth = "//div[@id='CCTab']/div/div[2]/div[3]/div/div[1]/div/div[1]/select";
		QaRobot.selectTextByLocator1(cardMonth, month, "<b><i>Selected Expiry Month</i></b>");

		String cardYear = "//div[@id='CCTab']/div/div[2]/div[3]/div/div[1]/div/div[2]/select";
		QaRobot.selectTextByLocator1(cardYear, year, "<b><i>Selected Expiry Year</i></b>");

		QaRobot.PassValue("CardCVVNumber", CVV);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write CVV Number</i></b>");

		QaRobot.PassValue("BillingAddressF", BillingAddress);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Billing Address</i></b>");

		String billingState = "(//select[@id='ddlBillingState'])[1]";
		QaRobot.selectTextByLocator1(billingState, BillingState, "<b><i>Selected Billing State</i></b>");

		String cardCity[] = CardCity.split(",");
		String cityCode = cardCity[0];
		String cityLocation = cardCity[1];
		TestBase.listofautosuggestion4(By.xpath("//div[@id='divCityCC']/p"), cityCode, cityLocation,
				By.xpath("(//input[@id='txtBillingCity'])[1]"));
		QaRobot.ScreenshotMethod("cardPayment", "<b><i>Screenshot for Card Payment</i></b>");
		QaExtentReport.extentScreenshot("Card Payment");

		QaRobot.PassValue("BZipCodeF", "12345");

		QaRobot.ClickOnElement("CreditPayNow");
		QaExtentReport.test.log(Status.INFO, "<b><i>Clicked on Credit Pay Now</i></b>");
	}

	public static void cardPaymentForHotel(String Cardtype, String CardNumber, String CardName, String CardDate,
			String CVV) throws Exception {
//		String cardType = "//select[@id='ctl00_contentMain_ddlCardCC']";
//		QaRobot.selectTextByLocator1(cardType, Cardtype, "<b><i>Select Card Type</i></b>");
//		Thread.sleep(2000);

		QaRobot.PassValue("Credit_card_number", CardNumber);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Card Number</i></b>");

		QaRobot.PassValue("Credit_card_name", CardName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Card Name</i></b>");

		String cardDate[] = CardDate.split(",");
		String month = cardDate[0];
		String year = cardDate[1];
		String cardMonth = "//select[@id='ctl00_contentMain_dobExp_ddlMonth']";
		QaRobot.selectTextByLocator1(cardMonth, month, "<b><i>Selecte Card Month</i></b>");

		String cardYear = "//select[@id='ctl00_contentMain_dobExp_ddlYear']";
		QaRobot.selectTextByLocator1(cardYear, year, "<b><i>Select Card Year</i></b>");

		QaRobot.PassValue("CardCVV", CVV);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write CVV Number</i></b>");
		QaRobot.ScreenshotMethod("cardPayment", "<b><i>Screenshot for Card Payment</i></b>");
	}

	public static void cardPaymentFlight_Hotel(String Cardtype, String CardNumber, String CardName, String CardDate,
			String CVV) throws Exception {
		String cardType = "//select[@id='ctl00_contentMain_ddlCardCC']";
		QaRobot.selectTextByLocator1(cardType, Cardtype, "<b><i>Select Card Type</i></b>");
		Thread.sleep(2000);

		QaRobot.PassValue("Credit_card_number", CardNumber);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Card Number</i></b>");

		QaRobot.PassValue("Credit_card_name", CardName);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write Card Name</i></b>");

		String cardDate[] = CardDate.split(",");
		String month = cardDate[0];
		String year = cardDate[1];
		String cardMonth = "//select[@id='ctl00_contentMain_dobExp_ddlMonth']";
		QaRobot.selectTextByLocator1(cardMonth, month, "<b><i>Selecte Card Month</i></b>");

		String cardYear = "//select[@id='ctl00_contentMain_dobExp_ddlYear']";
		QaRobot.selectTextByLocator1(cardYear, year, "<b><i>Select Card Year</i></b>");

		QaRobot.PassValue("CardCVV", CVV);
		QaExtentReport.test.log(Status.INFO, "<b><i>Write CVV Number</i></b>");
		QaRobot.ScreenshotMethod("cardPayment", "<b><i>Screenshot for Card Payment</i></b>");
	}
}
