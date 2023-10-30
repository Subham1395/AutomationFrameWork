package Practice;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4 {
	
	public static void main(String[] args) throws IOException, Throwable {
		

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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
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
    WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
    industry.click();
    Select sl= new Select(industry);
    sl.selectByVisibleText("Chemicals");
      
     WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
     type.click();
     Select sl2 = new Select(type);
     sl2.selectByVisibleText("Customer");
    
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
