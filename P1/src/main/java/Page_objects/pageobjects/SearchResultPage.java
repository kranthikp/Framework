package Page_objects.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;

public class SearchResultPage extends Baseclass{

	Action actionClass = new Action();
	@FindBy(xpath="//img[@itemprop='image']")
	
     WebElement productResult;

	public SearchResultPage (){		
	PageFactory.initElements(getDriver(), this);	
	}
	
	public   boolean isProductAvailable() throws Throwable {
		return actionClass.isDisplayed(getDriver(), productResult);
		
	}
	public  AddToCartPage clickOnproduct() throws Throwable{
		
		actionClass.click(getDriver(), productResult);
		return new AddToCartPage();
	}

	
	
}
