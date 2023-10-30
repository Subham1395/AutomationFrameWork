package contactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactsPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;


public class CreateContactsWithOrganizationTest extends BaseClass {
	@Test(groups="RegrassionSuite")

	public void createContactsWithOrganizationTest() throws Throwable {
	
	

	
	// Step 1: Create all the required Objects
//			JavaUtility jUtil = new JavaUtility();
//			ExcelUtility eUtil = new ExcelUtility();
//			PropertyFileUtility pUtil = new PropertyFileUtility();
//			WebDriverUility wUtil = new WebDriverUility();
//			WebDriver driver = null;
//
//			// Step 2: Read The Required Data
//			String BROWSER = pUtil.readDatafromPropertyFile("browser");
//			String URL = pUtil.readDatafromPropertyFile("url");
//			String USERNAME = pUtil.readDatafromPropertyFile("username");
//			String PASSWORD = pUtil.readDatafromPropertyFile("password");

			String ORGNAME = eUtil.readDataFromExcelUtility("Contacts", 7, 3) + jUtil.getRandomNumber();
			String LASTNAME = eUtil.readDataFromExcelUtility("Contacts", 7, 2);

			// Step 3: Launch the browser
//			if (BROWSER.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
//				System.out.println(BROWSER + " launched");
//			} else if (BROWSER.equalsIgnoreCase("Firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//				driver = new FirefoxDriver();
//				System.out.println(BROWSER + " launched");
//			} else if (BROWSER.equalsIgnoreCase("Edge")) {
//				WebDriverManager.edgedriver().setup();
//				driver = new EdgeDriver();
//				System.out.println(BROWSER + " launched");
//			} else {
//				System.out.println("Invalid Browser Name");
//			}

			wUtil.windowmaximize(driver);
			wUtil.waiIimplicitly(driver);

			// Step 4: Load the URL
//			driver.get(URL);
//			
//			//step 5: login to application
//			LoginPage login = new LoginPage(driver);
//			login.loginPage(USERNAME, PASSWORD);
			
			//step 6 click on organization
			HomePage hp = new HomePage(driver);
		    hp.clickOnOrganization();
		    
		    //step7 click on create organization look up image
		    OrganizationPage op = new OrganizationPage(driver);
		    		op.clickOnOrganizationLookUpImg();
		    		
		    //step8 Create new Organization with mandatory fields
		    		CreateNewOrganizationPage cop= new CreateNewOrganizationPage(driver);
		    		cop.createNewOrganizationPage(ORGNAME);
		    		
		    		//step9 validate for  organization
		    		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		    		String ORGANIZATIONHEADERTEXT = oip.getHeaderText();
		    		Assert.assertTrue(ORGANIZATIONHEADERTEXT.contains(ORGNAME));
		    		System.out.println(ORGANIZATIONHEADERTEXT);
//		    		if(ORGANIZATIONHEADERTEXT.contains(ORGNAME))
//		    		{
//		    			System.out.println(ORGANIZATIONHEADERTEXT);
//		    			System.out.println("organization created");
//		    		}
//		    		else
//		    		{
//		    			System.out.println("fail");
//		    		}
		    		//step10 click on contact link
		    		hp.clickOnContacts();
		    		
		    		//step11 click on contact look up  image
		    		ContactsPage cp = new ContactsPage(driver);
		    		cp.clickOnCreateContactLookUpImg();
		    		
		    		//step12 Create Contact with organization
		    		CreateNewContactsPage ccp= new CreateNewContactsPage(driver);
		    		ccp.createNewContacts(driver, LASTNAME, ORGNAME);
		    		
		    		//step13 validate 
		    		ContactInformationPage cip = new ContactInformationPage(driver);
		    		String contactheader=cip.getHeaderText();
		    		Assert.assertTrue(contactheader.contains(LASTNAME));
		    		System.out.println(contactheader);
		    	
//		    		if(contactheader.contains(LASTNAME))
//		    		{
//		    			System.out.println(contactheader);
//		    			System.out.println("contcta create");
//		    		}
//		    		else
//		    		{
//		    			System.out.println("fail");
//		    		}
		    		
//		            //step14 logout application
//		    		hp.logOutApp(driver);
		    		
//		    		//step15 close the browser
//		    		driver.quit();
		    		
			
		   
	}
}
