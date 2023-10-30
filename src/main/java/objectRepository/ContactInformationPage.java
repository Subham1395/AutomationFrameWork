package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
//step1 declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//step2 initialization
	public ContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//step3 utilization
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	//step4 business libraries
	public String getHeaderText()
	{
		 return contactHeaderText.getText();
	}
	
}
