package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\features",
				glue = "\\stepDefinations",monochrome = true,
				plugin = {"pretty","html:target/cucumber.html"}
		
				)
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
