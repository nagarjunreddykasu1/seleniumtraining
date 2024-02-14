package testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import suite.SeleniumTraining.Reusable;

public class DataProvidersTest3 {
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void launchApp(String browser, String url) {
		Reusable.launchApp(browser, url);
	}
	
	@Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
	public void TC_Login(String username, String password, String flag) throws Exception {
		
		String expectedValidationMessage="Invalid credentials";
		String expectedMessage="Required";
		
		switch(flag) {
		case "invuser":
			Thread.sleep(2000);
			Reusable.sendKeys(Reusable.getDriver().findElement(By.name("username")), username);
			Reusable.sendKeys(Reusable.getWebElement("name", "password"), password);
			Reusable.click(Reusable.getWebElement("xpath", "//button[@type='submit']"));
			String actualValidationMessage=Reusable.getText(Reusable.getWebElement("xpath", "//div[contains(@class,'oxd-alert-content--error')]/p"));
			Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
			break;
		case "invpwd":
			Thread.sleep(2000);
			Reusable.sendKeys(Reusable.getDriver().findElement(By.name("username")), username);
			Reusable.sendKeys(Reusable.getWebElement("name", "password"), password);
			Reusable.click(Reusable.getWebElement("xpath", "//button[@type='submit']"));
			String actualValidationMessage1=Reusable.getText(Reusable.getWebElement("xpath", "//div[contains(@class,'oxd-alert-content--error')]/p"));
			Assert.assertEquals(actualValidationMessage1, expectedValidationMessage);
			break;
		case "blank":
			Thread.sleep(2000);
			Reusable.click(Reusable.getWebElement("xpath", "//button[@type='submit']"));
			String errUsername=Reusable.getText(Reusable.getWebElement("xpath","(//span[contains(@class,'oxd-input-field-error-message')])[1]"));
			String errPassword=Reusable.getText(Reusable.getWebElement("xpath","(//span[contains(@class,'oxd-input-field-error-message')])[2]"));
			
			Assert.assertEquals(errUsername, expectedMessage);
			Assert.assertEquals(errPassword, expectedMessage);
			break;
		case "valid":
			Thread.sleep(2000);
			Reusable.sendKeys(Reusable.getDriver().findElement(By.name("username")), username);
			Reusable.sendKeys(Reusable.getWebElement("name", "password"), password);
			Reusable.click(Reusable.getWebElement("xpath", "//button[@type='submit']"));
			
			String currenUrl=Reusable.getCurrentUrl();			
			if(currenUrl.contains("dashboard")) {
				System.out.println("user is redirected to dashboard page");
			}
			else {
				System.out.println("user is NOT redirected to dashboard page");
				throw new Exception("User is not logged in with valid credentials");
			}
		}
		
	}
	
	@AfterClass
	public void afterClass() {
		Reusable.quit();
	}

}
