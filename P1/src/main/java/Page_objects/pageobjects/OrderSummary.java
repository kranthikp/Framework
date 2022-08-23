package Page_objects.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;

public class OrderSummary extends Baseclass {
	
	Action actionClass = new Action();
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public OrderSummary() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		actionClass.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
	
}