package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TooltipTest {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement frame=driver.findElement(By.cssSelector(".demo-frame"));
		
		driver.switchTo().frame(frame);
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("age"))).perform();
		
		action.moveToElement(driver.findElement(By.linkText("ThemeRoller"))).perform();
		
		
		String tooltip=driver.findElement(By.id("age")).getAttribute("title");
		
		System.out.println("Tooltip message: "+tooltip);
		
		
	}

}
