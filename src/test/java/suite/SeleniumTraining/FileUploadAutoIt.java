package suite.SeleniumTraining;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadAutoIt {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.automationtesting.in/FileUpload.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//div[contains(@class,'btn')]
		//div[contains(@class,'btn-primary')]
		//div[contains(@class,'btn-file')]
		
		driver.findElement(By.xpath("//div[contains(@class,'btn-file')]")).click();
		
		Thread.sleep(2000);
		//Runtime.getRuntime().exec("D:\\XTGlobal\\SeleniumTraining\\upload\\upload.exe");
		
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\upload\\upload.exe");
		
		//ControlFocus("title","text","controlid")
	}

}
