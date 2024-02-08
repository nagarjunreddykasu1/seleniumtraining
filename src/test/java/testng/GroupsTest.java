package testng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsTest {
	
	@Test(groups= {"sanity"})
	public void TC_Login_01() {
		System.out.println("TC_Login_01 test case");
	}
	@Test(groups= {"sanity","regression"})
	public void TC_Login_02() {
		System.out.println("TC_Login_02 test case");
	}
	@Test(groups= {"sanity"})
	public void TC_Login_03() {
		System.out.println("TC_Login_03 test case");
	}
	@Test(groups= {"regression"})
	public void TC_Login_04() {
		System.out.println("TC_Login_04 test case");
	}
	@Test(groups= {"regression"})
	public void TC_Login_05() {
		System.out.println("TC_Login_05 test case");
	}
	@Test(groups= {"regression"})
	public void TC_Login_06() {
		System.out.println("TC_Login_06 test case");
	}
	@Test(groups= {"regression"})
	public void TC_Login_07() {
		System.out.println("TC_Login_07 test case");
	}
	@Test(groups= {"sanity"})
	public void TC_Login_08() {
		System.out.println("TC_Login_08 test case");
	}
	@Test(groups= {"endtoend"})
	public void TC_Login_09() {
		System.out.println("TC_Login_09 test case");
	}
	@Test(groups= {"endtoend"})
	public void TC_Login_10() {
		System.out.println("TC_Login_10 test case");
	}
	
	@Test(dependsOnGroups = {"sanity"})
	public void TC_Login_11() {
		System.out.println("TC_Login_11 test case");
	}
	
	@BeforeGroups(groups= {"sanity"})
	@Test
	public void TC_Login_12() {
		System.out.println("TC_Login_12 test case");
	}
	
	@AfterGroups(groups= {"sanity"})
	@Test
	public void TC_Login_13() {
		System.out.println("TC_Login_13 test case");
	}
	
		
	
	
	

}
