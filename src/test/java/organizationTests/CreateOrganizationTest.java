package organizationTests;

import org.openqa.selenium.WebDriver;
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
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{
	@Test

	public void createOrganizationTest() throws Throwable {
	
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

					String ORGNAME = eUtil.readDataFromExcelUtility("Organizations", 1, 2) + jUtil.getRandomNumber();
					

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
					
					//step 6: click on organization
					HomePage hp = new HomePage(driver);
					hp.clickOnOrganization();
					
					//step 7 : click on create organization look up image
					OrganizationPage co = new OrganizationPage(driver);
					co.clickOnOrganizationLookUpImg();
					
					//step 8 : create organization with mandatory fields
					CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
					cop.createNewOrganizationPage(ORGNAME);
					
					//step 9: validate
					OrganizationInformationPage oip = new OrganizationInformationPage(driver);
					String organizationheadertext = oip.getHeaderText();
					Assert.assertTrue(organizationheadertext.contains(ORGNAME));
					System.out.println(organizationheadertext);
//					if(organizationheadertext.contains(ORGNAME))
//					{
//						System.out.println(organizationheadertext);
//						System.out.println("organization created");
//					}
//					else
//					{
//						System.out.println("fail");
//					}
					
//					//step 10: logout application
//					hp.logOutApp(driver);
//					
//					//step 11: close the browser
//					driver.quit();

}
}