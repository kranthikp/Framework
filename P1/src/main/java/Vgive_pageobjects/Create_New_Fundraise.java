package Vgive_pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ActionDriver.Action;
import Base.Baseclass;
import utility.Log;

public class Create_New_Fundraise extends Baseclass {
	
	
	
	
	/*************************************************
	 * @Locaters                   *                 *
	 *  Locater's for Create_New_Fundraise Module    *
	 *************************************************/
	

	@FindBy(xpath = "//input[@name=\"email\"]")
	private WebElement EmailRMS;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement Password;
	
	@FindBy(xpath = "//button[text()=\"LogIn\"]")
	private WebElement login;
	
	@FindBy(xpath = "//div[@class=\"jss19 MuiBox-root css-i1xvvt\"]//descendant::span[@class=\"MuiTouchRipple-root\"]")
	private WebElement create_newfundraise;
	
	@FindBy(xpath = "//a[text()=\"Create new fundraiser\"]")
	private WebElement newfundraise;
	
	@FindBy(xpath = "//h1[text()=\"Create fundraise for your charity\"]")
	private WebElement createfundraiseforcharity;	
	
	@FindBy(xpath = "//span[text()=\"Choose a cause\"]//ancestor::div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl  css-fvipm8\"]//descendant::div[@class=\"MuiSelect-select MuiSelect-outlined MuiInputBase-input MuiOutlinedInput-input css-qiwgdb\"]")
	private WebElement choose_A_cause;
	
	@FindBy(xpath = "//li[text()=\"Education\"]")
	private WebElement education;
	
	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"]")
	private WebElement Add_Fundraise_tittle;
	
	@FindBy(xpath = "//textarea[@name=\"description\"]")
	private WebElement Add_Fundraise_Description;
	
	@FindBy(xpath = "//label[text()=\"What do you plan to raise?\"]//ancestor::div[@class=\"MuiFormControl-root MuiFormControl-fullWidth css-tzsjye\"]")
	WebElement what_do_you_want_to_Raise;
		
	@FindBy(xpath = "//li[text()=\"Funds\"]")
	private WebElement Funds;
	
	@FindBy(xpath = "//*[@id=\"outlined-start-adornment\"]")
	private WebElement Amount;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/form/div/div[1]/div/div[8]/div/div/div/div/button")
	private WebElement calender;
	
	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div/div/div[2]/div/div[2]/div/div[4]/div[5]/button")
	private WebElement Date;
	
	@FindBy(xpath = "//p[text()=\"Upload image\"]")
	private WebElement Picture;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/form/div/div[2]/div/div/div/button")
    private WebElement preview;
	
	/** Assertion Elements **/
	
	@FindBy(xpath = "//span[text()=\"Home\"]")
	private WebElement Actual_HomeScreen;
	
	@FindBy(xpath = "//h1[text()=\"Log In\"]")
	private WebElement Actual_Login_Sheet;
	
	
	/*************************
	 * 						 *
	 *   Expecting Data      *
	 *						 *
	 *************************/
	
	private String Expecting_Home_Page="Home";
	private	String Expecting_Login_sheet="Log In";
	private String Expected_create_New_Fundraise="Create fundraise for your charity";
	String Path = "C:\\Users\\VijayKumarNarla\\Pictures\\Saved Pictures\\istockphoto-1295530809-612x612.webp";
	
	
	
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
	
	
	public Create_New_Fundraise()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void upload(String usernameRMS,String passwordRMS,String Add_Fundraise_tittle_Con,String Add_Fundraise_Description_con,String Amount_con) throws Exception
	{

		/********************************
		 *  Donate now page  Validation *
		 ********************************/
		
		//act.pageLoadTimeOut(getDriver(), 10);
		Thread.sleep(5000);
		
		String Actual_Homepage_header = Actual_HomeScreen.getText();
 		act.Assertion(Actual_Homepage_header,Expecting_Home_Page);
 		Log.debug("Assertion Success for Home Page");
 		
 	/** create new fundRaise  */
 		
		act.Move_To(getDriver(), create_newfundraise);
		Log.debug(" moved  successfully");
		act.implicitWait(getDriver(), 10);
		act.click(getDriver(), newfundraise);
		Log.debug(" create_newfundraise clicked successfully");	
		act.implicitWait(getDriver(), 10);
		
		
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
 		act.implicitWait(getDriver(), 10);
 		
 		
    /** Assertion  for the text " Create Fund raise for your charity " **/
 		
 		String charity = createfundraiseforcharity.getText();
 		act.Assertion(charity, Expected_create_New_Fundraise);
 		Log.Title(charity);
		Thread.sleep(5000);
		act.click(getDriver(), choose_A_cause);
		act.implicitWait(getDriver(), 10);
		act.click(getDriver(), education);
		act.implicitWait(getDriver(), 10);
		act.selectBySendkeys(Add_Fundraise_tittle_Con, Add_Fundraise_tittle);
		act.implicitWait(getDriver(), 10);
		act.selectBySendkeys(Add_Fundraise_Description_con, Add_Fundraise_Description);
		act.implicitWait(getDriver(), 10);		
		act.click(getDriver(), what_do_you_want_to_Raise);
		act.implicitWait(getDriver(), 10);
		act.click(getDriver(), Funds);
		act.implicitWait(getDriver(), 10);
		act.selectBySendkeys(Amount_con, Amount);
		act.implicitWait(getDriver(), 10);
		act.click(getDriver(), calender);
		act.implicitWait(getDriver(), 10);
		act.click(getDriver(), Date);
		Log.debug("Date clicked  successfully");
		act.implicitWait(getDriver(), 10);
	//	Picture.sendKeys(Path);
		act.click(getDriver(), Picture);
		Picture.sendKeys(Path);
		act.implicitWait(getDriver(), 10);
		act.click(getDriver(), preview);
	}



}

