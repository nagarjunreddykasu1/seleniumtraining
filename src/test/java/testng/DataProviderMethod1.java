package testng;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderMethod1 {
	
	
	@Test(dataProvider = "getTestData", dataProviderClass = DataProviders.class )
	public void TC_Login_01(String username, String password) {
		System.out.println(username+" --- "+password);
	}
	
	@Test(dataProvider = "getTestData", dataProviderClass = DataProviders.class )
	public void TC_Login_02(String username, String password) {
		System.out.println(username+" --- "+password);
	}
	
	@Test(dataProvider = "getTestData", dataProviderClass = DataProviders.class )
	public void TC_Login_03(String username, String password) {
		System.out.println(username+" --- "+password);
	}
	
	
	/*
	 * @DataProvider public Object[][] getTestData(Method method){ String testcase =
	 * method.getName(); if(testcase.equals("TC_Login_01")) { return new Object[][]
	 * {{"user1@gmail.com","Test@123"}}; } else if(testcase.equals("TC_Login_02")) {
	 * return new Object[][] {{"Admin","admin123"}}; } else { return new Object[][]
	 * {{"TestUser","Xtg$2341"}}; }
	 * 
	 * }
	 */
	
	

}
