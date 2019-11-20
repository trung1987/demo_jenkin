package demo.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demo.BaseCommons.BaseTest;
import demo.BaseCommons.DataTest;
import demo.BaseCommons.ExcelReader;
import demo.BaseCommons.ManageDrivers;
import demo.BaseMethod.AccountInfoMethod;
import demo.BaseMethod.LoginMethods;
import demo.BaseMethod.RegisterAccountMethod;

public class Flow000CreateAcc extends BaseTest{

	String dataPath = DataTest.rootDir + File.separator+ "data" + File.separator + DataTest.ExcelFileName;
	LoginMethods Mlogin;
	RegisterAccountMethod MRegis;
	AccountInfoMethod MAcc;
	
	@Test
	public void TC001_CreateAcc() {
		test = extent.createTest("TC001_CreateAcc");
		System.out.println("======Start TC001_CreateAcc============");
		
		test.log(Status.INFO, "1. Open Browser Homepage " );
		System.out.println( "1. Open Browser Homepage");
		Mlogin = ManageDrivers.ManageLoginPage(driver);
		Mlogin.OpenLoginPage();
		
		test.log(Status.INFO, "2. Click Here Link");
		System.out.println( "2. Click Here Link");
		MRegis = Mlogin.clickHereLink();

		test.log(Status.INFO, "3. Verify Register Page");
		System.out.println( "3. Verify Register Page");
		//verify
		assertTrue(MRegis.isRegisterPageDisplay());
		
		test.log(Status.INFO, "4. Input email account");
		System.out.println( "4. Input email account");
		//Input email
		
		String email = ExcelReader.ReadExcelAtCol(dataPath,DataTest.sheetAccout,DataTest.colEmail).get(0);
		MRegis.EnterEmail(email);
		
		test.log(Status.INFO, "5. Click submit");
		System.out.println( "5. Click submit");
		MAcc = MRegis.clickSubmit();
		
		//verify account info page
		test.log(Status.INFO, "6. Verify Account info is displayed");
		System.out.println( "6. Verify Account info is displayed");
		assertTrue(MAcc.isAccountInfoPageDisplayed());
		
		DataTest.username = MAcc.getUserInfo();
		DataTest.password = MAcc.getPassInfo();

	}
	
}
