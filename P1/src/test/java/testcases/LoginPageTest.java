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

public class LoginPageTest extends Baseclass{
	 indexPage IndexPage;
     loginPage LoginPage;
     HomePage homePage;
    
   // String browser="Chrome";
     @Parameters("browser")
     @BeforeMethod //(groups= {"Smoke","Sanity","Regression"})
     public void setup(String browser) {
 		
 		launchApp(browser);
 	}
	
	@AfterMethod //(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test  //(dataProvider="credentials", dataProviderClass= DataProviders.class,groups= {"Smoke","Sanity"})

	public void loginTest()throws Throwable {
		//public void loginTest()throws Throwable {
		Log.startTestCase("loginTest");
		IndexPage=new indexPage();
		Log.info("User is going to click on signIn");
		//Thread.sleep(2000);
		LoginPage=IndexPage.clickOnSignIn();
		Log.info("Enter Username and Password");		
		Thread.sleep(2000);
	
		//homePage=LoginPage.login(prop.getProperty(pswd),pswd, homePage);
		
		//Thread.sleep(2000);
		homePage=LoginPage.login(prop.getProperty("username"),prop.getProperty("password"), homePage);
		//System.out.println(uname+pswd);
		String actualURL=homePage.getCurrentURL();
		String expectedURL="http://automationpractice.com/index.php?controller=authentication&back=my-account";
	    
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
	    Log.info("login is sucess");
	    Log.endTestCase("loginTest");
	    //homePage=LoginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
}
