package Page_objects.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;

public class HomePage extends Baseclass{

	Action actionClass = new Action();
	@FindBy(xpath="//span[text()='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement orderHistory;
	
    public HomePage() {
		PageFactory.initElements(getDriver(), this);
		//System.out.println("driver out");
		
	}
	public boolean validateMyWishList() {
		return actionClass.isDisplayed(getDriver(), myWishList);
		
	}
	public  boolean  validateOrderHistory() {
		return actionClass.isDisplayed(getDriver(), orderHistory);
	}
	public String getCurrentURL() throws Throwable {
		String homePageURL=actionClass.getCurrentURL(getDriver());
		return homePageURL;
	}
}
