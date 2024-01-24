package suite.SeleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerTest {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		WebElement date=driver.findElement(By.cssSelector("div[class*='elementor-field-type-date']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", date );
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("div[class*='elementor-field-type-date']")).click();
		
		
		//driver.findElement(By.xpath("//div[@class='flatpickr-current-month']/span")).getText();
		
		while(!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']/span")).getText().equals("December")) {
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}
		
		//driver.findElement(By.xpath("//span[text()='31']")).click();
		
		List<WebElement> days=driver.findElements(By.cssSelector("[class*='flatpickr-day ']"));
		
		for(int i=0;i<days.size();i++) {
			if(days.get(i).getText().equals("31")) {
				days.get(i).click();
				break;
			}
		}
		
		
		//tagname[@attributename='value']
		
		//css: .classname  #idattributename  div[class*='elementor-field-type-date']
	}

}
