package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import utilities.TestContextSetup;

public class Hooks {
	public TestContextSetup testContextSetup;
	public Hooks(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
	}
	
	
	@After
	public void afterSecnario() throws IOException {
		
		testContextSetup.baseTest.WebDriverManager().quit();;
		

		
	}
	

}
