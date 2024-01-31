package suite.SeleniumTraining;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteTest2 {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/autocomplete/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//driver.switchTo().frame(0);
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		driver.findElement(By.id("tags")).sendKeys("j");
		
		List<WebElement> list=driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getText().contentEquals("Java")) {
				list.get(i).click();
				break;
			}
		}
		
	}

}
