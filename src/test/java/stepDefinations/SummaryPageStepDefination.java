package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.SummaryPage;
import utilities.TestContextSetup;

public class SummaryPageStepDefination {
	
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	SummaryPage summaryPage;
	
public SummaryPageStepDefination(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
		this.summaryPage=testContextSetup.pageObjectManager.getSummaryPage();
		this.landingPage= testContextSetup.pageObjectManager.getLandingPage();
	}

	

	
@Then("User proceeds to checkout page and validate the ProductName")
public void user_proceeds_to_checkout_page_and_validate_the_product_name() throws InterruptedException {
    
	
	
	
	
	String SummaryProductName= summaryPage.getProductname();
	String LandingPagesProName=landingPage.grabProductName();
	Assert.assertEquals(SummaryProductName, LandingPagesProName);
	
	
}

@Then("User validates the promocode and placeorderbutton and place the order")
public void User_validates_the_promocode_and_placeorderbutton_and_place_the_order() {
   
	testContextSetup.genericUtils.explecitWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoBtn")));
	Assert.assertTrue(summaryPage.verifyButton());
	Assert.assertTrue(summaryPage.verifyPlaceBtn());
	
}

@Then("Validate the order is placed successfully")
public void validate_the_order_is_placed_successfully() {


	summaryPage.orderPlace();
	
	
}
	










}
