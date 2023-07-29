package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage {
	
	WebDriver driver;
	
	public SummaryPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	By productName=By.cssSelector(".product-name");
	By quantity=By.cssSelector(".quantity");
	By totalcount=By.cssSelector("tbody td:last-of-type");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	
	
	public String getQuantity() {
		
	String proQuantity=	driver.findElement(quantity).getText();
	return proQuantity;
	
	}
	
	public String getProductname() {
		
		String ProductName=	driver.findElement(productName).getText();
		String[] splitedPro=ProductName.split(" ");
		String spl=splitedPro[0].trim();
		
		return spl;
		
		}
	
	public boolean verifyButton() {
		
		
		return driver.findElement(promoBtn).isDisplayed();
		
		
	}
	
	
	public boolean verifyPlaceBtn() {
		
		
		return driver.findElement(placeOrder).isDisplayed();
		
		
	}
	
	public void orderPlace() {
		
		driver.findElement(placeOrder).click();
	}
	
	
	

}
