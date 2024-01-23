package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SynchronizationTest {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.partialLinkText("Example 1")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		
		
		
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
		
		
		FluentWait<WebDriver> wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
				withMessage("Timeout Exception").pollingEvery(Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
		
		String message=driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
		
		System.out.println("Message is: "+message);
		
		
		
		
		
		
		
	}

}


/*
Synchronization:

Implicit Wait:
driver.manager().timeOuts().implicitlyWait();



Explicit Wait:

i. WebDriverWait:


ii. FluentWait




*/