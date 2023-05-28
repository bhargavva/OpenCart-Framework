package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcccountPage extends BasePage {
	public MyAcccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[contains(text(), 'My Account')]")
	WebElement myAccount_heading;
	
	@FindBy(linkText = "Logout")
	WebElement Logout_Link;
	
	public void clickLogout() {
		Logout_Link.click();
	}

	public boolean isMyAccountPageExists() {
		try {
			return myAccount_heading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
