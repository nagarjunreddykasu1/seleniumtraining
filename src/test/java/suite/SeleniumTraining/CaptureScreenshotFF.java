package suite.SeleniumTraining;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureScreenshotFF {
	public static void main(String[] args) throws IOException {
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://licindia.in/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector(".btn.btn-default")).click();
		
		File page=((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
		
		String timestamp=LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "");
		String filePath=System.getProperty("user.dir")+"\\screenshots\\fullpagescreenshot_"+timestamp+".png";
		
		File dest=new File(filePath);
		
		
		FileUtils.copyFile(page, dest);
		
	}

}
