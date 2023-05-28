package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "email")
	WebElement email_TextField;
	
	@FindBy(name = "password")
	WebElement password_TextField;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement login_Button;
	
	public void setEmail(String email) {
		email_TextField.sendKeys(email);
	}
	
	public void setPassword(String password) {
		password_TextField.sendKeys(password);
	}
	
	public void clickLoginButton() {
		login_Button.click();
	}
}
