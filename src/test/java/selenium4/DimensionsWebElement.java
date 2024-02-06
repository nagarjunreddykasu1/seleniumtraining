package selenium4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class DimensionsWebElement {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		
		
		WebElement username=driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.name("password")));
		
		Rectangle rec=username.getRect();
		System.out.println("Height: "+rec.getHeight());
		System.out.println("Width: "+rec.getWidth());
		
		System.out.println("x-coordinates: "+rec.getX());
		System.out.println("y-coordinates: "+rec.getY());
	}

}
