package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utilities.BaseTest;
import utilities.GenericUtils;
import utilities.TestContextSetup;

public class LandingPagestepDefination {
	
	public WebDriver driver;
	public String FinalProductName;
	public PageObjectManager pageObjectManager;
	LandingPage landingPage;
	TestContextSetup testContextSetup;
	
	public LandingPagestepDefination(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
		this.landingPage= testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("user is on the Greenkart homepage")
	public void user_is_on_the_greenkart_homepage() {
		
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		
	}

	@When("^user searched for name (.+) in the searchbar and extract actual product name$")
	public void user_searched_for_name_in_the_searchbar_and_extract_actual_product_name(String prodStName) throws InterruptedException {
		
		SoftAssert softass=new SoftAssert();
		
		
		landingPage.searchproduct(prodStName);
		
		
		Thread.sleep(3000);
		
		testContextSetup.FinalProductName=landingPage.grabProductName();
		
		System.out.println(testContextSetup.FinalProductName);
		
		softass.assertEquals(testContextSetup.FinalProductName, "Tomato");
		
		testContextSetup.ProductQuantity=landingPage.getproductQuantity();
		
	}
	
	
	
	
	
	@When("User add the Product count to three products and Add to Cart")
	public void user_add_the_product_count_to_products_and_add_to_cart() {
	    
//		testContextSetup.genericUtils.explecitWait().until(ExpectedConditions.visibilityOfElementLocated(""))
		
		
		landingPage.addtoCart();
		landingPage.clickCartIconandProceed();
		
	}
	
	

}
