package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorTest {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://qa.circulus.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement firstName=driver.findElement(By.id("TxtEmail"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='nagarjun.sdet@gmail.com'", firstName);
		
		//arguments[0].scrollIntoview()
		
		WebElement login=driver.findElement(By.id("BtnLogin"));
		js.executeScript("arguments[0].click()", login);
		
		
		
		
	}

}
