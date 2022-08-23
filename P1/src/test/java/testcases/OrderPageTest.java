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
import Page_objects.pageobjects.orderPage;
import utility.Log;

public class OrderPageTest extends Baseclass{

	indexPage Index;
	SearchResultPage searchresultPage;
	AddToCartPage addToCartPage;
	orderPage orderpage;
	
	@Parameters("browser")
	@BeforeMethod  //(groups= {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
		
		launchApp(browser);
	}
	
	@AfterMethod //(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test //(groups="Regression",dataProvider = "getproduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String product, String qty, String size) throws Throwable {
		Log.startTestCase("verifyTotalPrice");
		Index= new indexPage();
		searchresultPage=Index.searchProduct(product);
	    addToCartPage = searchresultPage.clickOnproduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderpage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderpage.getUnitPrice();
		Double totalPrice=orderpage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)))+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");
	}
}
