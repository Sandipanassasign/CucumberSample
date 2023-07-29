package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public DealsPage dealsPage;
	public SummaryPage summaryPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	
	public LandingPage getLandingPage() {
		
		
		landingPage=new LandingPage(driver);
		return landingPage;
	}
	
	
	public DealsPage getDealsPage() {
		
		dealsPage=new DealsPage(driver);
		return dealsPage;
		
	}
	
	public SummaryPage getSummaryPage() {
		
		summaryPage=new SummaryPage(driver);
		return summaryPage;
		
	}

}
