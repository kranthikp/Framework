package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page_objects.pageobjects.AddToCartPage;
import Page_objects.pageobjects.AddressPage;
import Page_objects.pageobjects.OrderConfirmationPage;
import Page_objects.pageobjects.OrderSummary;
import Page_objects.pageobjects.PaymentPage;
import Page_objects.pageobjects.SearchResultPage;
import Page_objects.pageobjects.ShippingPage;
import Page_objects.pageobjects.indexPage;
import Page_objects.pageobjects.loginPage;
import Page_objects.pageobjects.orderPage;
import utility.Log;

public class EndtoEndApp extends Baseclass{

	 indexPage Index;
	 SearchResultPage searchResultPage;
	 AddToCartPage addToCartPage;
	 orderPage orderpage;
	 loginPage loginpage;
	 AddressPage addressPage;
	 ShippingPage shippingPage;
	 PaymentPage paymentPage;
	 OrderSummary orderSummary;
	 OrderConfirmationPage orderConfirmationPage;

	 @Parameters("browser")
	 @BeforeMethod  //(groups = {"Smoke","Sanity","Regression"})
	    public void setup(String browser) {
			
			launchApp(browser);
		}
		
		@AfterMethod //(groups = {"Smoke","Sanity","Regression"})
		public void tearDown() {
			getDriver().quit();
		}
	
	@Test //(groups="Regression",dataProvider = "getproduct", dataProviderClass = DataProviders.class)
	    public void endToEndTest(String product, String qty, String size) throws Throwable {
		//public void endToEndTest() throws Throwable {
		Log.startTestCase("endToEndTest");
		Index= new indexPage();
		searchResultPage=Index.searchProduct(product);
		addToCartPage=searchResultPage.clickOnproduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderpage=addToCartPage.clickOnCheckOut();
		loginpage=orderpage.clickOnCheckOut();
		
		addressPage=loginpage.login1(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		Log.endTestCase("endToEndTest");
	}

}

