package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("Nested Frames")).click();
		
		int framesCount=driver.findElements(By.tagName("frame")).size();
		System.out.println("Frames count: "+framesCount);
		
		driver.switchTo().frame("frame-top");
		
		int coutOfFrames=driver.findElements(By.tagName("frame")).size();
		System.out.println("Count of Frames in Top frame: "+coutOfFrames);
		
		driver.switchTo().frame("frame-left");
		
		String left=driver.findElement(By.tagName("body")).getText();
		System.out.println("Left frame value: "+left);
		
		
		//driver.switchTo().frame("frame-top");
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-middle");
		
		String middle=driver.findElement(By.id("content")).getText();
		System.out.println("Middle frame value: "+middle);
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame-right");
		
		String right=driver.findElement(By.tagName("body")).getText();
		System.out.println("Right frame value: "+right);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame-bottom");
		
		String bottom=driver.findElement(By.tagName("body")).getText();
		System.out.println("Bottom frame value: "+bottom);
	}

}
