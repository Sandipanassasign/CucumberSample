package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
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
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException
	{	
		WebDriver driver=testContextSetup.baseTest.WebDriverManager();
		
		if(scenario.isFailed())
		{
			TakesScreenshot Screenshot= ((TakesScreenshot)driver);
			File Srcpath=Screenshot.getScreenshotAs(OutputType.FILE);
			
			
			byte[] fileAttach=FileUtils.readFileToByteArray(Srcpath);
			scenario.attach(fileAttach, "image/png", "screenshot");
		}
		
		
	}
	

}
