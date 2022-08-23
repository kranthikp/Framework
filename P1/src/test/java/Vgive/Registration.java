package Vgive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Base.Baseclass;
import Vgive_pageobjects.Registeration_Page_Objects;
import utility.Log;

public class Registration extends Baseclass{
	
	
	
	/************************************************************
	 *                                                          *
	 * 														    *
	 * @Test Case for Registration module in VGive Application  *
	 * @valid Credentials 									    *
	 *  													    *
	 *  													    *
     ************************************************************/
	
	
	
	
	/** Creating Object Of Registeration_Page_Objects And Placing as Global **/
	
	Registeration_Page_Objects rv;
	
	
	
	/** Launching Browser Base_class */
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser); 
	}
		
	
	/** Quitting Down the browser Closing the Connection **/
	
	@AfterMethod
	public void tearDown() {
		Log.endTestCase("  Test case Completed for User_Registration  ");
		//getDriver().quit();
	}
	
	
	
	/** Started Test case for Registration in VGive Application **/
	
	@Test
	public void Test_Registration() throws Exception
	{
		Log.startTestCase("  Test case Started for User_Registration  ");
		rv = new Registeration_Page_Objects();
		rv.Registration(prop.getProperty("Vgive_First_Name"), prop.getProperty("Vgive_Last_Name"), prop.getProperty("Vgive_Mobile"), prop.getProperty("Vgive_Email"), prop.getProperty("Vgive_New_Password"), prop.getProperty("Vgive_Address"), prop.getProperty("Postal_code"));
	}

	
	
}
