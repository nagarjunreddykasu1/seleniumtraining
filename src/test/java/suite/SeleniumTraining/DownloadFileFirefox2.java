package suite.SeleniumTraining;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadFileFirefox2 {
	
	public static void main(String[] args) throws Exception {
		String downloadFilePath=System.getProperty("user.dir")+"\\downloads";
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.download.dir", downloadFilePath);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain");//MIME type
		
		
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
		
		WebDriver driver=new FirefoxDriver(options);
		driver.get("https://the-internet.herokuapp.com/download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.linkText("LambdaTest.txt")).click();
		
		Thread.sleep(5000);
		//div[@class='example']/a[3]
		
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
