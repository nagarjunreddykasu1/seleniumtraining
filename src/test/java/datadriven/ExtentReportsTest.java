package datadriven;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import suite.SeleniumTraining.Reusable;

public class ExtentReportsTest {
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest extentTest;


	@BeforeSuite
	public void setup() {
		String datetimestamp=LocalDateTime.now().toString().replace(":", "").replace("-", "").replace(".", "");
		reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\ExtentReport_"+datetimestamp+".html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Automation Test Result");
		reporter.config().setEncoding("utf-8");
		reporter.config().setTheme(Theme.STANDARD);


		reports=new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("Selenium Version", "4.17.0");
		reports.setSystemInfo("OS", "Windows");
		reports.setSystemInfo("Author", "Nagarjun Reddy");
		reports.setSystemInfo("Project Name", "Orange HRM");


	}

	@Parameters({"browser","url"})
	@BeforeClass
	public void launchApp(String browser, String url) {
		Reusable.launchApp(browser, url);
	}

	//Verify the page title in OrangeHRM page
	@Test
	public void TC_Login_01() throws Exception {
		try {
			extentTest=reports.createTest("Verify the page title in OrangeHRM page");
			extentTest.assignCategory("Login");

			String expectedPageTitle="OrangeHRM..";
			String actualPageTitle=Reusable.getTitle();
			if(expectedPageTitle.equals(actualPageTitle)) {
				System.out.println("Both actual and expected page titles are equal.");
			}else {
				throw new Exception("Actual and expected page titles are NOT equal");
			}
		}
		catch(Exception e){
			System.out.println("TC_Login_01 Test case is failed");
			throw e;
		}
	}

	//Verify the user is able to login to the application using valid credentials
	@Test
	public void TC_Login_02() throws Exception {
		try {
			extentTest=reports.createTest("Verify the user is able to login to the application using valid credentials");
			extentTest.assignCategory("Login");

			Reusable.sendKeys(Reusable.getWebElement("name", "username"), "Admin");
			Reusable.sendKeys(Reusable.getWebElement("name", "password"), "admin123");
			Reusable.click(Reusable.getWebElement("xpath", "//button[@type='submit']"));

			String currentUrl=Reusable.getCurrentUrl();
			if(currentUrl.contains("dashboard")) {
				System.out.println("User logged in and redirected to dashboard page.");
			}
			else {
				System.out.println("User not logged in..");
				throw new Exception("User is not logged in. Please check the login details.");
			}

		}catch(Exception e){
			System.out.println("TC_Login_02 Test case is failed");
			throw e;
		}
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {
		if(result.getStatus() == ITestResult.SUCCESS) {
			String methodName=result.getMethod().getMethodName();
			Markup markup=MarkupHelper.createLabel("Test case "+methodName+" is Passed", ExtentColor.GREEN);
			extentTest.log(Status.PASS, markup);
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			String methodName=result.getMethod().getMethodName();
			Markup markup=MarkupHelper.createLabel("Test case "+methodName+" is Failed", ExtentColor.RED);
			extentTest.log(Status.FAIL, markup);
			Reusable.delay(3);
			String filePath=Reusable.takeScreenshot(methodName);
			
			String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
			extentTest.fail("<details><summary><font color=red>Exception Occurred</font></summary>"+exceptionMessage+"</details>", MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
			
		}
		else {
			String methodName=result.getMethod().getMethodName();
			Markup markup=MarkupHelper.createLabel("Test case "+methodName+" is Skipped", ExtentColor.YELLOW);
			extentTest.log(Status.SKIP, markup);
		}
		
	}
	


	@AfterSuite
	public void afterSuite() {
		reports.flush();
		Reusable.quit();
	}




}


/*
ExtentSparkReporter
ExtentReports
ExtentTest
MediaEntityBuilder




 */