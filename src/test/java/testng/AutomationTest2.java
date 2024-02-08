package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AutomationTest2 {
	WebDriver driver;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void launchApp(String browser, String url) {
		if(browser.contentEquals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.contentEquals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.contentEquals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
	}
	
	
	//Verify the page title in OrangeHRM page
	@Test
	public void TC_Login_01() throws Exception {
		try {
			String expectedPageTitle="OrangeHRM";
			String actualPageTitle=driver.getTitle();
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
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			String currentUrl=driver.getCurrentUrl();
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
		driver.quit();
	}

}
