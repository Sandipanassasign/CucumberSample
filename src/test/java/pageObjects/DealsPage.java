package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealsPage {
	
	WebDriver driver;
	
	public DealsPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	
	By searchField=By.cssSelector("#search-field");
	By dealProductName=By.cssSelector("tbody tr td:nth-child(1)");
	
	public void searchProduct(String prodStName) {
		
		driver.findElement(searchField).sendKeys(prodStName);
		
	}
	
	public String grabDealPageProName() {
		
		String DealsProdName=driver.findElement(dealProductName).getText();
		System.out.println("Deal pages product : "+DealsProdName);
		
		return DealsProdName;
	}
	
	
	
	
}
