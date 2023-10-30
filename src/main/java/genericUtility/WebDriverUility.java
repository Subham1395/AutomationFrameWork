package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consist of generic method of web drivers
 */
public class WebDriverUility {
	 /**
     * this method will used to maximize the window
     * @param driver
     */
	public void windowmaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method will used for synchronization
	 * @param driver
	 */
	public void waiIimplicitly(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * this method will used to capturing the visible text
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will used to click on check box
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClicable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method will used to handle drop down by index
	 * @param element
	 * @param index
	 */
	 public void dropDownhandle(WebElement element, int index )
	 {
		 Select s = new Select(element);
		 s.selectByIndex(index);
	 }
	 /**
	  * this method will used to handle drop down by value
	  * @param element
	  * @param value
	  */
	 public void dropDownhandle(WebElement element, String value )
	 {
		 Select s = new Select(element);
		 s.selectByValue(value);
	 }
	 /**
	  * this method will used to handle drop down by visible text
	  * @param text
	  * @param element
	  */
	 public void dropDownhandle(String text, WebElement element)
	 {
		Select s = new Select(element);
		 s.selectByVisibleText(text);;
	 }
	 /**
	  * this method will used to click on element
	  * @param driver
	  * @param Element
	  */
	 public void mouseHoverAction(WebDriver driver, WebElement Element)
	 {
		 Actions act = new Actions(driver);
				act.moveToElement(Element).perform();; 
	 }
	 /**
	  * this method will used double click
	  * @param driver
	  * @param element
	  */
	 public void DoubleClick(WebDriver driver, WebElement element)
	 {
		 Actions act = new Actions(driver);
        act.doubleClick().perform();
	 }
	 /**
	  * this meth0od will used for right click
	  * @param element
	  * @param driver
	  */
	 public void rightClick(WebElement element, WebDriver driver) 
	 {
		 Actions act = new Actions(driver);
		 act.contextClick().perform();
	 }
	 /**
	  * this method will use for move the mouse cursor based of offset and click on element
	  * @param driver
	  */
	 public void moveAndClick(WebDriver driver)
	 {
		 Actions act = new Actions(driver);
		 act.moveByOffset(10, 10).click().perform();
	 }
	 /**
	  * this method will used for drag and drop
	  * @param driver
	  * @param srcEle
	  * @param dstEle
	  */
	 public void dragAndDrop(WebDriver driver, WebElement srcEle, WebElement dstEle)
	 {
		 Actions act = new Actions(driver);
		 act.dragAndDrop(srcEle, dstEle).perform();
	 }
	 /**
	  * this method will used to switch the frame work with index
	  * @param driver
	  * @param index
	  */
	 public void switchToFrame(WebDriver driver, int index)
	 {
		 driver.switchTo().frame(index);
	 }
	 /**
	  * this method will used to switch the frame with element
	  * @param driver
	  * @param element
	  */
	 public void switchToFrame(WebDriver driver, WebElement element)
	 {
		 driver.switchTo().frame(element);
	 }
	 /**
	  * this method will used to switch the frame with NameId
	  * @param driver
	  * @param NameId
	  */
	 public void switchToFrame(WebDriver driver, String NameId)
	 {
		 driver.switchTo().frame(NameId);
	 }
	 /**
	  * this method will used for scroll down by 500 units
	  * @param driver
	  */
	 public void scrollDownAction(WebDriver driver)
	 {
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,500);","");
		 
	 }
	 /**
	  * this method will used for scroll up by 500 units
	  * @param driver
	  */
	 public void scrollUpAction(WebDriver driver)
	 {
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,-500);","");
		 
	 }
	 /**
	  * this method will used for accept the alert
	  * @param driver
	  */
	 public void acceptAlert(WebDriver driver)
	 {
		 driver.switchTo().alert().accept();
		 
	 }
	 /**
	  * this method will used for cancel the alert
	  * @param driver
	  */
	 public void cancelAlert(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();;
		 
	 }
	 /**
	  * this method will used for get alert Text the alert
	  * @param driver
	  */
	 public void getAlertText(WebDriver driver)
	 {
		 driver.switchTo().alert().getText();
		 
	 }
	 /**
	  * this method will capture the SS and also return the dst path 
	  * @param driver
	  * @param ScreenshotName
	  * @return
	  * @throws Throwable
	  */
	 public String captureScreenShot(WebDriver driver, String ScreenshotName) throws Throwable
	 {
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dst = new File(".\\ScreenShots\\"+ScreenshotName+".png");
		 Files.copy(src, dst);
		 
		 
		 return dst.getAbsolutePath();
	 }
	 
	 /**
	  * this method will used for switching window from parent to any child or vice versa
	  * @param driver
	  * @param PartialWindowTitle
	  */
	 public void switchWindoHandle(WebDriver driver, String PartialWindowTitle)
	 {
		 Set<String> allwindow = driver.getWindowHandles();
		 for(String window :allwindow )
		 {
			String actualTitle = driver.switchTo().window(window).getTitle();
			if(actualTitle.contains(PartialWindowTitle))
			{
				break;
			}
		 }
	 }

}
