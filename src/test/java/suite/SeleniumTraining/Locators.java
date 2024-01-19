package suite.SeleniumTraining;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locators {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");
		
		WebDriver driver=new ChromeDriver(options);
		
		//WebDriver ffDriver=new FirefoxDriver();
		
		//To maximize browser window
		driver.manage().window().maximize();
		driver.get("https://facebook.com");
		
		
		//WebElement email=driver.findElement(By.id("email"));
		//email.sendKeys("nagarjun.sdet@gmail.com");
		
		//driver.findElement(By.id("email")).sendKeys("nagarjun.sdet@gmail.com");
		
		//driver.findElement(By.name("email")).sendKeys("nagarjun@gmail.com");
		
		//driver.findElement(By.className("inputtext")).sendKeys("nag@gmail.com");
		
		//driver.findElement(By.cssSelector("#email")).sendKeys("nag@gmail.com");
		
		//Thread.sleep(2000);
		
		//driver.findElement(By.tagName("input")).sendKeys("nag@gmail.com");
		
		//driver.findElement(By.linkText("Forgotten password?")).click();
		
		//driver.findElement(By.partialLinkText("password?")).click();
		
		
		//driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nag@gmail.com");
		
		//driver.findElement(By.xpath("//input[contains(@placeholder,'phone')]")).sendKeys("nag@gmail.com");
		
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Email')]")).sendKeys("nag@gmail.com");
		
		
	}

}


/*
findElement

Locators :
===========
8 types of locators (these are the static methods implemented in By class)

id()
name()
className()
cssSelector():

syntax:
.classAttributevalue
 or
#idAttributeValue

tagName:

linkText:

partialLinkText:

xpath:

Absolute:
/html/body/div/div/div/div/div/div[2]div/div/form/div/div/input

Relative

//tagname[@attribute_name='valueofattribute']

//tagname[contains(@attribute,'partialvalue')]

//tagname[contains(text(),'partialvalue')]

//tagname[starts-with(@attribute,'startingpartialvalue')]
//input[starts-with(@placeholder,'Email')]

following
following-sibling
preceding
preceding-sibling






*/