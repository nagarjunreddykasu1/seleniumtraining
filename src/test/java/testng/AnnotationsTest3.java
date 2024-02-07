package testng;

import org.testng.annotations.Test;

public class AnnotationsTest3 {
	
	@Test(priority=1)
	public void login() {
		System.out.println("login test case");
	}
	
	@Test(priority=2)
	public void dashboard() {
		System.out.println("dashboard test case");
	}
	
	@Test(priority=3)
	public void search() {
		System.out.println("search test case");
	}

}

/*
Before setting priority:
==========================
dashboard test case
login test case
search test case

after setting priority:
=======================
login test case
dashboard test case
search test case

*/