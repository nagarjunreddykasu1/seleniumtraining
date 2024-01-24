package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebMethods {
	
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://qa.circulus.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String tagName=driver.findElement(By.id("TxtEmail")).getTagName();
		System.out.println("Tag name of username field: "+tagName);
		
		
		System.out.println(driver.findElement(By.id("TxtEmail")).getAttribute("maxlength"));
		
		
		Dimension dim=driver.findElement(By.id("TxtEmail")).getSize();
		
		System.out.println(dim.height+" -- "+dim.width);
		
		
		Point p=driver.findElement(By.id("TxtEmail")).getLocation();
		
		System.out.println(p.x+" -- "+p.y);
		
		
	}

}
