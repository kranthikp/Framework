package Page_objects.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionDriver.Action;
import Base.Baseclass;

public class indexPage extends Baseclass {

	Action actionClass = new Action();

	@FindBy(xpath="//a[@class='login']")
	 WebElement signInBtnElement;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	 WebElement logo;
	
	@FindBy(xpath="//input[@class='search_query form-control ac_input']")
	 WebElement search;
	
	@FindBy(xpath="//button[@name='submit_search']")
     WebElement submit;
	
	public indexPage() {
		System.out.println("driver    "+driver);
		PageFactory.initElements(getDriver(), this);
		//PageFactory.initElements(driver, this);
	}
	public  loginPage clickOnSignIn() throws Throwable {
	  Thread.sleep(2000);
		actionClass.click(getDriver(), signInBtnElement);
	    return new loginPage();
	}
	public boolean  validatelogo() throws Throwable{
		return actionClass.isDisplayed(getDriver(),logo);
	}
	public  String myStoreTitle() {
		String myStoreTitle1=getDriver().getTitle();
		return myStoreTitle1;
	}
	public SearchResultPage searchProduct(String productName)throws Throwable{
		actionClass.type(search, productName);
		actionClass.click(getDriver(), submit);
		Thread.sleep(3000);
		return new SearchResultPage();
		
	}
}
