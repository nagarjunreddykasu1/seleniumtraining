package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import suite.SeleniumTraining.Reusable;

public class AutomationTest3 {
	
	String browser, url;

	@Parameters({"browser","url"})
	@BeforeClass
	public void launchApp(String browser, String url) {
		Reusable.launchApp(browser, url);
		this.browser=browser;
		this.url=url;
	}

	//Verify the page title in OrangeHRM page
	@Test
	public void TC_Login_01() throws Exception {
		try {
			String expectedPageTitle="OrangeHRM";
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

	@AfterClass
	public void afterClass() {
		Reusable.quit();
	}


}
