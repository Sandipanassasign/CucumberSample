package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utilities.TestContextSetup;

public class LandingPagestepDefination {
	
	public WebDriver driver;
	public String FinalProductName;
	public PageObjectManager pageObjectManager;
	
	TestContextSetup testContextSetup;
	
	public LandingPagestepDefination(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
	}
	
	@Given("user is on the Greenkart homepage")
	public void user_is_on_the_greenkart_homepage() {
		
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized","--incognito");
		WebDriverManager.chromedriver().setup();
		testContextSetup.driver = new ChromeDriver(options);
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise");

	}

	@When("user searched for name {string} in the searchbar and extract actual product name")
	public void user_searched_for_name_in_the_searchbar_and_extract_actual_product_name(String prodStName) throws InterruptedException {
		
		
		
		LandingPage landingPage= testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchproduct(prodStName);
		
		
		Thread.sleep(3000);
		//WebDriverWait wait=new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4[class='product-name']")));
		
		testContextSetup.FinalProductName=landingPage.grabProductName();
		
		System.out.println(testContextSetup.FinalProductName);
		
		Assert.assertEquals(testContextSetup.FinalProductName, "Tomato");
		
		
	}
	
	
	

}
