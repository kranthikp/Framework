package Vgive_pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ActionDriver.Action;
import Base.Baseclass;
import utility.Log;


  public class Registeration_Page_Objects extends Baseclass {
	
	
	
	/************************************** 
	 * @Locaters                          *
	 *  Locater's for Registration Module *
	 **************************************/
	
	  
	  
	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-outlined jss3\"]")
	private WebElement user_Login;
	
	@FindBy(xpath = "//a[text()=\"Register Now\"]")
	private WebElement Register;

	@FindBy(xpath = "//label[text()=\"Profile Type\"]//ancestor::div[@class=\"MuiFormControl-root MuiFormControl-marginNormal MuiFormControl-fullWidth css-ibaxil\"]//descendant::div[@id=\"profile-type-select\"]")
	private WebElement profiletype;
	
	@FindBy(xpath = "//*[@id=\"menu-user_type_id\"]/div[3]/ul/li[1]")
	private WebElement Charity;
	
	@FindBy(xpath = "//button[text()=\"Yes, Proceed\"]")
	private WebElement Yes_Proceed;
	
	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-marginNormal MuiFormControl-fullWidth MuiTextField-root css-1u0h3mu\"]//descendant::label[text()=\"First name\"]")
	private WebElement FirstName;
	
	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-marginNormal MuiFormControl-fullWidth MuiTextField-root css-1u0h3mu\"]//descendant::label[text()=\"Last name\"]")
	private WebElement LastName;
	
	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart css-1e1uqed\"]")
	private WebElement MobileNum;
	
	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-marginNormal MuiFormControl-fullWidth MuiTextField-root css-1u0h3mu\"]//descendant::label[text()=\"Email ID\"]")
	private WebElement EmailID;
	
	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-marginNormal MuiFormControl-fullWidth css-ibaxil\"]//descendant::label[text()=\"Password\"]")
	private WebElement Password;
	
	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-marginNormal MuiFormControl-fullWidth css-ibaxil\"]//descendant::label[text()=\"Preferred method of contact\"]")
	private WebElement Prefered_Method_For_contact;
	
	@FindBy(xpath = "//*[@id=\"menu-preferred_method_of_contact\"]/div[3]/ul/li[2]")
	private WebElement Call;
	
	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-marginNormal MuiFormControl-fullWidth MuiTextField-root css-1u0h3mu\"]//descendant::label[text()=\"Address\"]")
	private WebElement Address;
	
	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-marginNormal MuiFormControl-fullWidth MuiTextField-root css-1u0h3mu\"]//descendant::label[text()=\"Postal Code\"]")
	private WebElement Postal_Code;
	
	@FindBy(xpath = "//label[text()=\"Select Avatar\"]")
	private WebElement Select_Avathar;
	
	@FindBy(xpath = "//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation24 MuiDialog-paper MuiDialog-paperScrollPaper MuiDialog-paperWidthSm css-43x0zg\"]")
	private WebElement Frame;
		
	@FindBy(xpath = "//input[@class=\"category-input\"][1]")
	private WebElement Image;
	
	@FindBy(xpath = "//button[text()=\"Save\"]")
	private WebElement Save;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/form/div/div[2]/div/div/button")
	private WebElement Next;
	
	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd MuiAutocomplete-input MuiAutocomplete-inputFocused css-1uvydh2\"]//ancestor::div[@class=\"MuiFormControl-root MuiFormControl-fullWidth MuiTextField-root css-fyrvnu\"]//descendant::label[text()=\"Select Country\"]")
	private WebElement SelectCountry;
	
	@FindBy(xpath = "//input[@value=\"India\"]")
	private WebElement india;
	
    /**   @Assertion_Elements   **/
	
	@FindBy(xpath = "//span[text()=\"Home\"]")
	private WebElement Actual_HomeScreen;
	
	@FindBy(xpath = "//h1[text()=\"Log In\"]")
	private WebElement Actual_Login_Sheet;
	
	@FindBy(xpath = "//h2[text()=\"Create your Profile\"]")
	private WebElement Register_page_title;
	
	@FindBy(xpath = "id=\"ssIFrame_google\"")
	private WebElement Frame_Id;
	
	
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
    
     public Registeration_Page_Objects()
     {
	    PageFactory.initElements(getDriver(), this);
     }
     
     /************************
 	 * 						 *
 	 *   Expecting Data      *
 	 *						 *
 	 *************************/
     
 	 private String Expecting_Login_sheet="Log In";
     private String Expecting_Home_Page="Home";
     private String ExpectedText_Create_your_Profile = "Create your Profile";
  //   private String Frame_id="id=\"ssIFrame_google\"";
    
    /**********************************
 	 * 						          *
 	 * Executing Registration Module  *
 	 * @Assertions			          *
 	 * @Adding Logs                   *
 	 * @Charity						  *
 	 * @First Name					  *
 	 * @last Name					  *
 	 * @Mobile _Num   				  *
 	 * @Email_ID					  *
 	 * @Password					  *
 	 * @Preferred Method			  *
 	 * @Address						  *
 	 * @Postal Code                   *
 	 * @Country                       *
 	 * @State                         *
 	 * @Avatar  			          *
 	 *    		 			          *
 	 * 						          *
 	 **********************************/
	
	public void Registration(String First_Name,String Last_Name,String Reg_Mobile,String Reg_New_Email,String Reg_New_Password,String Reg_Address,String Reg_Postalcode) throws Exception
	{
		
	/****************************
	 *  Registration Validation *
	 ***************************/	
	
    /** Home Page Validation  **/	
		
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
	 		
   /** Performing Register Action **/	
	 	//act.implicitWait(getDriver(), 10);
	 	Thread.sleep(4000);
	 	act.click(getDriver(), Register);
	 	act.implicitWait(getDriver(), 10);
		
   /** Register Page Validation  **/	
		
		act.implicitWait(getDriver(), 10);
		String Registration_Title = Register_page_title.getText();
		act.Assertion(ExpectedText_Create_your_Profile, Registration_Title);
		
	/** Register Page Values Passing   **/
		
		act.click(getDriver(), profiletype);
		Log.debug(" profiletype Selected Successfully ");
		
		act.implicitWait(getDriver(), 10);
		act.click(getDriver(), Charity);
		Log.debug(" Charity Clicked Successfully ");
		
		Thread.sleep(4000);
		act.click(getDriver(), Yes_Proceed);
		Log.debug(" Yes_Proceed Clicked Successfully ");
		
		act.selectBySendkeys(First_Name, FirstName);
		Log.debug(" FirstName Entered Successfully ");
		
		act.selectBySendkeys(Last_Name, LastName);
		Log.debug(" LastName Entered Successfully ");
		
		act.selectBySendkeys(Reg_Mobile, MobileNum);
		Log.debug(" MobileNum Entered Successfully ");
		
		act.selectBySendkeys(Reg_New_Email, EmailID);
		Log.debug(" EmailID Entered Successfully ");
		
		act.selectBySendkeys(Reg_New_Password, Password);
		Log.debug(" Password Entered Successfully ");
		
		act.click(getDriver(), Prefered_Method_For_contact);
		act.implicitWait(getDriver(), 10);
		Log.debug("Prefered_Method_For_contact clicked  Successfully ");
		
		act.click(getDriver(), Call);
		Log.debug("Call Method Selected Successfully ");
		
		act.implicitWait(getDriver(), 10);
		act.selectBySendkeys(Reg_Address, Address);
		Log.debug(" Address Entered Successfully ");
		
//		act.click(getDriver(), SelectCountry);
//		Log.debug("SelectCountry clicked  Successfully ");
//		
//		act.click(getDriver(), india);
//		Log.debug("india clicked Successfully ");
		
		act.selectBySendkeys(Reg_Postalcode, Postal_Code); 
		Log.debug(" Postal_Code Entered Successfully ");
		
		act.click(getDriver(), Select_Avathar);
		Log.debug("Select_Avathar clicked  Successfully ");
		
//		Thread.sleep(4000);
//		getDriver().switchTo().frame(Frame);
		
		act.switchToFrameById(getDriver(), "ssIFrame_google");
		Log.debug("Switched to Frame Successfully ");
		
		Thread.sleep(2000);
		act.click(getDriver(), Image);
		Log.debug("Image clicked  Successfully ");
		
		act.click(getDriver(), Save);
		Log.debug("Save clicked  Successfully ");
		
		act.click(getDriver(), Next);
		Log.debug("Next clicked  Successfully ");
	
	
	}

}
