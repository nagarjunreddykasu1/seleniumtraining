package suite.SeleniumTraining;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Reusable {
	static WebDriver driver;
	
	public static void click(WebElement element) {
		element.click();
	}
	
	
	public static void uploadFile(String filePath) throws AWTException, InterruptedException {
		StringSelection file=new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		
		Robot robot=new Robot();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public static void launchApp(String browser, String url) {
		if(browser.contentEquals("chrome")) {
			//ChromeOptions options=new ChromeOptions();
			//options.addArguments("headless");
			driver=new ChromeDriver();
		}
		else if(browser.contentEquals("firefox")) {
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--headless");
			driver=new FirefoxDriver(options);
		}
		else if(browser.contentEquals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	public static String getTitle() {
		return driver.getTitle();
	}
	
	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public static WebElement getWebElement(String locatorType, String locatorValue) {
		WebElement element = null;
		if(locatorType.equals("id")) {
			element=driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.equals("name")) {
			element=driver.findElement(By.name(locatorValue));
		}
		else if(locatorType.equals("xpath")) {
			element=driver.findElement(By.xpath(locatorValue));
		}
		
		return element;
		
	}

	
	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public static void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	
	
	public static String getText(WebElement element) {
		return element.getText();
	}
	
	
	
	
	
	
	
	
	

}
