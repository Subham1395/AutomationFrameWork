package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {//rule1
	
	//rule2 declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement organizationHeaderText;
	
	

	//rule3 initialization
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//rule4 utilization
	
	
	public WebElement getOrganizationHeaderText() 
	{
		return organizationHeaderText;
	}
	//rule5 business libraries
	/**
	 * this method will use for get Header part of organization
	 * @return
	 */
	
	public String getHeaderText()
	{
		return organizationHeaderText.getText();
	}
}
