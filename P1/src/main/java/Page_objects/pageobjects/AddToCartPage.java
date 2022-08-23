package Page_objects.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;

public class AddToCartPage extends Baseclass {
	Action actionClass = new Action();
	@FindBy(id="quantity_wanted")
	WebElement quantity;

	@FindBy(name="group_1")
	WebElement size;

	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCartBtn;

	@FindBy(xpath="//i[@class='icon-ok']")
	WebElement addToCartMessag;

	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement proceedToCheckOutBtn;

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	public void enterQuantity(String quantity1) throws Throwable {
		actionClass.type(quantity, quantity1);
	}

	public void selectSize(String size1) throws Throwable {
		
		actionClass.selectByVisibleText(size1, size);
	}

	public void clickOnAddToCart() throws Throwable {
		actionClass.click(getDriver(), addToCartBtn);
	}

	public boolean validateAddtoCart() throws Throwable {
		actionClass.fluentWait(getDriver(), addToCartMessag, 10);
		return actionClass.isDisplayed(getDriver(), addToCartMessag);
	}

	public orderPage clickOnCheckOut() throws Throwable {
		actionClass.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		//actionClass.click(driver, proceedToCheckOutBtn);
		actionClass.JSClick(getDriver(), proceedToCheckOutBtn);
		return new orderPage();
	}

}