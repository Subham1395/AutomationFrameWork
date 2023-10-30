package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule 1

	
		//rule2- declaration
		@FindBy(name= "user_name")
		private WebElement userNameEdt;
		
		@FindBy(name= "user_password")
		private WebElement passwordEdt;
		
		@FindAll({@FindBy(id="submitButton"), @FindBy(xpath= "//input[@type='submit']")})
		private WebElement loginBtn;
		
		//rule3 initialization
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		
		//rule4 -utilization
		public WebElement getUserNameEdt() {
			return userNameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		//rule5- Business libraries-generic method bases of need of project
		/**
		 * this method will use for login application
		 * @param USERNAME
		 * @param PASSWORD
		 */
		public void loginPage(String USERNAME, String PASSWORD)
		{
			userNameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			loginBtn.click();
		}
		



}
