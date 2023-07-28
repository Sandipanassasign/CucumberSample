package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import utilities.TestContextSetup;

public class DealsPagestepDefination {
	
	public String DealsProdName; 
	TestContextSetup testContextSetup;
	
	
public DealsPagestepDefination(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
	}

	
	@Then("user searched for the same name {string} in deals page")
	public void user_searched_for_the_same_name_in_deals_page(String prodStName) {
		
		testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		Set<String> windows=testContextSetup.driver.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		
		String parentWin=it.next();
		String childWin=it.next();
		testContextSetup.driver.switchTo().window(childWin);
		
		testContextSetup.driver.findElement(By.cssSelector("#search-field")).sendKeys(prodStName);
		
		DealsProdName=testContextSetup.driver.findElement(By.cssSelector("tbody tr td:nth-child(1)")).getText();
		System.out.println(DealsProdName);
		
		
	
	 	}
	
	@Then("validate product name in Homepage and Deals page are same")
	public void validate_product_name_in_homepage_and_deals_page_are_same() {
	   
		
		Assert.assertEquals(DealsProdName, testContextSetup.FinalProductName);
		testContextSetup.driver.quit();
		
	}
	
	

}
