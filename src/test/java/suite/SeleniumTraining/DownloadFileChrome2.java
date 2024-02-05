package suite.SeleniumTraining;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFileChrome2 {
	public static void main(String[] args) throws Exception {
		
		//D:\XTGlobal\SeleniumTraining\downloads
		
		String downloadFilePath=System.getProperty("user.dir")+"\\downloads";
		HashMap<String, Object> chromePrefs=new HashMap<>();
		chromePrefs.put("download.default_directory", downloadFilePath);
		
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.linkText("LambdaTest.txt")).click();
		
		Thread.sleep(5000);
		
		String fileName="LambdaTest.txt";
		File dir=new File(downloadFilePath);
		File[] files=dir.listFiles();
		
		boolean isDownloaded=false;
		for(int i=0;i<files.length;i++) {
			if(files[i].getName().contentEquals(fileName)) {
				isDownloaded=true;
				break;
			}
		}
		
		if(isDownloaded) {
			System.out.println("File is downloaded...");
		}
		else {
			System.out.println("File is NOT downloaded...");
			throw new Exception("File is NOT downloaded");
		}
	}

}
