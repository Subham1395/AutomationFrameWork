package Practice;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 {
	public static void main(String[] args) throws IOException, Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		FileInputStream fis = new FileInputStream("src/test/resources/commmondata.properties.");
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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		FileInputStream fis2 = new FileInputStream("src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sheet = book.getSheet("contacts");
		 Row row=sheet.getRow(1);
		 Cell cell = row.getCell(2);
		String lastname = cell.getStringCellValue()+rannum;
		System.out.println(lastname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
         Thread.sleep(2000);
         driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif'][1]")).click();
        // String OrgName = book.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue()+rannum;
        Set<String> allid = driver.getWindowHandles();
        Iterator<String> id = allid.iterator();
      while(id.hasNext())
      {
    	String mainid = id.next();
    	driver.switchTo().window(mainid);
    String title = driver.getTitle();
    System.out.println(title);
    if(title.contains("Accounts&action"))
    		
    		{
    	break;
    		}
      }
   driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Tata Motors317");
   driver.findElement(By.xpath("//input[@name='search']")).click();
   driver.findElement(By.xpath("//a[text()='Tata Motors317']")).click();
   Set<String> allid1 = driver.getWindowHandles();
   Iterator<String> id1 = allid1.iterator();
 while(id1.hasNext())
 {
	String mainid1 = id1.next();
	driver.switchTo().window(mainid1);
String title1 = driver.getTitle();
System.out.println(title1);
if(title1.contains("Contacts&action"))
		
		{
	break;
		}
 }
 Thread.sleep(2000);
   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
   String validate = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
	System.out.println(validate);
	if(validate.contains(lastname))
	{
		System.out.println("pass");
	}
	else
	{
		System.out.println("fail");
	}
	 WebElement alt = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    Actions act = new Actions(driver);
	 act.moveToElement(alt).perform();
	 driver.findElement(By.linkText("Sign Out")).click();
	 driver.quit();
	}
}
