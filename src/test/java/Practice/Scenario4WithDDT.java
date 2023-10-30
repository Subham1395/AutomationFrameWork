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
import org.openqa.selenium.support.ui.Select;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4WithDDT {

	public static void main(String[] args) throws Throwable {
		 //step1 read all the data 
		/*read the data from properties file*/
		PropertyFileUtility plib = new PropertyFileUtility();
		ExcelUtility elib = new ExcelUtility();
		WebDriverUility wlib = new WebDriverUility();
		JavaUtility jlib = new JavaUtility();
//		FileInputStream fis = new FileInputStream("src/test/resources/commmondata.properties");
//        Properties poj = new Properties();
//        poj.load(fis);
//        String URL = poj.getProperty("url");
//        String BROWSER = poj.getProperty("browser");
//          String USERNAME = poj.getProperty("username");
//         String PASSWORD = poj.getProperty("password");
		String URL=plib.readDatafromPropertyFile("url");
		String BROWSER=plib.readDatafromPropertyFile("browser");
		String USERNAME=plib.readDatafromPropertyFile("username");
		String PASSWORD=plib.readDatafromPropertyFile("password");
         
         /*read the data from excel sheet*/
//         Random ran=new Random();
//         int rannum = ran.nextInt(1000);
//        FileInputStream fis2 = new FileInputStream("src/test/resources/TestData.xlsx/");
//        Workbook book = WorkbookFactory.create(fis2);
//       String ORGNAME = book.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue()+rannum;
		String ORGNAME=elib.readDataFromExcelUtility("Organizations", 1, 2)+jlib.getRandomNumber();
       System.out.println(ORGNAME);
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
      
       //step3 give waits
//       driver.manage().window().maximize();
//       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       wlib.windowmaximize(driver);
       wlib.waiIimplicitly(driver);
       
       //step4 load the app
       driver.get(URL);
       
       //step5 login to app
    	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    	driver.findElement(By.id("submitButton")).click();
    	
    	//setp6 navigate to organization module
  	  driver.findElement(By.linkText("Organizations")).click();
  	  
  	  //step7 click on create organization look up image
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        
        //step8 create organization
  	 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
  	 
  	 //step9 select the industry as a chemical
  	 Thread.sleep(1000);
       WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
       industry.click();
      String CHEMICAL = driver.findElement(By.xpath("//option[@value='Chemicals']")).getText();
       
//       Select sl = new Select(industry);
//       sl.selectByVisibleText(CHEMICAL);
      wlib.dropDownhandle(CHEMICAL, industry);
       
       //step10 select the type as energy
       WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
       type.click();
//       Select sl2 = new Select(type);
//       sl2.selectByVisibleText("Customer");
       wlib.dropDownhandle("Customer", type);
       
       //step11 save
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
       //step12 validate
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
     
       //step13  sign out app
       Thread.sleep(2000);
  	 WebElement alt = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//       Actions act = new Actions(driver);
//  	 act.moveToElement(alt).perform();
  	 wlib.mouseHoverAction(driver, alt);
  	 driver.findElement(By.linkText("Sign Out")).click();
  	 System.out.println("sing out the app");
  	 
  	 //step14 close the browser
  	 driver.quit();

	}

}
