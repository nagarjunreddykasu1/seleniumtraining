package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownload {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		String fileName=driver.findElement(By.xpath("//div[@class='example']/a[1]")).getText();
		driver.findElement(By.linkText(fileName)).click();
		
		
	}

}
