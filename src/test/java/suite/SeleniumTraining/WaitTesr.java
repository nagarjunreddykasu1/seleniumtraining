package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitTesr {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//driver.get("http://qa.circulus.io/login.aspx");
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Dimension dim=driver.findElement(By.id("TxtEmail")).getSize();
		//System.out.println(dim.height+" -- "+dim.width);
		
		//Point p=driver.findElement(By.id("TxtEmail")).getLocation();
		//System.out.println(p.x+" -- "+p.y);
		
		
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div[2]/input")).click();
		
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/div/div[2]/input")).sendKeys("HYD");
		
	}

}
