package testng;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithList {
	
	
	@Test(dataProvider = "addUsers")
	public void TC_Add_Users(AddUsers users) {
		
		System.out.println(users.firstName+" --- "+users.lastName+" --- "+users.empId+" --- "+users.emailId);
		
		
		
	}
	
	
	
	@DataProvider
	public Iterator<AddUsers> addUsers(){
		
		
		ArrayList<AddUsers> al=new ArrayList<>();
		al.add(new AddUsers("Nagarjun","Kasu","XTG-001","nagarjun.sdet@gmail.com"));
		
		al.add(new AddUsers("Rahul","Nallapu","XTG-002","rahul@gmail.com"));
		
		al.add(new AddUsers("Lalitha","V","XTG-003","lalitha@gmail.com"));
		
		
		return al.iterator();
		
		
		
		
		
		
		
	}

}
