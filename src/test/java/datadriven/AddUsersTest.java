package datadriven;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testng.AddUser;

public class AddUsersTest {
	
	
	@Test(dataProvider = "getUserData")
	public void TC_AddUser(AddUser user) {
		System.out.println(user.tcId+" - "+user.firstName+" - "+user.lastName+" - "+user.empId+" - "+user.emailId+" - "+user.address);
	}
	
	
	
	
	
	@DataProvider
	public Iterator<AddUser> getUserData(Method method) throws IOException {
		//D:\XTGlobal\SeleniumTraining\src\test\java\datadriven\CreateUsers.xlsx
		
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\datadriven\\CreateUsers.xlsx";
		
		ExcelReader excel=new ExcelReader(path);
		
		ArrayList<AddUser> list=new ArrayList<>();
		list.addAll(excel.getUsersDataFromExcel("Sheet1", "TCID", method.getName()));
		
		return list.iterator();
		
	}

}
