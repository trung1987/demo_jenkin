package demo.BaseCommons;

import org.openqa.selenium.WebDriver;

import demo.BaseMethod.AccountInfoMethod;
import demo.BaseMethod.CusRegisteredInfoMethods;
import demo.BaseMethod.LoginMethods;
import demo.BaseMethod.ManagerHomePageMethods;
import demo.BaseMethod.NewCustomerMethods;
import demo.BaseMethod.RegisterAccountMethod;

public class ManageDrivers {
	
	public static LoginMethods ObLogin; 
	// neu la moi : null k co id
	//thi co id khi qua new 1 lan
	public static ManagerHomePageMethods ObHome;
	public static NewCustomerMethods ObNewCust;
	public static RegisterAccountMethod ObRegist;
	public static AccountInfoMethod ObAccInfo;
	public static CusRegisteredInfoMethods ObCusInfo;
	
	public static void initObject() {
		ObLogin = null;
		ObHome = null;
		ObNewCust = null;
		ObRegist = null;
		ObAccInfo = null;
		ObCusInfo = null;
	}
	
	public static LoginMethods ManageLoginPage(WebDriver GlobalDriver) {
		if(ObLogin == null) {
			ObLogin = new LoginMethods(GlobalDriver);
		}
		return ObLogin;
	}
	
	public static CusRegisteredInfoMethods CusRegisteredInfoPage(WebDriver GlobalDriver) {
		if(ObCusInfo == null) {
			ObCusInfo = new CusRegisteredInfoMethods(GlobalDriver);
		}
		return ObCusInfo;
	}
	
	public static AccountInfoMethod AccountInfoPage(WebDriver GlobalDriver) {
		if(ObAccInfo == null) {
			ObAccInfo = new AccountInfoMethod(GlobalDriver);
		}
		return ObAccInfo;
	}
	
	
	public static RegisterAccountMethod RegisterAccountPage(WebDriver GlobalDriver) {
		if(ObRegist == null) {
			ObRegist = new RegisterAccountMethod(GlobalDriver);
		}
		return ObRegist;
	}
	
	public static ManagerHomePageMethods ManageHomePage(WebDriver GlobalDriver) {
		if(ObHome == null) {
			ObHome = new ManagerHomePageMethods(GlobalDriver);
		}
		return ObHome;
	}
	
	public static NewCustomerMethods ManageNewCustomerPage(WebDriver GlobalDriver) {
		if(ObNewCust == null) {
			ObNewCust = new NewCustomerMethods(GlobalDriver);
		}
		return ObNewCust;
	}
}
