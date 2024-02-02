package suite.SeleniumTraining;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshot {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://licindia.in/home");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector(".btn.btn-default")).click();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String timestamp=LocalDateTime.now().toString().replace("-", "").replace(":", "").replace(".", "");
		String filePath=System.getProperty("user.dir")+"\\screenshots\\screenshot_"+timestamp+".png";
		
		File dest=new File(filePath);
		
		
		FileUtils.copyFile(source, dest);
		
	}

}
