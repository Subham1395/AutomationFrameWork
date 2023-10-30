package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUility;

public class CreateNewOrganizationPage extends WebDriverUility {//rule1
	//rule2 declaration
	
	@FindBy(name="accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDrowpdown;
	
	@FindBy(xpath="//select[@name='accounttype']")
	public WebElement typeDropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//rule3 initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//rule4 utilization

	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getIndustryDrowpdown() {
		return industryDrowpdown;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
//rule5 Business libraries
	public void createNewOrganizationPage(String ORGANIZATIONNAME)
	{
		organizationNameEdt.sendKeys(ORGANIZATIONNAME);
		saveBtn.click();
	}
	
	public void createNewOrganizationPage(String ORGANIZATIONNAME, String INDUSTRY)
	{
		organizationNameEdt.sendKeys(ORGANIZATIONNAME);
		dropDownhandle(industryDrowpdown,INDUSTRY);
		saveBtn.click();
	}
	public void createNewOrganizationPage(String ORGANIZATIONNAME, String INDUSTRY, String TYPE)
	{
		organizationNameEdt.sendKeys(ORGANIZATIONNAME);
		dropDownhandle(industryDrowpdown,INDUSTRY);
		dropDownhandle(typeDropdown,TYPE);
		saveBtn.click();
	}
}
