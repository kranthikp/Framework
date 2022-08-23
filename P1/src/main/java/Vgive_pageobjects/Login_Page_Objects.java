package Vgive_pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;
import utility.Log;

public class Login_Page_Objects extends Baseclass {
	
	
	
	/*******************************
	 * @Locaters                   *
	 *  Locater's for Login Module *
	 *******************************/
		
	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-outlined jss3\"]")
	private WebElement user_Login;
	
	@FindBy(xpath = "//input[@name=\"email\"]")
	private WebElement EmailRMS;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement Password;
	
	@FindBy(xpath = "//button[text()=\"LogIn\"]")
	private WebElement login;
	
	@FindBy(xpath = "//li[text()=\"Logout\"]")
	private WebElement logout;
	
	
	/**   @Assertion_Elements   **/
	
	@FindBy(xpath = "//span[text()=\"Home\"]")
	private WebElement Actual_HomeScreen;
	
	@FindBy(xpath = "//h1[text()=\"Log In\"]")
	private WebElement Actual_Login_Sheet;
	
	@FindBy(xpath = "//span[text()=\"Fundraiser\"]")
	private WebElement After_Valid_Login_Personal_Dashboard;
	
	
	/*************************************************************
	 * 															 *
	 * @Action class											 *
	 * Creating an object of Action class and Keeping as Global. *
	 *															 * 
	 * @Elements												 *
	 * Initializing  Elements of Login Page						 *
	 * 															 *
	 *************************************************************/

	Action act= new Action();
	
	public Login_Page_Objects()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	/*************************
	 * 						 *
	 *   Expecting Data      *
	 *						 *
	 *************************/
	
	private String Expecting_Home_Page="Home";
	private	String Expecting_After_Valid_Login_Personal_Dashboard="Fundraiser";
	private	String Expecting_Login_sheet="Log In";
	
	
 	/***************************
 	 * 						   *
 	 * Executing Login Module  *
 	 * @Assertions			   *
 	 * @Adding Logs            *
 	 * @Username			   *
 	 * @Password 			   *
 	 * 						   *
 	 ***************************/
	
	
	public void Login(String usernameVGIVE,String passwordVGIVE) throws Exception
 	{
		
	/************************
	 *  HomePage Validation *
	 ************************/
		
		act.pageLoadTimeOut(getDriver(), 10);
 		String Actual_Homepage_header = Actual_HomeScreen.getText();
 		act.Assertion(Actual_Homepage_header,Expecting_Home_Page);
 		Log.debug("Assertion Success for Home Page");
 		
 	/** Performing Login Action **/
 		
 		Log.debug("user_Login button clicked  successfully");
 		act.click(getDriver(), user_Login);
 		act.implicitWait(getDriver(), 10);
 		
 	/** Login_Sheet Validation **/
 		
 		String login_Sheet = Actual_Login_Sheet.getText();
 		act.Assertion(Expecting_Login_sheet, login_Sheet);
 		Log.debug("Assertion Success for Login Sheet");
 		
 			
 	/** Passing User_Name & Password **/
 		
 		act.selectBySendkeys(usernameVGIVE, EmailRMS );
 		Log.debug("Email Entered successfully");
 		act.selectBySendkeys(passwordVGIVE, Password);
 		Log.debug("password Entered successfully");
 		act.click(getDriver(), login);
 		Log.debug("login button clicked  successfully");
 		act.implicitWait(getDriver(), 10);
 		String Actual = act.getTitle(getDriver());
 		Log.Title(Actual);
 		Log.debug("Title printed successfully");
 		Thread.sleep(5000);
 		
 	/** User_DashBoard_Validation **/
 		
 		String Actual_Result_DashBoard = After_Valid_Login_Personal_Dashboard.getText();
 		act.Assertion(Expecting_After_Valid_Login_Personal_Dashboard, Actual_Result_DashBoard);
 		Log.debug("Assertion Success for Personal DashBoard");
 		
 		
 		act.click(getDriver(), user_Login);
 		Log.debug("user_Login clicked  successfully");
 		Thread.sleep(5000);
 		
 	/** User_Logout_From_Home_Page **/
 		
 		act.click(getDriver(), logout);
 		Log.debug("logout successfully");
 		
 	}
 	
 	
	

}
