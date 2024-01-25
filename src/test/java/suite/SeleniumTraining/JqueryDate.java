package suite.SeleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDate {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		System.out.println("Switched to frame...");
		driver.findElement(By.id("datepicker")).click();
		//String month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		//System.out.println("Month: "+month);

		while(!driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals("December")) {
			driver.findElement(By.cssSelector("[class*='ui-datepicker-next'] [class*='ui-icon-circle-triangle-e']")).click();
			Thread.sleep(1000);
		}

		//driver.findElement(By.xpath("//a[text()='31']")).click();

		//td[@data-handler='selectDay']/a
		
		List<WebElement> dates=driver.findElements(By.xpath("//td[@data-handler='selectDay']/a"));
		for(int i=0;i<dates.size();i++) {
			if(dates.get(i).getText().equals("31")) {
				dates.get(i).click();
				break;
			}
		}



	}

}
