package datadriven;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Log4JTest {
	Logger log;
	@BeforeSuite
	public void beforeSuite() {
		log=Logger.getLogger(Log4JTest.class);
		DOMConfigurator.configure("log4j.xml");
	}
	
	//verify the page title
	@Test
	public void TC_Login_01() {
		try {
			
			
			System.out.println(10/0);
			
			
			log.info("Actual and expected page titles are equal");
		}
		catch(Exception e) {
			
			log.error("Actual and expected page titles are NOT equal.");
			log.error(e);
		}
		
		
		
		
	}

}
