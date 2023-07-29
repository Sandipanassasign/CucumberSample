package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\GlobalProperties.properties");
		Properties Prop=new Properties();
		Prop.load(fis);
		String url=Prop.getProperty("URL");
		
		
		if(driver==null)
		{
			
			if (Prop.getProperty("browser").equalsIgnoreCase("chrome")) 
			{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized","--incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
			}
			
			else if(Prop.getProperty("browser").equalsIgnoreCase("firefox")) 
			{
				
				FirefoxOptions options=new FirefoxOptions();
				options.addArguments("start-maximized","--incognito");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(options);
				
							
			}
						
		driver.get(url);
		}
		return driver;
		
	}

}
