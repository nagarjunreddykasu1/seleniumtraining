package testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AssertionsTest {
	
	
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
				String expectedPageTitle="OrangeHRM...";
				String actualPageTitle=driver.getTitle();
				/*
				 * if(expectedPageTitle.equals(actualPageTitle)) {
				 * System.out.println("Both actual and expected page titles are equal."); }else
				 * { throw new Exception("Actual and expected page titles are NOT equal"); }
				 */
				
				Assert.assertEquals(actualPageTitle, expectedPageTitle);
				//Assert.assertEquals(al1, al2);
				System.out.println("Test case is passed");
			}
			catch(Exception e){
				System.out.println("TC_Login_01 Test case is failed");
				throw e;
			}
		}
	
	
	

}
