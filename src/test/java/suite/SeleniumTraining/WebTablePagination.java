package suite.SeleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebTablePagination {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//To maximize browser window
		driver.manage().window().maximize();
		driver.get("https://redmine.org/projects/redmine/issues");
		
		
		WebElement operator=driver.findElement(By.id("operators_status_id"));
		Select op=new Select(operator);
		op.selectByVisibleText("is");
		
		Select status=new Select(driver.findElement(By.id("values_status_id_1")));
		status.selectByVisibleText("Confirmed");
		
		driver.findElement(By.linkText("Apply")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//g[@class='down']")).click();
		List<WebElement> pages=driver.findElements(By.xpath("//span[@class='pagination']/ul/li"));
		
		System.out.println("page count: "+pages.size());
		
		for(int i=2;i<pages.size();i++) {
			
			//if(driver.findElements(By.xpath("//g[@class='down']")).size()>0) {
				//driver.findElement(By.xpath("//g[@class='down']")).click();
			//}
			
			if(i!=2) {
				//WebElement frame=driver.findElement(By.id("aswift_2"));
				//driver.findElement(By.id("values_status_id_1")).sendKeys(Keys.PAGE_UP);
				
				/*
				 * if(driver.findElements(By.id("aswift_2")).size()>0) {
				 * 
				 * driver.switchTo().frame("aswift_2");
				 * driver.findElement(By.xpath("//g[@class='down']")).click();
				 * 
				 * //driver.switchTo().frame("ad_iframe");
				 * //driver.findElement(By.id("dismiss-button")).click(); }
				 */
				 
				
				//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//ul[@class='pages']/li")));
				driver.findElement(By.xpath("//span[@class='pagination']/ul/li["+i+"]/a")).click();
				Thread.sleep(5000);
			}
			
			
			
			List<WebElement> rows=driver.findElements(By.xpath("//table[contains(@class,'issues')]/tbody/tr"));
			System.out.println("Row count: "+rows.size());
			
			//table[contains(@class,'issues')]/tbody/tr[1]/td[2]
			
			for(int row=1;row<=rows.size();row++) {
				String ticketid=driver.findElement(By.xpath("//table[contains(@class,'issues')]/tbody/tr["+row+"]/td[2]/a")).getText();
				System.out.println(ticketid);
			}
			
			
			
		}
		
		
		
		
		
	}

}
