package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		driver.findElement(By.partialLinkText("Alerts")).click();
		
		/*
		 * driver.findElement(By.xpath("//button[contains(text(),'JS Alert')]")).click()
		 * ; Alert al=driver.switchTo().alert(); System.out.println(al.getText());
		 * al.accept();
		 */
		
		/*
		 * driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]")).click
		 * (); Thread.sleep(2000); Alert confirm=driver.switchTo().alert();
		 * //confirm.getText(); //confirm.accept(); confirm.dismiss();
		 */
		
		driver.findElement(By.xpath("//button[contains(text(),'JS Prompt')]")).click();
		Alert prompt=driver.switchTo().alert();
		prompt.sendKeys("prompt message");
		
		Thread.sleep(2000);
		//prompt.accept();
		prompt.dismiss();
		
	}

}
