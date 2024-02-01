package suite.SeleniumTraining;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileRobot {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//div[contains(@class,'btn')]
		//div[contains(@class,'btn-primary')]
		//div[contains(@class,'btn-file')]
		
		driver.findElement(By.xpath("//div[contains(@class,'btn-file')]")).click();
		
		Thread.sleep(2000);
		
		String filePath=System.getProperty("user.dir")+"\\upload\\Petrol_Bill.jpg";
		
		/*
		 * StringSelection file=new StringSelection(filePath);
		 * Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		 * 
		 * Robot robot=new Robot();
		 * 
		 * robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V);
		 * 
		 * robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);
		 * 
		 * Thread.sleep(3000);
		 * 
		 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
		 */
		
		Reusable.uploadFile(filePath);
		
		
		
		
	}

}
