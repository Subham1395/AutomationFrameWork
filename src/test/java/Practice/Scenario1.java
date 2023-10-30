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
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class Scenario1 {
	
public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("src/test/resources/commondata.properties.txt");
		Properties poj = new Properties();
		poj.load(fis);
		String URL = poj.getProperty("url");
		String USERNAME = poj.getProperty("username");
		String PASSWORD = poj.getProperty("password");
		
		driver.get(URL);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		LoginPage pg= new LoginPage(driver);
		pg.getUserNameEdt().sendKeys(USERNAME);
		pg.getPasswordEdt().sendKeys(PASSWORD);
		pg.getLoginBtn().click();
		Random ran = new Random();
		int rannum = ran.nextInt(1000);
		  Thread.sleep(2000);
       driver.findElement(By.linkText("Organizations")).click();
       driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
       FileInputStream fis2 = new FileInputStream("src/test/resources/ExcelData.xlsx");
       Workbook book = WorkbookFactory.create(fis2);
      Sheet sheet = book.getSheet("Organizations");
     Row row = sheet.getRow(0);
    Cell cell = row.getCell(0);
   String ORGNAME = cell.getStringCellValue()+rannum;
   System.out.println(ORGNAME);
       driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(ORGNAME);
       Thread.sleep(2000);
       Sheet sheet1 = book.getSheet("Organizations");
       Row row1 = sheet1.getRow(1);
      Cell cell1 = row1.getCell(0);
      String Phone = cell1.getStringCellValue();
      System.out.println(Phone);
       driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(Phone);
       Sheet sheet2 = book.getSheet("Organizations");
       Row row2 = sheet2.getRow(2);
      Cell cell2 = row2.getCell(0);
      String Email = cell2.getStringCellValue();
      System.out.println(Email);
       driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(Email);
       Thread.sleep(2000);
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
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
       Thread.sleep(2000);
  	 WebElement alt = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       Actions act = new Actions(driver);
  	 act.moveToElement(alt).perform();
  	 driver.findElement(By.linkText("Sign Out")).click();
  	 driver.quit();
       

	}


}
