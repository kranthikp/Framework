package Vgive_pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;

public class Suppot_For_Existing_Fund_Raise_Page_objects extends Baseclass{
	
	
	
	
	/************************************** 
	 * @Locaters                          *
	 *  Locater's for Registration Module *
	 **************************************/
	
	
	
	@FindBy(xpath = "//div[@class=\"jss19 MuiBox-root css-i1xvvt\"]//descendant::span[@class=\"MuiTouchRipple-root\"]")
	private WebElement create_newfundraise;
	
	@FindBy(xpath = "//a[text()=\"Support existing fundraiser\"]")
	private WebElement Support_For_Existing;
	
	@FindBy(xpath = "//div[@class=\"MuiGrid-root MuiGrid-item MuiGrid-grid-xs-4 css-148ijqt\"][1]//descendant::button[text()=\"Support\"]")
	private WebElement Support_For_initial_one;
	
	@FindBy(xpath = "//h1[text()=\"Personalize the fundraiser\"]")
	private WebElement Text;
	
	@FindBy(xpath = "//div[@class=\"MuiFormControl-root MuiFormControl-marginNormal MuiFormControl-fullWidth MuiTextField-root css-1u0h3mu\"]")
	private WebElement Title;
		
	@FindBy(xpath = "//div[@class=\"MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-multiline css-15kq27i\"]")
	private WebElement Discription;
	
	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedStart css-1ixds2g\"]")
	private WebElement Amount;
		
	@FindBy(xpath = "//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"]")
	private WebElement Checkbox;
	
	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-edgeEnd MuiIconButton-sizeMedium css-slyssw\"]")
	private WebElement Calender;
	
	@FindBy(xpath = "//button[@aria-label=\"Aug 31, 2022\"]")
	private WebElement Date;
	
	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-14pknsb\"]")
	private WebElement Next;
	
	
	/**Assertion Elements  **/
	
	@FindBy(xpath = "//h2[text()=\"Help raise funds for the charity of your choice.\"]")
	private WebElement Help_raise_funds_for_the_charity_of_your_choice;
	

	
	

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
	
	public Suppot_For_Existing_Fund_Raise_Page_objects()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void Support_For_Exixting_FundRaise_Execution()
	{
		act.Move_To(getDriver(), create_newfundraise);
		act.click(getDriver(), Support_For_Existing);
		
		String Actual = act.Get_Text(getDriver(), Text);
		act.Assertion(Actual, Actual);
		act.click(getDriver(), Support_For_initial_one);
		
	}
	

}
