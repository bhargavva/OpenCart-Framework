package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount_Link;
	
	@FindBy(linkText = "Register")
	WebElement register_Link;
	
	@FindBy(linkText = "Login")
	WebElement login_Link;
	
	
	public void clickMyAccount() {
		myAccount_Link.click();
	}
	
	public void clickRegister() {
		register_Link.click();
	}
	
	public void clickLogin() {
		login_Link.click();
	}
	
}
