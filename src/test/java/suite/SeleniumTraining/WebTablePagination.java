package suite.SeleniumTraining;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class WebTablePagination {
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(System.getProperty("user.dir") + "\\adplusblock.crx"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://redmine.org/projects/redmine/issues");

		String parent = driver.getWindowHandle();

		WebElement operator = driver.findElement(By.id("operators_status_id"));
		Select op = new Select(operator);
		op.selectByVisibleText("is");

		Select status = new Select(driver.findElement(By.id("values_status_id_1")));
		status.selectByVisibleText("Confirmed");

		driver.findElement(By.linkText("Apply")).click();
		Thread.sleep(2000);

		List<WebElement> pages = driver.findElements(By.xpath("//span[@class='pagination']/ul/li"));

		System.out.println("page count: " + pages.size());

		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!parent.contentEquals(handle)) {
				driver.switchTo().window(handle);
				Thread.sleep(5000);
				driver.close();
			}
		}

		driver.switchTo().window(parent);
		
		int totalRecords=0;
		for (int i = 2; i < pages.size(); i++) {
			if (i != 2) {
				driver.findElement(By.xpath("//span[@class='pagination']/ul/li[" + i + "]/a")).click();
				Thread.sleep(5000);
			}

			List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'issues')]/tbody/tr"));
			System.out.println("Row count: " + rows.size());
			
			totalRecords=totalRecords + rows.size();
			
			for (int row = 1; row <= rows.size(); row++) {
				String ticketid = driver.findElement(By.xpath("//table[contains(@class,'issues')]/tbody/tr[" + row + "]/td[2]/a")).getText();
				System.out.println(ticketid);
			}
		}
		
		System.out.println("Total Records from all pages: "+totalRecords);

	}

}
