package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page_objects.pageobjects.SearchResultPage;
import Page_objects.pageobjects.indexPage;
import utility.Log;

public class SearchPageTest extends Baseclass{

	
	indexPage Index;
	SearchResultPage searchresultPage;
	
	
	@Parameters("browser")
	@BeforeMethod //(groups= {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
		
		launchApp(browser);
	}
	   
	@AfterMethod //(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test //(groups="Smoke",dataProvider = "searchproduct", dataProviderClass = DataProviders.class)
	public void productAvailabilityTest(String product) throws Throwable {
		
		Log.startTestCase("productAvailabilityTest");
		Index=new indexPage();
		searchresultPage=Index.searchProduct(product);
		boolean result = searchresultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	}
	
	
	
}
