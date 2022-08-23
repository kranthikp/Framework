
 
package Page_objects.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;


public class loginPage extends Baseclass{

	
	Action actionClass = new Action();
	@FindBy(xpath = "//input[@id='email']")
	 WebElement username;
	
	@FindBy(xpath = "//input[@id='passwd']")
	 WebElement password;
	
	@FindBy(xpath="//button[@name='SubmitLogin']")
	 WebElement signInBtn;
	
	
	@FindBy(name="email_create")
	 WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	 WebElement createNewAccountBtn;
	
	public loginPage() {
		PageFactory.initElements(getDriver(), this);
		
	}
	public HomePage  login(String uname,String pswd, HomePage homePage) throws Throwable {
		
		//actionClass actionClass = new actionClass();
		//actionClass.scrollByVisibilityOfElement(getDriver(), username);
		System.out.println("loginpage uname is "+uname+" pswd is  "+pswd);
		actionClass.type(username,uname);
		actionClass.type(password, pswd);
		actionClass.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		 
		return new HomePage();	
	}
	
	public AddressPage login1(String uname,String pswd, AddressPage addressPage) throws InterruptedException {
		actionClass.type(username,uname);
		actionClass.type(password, pswd);
		actionClass.click(getDriver(), signInBtn);
		Thread.sleep(2000);
		addressPage=new AddressPage();
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		actionClass.type(emailForNewAccount, newEmail);
		actionClass.click(getDriver(),createNewAccountBtn );
		return new AccountCreationPage();
		
	}
	
}
