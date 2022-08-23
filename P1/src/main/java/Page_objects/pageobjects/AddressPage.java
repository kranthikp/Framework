package Page_objects.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;

public class AddressPage extends Baseclass {
		
	Action actionClass = new Action();
		
		@FindBy(xpath="//span[text()='Proceed to checkout']" )                                      //"//span[text()='Proceed to checkout']")
		 WebElement proceedToCheckOut;
		//a[@title='Proceed to checkout']
		public AddressPage() {
			PageFactory.initElements(getDriver(), this);
		}

		public   ShippingPage clickOnCheckOut() throws Throwable {
			actionClass.click(getDriver(), proceedToCheckOut);
			return new  ShippingPage();
		}
		
	}

