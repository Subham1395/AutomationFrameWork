package Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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

public class Scenario2WithDDT {

	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtility  plib = new PropertyFileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib= new JavaUtility();
		WebDriverUility wlib = new WebDriverUility();
	
		//step1 real all the necessary data
		/* read the data  from properties file*/
//		FileInputStream fis = new FileInputStream("src/test/resources/commmondata.properties");
//       Properties poj = new Properties();
//       poj.load(fis);
//     String URL = poj.getProperty("url");
//    String BROWSER = poj.getProperty("browser");
//      String USERNAME = poj.getProperty("username");
//     String PASSWORD = poj.getProperty("password");
		String URL = plib.readDatafromPropertyFile("url");
		String BROWSER = plib.readDatafromPropertyFile("browser");
		String USERNAME = plib.readDatafromPropertyFile("username");
		String PASSWORD = plib.readDatafromPropertyFile("password");
     
     /*read the data from excel sheet*/
//     Random ran=new Random();
//     int rannum = ran.nextInt(1000);
//    FileInputStream fis2 = new FileInputStream("src/test/resources/TestData.xlsx/");
//    Workbook book = WorkbookFactory.create(fis2);
//   String LASTNAME = book.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue()+rannum;
		String LASTNAME=elib.readDataFromExcelUtility("Contacts", 1, 2)+jlib.getRandomNumber();
     System.out.println(LASTNAME);
   //step2 Launched the Browser
   WebDriver driver =null;
   if(BROWSER.equalsIgnoreCase("chrome"))
   {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
   }
   else if(BROWSER.equalsIgnoreCase("firefox"))
   {
	   WebDriverManager.firefoxdriver().setup();
	  driver= new FirefoxDriver();
   }
   else if(BROWSER.equalsIgnoreCase("edge"))
   {
	   WebDriverManager.edgedriver().setup();
	   driver=new EdgeDriver();
   }
   else
   {
	   System.out.println("launching failed");
   }
  
   //step give waits
//   driver.manage().window().maximize();
//   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   wlib.windowmaximize(driver);
   wlib.waiIimplicitly(driver);
   
   //step3 load the app
   driver.get(URL);
   
   //step4 login to app
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//step5 navigate to contacts module
	driver.findElement(By.linkText("Contacts")).click();
	
	//step 6 click on create contacts look up image
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	//step7 create contacts
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	
	//step8 save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//step9 validate
	String validate = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
	System.out.println(validate);
	if(validate.contains(LASTNAME))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	
	//step10 logout
	 WebElement alt = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//    Actions act = new Actions(driver);
//	 act.moveToElement(alt).perform();
	 wlib.mouseHoverAction(driver, alt);
	 driver.findElement(By.linkText("Sign Out")).click();
	 System.out.println("sign out successfully");
	 
	 //step11 close the window
	 driver.quit();
	}
	

}
