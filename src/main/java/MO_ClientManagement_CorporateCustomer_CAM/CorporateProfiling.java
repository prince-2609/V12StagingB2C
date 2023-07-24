package MO_ClientManagement_CorporateCustomer_CAM;

import org.openqa.selenium.By;
import org.testng.Assert;
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

@Listeners(listenerClass.Listener.class)
public class CorporateProfiling {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("CorporateProfiling", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void corporateProfiling(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String CorporateName, String DivisionName,
			String BranchName, String BranchCountry, String CityName, String MobileNumber, String ChooseGSTDetails,
			String GSTNo, String GSTHolderName, String GSTEmail, String NameOfDepartment, String CostCenterCode,
			String CostCenterName, String ProjectCode, String ProjectName, String BusinessUnitCode,
			String BusinessUnitName, String BusinessUnitHead, String BusinessUnitEmail, String BusinessUnitContactNo)
			throws Exception {
		TestBase.Companycode(Source, URL);
		QaExtentReport.test = QaExtentReport.report.createTest(TestCaseId + "-" + TestScenario);
		QaRobot.PassValue("CompanyCode", CompanyCode);
		QaRobot.PassValue("UserName", UserName);
		QaRobot.PassValue("PasswordFD", Password);
		QaExtentReport.extentScreenshot("Sigh In Page");
		QaRobot.ClickOnElement("LogIn");
		QaRobot.switchframe("//frame[@name='login']");
		QaRobot.switchframe("//frame[@name='leftbar']");
		QaRobot.ClickOnElement("ClientManagement");
		Thread.sleep(3000);
		QaRobot.ClickOnElement("CorporateCustomer");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@name='main']");
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.PassValue("CompanyName", CorporateName);
		QaRobot.ClickOnElement("SearchCompanyName");
		QaExtentReport.test.log(Status.INFO, "<b><i>Corporate Name</i></b>" + " - " + CorporateName);
		String AccountId = QaBrowser.driver.findElement(By.xpath("//span[@id='GridView1_ctl02_Label2']")).getText();
		QaExtentReport.test.log(Status.INFO, "<b><i>Account Id</i></b>" + " - " + AccountId);
		QaRobot.ClickOnElement("ClickOnSearchCompanyName");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='toolHeader']");
		QaRobot.ClickOnElement("CPCorporateManagement");
		QaBrowser.driver.switchTo().parentFrame();
		QaRobot.switchframe("//frame[@id='frm2']");
		QaRobot.ClickOnElement("ManageDivision");
		QaRobot.ClickOnElement("AddDivision");
		QaRobot.PassValue("TitleDivision", DivisionName);
		QaRobot.ClickOnElement("ActiveDivision");
		QaExtentReport.extentScreenshot("Division");
		QaRobot.ClickOnElement("SaveDivision");
		QaExtentReport.extentScreenshot("DivisionSave");
		QaRobot.ClickOnElement("CloseDivision");
//		QaRobot.ClickOnElement("ManageBranch");
//		QaRobot.ClickOnElement("AddBranch");
//		QaRobot.selectTextByLocator("//select[@id='ddlBusinessType']", DivisionName);
//		QaRobot.PassValue("BranchName", BranchName);
//		QaRobot.selectTextByLocator("//select[@id='drpCountry']", BranchCountry);
//		String City[] = CityName.split(",");
//		String City1 = City[0];
//		String City2 = City[1];
//		TestBase.listofautosuggestion(By.xpath("//div[@id='divCity']/p"), City1, City2,
//				By.xpath("//input[@id='txtCity']"));
//		Thread.sleep(3000);
//		QaBrowser.driver.findElement(By.xpath("//div[@id='divCity']/p")).click();
//		QaRobot.PassValue("MobileNumber", MobileNumber);
//		QaRobot.scrollPage(800);
//		QaRobot.ClickOnElement("BCreditCard");
//		QaRobot.ClickOnElement("BWallet");
//		QaRobot.ClickOnElement("BCash");
//		QaRobot.ClickOnElement("BDefaultCash");
//		QaRobot.ClickOnElement("BSelectCardTypeD");
//		QaRobot.ClickOnElement("BSMAsterCard");
//		QaRobot.ClickOnElement("BSVisa");
//		QaRobot.ClickOnElement("BAssociateCardType");
//		QaRobot.ClickOnElement("ComplexItineneraryAir");
//		QaRobot.ClickOnElement("HotelOnRequest");
//		QaRobot.ClickOnElement("SelfDriveCar");
//		QaRobot.ClickOnElement("Forex");
//		QaRobot.ClickOnElement("ChauffeurDrivenCar");
//		QaRobot.ClickOnElement("BNVisa");
//		QaRobot.ClickOnElement("Insurance");
//		QaRobot.ClickOnElement("Bus");
//		QaRobot.ClickOnElement("Retail");
//		if (ChooseGSTDetails.equalsIgnoreCase("Yes")) {
//			QaRobot.ClickOnElement("GSTDetails");
//			QaRobot.PassValue("GSTNo", GSTNo);
//			String HolderName[] = GSTHolderName.split(" ");
//			String FNTitle = HolderName[0];
//			String FN = HolderName[1];
//			String LN = HolderName[2];
//			QaRobot.selectTextByLocator("//select[@id='ddlGSTTittle']", FNTitle);
//			QaRobot.PassValue("GSTFN", FN);
//			QaRobot.PassValue("GSTLN", LN);
//			QaRobot.PassValue("GSTEmail", GSTEmail);
//		}
//		QaExtentReport.extentScreenshot("Branch");
//		QaRobot.ClickOnElement("SaveBranch");
//		QaRobot.acceptAlert("BranchStatus");
//		QaExtentReport.extentScreenshot("BranchSave");
//		QaRobot.ClickOnElement("CloseBranch");
		QaRobot.ClickOnElement("ManageDepartment");
		QaRobot.ClickOnElement("AddDepartment");
		QaRobot.selectTextByLocator("//select[@id='ddBranch']", BranchName);
		QaRobot.PassValue("NameOfDepartment", NameOfDepartment);
		QaExtentReport.extentScreenshot("Department");
		QaRobot.ClickOnElement("SaveDepartment");
		QaRobot.acceptAlert("DepartmentStatus");
		QaExtentReport.extentScreenshot("DepartmentSave");
		QaRobot.ClickOnElement("CloseDepartment");
		QaRobot.ClickOnElement("ManageCostCenter");
		QaRobot.ClickOnElement("AddCostCenter");
		QaRobot.PassValue("CostCenterCode", CostCenterCode);
		QaRobot.PassValue("CostCenterName", CostCenterName);
		QaRobot.ClickOnElement("ActiveCostCenter");
		QaRobot.ClickOnElement("CostCenterSelectAll");
		QaExtentReport.extentScreenshot("CostCenter");
		QaRobot.ClickOnElement("CostCenterSaveBtn");
		QaExtentReport.extentScreenshot("CostCenterSave");
		QaRobot.ClickOnElement("CostCenterBtnClose");
		QaRobot.ClickOnElement("ManageProject");
		QaRobot.ClickOnElement("AddProject");
		QaRobot.PassValue("ProjectCode", ProjectCode);
		QaRobot.PassValue("ProjectName", ProjectName);
		QaRobot.ClickOnElement("ActiveProject");
		QaExtentReport.extentScreenshot("Project");
		QaRobot.ClickOnElement("SaveProject");
		QaRobot.acceptAlert("ProjectStatus");
		QaExtentReport.extentScreenshot("ProjectSave");
		QaRobot.ClickOnElement("CloseProject");
		QaRobot.ClickOnElement("ManageBusinessUnit");
		QaRobot.ClickOnElement("AddBusinessUnit");
		QaRobot.PassValue("BusinessUnitCode", BusinessUnitCode);
		QaRobot.PassValue("BusinessUnitName", BusinessUnitName);
		QaRobot.PassValue("BusinessUnitHead", BusinessUnitHead);
		QaRobot.PassValue("BusinessUnitEmail", BusinessUnitEmail);
		QaRobot.PassValue("BusinessUnitContactNo", BusinessUnitContactNo);
		QaRobot.ClickOnElement("BusinessUnitSelectAll");
		QaRobot.ClickOnElement("ActiveBusinessUnit");
		QaExtentReport.extentScreenshot("BusinessUnit");
		QaRobot.ClickOnElement("SaveBusinessUnit");
		QaExtentReport.extentScreenshot("BusinessUnitSave");
		QaRobot.ClickOnElement("CloseBusinessUnit");
	}

	@AfterMethod
	public static void afterMethod() {
		QaExtentReport.test.getExtent().flush();
	}
}
