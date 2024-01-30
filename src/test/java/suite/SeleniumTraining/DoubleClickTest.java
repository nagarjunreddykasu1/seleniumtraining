package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://licindia.in/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.cssSelector(".btn.btn-default")).click();
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//a[@title='HOME']"));
		
		Actions action=new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//a[@title='HOME']"))).perform();
		
		
		
		
	}

}
