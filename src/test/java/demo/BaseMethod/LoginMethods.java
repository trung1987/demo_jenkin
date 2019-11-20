package demo.BaseMethod;

import org.openqa.selenium.WebDriver;

import demo.BaseCommons.BaseActions;
import demo.BaseCommons.ManageDrivers;
import demo.BaseObjects.LoginObject;

public class LoginMethods extends BaseActions {
	private WebDriver Localdriver;
	
	public LoginMethods(WebDriver driver) {
		Localdriver = driver;
	}
	
	//============Actions==============
		// Actions_Object 

		public void EnterUserName(String username) {
			/*txtUserID.clear();
			txtUserID.sendKeys(username);*/
			WaitEleDisplay(Localdriver, LoginObject.xpathUserID);
			SendkeyToElement(Localdriver,LoginObject.xpathUserID, username);
		}
		
		public void EnterPassWord(String password) {
			/*txtPassword.clear();
			txtPassword.sendKeys(password);*/
			SendkeyToElement(Localdriver,LoginObject.xpathPassWord, password);
		}
		
		public ManagerHomePageMethods ClickLogin() {
			//btnLogin.click();
			
			ClickToElementBySeleniumAPI(Localdriver,LoginObject.xpathbtnLogin);
			return ManageDrivers.ManageHomePage(Localdriver);
		}
		
		public RegisterAccountMethod clickHereLink() {
			ClickToElementBySeleniumAPI(Localdriver,LoginObject.hereLink);
			//
			return ManageDrivers.RegisterAccountPage(Localdriver);
		}
		
		public void OpenLoginPage() {
			OpenAnyURL(Localdriver, LoginObject.URL);
		}
		public void ClickReset() {
			ClickToElementBySeleniumAPI(Localdriver,LoginObject.xpathbtnReset);
		}
		
		public ManagerHomePageMethods LoginSystem(String username, String password) {
			WaitEleDisplay(Localdriver, LoginObject.xpathUserID);
			SendkeyToElement(Localdriver,LoginObject.xpathUserID, username);
			SendkeyToElement(Localdriver,LoginObject.xpathPassWord, password);
			WaitEleClickable(Localdriver, LoginObject.xpathbtnLogin);
			ClickToElementBySeleniumAPI(Localdriver,LoginObject.xpathbtnLogin);
			return ManageDrivers.ManageHomePage(Localdriver);
		}
		
		public boolean isClearInfo() {
			if(getElementText(Localdriver,LoginObject.xpathUserID).isEmpty() && getElementText(Localdriver,LoginObject.xpathPassWord).isEmpty()) 
				return true;
			return false;
		}
}
