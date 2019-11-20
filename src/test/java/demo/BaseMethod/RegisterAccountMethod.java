package demo.BaseMethod;

import org.openqa.selenium.WebDriver;

import demo.BaseCommons.BaseActions;
import demo.BaseCommons.ManageDrivers;
import demo.BaseObjects.RegistAccoutOb;

public class RegisterAccountMethod extends BaseActions {

	public WebDriver localDriver;
	
	public RegisterAccountMethod(WebDriver driver) {
		localDriver = driver;
	}
	
	
	public void EnterEmail(String email) {
		SendkeyToElement(localDriver, RegistAccoutOb.emailXapth, email);
	}
	
	public AccountInfoMethod clickSubmit() {
		ClickToElementBySeleniumAPI(localDriver, RegistAccoutOb.btnSubmitXpath);
		return ManageDrivers.AccountInfoPage(localDriver);
	}
	
	public Boolean isRegisterPageDisplay() {
		return isElementDisplayed(localDriver, RegistAccoutOb.RegisterHeaderXpath);
	}
}
