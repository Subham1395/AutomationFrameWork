package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//rule1
	
	//rule2 declaration
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
    private WebElement contactsLookUpImg;
	
	
	//rule3 initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//rule4 utilization
	public WebElement getContactsPlusImg() {
		return contactsLookUpImg;
	}
	
	//rule5 business libraries
	/**
	 * this method will used for click on create contact look up img
	 */
	 public void clickOnCreateContactLookUpImg()
	 {
		 contactsLookUpImg.click();
	 }
	
}
