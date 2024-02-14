package testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersTest {
	
	
	@Test(dataProvider = "Credentials" )
	public void TC_Login_01(String username, String password) {
		
		System.out.println(username+" --- "+password);
		
	}
	
	
	
	@DataProvider(name="Credentials")
	public Object[][] getData(){
		
		/*
		 * Object[][] obj=new Object[3][2];
		 * 
		 * obj[0][0]="user1@gmail.com"; obj[0][1]="Test@123";
		 * 
		 * obj[1][0]="user2@gmail.com"; obj[1][1]="Abc@123";
		 * 
		 * obj[2][0]="user3@gmail.com"; obj[2][1]="Lkaj@9801";
		 * 
		 * return obj;
		 */
		
		return new Object[][] {{"user1@gmail.com","Test@123"},{"user2@gmail.com","Abc@333"},{"user3@gmail.com","Asdf$235"}};
		
		
	}
	

}


