package suite.SeleniumTraining;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadProfilePic {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//To maximize browser window
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.linkText("My Info")).click();
		
		driver.findElement(By.cssSelector(".employee-image")).click();
		//button[contains(@class,'oxd-icon-button--solid-main')]
		//button[contains(@class,'employee-image-action')]
		
		driver.findElement(By.xpath("//button[contains(@class,'employee-image-action')]")).click();
		
		Thread.sleep(2000);
		
		Reusable.uploadFile(System.getProperty("user.dir")+"\\upload\\Petrol_Bill.jpg");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
