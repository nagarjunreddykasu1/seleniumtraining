package suite.SeleniumTraining;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class HttpsCertificationsTest {
	
	public static void main(String[] args) {
		
		
		ChromeOptions options=new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://129.213.162.67:9074/clientportal/ajguat");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		
	}

}
