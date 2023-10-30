package Practice;

import java.io.FileInputStream;
import java.io.IOException;
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

public class Scenario2 {
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		FileInputStream fis = new FileInputStream("src/test/resources/commondata.properties");
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
		FileInputStream fis2 = new FileInputStream("src/test/resources/ExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fis2);
		Sheet sheet = book.getSheet("contacts");
		 Row row=sheet.getRow(0);
		 Cell cell = row.getCell(0);
		String lastname = cell.getStringCellValue()+rannum;
		System.out.println(lastname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
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
