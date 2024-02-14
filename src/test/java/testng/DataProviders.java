package testng;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider
	public static Object[][] getData(){
		return new Object[][] {{"adminuser","admin123","invuser"},{"Admin","Asdf@123","invpwd"},{"","","blank"},{"Admin","admin123","valid"}};
	}
	
	@DataProvider
	public static Object[][] getTestData(Method method){
		String testcase = method.getName();
		if(testcase.equals("TC_Login_01")) {
			return new Object[][] {{"user1@gmail.com","Test@123"}};
		}
		else if(testcase.equals("TC_Login_02")) {
			return new Object[][] {{"Admin","admin123"}};
		}
		else {
			return new Object[][] {{"TestUser","Xtg$2341"}};
		}
		
	}
	
	

}
