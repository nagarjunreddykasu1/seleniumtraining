package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyEventsTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://qa.circulus.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(By.id("TxtEmail")).sendKeys("nagarjun.sdet@gmail.com");
		
		driver.findElement(By.id("TxtPassword")).sendKeys("Test@123");
		
		driver.findElement(By.id("TxtPassword")).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.linkText("Sign Up")).click();
		
		//modifier keys Control, Shift and Alt
		
		WebElement firstName=driver.findElement(By.id("txtFirstName"));
		
		Actions action=new Actions(driver);
		action.keyDown(firstName, Keys.SHIFT).sendKeys("nagarjunreddy").keyUp(Keys.SHIFT).perform();
		
		Thread.sleep(2000);
		
		action.keyDown(firstName,Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		WebElement comments=driver.findElement(By.id("txtComents"));
		
		action.keyDown(comments, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		//Keys.TAB
		
		//Keys.COMMAND
		//Keys.arr
		
		
		
		
	
	}

}
