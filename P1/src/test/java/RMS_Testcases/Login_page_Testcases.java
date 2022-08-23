/**
 * 
 */
package RMS_Testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Base.Baseclass;
import RMS_Pageobjects.RMS_Login_Page_pageobjects;
import utility.*;

/**
 * 
 * @author VijayKumarNarla
 *
 */


public class Login_page_Testcases extends Baseclass{
	
	RMS_Login_Page_pageobjects RLPP;
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	//(priority = 1,dependsOnMethods = {"RMS_login_In_validcredentials"})
	@Test
	public void RMS_login_validcredentials()
	{
		
		Log.startTestCase("Test case Started for Valid credentials");
		System.out.println("vijay");
		 RLPP=new RMS_Login_Page_pageobjects();
		 RLPP.username(prop.getProperty("usernameRMS"));
		 Log.info(" User email entered ");
		 RLPP.password(prop.getProperty("passwordRMS"));
		 Log.info(" User Password entered ");
		 RLPP.login_btn();
		 Log.info(" Login button clicked successfully ");
		 String Actual = RLPP.Title();
		 Assert.assertEquals(Actual, prop.getProperty("Expected"));
		 Log.info(" Assertion success ");
		 Log.endTestCase("Test case ended for Valid credentials");
	}
	
	@Test(priority = 2)
	public void RMS_login_In_validcredentials()
	{
		RLPP=new RMS_Login_Page_pageobjects();
		Log.startTestCase("Test case Started for IN_Valid credentials");
		RLPP.username(prop.getProperty("INUSERNAME"));
		Log.info(" User email entered ");
		RLPP.password(prop.getProperty("INPASSWORD"));
		Log.info(" User password entered ");
		RLPP.login_btn();
		Log.info(" Login button clicked successfully ");
		Log.endTestCase("Test case ended for Valid credentials");
	}
	
	@Test(priority = 3)
	public void RMS_LOGIN_VALIDEMAIL_AND_INVALIDPASSWORD()
	{
		Log.startTestCase("Test case Started for ValidEMAIL AND INVALID PASSWORD ");
		RLPP=new RMS_Login_Page_pageobjects();
		RLPP.username(prop.getProperty("usernameRMS"));
		Log.info(" User email entered ");
		RLPP.password(prop.getProperty("INPASSWORD"));
		Log.info(" User password entered ");
		RLPP.Sleep();
		RLPP.login_btn();
		RLPP.Sleep();
		Log.info(" Login button clicked successfully ");
		Log.endTestCase("Test case ended for ValidEMAIL AND INVALID PASSWORD");
	}
	@Test(priority = 4)
	public void RMS_LOGIN_INVALIDEMAIL_AND_VALIDPASSWORD()
	{
		Log.startTestCase("Test case Started for INValidEMAIL AND VALID PASSWORD ");
		RLPP=new RMS_Login_Page_pageobjects();
		RLPP.username(prop.getProperty("INUSERNAME"));
		Log.info(" User email entered ");
		RLPP.password(prop.getProperty("passwordRMS"));
		Log.info(" User password entered ");
		RLPP.Sleep();
		RLPP.login_btn();
		RLPP.Sleep();
		Log.info(" Login button clicked successfully ");
		Log.endTestCase("Test case ended for ValidEMAIL AND INVALID PASSWORD");
	}
	
	
	
	@Test(priority = 5)
	public void RMS_LOGIN_EMPTY_USERNAME_PASSWORD()
	{
		Log.startTestCase("Test case Started for EMPTYEMAIL AND EMPTY PASSWORD ");
		RLPP=new RMS_Login_Page_pageobjects();
		RLPP.username(prop.getProperty(""));
		Log.info(" User email entered ");
		RLPP.password(prop.getProperty(""));
		Log.info(" User password entered ");
		RLPP.Sleep();
		RLPP.login_btn();
		RLPP.Sleep();
		Log.info(" Login button clicked successfully ");
		Log.endTestCase("Test case ended for EMPTYEMAIL AND EMPTY PASSWORD");
	}
	
	@Test(priority = 6)
	public void RMS_LOGIN_EMPTY_USERNAME_AND_VALID_DPASSWORD()
	{
		Log.startTestCase("Test case Started for EMPTY_USERNAME_AND_VALID_DPASSWORD");
		RLPP=new RMS_Login_Page_pageobjects();
		RLPP.username(prop.getProperty(""));
		Log.info(" User email entered ");
		RLPP.password(prop.getProperty("passwordRMS"));
		Log.info(" User password entered ");
		RLPP.Sleep();
		RLPP.login_btn();
		RLPP.Sleep();
		Log.info(" Login button clicked successfully ");
		Log.endTestCase("Test case ended for EMPTYEMAIL AND EMPTY PASSWORD");
	}
	
	@Test(priority = 7)
	public void RMS_LOGIN_VALID_USERNAME_AND_EMPTY_PASSWORD()
	{
		Log.startTestCase("Test case Started for VALID_USERNAME_AND_EMPTY_PASSWORD ");
		RLPP=new RMS_Login_Page_pageobjects();
		RLPP.username(prop.getProperty("usernameRMS"));
		Log.info(" User email entered ");
		RLPP.password(prop.getProperty(""));
		Log.info(" User password entered ");
		RLPP.Sleep();
		RLPP.login_btn();
		RLPP.Sleep();
		Log.info(" Login button clicked successfully ");
		Log.endTestCase("Test case ended for EMPTYEMAIL AND EMPTY PASSWORD");
	}
}
