package demo.BaseMethod;

import org.openqa.selenium.WebDriver;

import demo.BaseCommons.BaseActions;
import demo.BaseObjects.AccountInfoOb;

public class AccountInfoMethod extends BaseActions {

	public WebDriver localDriver;
	
	public AccountInfoMethod(WebDriver driver) {
		localDriver = driver;
	}
	
	public String getUserInfo() {
		return getElementText(localDriver, AccountInfoOb.userInfo);
	}
	
	
	public String getPassInfo() {
		return getElementText(localDriver, AccountInfoOb.passInfo);
	}
	
	public Boolean isAccountInfoPageDisplayed() {
		return isElementDisplayed(localDriver, AccountInfoOb.AccountInfoHeaderXpath);
	}
}
