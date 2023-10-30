package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {//rule1
	
	//rule2 declare

	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement organizationLookUpImg;
	

	//rule3 initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//ruel4 utilization
	
	public WebElement getOrganizationLookUpImg() 
	{
		return organizationLookUpImg;
	}
	//rule5 business libraries
	/**
	 * this method will use for click on orglookupimg
	 */
	public void clickOnOrganizationLookUpImg()
	{
		organizationLookUpImg.click();
	}
}
