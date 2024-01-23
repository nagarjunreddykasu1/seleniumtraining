package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OrangeHRM {
	
	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//To maximize browser window
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
		driver.findElement(By.linkText("Admin")).click();
		
		driver.findElement(By.xpath("//button[contains(@class,'oxd-button')]/i")).click();
		
		driver.findElement(By.xpath("(//div[@class='oxd-select-text--after']/i)[1]")).click();
		
		//System.out.println(driver.getPageSource());
		
		driver.findElement(By.xpath("//div[@role='listbox']/div[2]/span")).click();
		
	
		
		
		
		
	}

}
