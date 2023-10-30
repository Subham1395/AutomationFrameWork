package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUility;

public class HomePage extends WebDriverUility {//ruel1
	
	//rule2 declare
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstrationImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
	
	//rule3 initialization
  public HomePage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  
  //rule4 utilization

public WebElement getOrganizationLnk() {
	return organizationLnk;
}

public WebElement getContactsLnk() {
	return contactsLnk;
}

public WebElement getAdminstrationImg() {
	return adminstrationImg;
}

public WebElement getSignoutLnk() {
	return signoutLnk;
}
  
  //rule5 Business libraries
/**
 * this method will use to click on organization
 */
 public void clickOnOrganization()
 {
	 organizationLnk.click();
 }
  /**
   * this method will use to click on contacts
   */
 public void clickOnContacts()
 {
	 contactsLnk.click();
 } 
/**
 * this method will use to log out the app	
 * @param driver
 */
public void logOutApp(WebDriver driver)
{
	mouseHoverAction(driver, adminstrationImg);
}
	

}
