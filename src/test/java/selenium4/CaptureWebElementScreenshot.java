package selenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class CaptureWebElementScreenshot {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		//above()
		WebElement username=driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.name("password")));
		username.sendKeys("Admin");
		
		File userNameScreenshot=username.getScreenshotAs(OutputType.FILE);
		
		String datetimestamp=LocalDateTime.now().toString().replace(":", "").replace("-", "").replace(".", "");
		String filePath=System.getProperty("user.dir")+"\\screenshots\\webelement_"+datetimestamp+".png";
		
		FileUtils.copyFile(userNameScreenshot, new File(filePath));
		
		
		
	}

}
