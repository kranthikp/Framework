package Vgive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Base.Baseclass;
import Vgive_pageobjects.Login_Page_Objects;
import utility.Log;

public class Login extends Baseclass {
	
	
	
	/**********************************************************
	 *                                                        *
	 * 														  *
	 * @Test Case for Login module in VGive Application       *
	 * @valid Credentials 									  *
	 *  													  *
	 *  													  *
     **********************************************************/
	
	
	/** Creating Object Of Login_pageobjects And Placing as Global **/
	
	 Login_Page_Objects l1;
	
	 
	
	/** Launching Browser Base_class */
	 
	@Parameters("browser")
	@BeforeMethod 
	public void setup(@Optional("chrome")String browser) {
	
		launchApp(browser); 
	}
	
	
	
	/** Quitting Down the browser Closing the Connection **/
	
	@AfterMethod
	public void tearDown() {
		Log.endTestCase("Test case Completed for Valid credentials");
		getDriver().quit();
	}
	
	/** Started Test case for Valid Login in VGive Application **/
	
	@Test
	public void login_Vgive() throws Exception
	{
		
		Log.startTestCase("Test case Started for Valid credentials");
		l1 = new Login_Page_Objects();
		
		/** Passing Values From Properties file **/
		l1.Login(prop.getProperty("usernameVGIVE"), prop.getProperty("passwordVGIVE")); 
		
	}

}
