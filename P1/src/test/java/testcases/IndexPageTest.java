package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page_objects.pageobjects.indexPage;
import utility.Log;

public class IndexPageTest extends Baseclass{
	indexPage IndexPage;
	
	//@Parameters("browser")
	@BeforeMethod //(groups= {"Smoke","Sanity","Regression"})
	
    public void setup(String browser) {
		
		launchApp(browser);
	}
	@AfterMethod //(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
		
	}
	@Test //(groups="Smoke")
	public void verifyLogo() throws Throwable{
		Log.startTestCase("verifyLogo");
		IndexPage=new indexPage();
		boolean result= IndexPage.validatelogo();
		Assert.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	@Test //(groups="Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		String actTitle =IndexPage.myStoreTitle();
		Assert.assertEquals(actTitle, "My Store1");
		Log.endTestCase("verifyTitle");
	}
	
}
