package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathTypes {
	
	
	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		WebDriver driver=new ChromeDriver(options);
		
		//To maximize browser window
		driver.manage().window().maximize();
		//driver.get("https://facebook.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//following and following-sibling
		
		//driver.findElement(By.xpath("(//button[@type='submit']/following::a[@role='button'])[1]")).click();
		
		//driver.findElement(By.xpath("//button[@type='submit']/../following-sibling::div[3]/a[@role='button']")).click();
		
		//preceding and preceding-sibling
		
		//driver.findElement(By.xpath("//a[@role='button']/preceding::div[5]/button")).click();
		
		//driver.findElement(By.xpath("//input[@type='password']/../preceding-sibling::div[1]/label"));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@name='username' and @placeholder='Username']")).sendKeys("nag@gmail.com");
		//driver.findElement(By.xpath("//input[@name='username' or @placeholder='Username']")).sendKeys("nag@gmail.com");
		
		
		
		
	}

}
