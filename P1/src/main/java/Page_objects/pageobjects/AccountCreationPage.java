package Page_objects.pageobjects;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;


public class AccountCreationPage extends Baseclass {
   
	
	Action actionClass = new Action();
	@FindBy(xpath = "//h1[text()='Create an account']")
	WebElement formTitle;

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public HomePage validateRegistration() throws Throwable {
		WebElement registerBtn = null;
		registerBtn.click();
		return new HomePage();
	}
    public boolean validateAccountCreatePage() {
    	return actionClass.isDisplayed(getDriver(), formTitle);
    	
    }
	

	
}