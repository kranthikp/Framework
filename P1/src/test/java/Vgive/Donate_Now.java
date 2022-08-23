package Vgive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Baseclass;
import Vgive_pageobjects.Donate_Now_Page_Objects;
import utility.Log;

public class Donate_Now extends Baseclass {
	
	Donate_Now_Page_Objects Dnp;
	

	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod
	public void tearDown() {
		Log.endTestCase("Test case Completed for Valid credentials");
		getDriver().quit();
	}
	@Test
	public void DonatenowExecution() throws Exception
	{
		Log.startTestCase("Test case for Donation");
		Dnp = new Donate_Now_Page_Objects();
		Dnp.Donatenow(prop.getProperty("usernameRMS"), prop.getProperty("passwordRMS"),prop.getProperty("Money"));
	}

}
