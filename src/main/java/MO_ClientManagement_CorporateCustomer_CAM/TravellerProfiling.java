package MO_ClientManagement_CorporateCustomer_CAM;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class TravellerProfiling {

	@DataProvider
	public Object[][] getexceldata() throws Exception {
		return QaDataProvider.getTestdata("TravellerProfiling", "Sheet1");
	}

	@Test(dataProvider = "getexceldata")
	public static void travellerProfiling(String TestCaseId, String TestCaseType, String TestScenario, String Source,
			String URL, String CompanyCode, String UserName, String Password, String CorporateName, String SelectBranch,
			String DepartmentName, String AddDesignation, String CategoryCode, String CategoryName,
			String GradeCategoryFor, String TravellerName, String Gender, String TUserName, String TEmail,
			String SelectBranchName, String Language, String Country, String MobileCountry, String MobileNo,
			String TravellerType, String TotalRights, String RightNames, String PassportNo, String TravellerDOB,
			String PPlaceOfIssue, String PValidFrom, String PExpireFrom, String VisaNumber, String CountryOfVisa,
			String VValidFrom, String VExpireFrom, String DependentName, String DGender, String DepDOB,
			String DRelation, String DPassportNo, String DpassportExpiryDate, String DNationality,
			String DPassIssuingCountry) throws Exception {

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
//		QaRobot.ClickOnElement("ManageDepartment");
//		QaRobot.ClickOnElement("Adddepartment");
//		QaRobot.selectTextByLocator("//select[@id='ddBranch']", SelectBranch);
//		QaRobot.PassValue("DepartmentName", DepartmentName);
//		QaRobot.ClickOnElement("SaveDepartment");
//		QaRobot.acceptAlert("DepartmentStatus");
//		QaRobot.ClickOnElement("CloseDepartment");
//		QaRobot.ClickOnElement("ManageDesignation");
//		QaRobot.ClickOnElement("AddManageDesignation");
//		QaRobot.PassValue("AddDesignation", AddDesignation);
//		QaRobot.ClickOnElement("ManageDesignationSelectAll");
//		QaRobot.ClickOnElement("SaveDesignation");
//		QaRobot.acceptAlert("DesignationStatus");
//		QaRobot.ClickOnElement("CloseDesignation");
//		QaRobot.ClickOnElement("ManageGrade");
//		QaRobot.ClickOnElement("AddGrade");
//		QaRobot.PassValue("CategoryCode", CategoryCode);
//		QaRobot.PassValue("CategoryName", CategoryName);
//		if (GradeCategoryFor.equalsIgnoreCase("Book For Family")) {
//			QaRobot.ClickOnElement("BookFamily");
//		} else if (GradeCategoryFor.equalsIgnoreCase("Personal")) {
//			QaRobot.ClickOnElement("Personal");
//		}
//		QaRobot.ClickOnElement("GradeSelectAll");
//		QaRobot.ClickOnElement("AddGrade");
//		QaRobot.acceptAlert("GradeStatus");
//		QaRobot.ClickOnElement("CloseGrade");
		QaRobot.ClickOnElement("ManageTravellers");
		QaRobot.ClickOnElement("CreateNewTraveller");
		String HolderName[] = TravellerName.split(" ");
		String FNTitle = HolderName[0];
		String FN = HolderName[1];
		String LN = HolderName[2];
		QaRobot.selectTextByLocator("//select[@id='ddltitle']", FNTitle);
		QaRobot.PassValue("TravellerFN", FN);
		QaRobot.PassValue("TravellerLN", LN);
		if (Gender.equalsIgnoreCase("Male")) {
			QaRobot.ClickOnElement("GMAle");
		} else if (Gender.equalsIgnoreCase("Female")) {
			QaRobot.ClickOnElement("GFemale");
		}
		QaRobot.ClickOnElement("TravellerDOB");
		String DateSelection[] = TravellerDOB.split("-");
		String year = DateSelection[2];
		String month = DateSelection[1];
		String expDate = DateSelection[0];
		QaRobot.selectDateInCalendar(expDate, month, year);
		QaRobot.PassValue("TUserName", TUserName);
		QaRobot.PassValue("TEmailId", TEmail);
		QaRobot.selectTextByLocator("//select[@id='cbobranch']", SelectBranchName);
		QaRobot.selectTextByLocator("//select[@id='cboLang']", Language);
		QaRobot.selectTextByLocator("//select[@id='drpDownCountryOfResidence']", Country);
		QaRobot.selectTextByLocator("//select[@id='ddlMobileCountryCode']", MobileCountry);
		QaRobot.PassValue("MobileNo", MobileNo);
		int pAS = Integer.parseInt(TotalRights);
		for (int i = 1; i <= pAS; i++) {
			String[] tN = RightNames.split(",");
			String b = tN[i - 1];
			List<WebElement> listOfRights = QaBrowser.driver.findElements(
					By.xpath("/html/body/div/form/div[5]/div/div/div/div[2]/div[2]/div/div[46]/div/label/span/label"));

			for (WebElement autoRights : listOfRights) {
				if (autoRights.getText().equalsIgnoreCase(b)) {
					autoRights.click();
					break;
				} else {
				}
			}
		}
		QaRobot.ClickOnElement("VIP");
		QaRobot.ClickOnElement("CIP");
		if (TravellerType.equalsIgnoreCase("Administrator")) {
			QaRobot.ClickOnElement("Administrator");
		} else if (TravellerType.equalsIgnoreCase("Travel Arranger")) {
			QaRobot.ClickOnElement("TravelArranger");
		} else if (TravellerType.equalsIgnoreCase("Travel Co-ordinator")) {
			QaRobot.ClickOnElement("TravelCoOrdinator");
		} else if (TravellerType.equalsIgnoreCase("Employee")) {
			QaRobot.ClickOnElement("Employee");
		}
		QaRobot.ClickOnElement("Acknowledgment1");
		QaRobot.ClickOnElement("Acknowledgment2");
		QaRobot.ClickOnElement("TravellerSave");
		QaRobot.ClickOnElement("SearchOption");
		QaRobot.PassValue("SUserFN", FN);
		QaRobot.ClickOnElement("SUserSearch");
		QaRobot.ClickOnElement("SelectTraveller");
		QaRobot.ClickOnElement("PassportDetails");
		QaRobot.ClickOnElement("AddPassport");
		QaRobot.PassValue("PassportNo", PassportNo);
//		QaRobot.ClickOnElement("TravellerDOB");
//		String DateSelection[] = TravellerDOB.split("-");
//		String year = DateSelection[2];
//		String month = DateSelection[1];
//		String expDate = DateSelection[0];
//		QaRobot.selectDateInCalendar(expDate, month, year);
		String City[] = PPlaceOfIssue.split(",");
		String City1 = City[0];
		String City2 = City[1];
		TestBase.listofautosuggestion(By.xpath("//div[@id='divCityPassport']/p"), City1, City2,
				By.xpath("//input[@id='txtSearchCity']"));
		QaRobot.ClickOnElement("PValidFrom");
		String DateSelection1[] = PValidFrom.split("-");
		String year1 = DateSelection1[2];
		String month1 = DateSelection1[1];
		String expDate1 = DateSelection1[0];
		QaRobot.selectDateInCalendar(expDate1, month1, year1);
		QaRobot.ClickOnElement("PExpireFrom");
		String DateSelection2[] = PExpireFrom.split("-");
		String year2 = DateSelection2[2];
		String month2 = DateSelection2[1];
		String expDate2 = DateSelection2[0];
		QaRobot.selectDateInCalendar(expDate2, month2, year2);
		QaRobot.ClickOnElement("PassportPrimary");
		QaRobot.ClickOnElement("AddPassport");
		QaRobot.ClickOnElement("VisaDetails");
		QaRobot.ClickOnElement("AddVisa");
		QaRobot.PassValue("VisaNumber", VisaNumber);
		QaRobot.selectTextByLocator("//select[@id='ddlVisa_CountryCode']", CountryOfVisa);
		QaRobot.ClickOnElement("VValidFrom");
		String DateSelection3[] = VValidFrom.split("-");
		String year3 = DateSelection3[2];
		String month3 = DateSelection3[1];
		String expDate3 = DateSelection3[0];
		QaRobot.selectDateInCalendar(expDate3, month3, year3);
		QaRobot.ClickOnElement("VExpireFrom");
		String DateSelection4[] = VExpireFrom.split("-");
		String year4 = DateSelection4[2];
		String month4 = DateSelection4[1];
		String expDate4 = DateSelection4[0];
		QaRobot.selectDateInCalendar(expDate4, month4, year4);
		QaRobot.ClickOnElement("AddVisa");
		QaRobot.ClickOnElement("DependentDetails");
		QaRobot.ClickOnElement("AddDependent");
		String HolderName1[] = DependentName.split(" ");
		String FNTitle1 = HolderName1[0];
		String FN1 = HolderName1[1];
		String LN1 = HolderName1[2];
		QaRobot.selectTextByLocator("//select[@id='ddlDependantTitle']", FNTitle1);
		QaRobot.PassValue("DFN", FN1);
		QaRobot.PassValue("DLN", LN1);
		if (DGender.equalsIgnoreCase("Male")) {
			QaRobot.ClickOnElement("DMale");
		} else if (DGender.equalsIgnoreCase("Female")) {
			QaRobot.ClickOnElement("DFemale");
		}
		QaRobot.ClickOnElement("DDOB");
		String DateSelection5[] = DepDOB.split("-");
		String year5 = DateSelection5[2];
		String month5 = DateSelection5[1];
		String expDate5 = DateSelection5[0];
		QaRobot.selectDateInCalendar(expDate5, month5, year5);
		QaRobot.selectTextByLocator("//select[@id='ddlDependantRelation']", DRelation);
		QaRobot.PassValue("DPassportNo", DPassportNo);
		QaRobot.ClickOnElement("DPassportExpiryDate");
		String DateSelection6[] = DpassportExpiryDate.split("-");
		String year6 = DateSelection6[2];
		String month6 = DateSelection6[1];
		String expDate6 = DateSelection6[0];
		QaRobot.selectDateInCalendar(expDate6, month6, year6);
		QaRobot.selectTextByLocator("//select[@id='ddlPassnationality']", DNationality);
		QaRobot.selectTextByLocator("//select[@id='ddlpassisscountry']", DPassIssuingCountry);
		QaRobot.ClickOnElement("DAcknowledgment1");
		QaRobot.ClickOnElement("DAcknowledgment2");
		QaRobot.ClickOnElement("DSave");
	}

	@AfterMethod
	public static void afterMethod() {
//		QaExtentReport.test.getExtent().flush();
	}
}
