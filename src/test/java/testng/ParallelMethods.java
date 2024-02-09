package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelMethods {
	
	String browser, url;
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void beforeMethod(String browser, String url) {
		this.browser=browser;
		this.url=url;
	}
	
	
	@Test
	public void TC_Login_01() throws Exception {
		try {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
			WebDriver driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(url);
			
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
	
	
	@Test
	public void TC_Login_02() throws Exception {
		try {
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
			WebDriver driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(url);
			
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
		}
		catch(Exception e){
			System.out.println("TC_Login_02 Test case is failed");
			throw e;
		}
	}

}
