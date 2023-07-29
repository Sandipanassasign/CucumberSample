package utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	
		WebDriver driver;
		
		public GenericUtils(WebDriver driver) 
		
		{
			
			this.driver=driver;
		}
	
	
public void switchtoDealsPage() {
		
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		
		String parentsWin=it.next();
		String childWin=it.next();
		driver.switchTo().window(childWin);
	}

public WebDriverWait explecitWait() {
	
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	
}

}
