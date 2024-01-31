package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageUpDownTest {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://licindia.in/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector(".btn.btn-default")).click();
		
		driver.findElement(By.id("_com_liferay_portal_search_web_portlet_SearchPortlet_keywords")).sendKeys(Keys.PAGE_DOWN);
		
		
		//Keys.PAGE_DOWN
		//Keys.PAGE_UP
	}

}
