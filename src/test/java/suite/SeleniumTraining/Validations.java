package suite.SeleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Validations {
	
	
	
	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		WebDriver driver=new ChromeDriver(options);
		//To maximize browser window
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
		
		WebElement btnLogin=driver.findElement(By.xpath("//button[@type='submit']"));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//String actualMessage=driver.findElement(By.className("_9ay7")).getText();
		
		String actualMessage=driver.findElement(By.xpath("//input[@name='email']/following-sibling::div[2]")).getText();
		
		System.out.println(actualMessage);
		
		Reusable.click(btnLogin);
	}

}
