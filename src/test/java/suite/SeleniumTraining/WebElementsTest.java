package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElementsTest {
	
	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		WebDriver driver=new ChromeDriver(options);
		
		//To maximize browser window
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//driver.findElement(By.xpath("//a[contains(text(),'Create new')]")).click();
		//driver.findElement(By.xpath("//a[contains(@id,'u_0_0_')]")).click();
		//driver.findElement(By.xpath("//a[starts-with(@id,'u_0_0_')]")).click();
		
		//WebElement btnCreateAccount=driver.findElement(By.xpath("//a[contains(@id,'u_0_0_')]"));
		//System.out.println(btnCreateAccount.isDisplayed());
		//System.out.println(btnCreateAccount.isEnabled());
		
		//following and following-sibling
		//driver.findElement(By.xpath("//button[@type='submit']/following::a[@role='button']")).click();
		//driver.findElement(By.xpath("//button[@type='submit']/../following-sibling::div[3]/a[@role='button']")).click();
		
		//ancestor : Selects all ancestors (parent, grandparent, etc.) of the current node
		driver.findElement(By.xpath("(//form[starts-with(@id,'u_0_2_')]//ancestor::a)[3]")).click();
		
		//descendant: Selects all descendants (children, grandchildren, etc.) of the current node
		//Login button locator using descendant
		//driver.findElement(By.xpath("//form[@class='_9vtf']/descendant::button")).click();
		
		//preceding and preceding-sibling
		//Login button
		//driver.findElement(By.xpath("//a[@role='button']/preceding::div[5]/button")).click();
		
		//Password label in orangehrmlive website
		//driver.findElement(By.xpath("//input[@type='password']/../preceding-sibling::div/label"));
		
		//parent and child
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//String credentials=driver.findElement(By.xpath("//form[@class='oxd-form']/parent::div/div/div/p[1]")).getText();
		//String credentials=driver.findElement(By.xpath("//form[@class='oxd-form']/../div/div/p[1]")).getText();
		//System.out.println(credentials);
		
		//Login button locator using child
		//driver.findElement(By.xpath("//form[@class='oxd-form']/child::div[3]/button")).click();
		
		//and or
		//driver.findElement(By.xpath("//input[@name='email' and @id='email']")).sendKeys("nagarjun@gmail.com");
		
		//driver.findElement(By.xpath("//input[@name='email' or @id='emailid']")).sendKeys("nagarjun@gmail.com");
		
		
		//getText (after clicking Login button)
		//String validationMessage=driver.findElement(By.className("_9ay7")).getText();
		//String validationMessage=driver.findElement(By.xpath("//input[@name='email' and @id='email']/following-sibling::div[2]")).getText();
		//System.out.println(validationMessage);
	}

}
