package suite.SeleniumTraining;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://licindia.in/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//button[contains(@class,'btn-default')]
		//button[contains(text(),'Close')]
		
		driver.findElement(By.cssSelector(".btn.btn-default")).click();
		
		String parentWindowId=driver.getWindowHandle();
		
		System.out.println("Parent window id: "+parentWindowId);
		
		driver.findElement(By.xpath("//a[@title='LIC on Facebook ']")).click();
		
		Alert al=driver.switchTo().alert();
		
		System.out.println(al.getText());
		
		al.accept();
		
		//(//div[contains(@class,'xjbqb8w')]/input)[1]
		//div[contains(@class,'xjbqb8w')]/input[@type='text']
		//div[contains(@class,'xjbqb8w')]/input[@name='email']
		
		//getWindowHandle() -> returns current browser window id (string)
		//getWindowHandles() -> returns all browser window ids opened by webdriver
		
		Thread.sleep(5000);
		
		Set<String> windowIds=driver.getWindowHandles();
		
		for(String windowid:windowIds) {
			if(!windowid.contentEquals(parentWindowId)) {
				driver.switchTo().window(windowid);
				System.out.println("Switched to window: "+windowid);
				break;
			}
		}
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//div[contains(@class,'xjbqb8w')]/input[@name='email']")).sendKeys("nagarjun@gmail.com");
		//driver.findElement(By.xpath("//div[contains(@class,'x1iyjqo2')]/input[@id=':r2:']")).sendKeys("nagarjun@gmail.com");
		
		//driver.findElement(By.xpath("//span[contains(text(),'Create New Account')]")).click();
		
		//driver.findElement(By.xpath("//div[@aria-label='Close']")).click();
	
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		
		//System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[@title='LIC on Facebook ']")).click();
		
		String jobs="1 - 20 of 13826";
		
		System.out.println(jobs.split("of")[1]);
		
		
		
		
	}

}
