package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page_objects.pageobjects.AddToCartPage;
import Page_objects.pageobjects.SearchResultPage;
import Page_objects.pageobjects.indexPage;
import utility.Log;

public class AddToCartTest extends Baseclass {

	indexPage Index;
	SearchResultPage searchresultPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod //(groups= {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
		
		launchApp(browser);
	}
	
	@AfterMethod //(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test //(groups= {"Regression","Sanity"}, dataProvider = "getproduct", dataProviderClass = DataProviders.class)
	    public void addToCartTest(String product, String qty, String size) throws Throwable {
		//public void addToCartTest() throws Throwable {
		Log.startTestCase("addToCartTest");
		Index= new indexPage();
		searchresultPage=Index.searchProduct(product);
		addToCartPage=searchresultPage.clickOnproduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		boolean result =addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		Log.endTestCase("addToCartTest");
	}
}
