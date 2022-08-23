package Vgive;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.Baseclass;
import Vgive_pageobjects.Create_New_Fundraise;
import utility.Log;

public class Create_New_Fund_Raise extends Baseclass{
	
	

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
	
	Create_New_Fundraise cnf;
	
	@Test
	public void Execute() throws Exception
	{
		
		Log.startTestCase("Test case Started for Valid credentials");
		cnf = new Create_New_Fundraise();
		cnf.upload(prop.getProperty("usernameRMS"), prop.getProperty("passwordRMS"),prop.getProperty("Add_Fundraise_tittle_Con"),prop.getProperty("Add_Fundraise_Description_con"),prop.getProperty("Amount_con"));
	}

}
