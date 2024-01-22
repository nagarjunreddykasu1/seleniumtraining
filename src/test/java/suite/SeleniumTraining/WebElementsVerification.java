package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElementsVerification {
	
	public static void main(String[] args) {
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		WebDriver driver=new ChromeDriver(options);
		
		//To maximize browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		System.out.println(driver.findElement(By.xpath("//button[@type='submit']")).isEnabled());
		
		System.out.println(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
		
		
		
		
	}

}
