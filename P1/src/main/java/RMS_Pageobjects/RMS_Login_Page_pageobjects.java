/**
 * 
 */
package RMS_Pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;


/**
 * @author VijayKumarNarla
 *
 */
public class RMS_Login_Page_pageobjects extends Baseclass{
	
	
	/**
	 * 
	 * creating Actions class object globally 
	 * 
	 * */
	
	Action action= new Action();
	
	
	@FindBy(xpath = "//input[@name=\"txtUsername\"]")
	private WebElement EmailRMS;
	
	@FindBy(xpath = "//input[@name=\"txtPassword\"]")
	private WebElement Password;
	
	@FindBy(xpath = "//input[@name=\"Submit\"]")
	private WebElement login;
	
	@FindBy(xpath = "//a[text()=\"Forgot your password?\"]")
	private WebElement Forgotpassword;
	
	
	@FindBy(xpath = "")
	private WebElement Cancel;
	
	
 	public RMS_Login_Page_pageobjects()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
 	
 	public void username(String useremail)
 	{
 		action.findElement(getDriver(), EmailRMS);
 		action.isSelected(getDriver(), EmailRMS);
 		action.selectBySendkeys(useremail, EmailRMS );
 		System.out.println(EmailRMS);
 	
 	}
 	
 	public void password(String password)
 	{
 		action.selectBySendkeys(password, Password);
 	}
 	
 	public void login_btn()
 	{
 		action.click(getDriver(), login);
 		return;
 	}
 	
	public void Forgotpassword()
	{
		action.click(getDriver(), Forgotpassword);
	}
	public void Sleep()
	{
		action.implicitWait(getDriver(), 10);
	}
	
	public String Title() {
		String Actual = action.getTitle(getDriver());
		return Actual;
	}
	
	
	

}
