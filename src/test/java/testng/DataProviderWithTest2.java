package testng;

import org.testng.annotations.Test;

public class DataProviderWithTest2 {
	
	
	@Test(dataProvider = "getLoginData", dataProviderClass = DataProviders.class)
	public void TC_Search(String username, String password, String flag) {
		System.out.println(username+" --- "+password+" --- "+flag);
	}

}
