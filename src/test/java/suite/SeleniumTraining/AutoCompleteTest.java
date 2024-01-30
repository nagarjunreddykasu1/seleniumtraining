package suite.SeleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/AutoComplete.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("searchbox")).sendKeys("united");
		
		//div[@id='menucontainer']/ul/li
		//ul[@id='ui-id-1']/li
		//ul/li[@class='ui-menu-item']
		//.ui-menu-item
		
		Thread.sleep(1000);
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@id='menucontainer']/ul/li"));
		
		for(int i=0;i<list.size();i++) {
			String option=list.get(i).getText();
			if(option.contentEquals("United Kingdom")) {
				list.get(i).click();
				break;
			}
			
			
		}
		
	}

}
