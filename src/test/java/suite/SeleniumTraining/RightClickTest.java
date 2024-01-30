package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickTest {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://qa.circulus.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//WebElement username=driver.findElement(By.id("TxtEmail"));
		//Actions action=new Actions(driver);
		//action.contextClick(username).perform();
		
		//optimized way
		new Actions(driver).contextClick(driver.findElement(By.id("TxtEmail"))).perform();
		
	}

}
