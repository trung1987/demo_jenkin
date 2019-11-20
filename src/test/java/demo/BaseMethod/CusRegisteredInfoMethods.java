package demo.BaseMethod;

import org.openqa.selenium.WebDriver;

import demo.BaseCommons.BaseActions;
import demo.BaseObjects.CusRegisteredInfo;

public class CusRegisteredInfoMethods extends BaseActions{

	private WebDriver localdriver;
	// contructor
	public CusRegisteredInfoMethods(WebDriver globalDriver) {
		localdriver = globalDriver;
			
		}
	public boolean isRegistSucessDisplay() {
		return isElementDisplayed(localdriver,CusRegisteredInfo.RegisteredInfoXpath);
	}
	
		
	
}
