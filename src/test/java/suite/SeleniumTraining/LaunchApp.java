package suite.SeleniumTraining;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchApp {
	
	public static void main(String[] args) throws Exception {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		
		WebDriver driver=new ChromeDriver(options);
		
		//WebDriver ffDriver=new FirefoxDriver();
		
		//To maximize browser window
		driver.manage().window().maximize();
		driver.get("https://selenium.dev");
		
		//driver.navigate().to("https://selenium.dev");
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		//Navigation methods navigate(), back() forward() refresh()
		driver.navigate().to("http://google.co.in");
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		String actualTitle=driver.getTitle();
		System.out.println(actualTitle);
		
		String expectedTitle="Google";
		
		if(expectedTitle.contentEquals(actualTitle)) {
			System.out.println("Actual and Expected titles are same.");
		}
		else {
			throw new Exception("Actual and Expected page titles are not equal. "+actualTitle);
		}
		
		
		//System.out.println(driver.getPageSource());
		
		//driver.close();
		
		
		driver.quit();
		
		
		
		
		
		
		
		
		
	}
	
	

}
