package testng;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;


public class ListenersDemo implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart method");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess method");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure method");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped method");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart method");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish method");
		
	}

	

}


/*

Listeners:

ISuiteListener
IInvokedMethod
IReporter
IConfigurationListener
IHookable
ITestListener  *




*/