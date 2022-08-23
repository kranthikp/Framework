package Vgive_pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ActionDriver.Action;
import Base.Baseclass;
import utility.Log;

public class Donate_Now_Page_Objects extends Baseclass{
	
	
	/*************************************************
	 * @Locaters                   *                 *
	 *  Locater's for Donate_Now_Page_Objects Module *
	 *************************************************/
	
	@FindBy(xpath = "//a[text()=\"Donate now\"]")
	private WebElement Donatenow;
	
	@FindBy(xpath = "//h3[text()=\"Donate now\"]")
	private WebElement Scroll;	
	
	@FindBy(xpath = "//p[text()=\"Add fund\"]//ancestor::div[@class=\"MuiBox-root css-am8j60\"]//descendant::button")
	private WebElement Donatenowto123;
	
	@FindBy(xpath = "//*[@id=\"outlined-start-adornment\"]")
	private  WebElement Amount;
	
	@FindBy(xpath = "//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"]")
	private  WebElement checkbox;
	
	@FindBy(xpath = "//button[text()=\" Continue\"]")
	private  WebElement Continuebutton;
	
	@FindBy(xpath = "//input[@name=\"email\"]")
	private WebElement EmailRMS;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement Password;
	
	@FindBy(xpath = "//button[text()=\"LogIn\"]")
	private WebElement login;
	
/**   @Assertion_Elements   **/
	
	@FindBy(xpath = "//span[text()=\"Home\"]")
	private WebElement Actual_HomeScreen;
	
	@FindBy(xpath = "//h1[text()=\"Log In\"]")
	private WebElement Actual_Login_Sheet;
	
	@FindBy(xpath = "//span[text()=\"Fundraiser\"]")
	private WebElement After_Valid_Login_Personal_Dashboard;
	
	@FindBy(xpath = "//h3[text()=\"Donate now\"]")
	private WebElement Donate_Now_Text;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div[1]/h4/span")
	private WebElement Thanks;
	
	@FindBy(xpath = "//p[text()=\"Thankyou for your Donation!\"]")
	private WebElement Thankyouforyourgift;
	
	
	
	/*************************
	 * 						 *
	 *   Expecting Data      *
	 *						 *
	 *************************/
	
	private String Thanks_Expeccted ="Hi Test,Thanks for Initiating Donation";
	private String Dnt_Tex_Expected="Donate now";
	private String Th="Thankyou for your Donation!";
	private String Expecting_Home_Page="Home";
	private	String Expecting_Login_sheet="Log In";
	
	
	
	/*************************************************************
	 * 															 *
	 * @Action class											 *
	 * Creating an object of Action class and Keeping as Global. *
	 *															 * 
	 * @Elements												 *
	 * Initializing  Elements of Login Page						 *
	 * 															 *
	 *************************************************************/
	
	Action act = new Action();
	
	public Donate_Now_Page_Objects()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	/********************************
 	 * 					            *
 	 * Executing Donate now Module  *
 	 * @Assertions			        *
 	 * @Adding Logs                 *
 	 * @Adding Amount			    *
 	 *                  		    *
 	 * 						        *
 	 ********************************/
	
	public void Donatenow(String usernameRMS,String passwordRMS,String MONEY) throws Exception
	{
		
		/********************************
		 *  Donate now page  Validation *
		 ********************************/
		
		act.pageLoadTimeOut(getDriver(), 10);
		
		String Actual_Homepage_header = Actual_HomeScreen.getText();
 		act.Assertion(Actual_Homepage_header,Expecting_Home_Page);
 		Log.debug("Assertion Success for Home Page");
 		
  	/**  Donate Now_page  **/
 		
		act.click(getDriver(), Donatenow);
		Log.debug(" Donatenow clicked  successfully");
		Thread.sleep(10000);
		String Dnt_Text = Donate_Now_Text.getText();
		act.Assertion(Dnt_Text, Dnt_Tex_Expected);
	
	 	
		act.scrollByVisibilityOfElement(getDriver(), Scroll);
		Thread.sleep(10000);
		act.click(getDriver(), Donatenowto123);
		Log.debug(" Selected One  clicked  successfully");
		
	/** Login_Sheet Validation **/
	 		
		 String login_Sheet = Actual_Login_Sheet.getText();
		 act.Assertion(Expecting_Login_sheet, login_Sheet);
		 Log.debug("Assertion Success for Login Sheet");
		 			
	/** Login to the page with User Credentials  */	
		
 		act.selectBySendkeys(usernameRMS, EmailRMS );
 		Log.debug("Email Entered successfully");
 		act.selectBySendkeys(passwordRMS, Password);
 		Log.debug("password Entered successfully");
 		act.click(getDriver(), login);
 		Log.debug("login button clicked  successfully");
 		
   /** Page Validation */
 		
 		act.scrollByVisibilityOfElement(getDriver(), Scroll);
		Thread.sleep(10000);
		act.click(getDriver(), Donatenowto123);
		Log.debug(" Selected One  clicked  successfully");
		
		Thread.sleep(3000);
		String Thanks12 = Thanks.getText();
		act.Assertion(Thanks12, Thanks_Expeccted);
	
    /** Assertion  for the text " Hi Test,Thanks for Initiating Donation "  */
		
		Thread.sleep(3000);
		System.out.println(Thanks12);
		Log.debug(" Text printed successfully");
		Thread.sleep(3000);
		act.selectBySendkeys(MONEY, Amount);
		Log.debug(" Amount entered successfully");
		Thread.sleep(3000);
		act.click(getDriver(), checkbox);
		Log.debug(" checkbox clicked successfully");
		Thread.sleep(3000);
		act.click(getDriver(), Continuebutton);
		Log.debug(" Continuebutton clicked successfully");
		Thread.sleep(3000);
		String thanksfor = Thankyouforyourgift.getText();
		
	/**Assertion  for the text " Thank_you for your Donation!"  */
		
		System.out.println(thanksfor);
		act.Assertion(thanksfor, Th);
		Log.debug(" Text printed  successfully");
	}
	
	
	
	
	
	
	
	

}
