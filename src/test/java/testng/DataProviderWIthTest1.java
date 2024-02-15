package testng;

import org.testng.annotations.Test;

public class DataProviderWIthTest1 {
	
	
	@Test(dataProvider = "getLoginData", dataProviderClass = DataProviders.class)
	public void TC_Login(String username, String password) {
		
		System.out.println(username+" --- "+ password);
		
		
	}

}
