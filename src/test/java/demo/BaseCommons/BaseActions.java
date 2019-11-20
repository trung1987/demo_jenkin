package demo.BaseCommons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions {

	// web driver

	// open url
	protected void OpenAnyURL(WebDriver driver, String URL) {
		// viet don gian
		driver.get(URL);
		
	}

	// hien tai
	protected void ClickToElementBySeleniumAPI(WebElement ele) {
		ele.click();
	}

	protected String getElementText(WebElement ele) {
		return ele.getText();
	}
	
	protected String getElementText(WebDriver driver, String xpath) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		return ele.getText();
	}
	// ve sau
	protected void ClickToElementBySeleniumAPI(WebDriver driver, String xpath) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		ele.click();
	}

	protected void SendkeyToElement(WebElement ele, String inputValue) {
		ele.clear();
		ele.sendKeys(inputValue);
	}

	protected void SendkeyToElement(WebDriver driver, String xpath, String inputValue) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		ele.clear();
		ele.sendKeys(inputValue);
	}
	
	protected boolean isElementDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}
	
	protected boolean isElementDisplayed(WebDriver driver, String xpath) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		return ele.isDisplayed();
	}
	
	
	public void WaitEleDisplay(WebDriver driver,String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//cach 1: cho 1 ele : driver.findElement(By.xpath(xpath))  ==>> ele
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
		
		//cach 2:
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
	}
	
	
	public void WaitEleClickable(WebDriver driver,String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//cach 1: cho 1 ele : driver.findElement(By.xpath(xpath))  ==>> ele
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
		
		//cach 2:
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
	}
}
