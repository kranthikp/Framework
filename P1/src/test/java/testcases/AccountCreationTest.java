package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Baseclass;
import Page_objects.pageobjects.AccountCreationPage;
import Page_objects.pageobjects.HomePage;
import Page_objects.pageobjects.indexPage;
import Page_objects.pageobjects.loginPage;
import utility.Log;

public class AccountCreationTest extends Baseclass {

	indexPage IndexPage;
	loginPage LoginPage;
	AccountCreationPage accountCreationPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod//(groups= {"Smoke","Sanity","Regression"})
    public void setup(String browser) {
		
		launchApp(browser);
	}
    
    @AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
    
    /* @Test(groups="Sanity")
   /* public void loginTest()throws Throwable {
		IndexPage=new indexPage();
		LoginPage=IndexPage.clickOnSignIn();
		accountCreationPage=LoginPage.createNewAccount("jhsdfyujh@gmail.com");
		
		boolean result = accountCreationPage.validateAccountCreatePage();
}*/
    
    @Test//(groups = "Sanity",dataProvider = "email", dataProviderClass = DataProviders.class)
	  public void verifyCreateAccountPageTest(String email) throws Throwable {
    	//public void verifyCreateAccountPageTest() throws Throwable {
		Log.startTestCase("verifyCreateAccountPageTest");
		IndexPage= new indexPage();
		LoginPage=IndexPage.clickOnSignIn();
		accountCreationPage=LoginPage.createNewAccount(email);
		boolean result=accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);
		Log.endTestCase("verifyCreateAccountPageTest");
	}

}






