package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
	}

	
	By search=By.cssSelector("input[type='search']");
	By productName=By.cssSelector("h4[class='product-name']");
	
	
	public void searchproduct(String prodStName) {
		
		driver.findElement(search).sendKeys(prodStName);
	}
	
	public String grabProductName() {
		
		String ProductName=driver.findElement(productName).getText();
		System.out.println(ProductName);
		
		String[] splitedPro=ProductName.split("-");
		String spl=splitedPro[0].trim();
		
		return spl;
		
		
		
		
	}
	
	
		public void switchtoDealsPage() {
		
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		
		String parentWin=it.next();
		String childWin=it.next();
		driver.switchTo().window(childWin);
	}
	
	
	
	
	
	
	
	
	
	
	
	
} 


