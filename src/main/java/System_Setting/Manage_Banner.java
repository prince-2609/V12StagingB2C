package System_Setting;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;
import utilities.QaBrowser;
import utilities.QaDataProvider;
import utilities.QaExtentReport;
import utilities.QaRobot;

@Listeners(listenerClass.Listener.class)
public class Manage_Banner {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("SystemSetting_ManageBanner", "Sheet4");
	}

	@Test(dataProvider = "getexceldata")
	public static void preferredAirlines(String TestCaseId, String TestScenario, String Source, String URL,
			String CompanyCode, String UserName, String Password, String ProductBanner, String ProductBannerTitle,
			String SCQty, String SalesChannel, String Language, String Preference, String Status) throws Exception {
		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		Thread.sleep(2000);
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("V12Administration");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("v12SystemSetting");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='toolHeader']");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("V12RManagementMaster");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		Thread.sleep(3000);
		// QaRobot.ClickOnElement("ClickMaster");
		// QaBrowser.driver.findElement(By.xpath("//*[@id=\"tblMain\"]/tbody/tr[3]/td"));
		QaRobot.ClickOnElement("SSManageBanner");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("BMAddNew");
		Thread.sleep(2000);

		// Product banner Select Dropdown
		QaRobot.selectTextFromDropdown("SSBMProductBanner", ProductBanner);
		QaRobot.PassValue("SSBMProductBannerTitle", ProductBannerTitle);

		// Sales Channel list of Auto Suggestion
		int pA = Integer.parseInt(SCQty);
		for (int k = 1; k <= pA; k++) {
			String[] tN1 = SalesChannel.split(",");
			String b1 = tN1[k - 1];
			List<WebElement> listOfRights1 = QaBrowser.driver.findElements(By.xpath(
					"/html/body/form/table/tbody/tr[3]/td[1]/table/tbody/tr[1]/td/table/tbody/tr/td/div/fieldset/table/tbody/tr[4]/td[2]/table/tbody/tr"));
			for (WebElement autoRights1 : listOfRights1) {
				if (autoRights1.getText().equalsIgnoreCase(b1)) {
					autoRights1.click();
					Thread.sleep(3000);
				}
			}
		}

		QaRobot.selectTextFromDropdown("SMBMLanguage", Language);
		String ParentWindow1 = QaBrowser.driver.getWindowHandle();

		// File Upload Pop-up handle
		QaRobot.ClickOnElement("MBUploadFile");
		Set<String> handles1 = QaBrowser.driver.getWindowHandles();
		for (String childWindow1 : handles1) {
			if (!childWindow1.equals(ParentWindow1))
				QaBrowser.driver.switchTo().window(childWindow1);
		}
		QaRobot.PassValue("MBChooseFile",
				"D:\\OneDrive - QuadLabs Technologies Pvt Ltd (HQ - Gurgaon)\\Desktop\\Banner.png");
		Thread.sleep(2000);
		QaRobot.ClickOnElement("MBUpload");

		// QaRobot.alertAccept();
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().window(ParentWindow1);
		Thread.sleep(2000);
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.PassValue("MBPreference", Preference);
		if (Status.equalsIgnoreCase("Yes")) {
			QaRobot.ClickOnElement("MBStatus");
		}
		QaExtentReport.extentScreenshot("Manage Banner");
		QaRobot.ClickOnElement("MBSave");
		Thread.sleep(8000);
		QaRobot.alertDismiss();
		Thread.sleep(2000);
		// QaExtentReport.extentScreenshot("Manage Banners list");
//		Thread.sleep(2000);
//		QaRobot.ClickOnElement("ManageBannerClose");	

	}

	@AfterMethod
	public static void afterMethod() {
		// QaExtentReport.test.getExtent().flush();
	}
}
