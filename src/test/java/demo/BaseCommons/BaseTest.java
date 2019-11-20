package demo.BaseCommons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter; // khai bao bien mot report
	public static String dir = System.getProperty("user.dir");
	public static ExtentReports extent; // quan ly report
	public static ExtentTest test; // qua ly thng tin tug step

	@Parameters("browser")
	@BeforeTest
	public void init(String browser) {

		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(
				dir + File.separator + "myreport" + File.separator + "AutomationRPinBrowser_" + browser + ".html"); // dua duong dan
																										// den file html

		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();

		// attach only HtmlReporter
		extent.attachReporter(htmlReporter);

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser not support");
		}
			

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//init class managedriver
		ManageDrivers.initObject();
	}

	
	@Parameters({"browser"}) 
	@AfterTest
	public void clearUp(String browser) {
		driver.quit();
		String command="";
		if(browser.equals("Chrome")) {
			if(System.getProperty("os.name").contains("Mac")) {
				command = "kill -9 chromedriver.exe";
			} else {
				command = "taskkill /im chromedriver.exe /f /t";
			}
		}
		else {
			//run cho ffs
			if(System.getProperty("os.name").contains("Mac")) {
				command = "kill -9 geckodriver";
			} else {
				command = "taskkill /im geckodriver /f /t";
			}
		}
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	// chup hinh
	public static String takeScreenshot() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver; // chup man hinh bang screenprint

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date()); // thoi gian hien tai
		File source = ts.getScreenshotAs(OutputType.FILE); // lay cache ra de luu thanh fileva dang nam o mot thu muc
															// tam nao do

		String destination = dir + "/myreport/" + "img" + dateName + ".png";
		File finalDestination = new File(destination); // tro den thu muc chi dih, muon copy toi

		FileUtils.copyFile(source, finalDestination); // leh copy 1 file tu thu muc goc de 1 thu muc chi dinh

		return finalDestination.getAbsolutePath(); // return duog dan + ten hinh
	}

	@AfterMethod // AfterMethod se chay sau moi @Test
	public void screeshotRP(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.

			// String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			String screenshotPath = takeScreenshot();
			// To add it in the extent report

			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			// logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
			// chup hinh to
			String image = takeScreenshot();
			System.out.println(image);
			test.pass("" + test.addScreenCaptureFromPath(image));
		}
		
		extent.flush();
	}
	
	
}
