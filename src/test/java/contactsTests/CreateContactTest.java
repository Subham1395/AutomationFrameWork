package contactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
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
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtility.ListenerImplementationClass.class)// this annotation used for listeners only and pass full qualified name with .class extension
public class CreateContactTest extends BaseClass {
	@Test(groups = "SmokeSuite")

	public void createContactTest() throws Throwable {
	
//		// Step 1: Create all the required Objects
//					JavaUtility jUtil = new JavaUtility();
//					ExcelUtility eUtil = new ExcelUtility();
//					PropertyFileUtility pUtil = new PropertyFileUtility();
//					WebDriverUility wUtil = new WebDriverUility();
//					WebDriver driver = null;
//
//					// Step 2: Read The Required Data
//					String BROWSER = pUtil.readDatafromPropertyFile("browser");
//					String URL = pUtil.readDatafromPropertyFile("url");
//					String USERNAME = pUtil.readDatafromPropertyFile("username");
//					String PASSWORD = pUtil.readDatafromPropertyFile("password");

					String LASTNAME = eUtil.readDataFromExcelUtility("Contacts", 1, 2)+ jUtil.getRandomNumber();

//					// Step 3: Launch the browser
//					if (BROWSER.equalsIgnoreCase("chrome")) {
//						WebDriverManager.chromedriver().setup();
//						driver = new ChromeDriver();
//						System.out.println(BROWSER + " launched");
//					} else if (BROWSER.equalsIgnoreCase("Firefox")) {
//						WebDriverManager.firefoxdriver().setup();
//						driver = new FirefoxDriver();
//						System.out.println(BROWSER + " launched");
//					} else if (BROWSER.equalsIgnoreCase("Edge")) {
//						WebDriverManager.edgedriver().setup();
//						driver = new EdgeDriver();
//						System.out.println(BROWSER + " launched");
//					} else {
//						System.out.println("Invalid Browser Name");
//					}
//
//					wUtil.windowmaximize(driver);
//					wUtil.waiIimplicitly(driver);
//
//					// Step 4: Load the URL
//					driver.get(URL);
//					
//					//step 5: login to application
//					LoginPage login = new LoginPage(driver);
//					login.loginPage(USERNAME, PASSWORD);
					
					//step 6: click on contact
					HomePage hp = new HomePage(driver);
					hp.clickOnContacts();
					Reporter.log("click on contact");
					
					//step 7: click on create contacts look up 
					ContactsPage cp= new ContactsPage(driver);
				     cp.clickOnCreateContactLookUpImg();
				    // Assert.fail();
				     Reporter.log("click on contact look up image");
				     
				     //step 8: create contacts with mandatory fields
				     CreateNewContactsPage cpp= new CreateNewContactsPage(driver);
				     cpp.createNewContacts(LASTNAME);
				     Reporter.log("fill the mandatory field");
				     
				     //step 9 : validate 
				     ContactInformationPage cip = new ContactInformationPage(driver);
				     String contactheadertext = cip.getHeaderText();
				     Assert.assertTrue(contactheadertext.contains(LASTNAME));
				     System.out.println(contactheadertext);
				     Reporter.log("validate");
				    // Assert.fail();
				    // Assert.assertEquals(true, false); //only write for checking the listener failed method worked or not 
//				     if(contactheadertext.contains(LASTNAME))
//				     {
//				    	 System.out.println(contactheadertext);
//				    	 System.out.println("contact created");
//				     }
//				     else
//				     {
//				    	 System.out.println("fail");
//				     }
//				     
//				     //step 10: log out application
//				     hp.logOutApp(driver);
//				     
//				     //step 11: close the browser
//				     driver.quit();
//				     

	}

}
