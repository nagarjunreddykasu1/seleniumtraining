package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsTest1 {
	
	
	@Test
	public void TC_Login_01() {
		System.out.println("TC_Login_01 test case");
	}
	
	@Test
	public void TC_Login_02() {
		System.out.println("TC_Login_02 test case");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After method");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class method");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test method");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite method");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite method");
	}
	
	
	
	
	

}
