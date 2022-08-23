package Page_objects.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;

public class PaymentPage extends Baseclass {
	
	Action actionClass = new Action();
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary clickOnPaymentMethod() throws Throwable {
		actionClass.click(getDriver(), bankWireMethod);
		return new OrderSummary();
	}
}