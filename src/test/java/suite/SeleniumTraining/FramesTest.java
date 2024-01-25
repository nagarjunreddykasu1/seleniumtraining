package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesTest {
	
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("iFrame")).click();
		
		int framesCount=driver.findElements(By.tagName("iFrame")).size();
		System.out.println("Frames count: "+framesCount);
		
		//driver.switchTo().frame("mce_0_ifr");
		
		//driver.switchTo().frame(0);
		
		driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
		
		
		driver.findElement(By.id("tinymce")).clear();
		
		driver.findElement(By.id("tinymce")).sendKeys("Selenium Training");
		
		//To get the count of links on the webpage
		int coutOfLinks=driver.findElements(By.tagName("a")).size();
		System.out.println(coutOfLinks);
		
		
	}

}
