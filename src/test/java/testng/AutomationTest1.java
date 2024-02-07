package testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutomationTest1 {
	
	WebDriver driver;
	@BeforeClass
	public void launchApp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void TC_Login_01() throws Exception {
		try {
			String expectedPageTitle="OrangeHRM..";
			String actualPageTitle=driver.getTitle();
			if(expectedPageTitle.equals(actualPageTitle)) {
				System.out.println("Both actual and expected page titles are equal.");
			}else {
				throw new Exception("Actual and expected page titles are NOT equal");
			}
		}
		catch(Exception e){
			System.out.println("Test case is failed");
			throw e;
		}
	}

}
