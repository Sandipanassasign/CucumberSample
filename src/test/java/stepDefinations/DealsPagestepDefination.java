package stepDefinations;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.DealsPage;
import pageObjects.LandingPage;
import utilities.GenericUtils;
import utilities.TestContextSetup;

public class DealsPagestepDefination {
	
	
	TestContextSetup testContextSetup;
	
	
public DealsPagestepDefination(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
	}

	
	@Then("user searched for the same name {string} in deals page")
	public void user_searched_for_the_same_name_in_deals_page(String prodStName) {
		
		DealsPage dealPage=testContextSetup.pageObjectManager.getDealsPage();
		LandingPage landingPage= testContextSetup.pageObjectManager.getLandingPage() ;
		
		testContextSetup.genericUtils.switchtoDealsPage();
		
		dealPage.searchProduct(prodStName);
		dealPage.grabDealPageProName();
	
	 	}
	
	@Then("validate product name in Homepage and Deals page are same")
	public void validate_product_name_in_homepage_and_deals_page_are_same() {
		
		
		DealsPage dealPage=testContextSetup.pageObjectManager.getDealsPage();
		
		Assert.assertEquals(dealPage.grabDealPageProName(), testContextSetup.FinalProductName);
		testContextSetup.driver.quit();
		
	}
	
	
	
	

}
