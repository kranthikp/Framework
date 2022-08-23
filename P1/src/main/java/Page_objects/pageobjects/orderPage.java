package Page_objects.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;

public class orderPage extends Baseclass{
	
	Action actionClass = new Action();
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
			//"//span[@id='product_price_1_1_0']")                                // "//td[@class='cart_unit']/span/span")
	 WebElement unitPrice;
	
	@FindBy(id="total_price")
	 WebElement totalPrice;
	
	@FindBy(xpath=" //span[text()='Proceed to checkout']" )//span[text()='Proceed to checkout']")
    WebElement proceedToCheckOut;
	//a[@title='Proceed to checkout']
	public orderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public double getUnitPrice() {
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public loginPage clickOnCheckOut() throws Throwable {
		actionClass.click(getDriver(), proceedToCheckOut);
		return new loginPage();
	}

}
