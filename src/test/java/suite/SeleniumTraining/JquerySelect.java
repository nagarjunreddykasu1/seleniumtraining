package suite.SeleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JquerySelect {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectmenu");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		System.out.println("Switched to frame...");
		
		driver.findElement(By.id("speed-button")).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//ul[@id='speed-menu']/li"));
		for(int i=1;i<=list.size();i++) {
			String option=driver.findElement(By.xpath("//ul[@id='speed-menu']/li["+i+"]/div")).getText();
			System.out.println(option);
			
			if(option.equals("Faster")) {
				driver.findElement(By.xpath("//ul[@id='speed-menu']/li["+i+"]/div")).click();
				break;
			}
		}
	}

}
