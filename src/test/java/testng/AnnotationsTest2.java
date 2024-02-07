package testng;

import org.testng.annotations.Test;

public class AnnotationsTest2 {
	
	
	
	@Test
	public void TC_Login_01() {
		System.out.println("TC_Login_01 test case");
		System.out.println(10/0);
	}
	
	@Test
	public void TC_Login_02() {
		System.out.println("TC_Login_02 test case");
	}
	
	@Test(dependsOnMethods= {"TC_Login_01"})
	public void TC_Login_03() {
		System.out.println("TC_Login_03 test case");
	}
	
	@Test(enabled=false)
	public void TC_Login_04() {
		System.out.println("TC_Login_04 test case");
	}

}

/*
Attributes in @Test
====================
Priority
enabled
dependsOnMethods
invocationCount
groups
dependsOnGroups

*/