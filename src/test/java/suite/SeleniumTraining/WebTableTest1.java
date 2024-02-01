package suite.SeleniumTraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTest1 {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//To maximize browser window
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/tables");
		
		
		List<WebElement> headers=driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		ArrayList<String> actualHeaders=new ArrayList<>();
		for(int i=1;i<=headers.size();i++) {
			String header=driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th["+i+"]")).getText();
			//System.out.println(header);
			actualHeaders.add(header);
		}
		
		System.out.println("Actual Header names: "+actualHeaders);
		
		
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		
		////table[@id='table1']/tbody/tr[3]/td[3]
		
		for(int i=1;i<=rows.size();i++) {
			String email=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(email);
		}
		
		
	}

}
