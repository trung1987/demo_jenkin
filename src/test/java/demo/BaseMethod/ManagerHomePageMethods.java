package demo.BaseMethod;

import org.openqa.selenium.WebDriver;

import demo.BaseCommons.BaseActions;
import demo.BaseCommons.ManageDrivers;
import demo.BaseObjects.ManagerHomePageObject;

public class ManagerHomePageMethods extends BaseActions {

	private WebDriver Localdriver;
	
	public ManagerHomePageMethods(WebDriver driver) {
		Localdriver = driver;
	}
	
	
	
	//Actions
	public boolean isLoginSucess() {
		WaitEleDisplay(Localdriver,ManagerHomePageObject.xpathlblWelcome);
		return isElementDisplayed(Localdriver,ManagerHomePageObject.xpathlblWelcome);
	}
	
	public NewCustomerMethods openNewCust() {
		
		ClickToElementBySeleniumAPI(Localdriver,String.format(ManagerHomePageObject.dynamicLeftMenuXpath,"New Customer"));
		return ManageDrivers.ManageNewCustomerPage(Localdriver);
	}
	
	//tam thoi de void vi chua lam ben manageDriver va tao object class
	public void openEditCust() {
		ClickToElementBySeleniumAPI(Localdriver,String.format(ManagerHomePageObject.dynamicLeftMenuXpath,"Edit Customer"));
	}
	
	public void openDelCust() {
		ClickToElementBySeleniumAPI(Localdriver,String.format(ManagerHomePageObject.dynamicLeftMenuXpath,"Delete Customer"));
	}
	
	public void openNewAccout() {
		ClickToElementBySeleniumAPI(Localdriver,String.format(ManagerHomePageObject.dynamicLeftMenuXpath,"New Account"));
	}
}
