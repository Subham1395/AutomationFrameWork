package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUility;

public class CreateNewContactsPage extends WebDriverUility {//rule1
	
	//rule2 declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement organizationLookUpImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="search_text")
	private WebElement organizationSearchEdt; 
	
	@FindBy(name="search")
	private WebElement organizationSearchbtn;
	
	//rule3 initialization
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//rule4 utilization
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrganizationPlusImg() {
		return organizationLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getOrganizationSearchEdt() {
		return organizationSearchEdt;
	}

	public WebElement getOrganizationSearchbtn() {
		return organizationSearchbtn;
	}
	
	//rule5 business libraries
	
	
	public void createNewContacts(String ORGANIZATIONNAME )
	{
		lastNameEdt.sendKeys(ORGANIZATIONNAME);
		saveBtn.click();
	}
	public void createNewContacts(WebDriver driver, String LASTNAME, String ORGANIZATIONNAME)
	{
		lastNameEdt.sendKeys(LASTNAME);
		organizationLookUpImg.click();
		switchWindoHandle(driver,"Accounts");
		organizationSearchEdt.sendKeys(ORGANIZATIONNAME);
		organizationSearchbtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGANIZATIONNAME+"']")).click();
		switchWindoHandle(driver,"Contacts");
		saveBtn.click();
	}
	

}
