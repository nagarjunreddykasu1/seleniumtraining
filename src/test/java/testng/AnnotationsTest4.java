package testng;

import org.testng.annotations.Test;

public class AnnotationsTest4 {
	
	@Test(invocationCount = 10)
	public void search() {
		System.out.println("search test case");
	}

}
