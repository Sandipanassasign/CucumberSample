package utilities;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String FinalProductName;
	public PageObjectManager pageObjectManager;
	public BaseTest baseTest;
	public GenericUtils genericUtils;
	public TestContextSetup() {
		
		pageObjectManager=new PageObjectManager(baseTest.WebDriverManager());
		baseTest=new BaseTest();
		genericUtils=new GenericUtils(baseTest.WebDriverManager());
		
		
		
	}
	

}
