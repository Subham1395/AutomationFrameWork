package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	/**
	 * this class contains of all base configuration Annotation of TestNg
	 */
	public JavaUtility jUtil = new JavaUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriverUility wUtil = new WebDriverUility();
	public WebDriver driver = null;
	public static WebDriver sdriver; //we use this only for listeners class becuse we need only drive from base class so easy not extend that class insted we jst make it static.
	
	@BeforeSuite(groups= {"SmokeSuite","RegrassionSuite"})
	public void bsConfigure()
	{
		System.out.println("-------DB Connection Successfull------");
	}
	//@Parameters("browser") //this will used only for cross browser testing with @before test annotation.
	//@BeforeTest    // this will only change for parallel execution after execution revert back
	@BeforeClass(alwaysRun=true)
	public void bcConfigure() throws Throwable
	//public void bcConfigure(String BROWSER) throws Throwable  // this will only use for cross browser
	{
		String BROWSER = pUtil.readDatafromPropertyFile("browser");
		String URL = pUtil.readDatafromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + " launched");
		} else {
			System.out.println("Invalid Browser Name");
		}
		
		wUtil.windowmaximize(driver);
		wUtil.waiIimplicitly(driver);
		sdriver=driver;// we use only for listeners .
		driver.get(URL);

		System.out.println("-------Launching Browser Successfull------");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfigure() throws Throwable
	{
		
		String USERNAME = pUtil.readDatafromPropertyFile("username");
		String PASSWORD = pUtil.readDatafromPropertyFile("password");
		LoginPage login = new LoginPage(driver);
		login.loginPage(USERNAME, PASSWORD);
		System.out.println("-------Login app  Successfull------");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfigure()
	{
		HomePage home = new HomePage(driver);
		home.logOutApp(driver);
		System.out.println("-------LogOut App Successfull------");
	}
	//@AfterTest              // this will only change for parallel execution and after execution revert back 
	@AfterClass(alwaysRun=true)
	public void acConfigure()
	{
		driver.quit();
		System.out.println("-------Close Browser Successfull------");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfigure()
	{
		System.out.println("------- close DB Connection Successfull------");
	}
	

}

