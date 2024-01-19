package suite.SeleniumTraining;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementsDemo {
	
	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		
		WebDriver driver=new ChromeDriver(options);
		
		//WebDriver ffDriver=new FirefoxDriver();
		
		//To maximize browser window
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
		List<WebElement> list=driver.findElements(By.id("email")); //5 text fields matching with id attr value
		//list.get(0).sendKeys("nag@gmail.com");
		
		System.out.println(list.size());
		
		
		driver.findElement(By.id("pass")).sendKeys("Test@331");
		
		//driver.findElement(By.id("pass")).clear();
		
		//u_0_5_Jp
		//u_0_5_q4
		
		//*[@id="u_0_5_q4"]
		
		driver.findElement(By.xpath("//*[starts-with(@id,'u_0_5')]"));
		driver.findElement(By.xpath("//input[contains(@id,'u_0_5')]"));
		
		
		
		////tagname[@attribute_name='valueofattribute']
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
	}

}
