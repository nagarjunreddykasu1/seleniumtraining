package suite.SeleniumTraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseoverTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://licindia.in/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.cssSelector(".btn.btn-default")).click();
		
		//WebElement products=driver.findElement(By.xpath("//a[@title='Products']"));
		//Actions action=new Actions(driver);
		//action.moveToElement(products).perform();
		
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//a[@title='Products']"))).perform();
		
		Thread.sleep(2000);
		
		List<WebElement> submenuList=driver.findElements(By.xpath("//div[@class='siteNav']/ul/li[3]/ul/li"));
		
		//div[@class='siteNav']/ul/li[3]/ul/li[1]/a
		//div[@class='siteNav']/ul/li[3]/ul/li[2]/a
		//div[@class='siteNav']/ul/li[3]/ul/li[3]/a
		
		ArrayList<String> actualProducts=new ArrayList<>();
		
		for(int i=1;i<=submenuList.size();i++) {
			String submenu=driver.findElement(By.xpath("//div[@class='siteNav']/ul/li[3]/ul/li["+i+"]/a")).getText();
			//System.out.println(submenu);
			actualProducts.add(submenu);
		}
		
		System.out.println("Actual Products: "+actualProducts);
		
		//a[@title='Health Plans']
		//link text -> Health Plans
		//div[@class='siteNav']/ul/li[3]/ul/li[6]/a
		
		driver.findElement(By.xpath("//a[@title='Health Plans']")).click();
		
		System.out.println(driver.getTitle());
		
		String header=driver.findElement(By.id("maincontent")).getText();
		System.out.println(header);
		
		
		
		
		
		
		
		
	}

}
