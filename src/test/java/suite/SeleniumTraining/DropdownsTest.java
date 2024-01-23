package suite.SeleniumTraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownsTest {
	
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://qa.circulus.io/login.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String expected="CEO,President,";
		String[] arr=expected.split(",");
		
		ArrayList<String> expectedOptions=new ArrayList<>(Arrays.asList(arr));
		
		
		driver.findElement(By.linkText("Sign Up")).click();
		
		WebElement ddlJobTitle=driver.findElement(By.id("ddlJobTitle"));
		
		Select sel=new Select(ddlJobTitle);
		
		//sel.selectByIndex(2);
		//sel.selectByValue("12");
		sel.selectByVisibleText("Director Finance");
		
		List<WebElement> options=sel.getOptions();
		
		ArrayList<String> actualOptions=new ArrayList<>();
		
		for(int i=0;i<options.size();i++) {
			actualOptions.add(options.get(i).getText());
		}
		
		for(WebElement element:options) {
			System.out.println(element.getText());
		}
		
		Iterator<WebElement> itr=options.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
		
		actualOptions.remove(0);
		System.out.println(actualOptions);
		
		
		System.out.println("Selected option is: "+sel.getFirstSelectedOption().getText());
		
		
		
	}

}

/*

Single select drop downs

Multi select drop downs

*/