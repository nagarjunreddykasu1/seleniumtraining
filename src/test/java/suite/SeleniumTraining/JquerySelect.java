package suite.SeleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JQuerySelect {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/selectmenu/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		//Select select=new Select(driver.findElement(By.id("speed")));
		//select.selectByVisibleText("Faster");
		
		driver.findElement(By.id("speed-button")).click();
		
		//driver.findElement(By.id("ui-id-5")).click();
		
		List<WebElement> list=driver.findElements(By.xpath("//ul[@id='speed-menu']/li"));
		
		//ul[@id='speed-menu']/li[1]/div
		//ul[@id='speed-menu']/li[2]/div
		//ul[@id='speed-menu']/li[3]/div
		
		for(int i=1;i<=list.size();i++) {
			String option=driver.findElement(By.xpath("//ul[@id='speed-menu']/li["+i+"]/div")).getText();
			
			if(option.contentEquals("Fast")) {
				driver.findElement(By.xpath("//ul[@id='speed-menu']/li["+i+"]/div")).click();
				break;
			}
		}
		
		
	}

}
