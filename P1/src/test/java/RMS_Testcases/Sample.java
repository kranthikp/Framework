package RMS_Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ActionDriver.Action;
import Base.Baseclass;

/*
 * Class should have 
 * locators
 * actions
 * test scripts
 */
		


public class Sample extends Baseclass {
	//Defined Variables for Action and Driver
	Action act;
	//WebDriver driver;
	
	
	//Saving xpath for Username and Password
	@FindBy(xpath = "//input[@name=\"txtUsername\"]")
	WebElement username;
	
	@FindBy(xpath = "//input[@name=\"Submit\"]")
	WebElement submit;
	
	
	//1.Opening the Browser
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		launchApp(browser); 
	}
	

	
	//2.Initiate the browser drivers in constructor
	public Sample()
	{
		//this.driver= driver1;
		PageFactory.initElements(getDriver(), this);
		
	
	}
	
	//3.Initialization
	//Saving xpath for Username and Password
	public void Username()
	{	System.out.println("in username  "+getDriver());
		Action act = new Action();
		System.out.println("vijaydcfvgbhjn");
		act.click(getDriver(), submit);
	//	submit.click();
	}
	
	
	//Test Case
	@Test
	public void Test1() throws Exception {
		System.out.println("vijay");
		System.out.println("in test  "+getDriver());
//		
//		
//		act = new Action();
//		Thread.sleep(3000);
//		System.out.println("vijay");
//		act.click(getDriver(),username );
//		//username.sendKeys("vijay");
		//sample.Username();
		Thread.sleep(3000);
		Username();
	}
	
	//Close the Browser
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
}
