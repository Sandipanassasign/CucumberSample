package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() {
		
		if(driver==null)
		{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized","--incognito");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		}
		return driver;
		
	}

}
