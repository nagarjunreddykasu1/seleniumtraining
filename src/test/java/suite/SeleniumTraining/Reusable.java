package suite.SeleniumTraining;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class Reusable {
	
	
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

}
