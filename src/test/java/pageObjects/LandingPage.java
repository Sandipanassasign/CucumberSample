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
	By addProduct=By.cssSelector("a.increment");
	By addToCart=By.cssSelector("div[class='product-action'] button[type='button']");
	By CartIcon=By.cssSelector("img[alt='Cart']");
	By proceedCheckOut= By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By productQuantity=By.cssSelector("input[class='quantity']");
	
	public void searchproduct(String prodStName) {
		
		driver.findElement(search).sendKeys(prodStName);
	}
	
	public String grabProductName() {
		
		String ProductName=driver.findElement(productName).getText();
		
		
		String[] splitedPro=ProductName.split("-");
		String spl=splitedPro[0].trim();
		
		return spl;
		
		
		
		
	}
	
	public void addtoCart() {
		
		for(int i=0;i<3;i++) {
		driver.findElement(addProduct).click();
		}
		
		
		driver.findElement(addToCart).click();
		
		
	}
	
	public String getTitleLandingPage() {
		
		return driver.getTitle();
	}
	
	
		
	public void clickCartIconandProceed() {
		
		driver.findElement(CartIcon).click();
		
		driver.findElement(proceedCheckOut).click();
		
	}
	
	public String getproductQuantity() {
		
		
		String quantity=driver.findElement(productQuantity).getText();
		
		return quantity;
	
	}
	
	
	
	
	
	
	
	
	
	
	
} 


