package demo.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demo.BaseCommons.BaseTest;
import demo.BaseCommons.DataTest;
import demo.BaseCommons.ExcelReader;
import demo.BaseCommons.ManageDrivers;
import demo.BaseMethod.CusRegisteredInfoMethods;
import demo.BaseMethod.LoginMethods;
import demo.BaseMethod.ManagerHomePageMethods;
import demo.BaseMethod.NewCustomerMethods;

public class Flow002Newcustomer extends BaseTest{

	LoginMethods ObLogin;
	ManagerHomePageMethods ObHomePage;
	NewCustomerMethods ObNewCust;
	CusRegisteredInfoMethods ObCusInfos;
	String dataPath = DataTest.rootDir + File.separator+ "data" + File.separator + DataTest.ExcelFileName;
	@Test
	public void TC001_CheckNewCustomerScreen() {
		test = extent.createTest("TC001_CheckNewCustomerScreen");
		System.out.println("======Start TC001_CheckNewCustomerScreen============");
	
		test.log(Status.INFO, "1. Login System");
		System.out.println( "1. Login System");
		ObLogin = ManageDrivers.ManageLoginPage(driver);
		ObLogin.OpenLoginPage();
		ObLogin.LoginSystem(DataTest.username, DataTest.password);

		test.log(Status.INFO, "2. Verify homepage display ");
		System.out.println( "2. Verify homepage display ");
		// khoi tao homepage
		ObHomePage = ManageDrivers.ManageHomePage(driver);
		Assert.assertTrue(ObHomePage.isLoginSucess(), "login khong thanh cong");
		
		test.log(Status.INFO, "3. Access New Customer Page");
		System.out.println( "3.  Access New Customer Page");
		ObHomePage.openNewCust();
		
		test.log(Status.INFO, "4. Verify New Customer Page Displayed");
		System.out.println( "5.  Verify New Customer Page Displayed");
		ObNewCust = ManageDrivers.ManageNewCustomerPage(driver);
		Assert.assertTrue(ObNewCust.isNewCustomerDisplayed());
		
	}
	
	@Test
	public void TC002_CreateNewCus() {
		test = extent.createTest("TC002_CreateNewCus");
		System.out.println("======Start TC002_CreateNewCus============");
					
		test.log(Status.INFO, "1. Verify New Customer Page Displayed");
		System.out.println( "1.  Verify New Customer Page Displayed");
		ObNewCust = ManageDrivers.ManageNewCustomerPage(driver);
		Assert.assertTrue(ObNewCust.isNewCustomerDisplayed());
		
		test.log(Status.INFO, "2. Input New Customer ");
		System.out.println( "2.  Input New Customer ");
		
		//Get info from excel
		ArrayList<String> arr = ExcelReader.ReadExcelAtCol(dataPath, DataTest.sheetUserInfo,0, DataTest.colInfo);

		ObCusInfos = ObNewCust.RegistNewCus(arr);
		
		test.log(Status.INFO, "3. Verify Create new cus successfull ");
		System.out.println( "3.  Verify Create new cus successfull ");
		assertTrue(ObCusInfos.isRegistSucessDisplay());
	
	}
	
	
	
	
	
}
