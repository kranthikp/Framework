package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page_objects.pageobjects.HomePage;
import Page_objects.pageobjects.indexPage;
import Page_objects.pageobjects.loginPage;
import utility.Log;

public class HomePageTest extends Baseclass {

	indexPage IndexPage;
	loginPage  LoginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod  //(groups= {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
		
		launchApp(browser);
	}  
	@AfterMethod //(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test //(groups="Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void wishListtest(String uname, String pswd)throws Throwable {
		
		Log.startTestCase("wishListTest");
		IndexPage=new indexPage();
		LoginPage=IndexPage.clickOnSignIn();
		homePage=LoginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
		Log.endTestCase("end to endtest");
	}
	@Test //(groups="Smoke")
	public void orderHistoryDetailsTest(String uname, String pswd)throws Throwable {
		
		Log.startTestCase("orderHistoryandDetailsTest");
		IndexPage=new indexPage();
		LoginPage=IndexPage.clickOnSignIn();
		homePage=LoginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(false);
		Log.endTestCase("orderHistoryandDetailsTest");
	}	
		
}
