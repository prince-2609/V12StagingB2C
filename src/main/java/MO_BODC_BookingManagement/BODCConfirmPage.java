package MO_BODC_BookingManagement;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import utilities.QaBrowser;
import utilities.QaExtentReport;

public class BODCConfirmPage {
	public static void confirmpageFlight() throws InterruptedException, IOException {
		String getT = QaBrowser.driver
				.findElement(By.xpath("//div[@id='printdiv']/section/div/div/div/div[1]/div/div/div[1]/h1")).getText();
		System.out.println(getT);
		String getTxt1[] = getT.split(" ");
		String number = getTxt1[2];
		System.out.println(number);
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>" + number);

		WebElement getT1 = QaBrowser.driver.findElement(
				By.xpath("//div[@id='printdiv']/section/div/div/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/div"));
		String getTxt2 = getT1.getText();
		String getTxt3[] = getTxt2.split(",");
		String number1 = getTxt3[0];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>" + number1);

		String text = QaBrowser.driver
				.findElement(By.xpath(
						"//div[@id='printdiv']/section/div/div/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/div/span[1]"))
				.getText();

		if (text.equalsIgnoreCase("UnConfirmed")) {
			QaExtentReport.test.log(Status.INFO, "<b><i>Booking Fail </i></b>");
		} else {
			WebElement getT2 = QaBrowser.driver.findElement(
					By.xpath("//div[@id='printdiv']/section/div/div/div/div[2]/div[2]/div[1]/div[1]/div/div[2]/div"));
			String getTxt4 = getT2.getText();
			String getTxt5[] = getTxt4.split(" ");
			String number2 = getTxt5[2];
			QaExtentReport.test.log(Status.INFO, "<b><i>Confirming Status PNR Number is </i></b>" + number2);
		}
		QaExtentReport.extentScreenshot("Confirm Page");
	}

	public static void confirmpageHotel() throws IOException {
		WebElement getT = QaBrowser.driver
				.findElement(By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[1]/h2"));
		String getTxt = getT.getText();
		String getTxt1[] = getTxt.split(" ");
		String number = getTxt1[1];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>" + number);

		WebElement getT1 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p"));
		String getTxt2 = getT1.getText();
		String getTxt3[] = getTxt2.split(" ");
		String number1 = getTxt3[0];
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking Status is </i></b>" + number1);

		String text = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p/span[1]")).getText();

		if (text.equalsIgnoreCase("UnConfirmed")) {
			QaExtentReport.test.log(Status.INFO, "<b><i>Booking Fail </i></b>");
		} else {
			WebElement getT2 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p"));
			String getTxt4 = getT2.getText();
			String getTxt5[] = getTxt4.split(" ");
			String number2 = getTxt5[2];
			QaExtentReport.test.log(Status.INFO, "<b><i>Confirming Status Number is </i></b>" + number2);
		}
		QaExtentReport.extentScreenshot("Confirm Page");
	}

	public static void confirmpageFlight_Hotel() throws IOException {
		String getT = QaBrowser.driver
				.findElement(By.xpath("/html/body/form/div[4]/div[2]/section/div[2]/div/div[1]/div[1]/h2")).getText();
		System.out.println(getT);
		String getTxt1[] = getT.split(" ");
		String number = getTxt1[1];
		System.out.println(number);
		QaExtentReport.test.log(Status.INFO, "<b><i>Booking id is </i></b>" + number);

		WebElement getT1 = QaBrowser.driver
				.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div[1]/div[1]/div[2]/p"));
		String getTxt2 = getT1.getText();
		System.out.println(getTxt2);
		String getTxt3[] = getTxt2.split(" ");
		String number1 = getTxt3[0];
		System.out.println(number1);
		QaExtentReport.test.log(Status.INFO, "<b><i>Flight Booking Status is </i></b>" + number1);

		String text = QaBrowser.driver
				.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div[1]/div[1]/div[2]/p/span[1]"))
				.getText();

		if (text.equalsIgnoreCase("UnConfirmed")) {
			QaExtentReport.test.log(Status.INFO, "<b><i>Flight Booking Fail </i></b>");
		} else {
			WebElement getT2 = QaBrowser.driver
					.findElement(By.xpath("//div[@id='ctl00_contentMain_flt_details']/div[1]/div[1]/div[2]/p"));
			String getTxt4 = getT2.getText();
			System.out.println(getTxt4);
			String getTxt5[] = getTxt4.split(" ");
			String number2 = getTxt5[2];
			System.out.println(number2);
			QaExtentReport.test.log(Status.INFO, "<b><i>Flight Confirming Status PNR Number is </i></b>" + number2);
		}

		WebElement getT2 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p"));
		String getTxt5 = getT2.getText();
		System.out.println(getTxt5);
		String getTxt6[] = getTxt5.split(" ");
		String number3 = getTxt6[0];
		System.out.println(number3);
		QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Booking Status is </i></b>" + number3);

		String text2 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p/span[1]")).getText();

		if (text2.equalsIgnoreCase("UnConfirmed")) {
			QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Booking Fail </i></b>");
		} else {
			WebElement getT3 = QaBrowser.driver.findElement(By.xpath("//div[@id='nc_status']/p"));
			String getTxt7 = getT3.getText();
			String getTxt8[] = getTxt7.split(" ");
			String number4 = getTxt8[2];
			QaExtentReport.test.log(Status.INFO, "<b><i>Hotel Confirming Status Number is </i></b>" + number4);
		}
		QaExtentReport.extentScreenshot("Confirm Page");
	}
}
