package Practice;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import objectRepository.LoginPage;

public class Scenario1withDDT {

	public static void main(String[] args) throws Throwable {
		//step1 Read all the necessary Data
		/*read data from properties file*/
//		FileInputStream fis = new FileInputStream("src/test/resources/commmondata.properties");
//       Properties poj = new Properties();
//       poj.load(fis);
//      String URL = poj.getProperty("url");
//     String BROWSER = poj.getProperty("browser");
//    String USERNAME = poj.getProperty("username");
//   String PASSWORD = poj.getProperty("password");
//   
		PropertyFileUtility plib = new PropertyFileUtility();
		 String URL=plib.readDatafromPropertyFile("url");
		 String BROWSER=plib.readDatafromPropertyFile("browser");
		 String USERNAME=plib.readDatafromPropertyFile("username");
		 String PASSWORD =plib.readDatafromPropertyFile("password");
   /*read the data from excel sheet*/
		 JavaUtility jlib= new JavaUtility();
		 
//   Random ran = new Random();
//	int rannum = ran.nextInt(1000);
//  FileInputStream fis2 = new FileInputStream("src/test/resources/TestData.xlsx");
//  Workbook book=WorkbookFactory.create(fis2);
//   String ORGNAME = book.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue()+rannum;
	ExcelUtility elib= new ExcelUtility();
	String ORGNAME=elib.readDataFromExcelUtility("Organizations", 1, 2)+jlib.getRandomNumber();
   System.out.println(ORGNAME);
   
   WebDriver driver = null;
   //step2 launching the browser
   if(BROWSER.equalsIgnoreCase("chrome"))
   {
	   WebDriverManager.chromedriver().setup();
	 driver=  new ChromeDriver();
	 System.out.println(BROWSER+" launched");
   }
   else if(BROWSER.equalsIgnoreCase("firefox"))
   {
	   WebDriverManager.firefoxdriver().setup();
	 driver=  new FirefoxDriver();
	 System.out.println(BROWSER+" launched");
   }
   else if(BROWSER.equalsIgnoreCase("edge"))
   {
	   WebDriverManager.edgedriver().setup();
	 driver=  new EdgeDriver();
	 System.out.println(BROWSER+" launched");
   }
   else
   {
	   System.out.println("browser launching failed");
   }
   //step give waits
   WebDriverUility wlib = new WebDriverUility();
   wlib.windowmaximize(driver);
   wlib.waiIimplicitly(driver);
//   driver.manage().window().maximize();
//   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   
   //step3 load the app
   driver.get(URL);
   
   //step4 login to app
//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//	driver.findElement(By.id("submitButton")).click();
   LoginPage pg= new LoginPage(driver);
   pg.loginPage(USERNAME, PASSWORD);
//	pg.getUserNameEdt().sendKeys(USERNAME);
//	pg.getPasswordEdt().sendKeys(PASSWORD);
//	pg.getLoginBtn().click();
	
	//step5 navigate to contacts module
	driver.findElement(By.linkText("Organizations")).click();
   
    //step 6 click on create contacts look up image
    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//step7 create contacts
    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
	
	//step8 save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//step9 validate
	 String validate = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	System.out.println(validate);
	if(validate.contains(ORGNAME))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	
	//step10 logout
	 WebElement alt = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 wlib.mouseHoverAction(driver, alt);
//    Actions act = new Actions(driver);
//	 act.moveToElement(alt).perform();
	 driver.findElement(By.linkText("Sign Out")).click();
	 System.out.println("sign out successfully");
	 
	 //step11 close the window
	 driver.quit();
	}

}
