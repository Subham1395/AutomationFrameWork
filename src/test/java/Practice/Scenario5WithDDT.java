package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5WithDDT {

	public static void main(String[] args) throws Throwable {

		// Step 1: Create all the required Objects
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUility wUtil = new WebDriverUility();
		WebDriver driver = null;

		// Step 2: Read The Required Data
		String BROWSER = pUtil.readDatafromPropertyFile("browser");
		String URL = pUtil.readDatafromPropertyFile("url");
		String USERNAME = pUtil.readDatafromPropertyFile("username");
		String PASSWORD = pUtil.readDatafromPropertyFile("password");

		String ORGNAME = eUtil.readDataFromExcelUtility("Contacts", 7, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelUtility("Contacts", 7, 2);

		// Step 3: Launch the browser
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

		// Step 4: Load the URL
		driver.get(URL);

		// Step 5: Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 6: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();

		// Step 7: Click on Create Organization look Up Imge
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 7: Create Organization with mandatory information
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 8: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 9: Validate for Organization
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader);
			System.out.println("Organization created successfully");
		} else {
			System.out.println("FAIL");
		}

		// Step 10: Navigate to Contacts
		driver.findElement(By.linkText("Contacts")).click();

		// Step 11: Click on create Contact look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 12: Create Contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 13: click on Organization look Up Image
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();

		wUtil.switchWindoHandle(driver, "Accounts");

		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();

		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();
		// Orgname is dynamic
		// xpath is changing dynamically - dynamic xpath
		// a[text()='"+varible+"']

		wUtil.switchWindoHandle(driver, "Contacts");

		// Step 14: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 15: Validate for Organization
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Step 16: logout of app
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);

		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successful");

	}

}

