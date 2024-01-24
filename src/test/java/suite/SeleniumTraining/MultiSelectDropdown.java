package suite.SeleniumTraining;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropdown {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://techcanvass.com/Examples/multi-select.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		WebElement ddl=driver.findElement(By.id("multiselect"));
		
		Select sel=new Select(ddl);
		sel.selectByVisibleText("Volvo");
		
		sel.selectByVisibleText("Honda");
		
		sel.selectByVisibleText("Audi");
		
		System.out.println(sel.isMultiple());
		
		Thread.sleep(2000);
		
		//sel.deselectAll();
		
		//sel.deselectByVisibleText("Honda");
		
		
		List<WebElement> selected=sel.getAllSelectedOptions();
		
		ArrayList<String> selectedOptions=new ArrayList<>();
		for(WebElement element:selected) {
			selectedOptions.add(element.getText());
		}
		
		System.out.println("Selected Options: "+selectedOptions);
		
		
		
	}

}
