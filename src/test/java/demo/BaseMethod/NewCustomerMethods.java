package demo.BaseMethod;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import demo.BaseCommons.BaseActions;
import demo.BaseCommons.ManageDrivers;
import demo.BaseObjects.NewCustomerObject;

public class NewCustomerMethods extends BaseActions{

	private WebDriver localdriver;
	// contructor
	public NewCustomerMethods(WebDriver globalDriver) {
		localdriver = globalDriver;
			
		}
	public boolean isNewCustomerDisplayed() {
		return isElementDisplayed(localdriver,NewCustomerObject.headerNewCust);
	}
	
	public void EnterCusName(String inputValue) {
		SendkeyToElement(localdriver, NewCustomerObject.inputCusName, inputValue);
	}
	
	public void EnterDOB(String inputValue) {
		SendkeyToElement(localdriver, NewCustomerObject.inputDOB, inputValue);
	}
	
	public void EnterAddress(String inputValue) {
		SendkeyToElement(localdriver, NewCustomerObject.inputAddress, inputValue);
	}
	
	public void ChoiceGender(String inputValue) {
		if(inputValue.toLowerCase().contains("f")) {
			ClickToElementBySeleniumAPI(localdriver, String.format(NewCustomerObject.choiceGender, "f"));
		} else {
			ClickToElementBySeleniumAPI(localdriver, String.format(NewCustomerObject.choiceGender, "m"));
		}
	}
	
	public void EnterCity(String inputValue) {
		SendkeyToElement(localdriver, NewCustomerObject.inputCity, inputValue);
	}
	
	public void EnterState(String inputValue) {
		SendkeyToElement(localdriver, NewCustomerObject.inputState, inputValue);
	}
	
	public void EnterPIN(String inputValue) {
		SendkeyToElement(localdriver, NewCustomerObject.inputPIN, inputValue);
	}
	
	public void EnterPhone(String inputValue) {
		SendkeyToElement(localdriver, NewCustomerObject.inputPhone, inputValue);
	}
	
	public void EnterEmail(String inputValue) {
		SendkeyToElement(localdriver, NewCustomerObject.inputEmail, inputValue);
	}
	
	public void EnterPass(String inputValue) {
		SendkeyToElement(localdriver, NewCustomerObject.inputPass, inputValue);
	}
	
	public CusRegisteredInfoMethods RegistNewCus(ArrayList<String> CustInfos) {
		
		EnterCusName(CustInfos.get(0));
		
		ChoiceGender(CustInfos.get(1));
		
		EnterDOB(CustInfos.get(2));
		
		EnterAddress(CustInfos.get(3));
		
		EnterCity(CustInfos.get(4));
		
		EnterState(CustInfos.get(5));
		
		EnterPIN(CustInfos.get(6));
		
		EnterPhone(CustInfos.get(7));
		
		EnterEmail(CustInfos.get(8)+(new Random().nextInt(9999)));
		EnterPass(CustInfos.get(9));
		ClickToElementBySeleniumAPI(localdriver, NewCustomerObject.btnSub);
		return ManageDrivers.CusRegisteredInfoPage(localdriver);
	}
	
}
