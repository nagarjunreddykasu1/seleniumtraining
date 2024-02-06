package selenium4;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class InvokeTab {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		//above()
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.name("password"))).sendKeys("Admin");
		//driver.findElement(RelativeLocator.with(By.tagName("input")).above(driver.findElement(By.name("password")))).sendKeys("Admin");
		//below()
		//driver.findElement(RelativeLocator.with(By.tagName("input")).below(driver.findElement(By.name("username")))).sendKeys("admin123");
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.name("username"))).sendKeys("admin123");
		//near()
		driver.findElement(RelativeLocator.with(By.tagName("button")).near(By.name("password"))).click();
		//toLeftOf()  toRightOf()
		Thread.sleep(3000);
		
		String parentWindowId=driver.getWindowHandle();
		
		WebDriver newTab=driver.switchTo().newWindow(WindowType.TAB);
		newTab.get("https://the-internet.herokuapp.com/login");
		newTab.findElement(By.id("username")).sendKeys("tomsmith");
		
		Set<String> handles=driver.getWindowHandles();
		for(String handle:handles) {
			if(parentWindowId.contentEquals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		
		System.out.println("main window page title: "+driver.getTitle());
		
		
		
		
		
	}

}
