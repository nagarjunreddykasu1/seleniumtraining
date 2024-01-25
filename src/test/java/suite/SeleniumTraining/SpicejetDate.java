package suite.SeleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SpicejetDate {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement cityFrom=driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div[2]/input"));
		cityFrom.click();
		
		cityFrom.sendKeys("HYD");
		
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/div/div[2]/input")).sendKeys("DEL");
		Thread.sleep(2000);
		////div[@class='css-1dbjc4n r-k8qxaj']/div
		//[class*='r-k8qxaj'] [class*='r-1kfrs79']
		
		List<WebElement> titles=driver.findElements(By.cssSelector("[class*='r-k8qxaj'] [class*='r-1kfrs79']"));
		
		/*
		 * for(int i=0;i<titles.size();i+=2) { //String
		 * currentMonth=titles.get(i).getText(); //System.out.println(currentMonth);
		 * if(!titles.get(i).getText().contains("September") &&
		 * !titles.get(i+1).getText().contains("September")) {
		 * 
		 * System.out.println(titles.get(i).getText()+" --- "+titles.get(i+1).getText())
		 * ;
		 * 
		 * driver.findElement(By.xpath(
		 * "//div[@data-testid='undefined-calendar-picker']/div[1]")).click();
		 * Thread.sleep(2000); } else { break; } }
		 */
		
		
		for(int i=1;i<titles.size();i++) {
			String currentMonth=titles.get(i).getText();
			System.out.println(currentMonth);
			if(!titles.get(i).getText().contains("May")) {
				if(i==3 || i==5 || i==7 || i==9) {
					driver.findElement(By.xpath("//div[@data-testid='undefined-calendar-picker']/div[1]")).click();
					Thread.sleep(2000);
				}
			}
			else {
				driver.findElements(By.xpath("//div[text()='20']")).get(i).click();
				break;
			}
		}
		
		
	}

}
