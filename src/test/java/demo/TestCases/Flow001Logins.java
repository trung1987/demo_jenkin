package demo.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demo.BaseCommons.BaseTest;
import demo.BaseCommons.DataTest;
import demo.BaseCommons.ManageDrivers;
import demo.BaseMethod.LoginMethods;
import demo.BaseMethod.ManagerHomePageMethods;

public class Flow001Logins extends BaseTest {

	// khai bao driver

	LoginMethods ObLogin;
	ManagerHomePageMethods ObHomePage;


	@Test
	public void TC001_CheckReset() {
		test = extent.createTest("TC001_CheckReset");
		System.out.println("======Start TC001_CheckReset============");
		//driver.get(url);
		
		test.log(Status.INFO, "1. Go to Loginpage");
		System.out.println( "1. Go to Loginpage");
		//ObLogin = new LoginObject(driver);
	
		
		ObLogin = ManageDrivers.ManageLoginPage(driver);
		ObLogin.OpenLoginPage();
		
		test.log(Status.INFO, "2. Enter username " + DataTest.username);
		System.out.println( "2. Enter username " + DataTest.username);
		ObLogin.EnterUserName(DataTest.username);
		
		test.log(Status.INFO, "3. Enter Password " + DataTest.password);
		System.out.println("3. Enter Password " + DataTest.password);
		ObLogin.EnterPassWord(DataTest.password);
		
		test.log(Status.INFO, "4. Click Reset ");
		System.out.println( "4. Click Reset ");
		ObLogin.ClickReset();
		
		test.log(Status.INFO, "5. Verify all infos are cleared ");
		System.out.println( "5. Verify all infos are cleared");
		Assert.assertTrue(ObLogin.isClearInfo());
	}
	
	@Test
	public void TC002_LoginSucess() {
		test = extent.createTest("TC002_LoginSucess");
		System.out.println("======Start TC002_LoginSucess============");
		
		test.log(Status.INFO, "1. Go to Loginpage");
		System.out.println( "1. Go to Loginpage");
		ObLogin = ManageDrivers.ManageLoginPage(driver);
		ObLogin.OpenLoginPage();

		test.log(Status.INFO, "2. Enter username " + DataTest.username);
		System.out.println( "2. Enter username " + DataTest.username);
		ObLogin.EnterUserName(DataTest.username);
		
		test.log(Status.INFO, "3. Enter Password " + DataTest.password);
		System.out.println("3. Enter Password " + DataTest.password);
		ObLogin.EnterPassWord(DataTest.password);
		
		test.log(Status.INFO, "4. Click Login ");
		System.out.println( "4. Click Login ");
		ObHomePage = ObLogin.ClickLogin();

		test.log(Status.INFO, "5. Verify homepage display ");
		System.out.println( "5. Verify homepage display ");
		Assert.assertTrue(ObHomePage.isLoginSucess(), "login khong thanh cong");

	}
}
